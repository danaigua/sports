package vip.wukong.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import vip.wukong.entity.ProjectDepartment;

/**
 * 系部-规则关联业务层接口
 * @author 章家宝
 *
 */
public interface ProjectDepartmentService {

	@Modifying
	public void delete(Integer id);

	public void save(ProjectDepartment projectDepartment);

	public List<ProjectDepartment> findByProjectId(Integer id);
	
	public List<ProjectDepartment> findByDepartmentId(Integer id);
	
	public void deleteByDepartmentId(Integer id);
	
	public void deleteByProjecttId(Integer id);
}
