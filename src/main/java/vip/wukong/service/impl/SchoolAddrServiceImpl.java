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

import vip.wukong.entity.SchoolAddr;
import vip.wukong.repository.SchoolAddrRepository;
import vip.wukong.service.SchoolAddrService;

/**
 * 学院业务层接口实现类
 * @author 章家宝
 *
 */
@Service("schoolAddrService")
public class SchoolAddrServiceImpl implements SchoolAddrService {
	
	@Resource
	private SchoolAddrRepository schoolAddrRepository;

	@Override
	public void save(SchoolAddr schoolAddr) {
		// TODO Auto-generated method stub
		schoolAddrRepository.save(schoolAddr);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		schoolAddrRepository.deleteById(id);
	}

	@Override
	public List<SchoolAddr> list(Integer page, Integer pageSize, Direction direction, String... properties) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<SchoolAddr> schoolAddrPage = schoolAddrRepository.findAll(new Specification<SchoolAddr>() {
			
			@Override
			public Predicate toPredicate(Root<SchoolAddr> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				return predicate;
			}
		}, pageable);
		
		return schoolAddrPage.getContent();
	}

	@Override
	public SchoolAddr findByName(String schoolAddrName) {
		// TODO Auto-generated method stub
		return schoolAddrRepository.findByName(schoolAddrName);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return schoolAddrRepository.count();
	}

	@Override
	public List<SchoolAddr> listAll() {
		return schoolAddrRepository.findAll();
	}

	@Override
	public SchoolAddr findById(Integer id) {
		// TODO Auto-generated method stub
		return schoolAddrRepository.getOne(id);
	}
	
	

}
