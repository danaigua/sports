package vip.wukong.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import vip.wukong.entity.Student;
import vip.wukong.entity.Teacher;
import vip.wukong.repository.StudentRepository;
import vip.wukong.repository.TeacherRepository;

public class MyRealm extends AuthorizingRealm {

	@Resource
	private StudentRepository studentRepository;
	
	@Resource
	private TeacherRepository teacherRepository;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		Student student = studentRepository.findByStudentName(userName);
		Teacher teacher = teacherRepository.findByTeacherName(userName);
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		Student student = studentRepository.findByStudentName(userName);
		Teacher teacher = teacherRepository.findByTeacherName(userName);
		if(teacher != null) {
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(teacher.getName(), teacher.getPassword(), "xxx");
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", teacher);
			return authInfo;
		}
		if(student != null) {
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", student);
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(student.getName(), student.getPassword(), "xxx");
			return authInfo;
		}
		return null;
	}

}
