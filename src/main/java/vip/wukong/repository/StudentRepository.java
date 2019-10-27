package vip.wukong.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Log;
import vip.wukong.entity.Student;

/**
 * 学生持久层接口
 * @author 章家宝
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

	@Query(value = "select * from t_student where name = ?1", nativeQuery = true)
	public List<Student> findByStudentName(String studentName);
	
	@Query(value = "select * from t_student where college = ?1", nativeQuery = true)
	public List<Student> findByCollegeName(String name);
	
	@Query(value = "select * from t_student where department = ?1", nativeQuery = true)
	public List<Student> findByDepartment(String name);

	@Query(value = "select * from t_student where addr = ?1", nativeQuery = true)
	public List<Student> findBySchoolAddrName(String name);
	
	@Query(value = "select * from t_student where true_name = ?1", nativeQuery = true)
	public List<Student> findByTrueName(String trueName);
	
	@Query(value = "SELECT * FROM t_student WHERE true_name = ?1  AND grade like ?2 ", nativeQuery = true)
	public List<Student> findByNameAndGrade(String trueName, String grade);
} 
