package vip.wukong.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Project;

/**
 * 项目业务层接口
 * @author 章家宝
 *
 */
public interface ProjectService {

	/**
	 * 删除一个项目
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 获取总记录数
	 * @param project
	 * @return
	 */
	public Long getCount(Project project);
	/**
	 * 保存或者修改一个项目
	 * @param project
	 */
	public void save(Project project);
	/**
	 * 通过id查找项目
	 * @param id
	 * @return
	 */
	public Project findById(Integer id);
	/**
	 * 通过名称查找项目
	 * @param projectName
	 * @return
	 */
	public Project findByName(String projectName);
	/**
	 * 分页查询所有项目
	 * @param project
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Project> list(Project project, Integer page, Integer pageSize, Direction direction, String...properties);
	
	/**
	 * 通过学院id查找项目
	 * @param collegeId
	 * @return
	 */
	public List<Project> findByCollege(Integer collegeId);
	/**
	 * 通过系部id查找项目
	 * @param collegeId
	 * @return
	 */
	public List<Project> findByDepartmentId(Integer department_id);
	/**
	 * 不分页显示所有的项目
	 * @return
	 */
	public List<Project> listAll();
	/**
	 * 通过父类id查找
	 * @param asc
	 * @param string
	 * @return
	 */
	public List<Project> findByParentId(Integer id);
	/**
	 * 查找是否有项目绑定校区
	 * @param id
	 * @return
	 */
	public List<Project> findBySchoolAddr(String addrName);
}
