package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Department;
import vip.wukong.entity.Log;

/**
 * 系部持久层接口
 * @author 章家宝
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

	@Query(value = "select * from t_department where name = ?1", nativeQuery = true)
	public Department findByName(String departmentName);
}
