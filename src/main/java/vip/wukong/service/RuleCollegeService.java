package vip.wukong.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import vip.wukong.entity.RuleCollege;

/**
 * 学院-规则关联业务层接口
 * @author 章家宝
 *
 */
public interface RuleCollegeService {

	@Modifying
	public void delete(Integer id);

	public void save(RuleCollege ruleCollege);

	public List<RuleCollege> findByRuleId(Integer id);
	
	public List<RuleCollege> findByCollegeId(Integer id);
	
	public void deleteByCollegeId(Integer id);
	
	public void deleteByRuletId(Integer id);
}
