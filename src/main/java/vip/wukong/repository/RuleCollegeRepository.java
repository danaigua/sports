package vip.wukong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.RuleCollege;

/**
 * 学生项目持久层接口
 * @author 章家宝
 *
 */
public interface RuleCollegeRepository extends JpaRepository<RuleCollege, Integer>, JpaSpecificationExecutor<RuleCollege> {

	@Query(value = "delete from t_rule_project where college_id = ?1", nativeQuery = true)
	public void deleteByCollegeId(Integer id);
	
	@Query(value = "delete from t_rule_project where rule_id = ?1", nativeQuery = true)
	public void deleteByRuleId(Integer id);
	
	@Query(value = "select * from t_rule_project where college_id = ?1", nativeQuery = true)
	public List<RuleCollege> findByCollegeId(Integer id);
	
	@Query(value = "select * from t_rule_project where rule_id = ?1", nativeQuery = true)
	public List<RuleCollege> findByRuleId(Integer id);
}
