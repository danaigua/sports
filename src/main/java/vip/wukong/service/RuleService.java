package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.Rule;

/**
 * 规则业务层接口
 * @author 章家宝
 *
 */
public interface RuleService {

	/**
	 * 通过id删除规则
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 保存或者修改一个规则
	 * @param rule
	 */
	public void save(Rule rule);
	/**
	 * 获取总记录数
	 * @param rule
	 * @return
	 */
	public Long getCount(Rule rule);
	/**
	 * 分页查询所有规则
	 * @param rule
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Rule> list(Rule rule, Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 通过规则姓名查找规则
	 * @param StudnetName
	 * @return
	 */
	public Rule findByRuleName(String StudnetName);
	/**
	 * 通过id查找规则
	 * @param id
	 * @return
	 */
	public Rule findById(Integer id);
	/**
	 * 列出所有的比赛规则
	 * @param asc
	 * @param string
	 * @return
	 */
	public List<Rule> listAll(Rule rule, Direction asc, String...properties);
}
