package vip.wukong.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vip.wukong.entity.Rule;
import vip.wukong.repository.RuleRepository;
import vip.wukong.service.RuleService;
import vip.wukong.util.StringUtils;

@Service("ruleService")
public class RuleServiceImpl implements RuleService {

	@Resource
	private RuleRepository ruleRepository;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ruleRepository.deleteById(id);
	}

	@Override
	public void save(Rule rule) {
		ruleRepository.save(rule);
	}

	@Override
	public List<Rule> list(Rule rule, Integer page, Integer pageSize, Direction direction,
			String... properties) {
		Pageable pageable = PageRequest.of(page - 1, pageSize, direction, properties);
		Page<Rule> rulePage = ruleRepository.findAll(new Specification<Rule>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Rule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (rule != null) {
					if (StringUtils.isNotEmpty(rule.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + rule.getName() + "%"));
					}
				}
				return predicate;
			}
		}, pageable);
		return rulePage.getContent();
	}

	@Override
	public Rule findByRuleName(String studnetName) {
		// TODO Auto-generated method stub
		return ruleRepository.findByRuleName(studnetName);
	}

	@Override
	public Rule findById(Integer id) {
		// TODO Auto-generated method stub
		return ruleRepository.getOne(id);
	}

	@Override
	public Long getCount(Rule rule) {
		Long count = ruleRepository.count(new Specification<Rule>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Rule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (rule != null) {
					if (StringUtils.isNotEmpty(rule.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + rule.getName() + "%"));
					}
				}
				return predicate;
			}
		});
		return count;
	}



	@Override
	public List<Rule> listAll(Rule rule, Direction asc, String...properties) {
		// TODO Auto-generated method stub
		return ruleRepository.findAll(new Specification<Rule>() {
			
			@Override
			public Predicate toPredicate(Root<Rule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (rule != null) {
					if (StringUtils.isNotEmpty(rule.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + rule.getName() + "%"));
					}
				}
				return predicate;
			}
		},new Sort(asc, properties));
	}


}
