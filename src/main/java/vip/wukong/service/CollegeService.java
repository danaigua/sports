package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.College;

/**
 * 日志业务层接口
 * @author 章家宝
 *
 */
public interface CollegeService {

	
	/**
	 * 添加或者修改学院
	 * @param college
	 */
	public void save(College college);
	/**
	 * 通过id删除一个学院
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
	/**
	 * 列出所有学院
	 * @return
	 */
	public List<College> list(Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 列出所有的学院
	 * @return
	 */
	public List<College> listAll();
	/**
	 * 通过名称查找学院
	 * @param collegeName
	 * @return
	 */
	public College findByName(String collegeName);
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public College findById(Integer id);
	
}
