package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.SchoolAddr;

/**
 * 校区持久层接口
 * @author 章家宝
 *
 */
public interface SchoolAddrRepository extends JpaRepository<SchoolAddr, Integer>, JpaSpecificationExecutor<SchoolAddr> {

	/**
	 * 通过校区名称查找实体
	 * @param schoolAddrName
	 * @return
	 */
	@Query(value = "select * from t_school_addr where name = ?1", nativeQuery = true)
	public SchoolAddr findByName(String schoolAddrName);
}
