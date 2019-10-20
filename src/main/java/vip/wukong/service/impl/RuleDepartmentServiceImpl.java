package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vip.wukong.entity.RuleDepartment;
import vip.wukong.repository.RuleDepartmentRepository;
import vip.wukong.service.RuleDepartmentService;

/**
 * 规则-学院接口业务层实现类
 * @author 章家宝
 *
 */
@Service("ruleDepartmentService")
public class RuleDepartmentServiceImpl implements RuleDepartmentService{
	@Resource
	private RuleDepartmentRepository ruleDepartmentRepository;

	@Override
	@Transactional			//加事务
	public void delete(Integer id) {
		ruleDepartmentRepository.deleteById(id);
	}

	@Override
	public void save(RuleDepartment ruleDepartment) {
		ruleDepartmentRepository.save(ruleDepartment);
	}

	@Override
	public List<RuleDepartment> findByRuleId(Integer id) {
		return ruleDepartmentRepository.findByRuleId(id);
	}

	@Override
	public List<RuleDepartment> findByDepartmentId(Integer id) {
		return ruleDepartmentRepository.findByDepartmentId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByDepartmentId(Integer id) {
		ruleDepartmentRepository.deleteByDepartmentId(id);
	}

	@Override
	@Transactional			//加事务
	public void deleteByRuletId(Integer id) {
		// TODO Auto-generated method stub
		ruleDepartmentRepository.deleteByRuleId(id);
	}
}
