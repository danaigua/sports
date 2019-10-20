package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vip.wukong.entity.ProjectCollege;
import vip.wukong.repository.ProjectCollegeRepository;
import vip.wukong.service.ProjectCollegeService;

/**
 * 规则-学院接口业务层实现类
 * @author 章家宝
 *
 */
@Service("projectCollegeService")
public class ProjectCollegeServiceImpl implements ProjectCollegeService{
	@Resource
	private ProjectCollegeRepository projectCollegeRepository;

	@Override
	@Transactional			//加事务
	public void delete(Integer id) {
		projectCollegeRepository.deleteById(id);
	}

	@Override
	public void save(ProjectCollege projectCollege) {
		projectCollegeRepository.save(projectCollege);
	}

	@Override
	public List<ProjectCollege> findByProjectId(Integer id) {
		return projectCollegeRepository.findByProjectId(id);
	}

	@Override
	public List<ProjectCollege> findByCollegeId(Integer id) {
		return projectCollegeRepository.findByCollegeId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByCollegeId(Integer id) {
		projectCollegeRepository.deleteByCollegeId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByProjecttId(Integer id) {
		// TODO Auto-generated method stub
		projectCollegeRepository.deleteByProjectId(id);
	}
}
