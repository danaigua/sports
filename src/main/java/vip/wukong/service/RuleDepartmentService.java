package vip.wukong.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import vip.wukong.entity.RuleDepartment;

/**
 * 系部-规则关联业务层接口
 * @author 章家宝
 *
 */
public interface RuleDepartmentService {

	@Modifying
	public void delete(Integer id);

	public void save(RuleDepartment ruleDepartment);

	public List<RuleDepartment> findByRuleId(Integer id);
	
	public List<RuleDepartment> findByDepartmentId(Integer id);
	
	public void deleteByDepartmentId(Integer id);
	
	public void deleteByRuletId(Integer id);
}
