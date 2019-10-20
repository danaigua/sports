package vip.wukong.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import vip.wukong.entity.ProjectCollege;

/**
 * 项目-学院关联业务层接口
 * @author 章家宝
 *
 */
public interface ProjectCollegeService {

	@Modifying
	public void delete(Integer id);

	public void save(ProjectCollege projectCollege);

	public List<ProjectCollege> findByProjectId(Integer id);
	
	public List<ProjectCollege> findByCollegeId(Integer id);
	
	public void deleteByCollegeId(Integer id);
	
	public void deleteByProjecttId(Integer id);
}
