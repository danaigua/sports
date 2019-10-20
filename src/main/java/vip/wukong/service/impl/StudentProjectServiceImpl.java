package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vip.wukong.entity.StudentProject;
import vip.wukong.repository.StudentProjectRepository;
import vip.wukong.service.StudentProjectService;

/**
 * 学生项目接口业务层实现类
 * @author 章家宝
 *
 */
@Service("studentProjectService")
public class StudentProjectServiceImpl implements StudentProjectService{
	@Resource
	private StudentProjectRepository studentProjectRepository;

	@Override
	@Transactional			//加事务
	public void delete(Integer id) {
		studentProjectRepository.deleteById(id);
	}

	@Override
	public void save(StudentProject studentProject) {
		studentProjectRepository.save(studentProject);
	}

	@Override
	public List<StudentProject> findByStudentId(Integer id) {
		// TODO Auto-generated method stub
		return studentProjectRepository.findByStudentId(id);
	}

	@Override
	public List<StudentProject> findByProjectId(Integer id) {
		// TODO Auto-generated method stub
		return studentProjectRepository.findByProjectId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByProjectId(Integer id) {
		// TODO Auto-generated method stub
		studentProjectRepository.deleteByProjectId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByStudenttId(Integer id) {
		// TODO Auto-generated method stub
		studentProjectRepository.deleteByStudentId(id);
	}

	@Override
	public boolean findByProjectIdAndStudentId(Integer projectId, Integer id) {
		// TODO Auto-generated method stub
		StudentProject studentProject = studentProjectRepository.findByProjectIdAndStudentId(projectId, id);
		if(studentProject != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	@Transactional			//加事务
	public void deleteByStudentIdAndProjectId(Integer id, Integer projectId) {
		// TODO Auto-generated method stub
		studentProjectRepository.deleteByStudentIdAndProjectId(id, projectId);
	}
}
