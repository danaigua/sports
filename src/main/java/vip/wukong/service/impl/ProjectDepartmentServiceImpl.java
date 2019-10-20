package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vip.wukong.entity.ProjectDepartment;
import vip.wukong.repository.ProjectDepartmentRepository;
import vip.wukong.service.ProjectDepartmentService;

/**
 * 规则-学院接口业务层实现类
 * @author 章家宝
 *
 */
@Service("projectDepartmentService")
public class ProjectDepartmentServiceImpl implements ProjectDepartmentService{
	@Resource
	private ProjectDepartmentRepository projectDepartmentRepository;

	@Override
	@Transactional			//加事务
	public void delete(Integer id) {
		projectDepartmentRepository.deleteById(id);
	}

	@Override
	public void save(ProjectDepartment projectDepartment) {
		projectDepartmentRepository.save(projectDepartment);
	}

	@Override
	public List<ProjectDepartment> findByProjectId(Integer id) {
		return projectDepartmentRepository.findByProjectId(id);
	}

	@Override
	public List<ProjectDepartment> findByDepartmentId(Integer id) {
		return projectDepartmentRepository.findByDepartmentId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByDepartmentId(Integer id) {
		projectDepartmentRepository.deleteByDepartmentId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByProjecttId(Integer id) {
		// TODO Auto-generated method stub
		projectDepartmentRepository.deleteByProjectId(id);
	}
}
