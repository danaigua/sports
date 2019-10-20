package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.Teacher;

/**
 * 教师业务层接口
 * @author 章家宝
 *
 */
public interface TeacherService {

	/**
	 * 通过id删除教师
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 保存或者修改教师
	 * @param teacher
	 */
	public void save(Teacher teacher);
	/**
	 * 获取总记录数
	 * @param teacher
	 * @return
	 */
	public Long getCount(Teacher teacher);
	/**
	 * 分页查询教师
	 * @param teacher
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Teacher> list(Teacher teacher, Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 通过教师姓名查找教师
	 * @param teacherName
	 * @return
	 */
	public Teacher findByTeacherName(String teacherName);
	
	/**
	 * 通过id查找教师
	 * @param id
	 * @return
	 */
	public Teacher findById(Integer id);
}
