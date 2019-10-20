package vip.wukong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.ProjectDepartment;

/**
 * 学生项目持久层接口
 * @author 章家宝
 *
 */
public interface ProjectDepartmentRepository extends JpaRepository<ProjectDepartment, Integer>, JpaSpecificationExecutor<ProjectDepartment> {

	@Query(value = "delete from t_project_department where department_id = ?1", nativeQuery = true)
	public void deleteByDepartmentId(Integer id);
	
	@Query(value = "delete from t_project_department where project_id = ?1", nativeQuery = true)
	public void deleteByProjectId(Integer id);
	
	@Query(value = "select * from t_project_department where department_id = ?1", nativeQuery = true)
	public List<ProjectDepartment> findByDepartmentId(Integer id);
	
	@Query(value = "select * from t_project_department where project_id = ?1", nativeQuery = true)
	public List<ProjectDepartment> findByProjectId(Integer id);
}
