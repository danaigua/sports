package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vip.wukong.entity.RuleCollege;
import vip.wukong.repository.RuleCollegeRepository;
import vip.wukong.service.RuleCollegeService;

/**
 * 规则-学院接口业务层实现类
 * @author 章家宝
 *
 */
@Service("ruleCollegeService")
public class RuleCollegeServiceImpl implements RuleCollegeService{
	@Resource
	private RuleCollegeRepository ruleCollegeRepository;

	@Override
	@Transactional			//加事务
	public void delete(Integer id) {
		ruleCollegeRepository.deleteById(id);
	}

	@Override
	public void save(RuleCollege ruleCollege) {
		ruleCollegeRepository.save(ruleCollege);
	}

	@Override
	public List<RuleCollege> findByRuleId(Integer id) {
		return ruleCollegeRepository.findByRuleId(id);
	}

	@Override
	public List<RuleCollege> findByCollegeId(Integer id) {
		return ruleCollegeRepository.findByCollegeId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByCollegeId(Integer id) {
		ruleCollegeRepository.deleteByCollegeId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByRuletId(Integer id) {
		// TODO Auto-generated method stub
		ruleCollegeRepository.deleteByRuleId(id);
	}
}
