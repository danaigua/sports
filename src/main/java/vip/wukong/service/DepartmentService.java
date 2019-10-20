package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.Department;

/**
 * 系部业务层接口
 * @author 章家宝
 *
 */
public interface DepartmentService {

	/**
	 * 保存或者修改系部
	 * @param department
	 */
	public void save(Department department);
	/**
	 * 删除系部
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
	/**
	 * 列出所有的系部
	 * @return
	 */
	public List<Department> list(Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 通过系部名称查找系部
	 * @param departmentName
	 * @return
	 */
	public Department findByName(String departmentName);
	/**
	 * 不分页获取所有的系部信息
	 * @return
	 */
	public List<Department> listAll();
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public Department findById(Integer id);
	
}
