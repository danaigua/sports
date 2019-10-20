package vip.wukong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.ProjectCollege;

/**
 * 学生项目持久层接口
 * @author 章家宝
 *
 */
public interface ProjectCollegeRepository extends JpaRepository<ProjectCollege, Integer>, JpaSpecificationExecutor<ProjectCollege> {

	@Query(value = "delete from t_project_project where college_id = ?1", nativeQuery = true)
	public void deleteByCollegeId(Integer id);
	
	@Query(value = "delete from t_project_project where project_id = ?1", nativeQuery = true)
	public void deleteByProjectId(Integer id);
	
	@Query(value = "select * from t_project_project where college_id = ?1", nativeQuery = true)
	public List<ProjectCollege> findByCollegeId(Integer id);
	
	@Query(value = "select * from t_project_project where project_id = ?1", nativeQuery = true)
	public List<ProjectCollege> findByProjectId(Integer id);
}
