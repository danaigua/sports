package vip.wukong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Log;
import vip.wukong.entity.Student;
import vip.wukong.entity.StudentProject;

/**
 * 学生项目持久层接口
 * @author 章家宝
 *
 */
public interface StudentProjectRepository extends JpaRepository<StudentProject, Integer>, JpaSpecificationExecutor<StudentProject> {

	@Query(value = "delete from t_student_project where student_id = ?1", nativeQuery = true)
	@Modifying
	public void deleteByStudentId(Integer id);
	
	@Query(value = "delete from t_student_project where project_id = ?1", nativeQuery = true)
	@Modifying
	public void deleteByProjectId(Integer id);
	
	@Query(value = "select * from t_student_project where student_id = ?1", nativeQuery = true)
	public List<StudentProject> findByStudentId(Integer id);
	
	@Query(value = "select * from t_student_project where project_id = ?1", nativeQuery = true)
	public List<StudentProject> findByProjectId(Integer id);
	
	
	/**
	 * 查找项目和学生id是否存在，存在则不能重复报名
	 * @param projectId
	 * @param id
	 */
	@Query(value = "select * from t_student_project where project_id = ?1 and student_id = ?2", nativeQuery = true)
	public StudentProject findByProjectIdAndStudentId(Integer projectId, Integer id);
	
	/**
	 * 删除项目
	 * @param id
	 * @param projectId
	 */
	@Query(value = "delete from t_student_project where  student_id = ?1 and project_id = ?2", nativeQuery = true)
	@Modifying
	public void deleteByStudentIdAndProjectId(Integer id, Integer projectId);
}
