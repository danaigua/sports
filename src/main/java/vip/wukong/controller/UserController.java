package vip.wukong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vip.wukong.entity.Log;
import vip.wukong.entity.Student;
import vip.wukong.entity.Teacher;
import vip.wukong.service.LogService;
import vip.wukong.service.StudentService;
import vip.wukong.service.TeacherService;
import vip.wukong.util.Md5Utils;

/**
 * 用户控制层
 * 
 * @author 章家宝
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private StudentService studentService;

	@Resource
	private TeacherService teacherService;

	@Resource
	private LogService logService;

	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @param vercode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Map<String, Object> login(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "vercode", required = false) String vercode, HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String code = (String) session.getAttribute("checkcode");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, Md5Utils.md5(password, "sports"));
//		if (!vercode.equals(code)) {
//			map.put("success", false);
//			map.put("errorInfo", "验证码错误");
//			return map;
//		}
		Student student = studentService.findByStudentName(userName);
		Teacher teacher = teacherService.findByTeacherName(userName);
		if (teacher != null) {
			if (teacher.getPassword().equals(Md5Utils.md5(password, "sports"))) {
				subject.login(token);
				map.put("success", true);
				logService.save(new Log(Log.LOGIN_ACTION, "用户登录" + teacher));
				return map;
			} else {
				map.put("success", false);
				map.put("errorInfo", "用户名或者密码错误");
				return map;
			}

		}
		if (student != null) {
			if (student.getPassword().equals(Md5Utils.md5(password, "sports"))) {
				subject.login(token);
				map.put("success", true);
				logService.save(new Log(Log.LOGIN_ACTION, "用户登录" + student));
				return map;
			} else {
				map.put("success", false);
				map.put("errorInfo", "用户名或者密码错误");
				return map;
			}
		}
		map.put("success", false);
		map.put("errorInfo", "用户名或者密码错误");
		return map;
	}

	/**
	 * 退出
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/admin/logout")
	public String logout() throws Exception {
		String userName = SecurityUtils.getSubject().getPrincipal().toString();
		Student student = studentService.findByStudentName(userName);
		Teacher teacher = teacherService.findByTeacherName(userName);
		if (student != null) {
			logService.save(new Log(Log.LOGIN_ACTION, "用户安全退出" + student));
		} else {
			logService.save(new Log(Log.LOGIN_ACTION, "用户安全退出" + teacher));
		}
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}

	/**
	 * 修改密码
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/modifyPassword")
	public Map<String, Object> modifyPassword(@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "trueName", required = false) String trueName) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String name = SecurityUtils.getSubject().getPrincipal().toString();
		String newPassword = Md5Utils.md5(password, "sports");
		if (name != null) {
			Student student = studentService.findByStudentName(name);
			Teacher teacher = teacherService.findByTeacherName(name);
			if (teacher != null) {
				if (!teacher.getPassword().equals(newPassword)) {
					map.put("errorInfo", "原密码不正确");
					map.put("success", false);
					return map;
				} else {
					teacher.setPassword(newPassword);
					teacherService.save(teacher);
					logService.save(new Log(Log.UPDATE_ACTION, "修改密码" + teacher));
					map.put("success", true);
					return map;
				}
			}
			if (student != null) {
				if (!student.getPassword().equals(newPassword)) {
					map.put("errorInfo", "原密码不正确");
					map.put("success", false);
					return map;
				} else {
					student.setPassword(newPassword);
					studentService.save(student);
					logService.save(new Log(Log.UPDATE_ACTION, "修改密码" + student));
					map.put("success", true);
					return map;
				}
			}
			map.put("errorInfo", "发生未知错误，请联系管理员！");
			map.put("success", false);
			return map;
		} else {
			Student student = studentService.findByStudentName(userName);
			Teacher teacher = teacherService.findByTeacherName(userName);
			if (student != null && student.getTrueName().equals(trueName)) {
				student.setPassword(newPassword);
				map.put("success", true);
				return map;
			}
			if (teacher != null && teacher.getTrueName().equals(trueName)) {
				teacher.setPassword(newPassword);
				map.put("success", true);
				return map;
			}
			map.put("errorInfo", "找不到该用户");
			map.put("success", false);
			return map;
		}
	}

	/**
	 * 获取个人的详细信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/info")
	public Object info() {
		String userName = SecurityUtils.getSubject().getPrincipal().toString();
		Student student = studentService.findByStudentName(userName);
		Teacher teacher = teacherService.findByTeacherName(userName);
		if (student != null) {
			student.setPassword("");
			return student;
		}
		if (teacher != null) {
			teacher.setPassword("");
			return teacher;
		}
		return null;
	}
	/**
	 * 获取用户名
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/admin/getUserIfo")
	public Map<String, Object> getUserIfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = SecurityUtils.getSubject().getPrincipal().toString();
		Student student = studentService.findByStudentName(userName);
		Teacher teacher = teacherService.findByTeacherName(userName);
		if (student != null) {
			map.put("info", student.getTrueName());
		}
		if (teacher != null) {
			map.put("info", teacher.getTrueName());
		}
		return map;
	}
}
