package vip.wukong.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Log;
import vip.wukong.entity.Project;

/**
 * 项目持久层接口
 * @author 章家宝
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
	
	@Query(value = "select * from t_project where name = ?1", nativeQuery = true)
	public Project findByName(String projectName);
	/**
	 * 通过学院id查找项目
	 * @param collegeId
	 * @return
	 */
	@Query(value = "select * from t_project where college_id = ?1", nativeQuery = true)
	public List<Project> findByCollege(Integer collegeId);
	/**
	 * 通过系部id查找项目
	 * @param collegeId
	 * @return
	 */
	@Query(value = "select * from t_project where department_id = ?1", nativeQuery = true)
	public List<Project> findByDepartmentId(Integer department_id);
	/**
	 * 通过父类id查找实体
	 * @param id
	 * @return
	 */
	@Query(value = "select * from t_project where pid = ?1 ORDER BY time ASC;", nativeQuery = true)
	public List<Project> findByParentId(Integer id);
	
	/**
	 * 查找是否有项目绑定校区
	 * @param id
	 * @return
	 */
	@Query(value = "select * from t_project where addr = ?1", nativeQuery = true)
	public List<Project> findBySchoolAddr(String addrName);
}
