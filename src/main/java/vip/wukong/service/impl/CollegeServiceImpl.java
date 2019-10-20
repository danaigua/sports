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
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vip.wukong.entity.College;
import vip.wukong.repository.CollegeRepository;
import vip.wukong.service.CollegeService;

/**
 * 学院业务层接口实现类
 * @author 章家宝
 *
 */
@Service("collegeService")
public class CollegeServiceImpl implements CollegeService {
	
	@Resource
	private CollegeRepository collegeRepository;

	@Override
	public void save(College college) {
		// TODO Auto-generated method stub
		collegeRepository.save(college);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		collegeRepository.deleteById(id);
	}

	@Override
	public List<College> list(Integer page, Integer pageSize, Direction direction, String... properties) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<College> collegePage = collegeRepository.findAll(new Specification<College>() {
			
			@Override
			public Predicate toPredicate(Root<College> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				return predicate;
			}
		}, pageable);
		
		return collegePage.getContent();
	}

	@Override
	public College findByName(String collegeName) {
		// TODO Auto-generated method stub
		return collegeRepository.findByName(collegeName);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return collegeRepository.count();
	}

	@Override
	public List<College> listAll() {
		return collegeRepository.findAll();
	}

	@Override
	public College findById(Integer id) {
		// TODO Auto-generated method stub
		return collegeRepository.getOne(id);
	}
	
	

}
