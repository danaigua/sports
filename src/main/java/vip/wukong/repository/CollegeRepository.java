package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.College;

/**
 * 学院持久层接口
 * @author 章家宝
 *
 */
public interface CollegeRepository extends JpaRepository<College, Integer>, JpaSpecificationExecutor<College> {

	/**
	 * 通过学院名称查找实体
	 * @param collegeName
	 * @return
	 */
	@Query(value = "select * from t_college where name = ?1", nativeQuery = true)
	public College findByName(String collegeName);
}
