package vip.wukong.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import vip.wukong.entity.Rule;

/**
 * 学生持久层接口
 * @author 章家宝
 *
 */
public interface RuleRepository extends JpaRepository<Rule, Integer>, JpaSpecificationExecutor<Rule> {

	@Query(value = "select * from t_rule where name = ?1", nativeQuery = true)
	public Rule findByRuleName(String ruleName);
	
}
