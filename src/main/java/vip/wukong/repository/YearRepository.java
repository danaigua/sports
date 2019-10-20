package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Year;

public interface YearRepository extends JpaRepository<Year, Integer>, JpaSpecificationExecutor<Year> {

	/**
	 * 通过名称获取年份表
	 * @param year
	 * @return
	 */
	@Query(value = "select * from t_year where name = ?1", nativeQuery = true)
	public Year getByName(String year);
	
}
