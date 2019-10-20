package vip.wukong.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort.Direction;

import com.google.gson.JsonArray;

import vip.wukong.entity.Student;

/**
 * 学生业务层接口
 * @author 章家宝
 *
 */
public interface StudentService {

	/**
	 * 通过id删除学生
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 保存或者修改一个学生
	 * @param student
	 */
	public void save(Student student);
	/**
	 * 获取总记录数
	 * @param student
	 * @return
	 */
	public Long getCount(Student student);
	/**
	 * 分页查询所有学生
	 * @param student
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Student> list(Student student, Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 通过学生姓名查找学生
	 * @param StudnetName
	 * @return
	 */
	public Student findByStudentName(String StudnetName);
	/**
	 * 通过id查找学生
	 * @param id
	 * @return
	 */
	public Student findById(Integer id);
	/**
	 * 列出所有的比赛学生
	 * @param asc
	 * @param string
	 * @return
	 */
	public List<Student> listAll(Student student, Direction asc, String...properties);
	/**
	 * 通过学院名称查找实体
	 * @param name
	 * @return
	 */
	public List<Student> findByCollegeName(String name);
	/**
	 * 通过查找系部名称查找实体
	 * @param name
	 * @return
	 */
	public List<Student> findByDepartmentName(String name);
	/**
	 * 通过条件获取没有分页的总数
	 * @param s_student
	 * @return
	 */
	public List<Student> listNoPage(Student s_student);
	/**
	 * 查找是否有学生绑定校区
	 * @param name
	 * @return
	 */
	public List<Student> findBySchoolAddrName(String name);
}
