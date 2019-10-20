package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Log;
import vip.wukong.entity.Teacher;

/**
 * 教师持久层接口
 * @author 章家宝
 *
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {

	@Query(value = "select * from t_teacher where name = ?1", nativeQuery = true)
	public Teacher findByTeacherName(String teacherName);

}
