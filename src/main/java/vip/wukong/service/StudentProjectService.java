package vip.wukong.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;

import vip.wukong.entity.StudentProject;

/**
 * 学生项目关联业务层接口
 * @author 章家宝
 *
 */
public interface StudentProjectService {

	@Modifying
	public void delete(Integer id);

	public void save(StudentProject studentProject);

	public List<StudentProject> findByStudentId(Integer id);
	
	public List<StudentProject> findByProjectId(Integer id);
	
	public void deleteByProjectId(Integer id);
	
	public void deleteByStudenttId(Integer id);

	/**
	 * 查找项目和学生id是否存在，存在则不能重复报名
	 * @param projectId
	 * @param id
	 */
	public boolean findByProjectIdAndStudentId(Integer projectId, Integer id);

	/**
	 * 删除项目
	 * @param id
	 * @param projectId
	 */
	@Modifying
	public void deleteByStudentIdAndProjectId(Integer id, Integer projectId);
}
