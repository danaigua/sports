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

import vip.wukong.entity.Department;
import vip.wukong.repository.DepartmentRepository;
import vip.wukong.service.DepartmentService;

/**
 * 系部业务层接口实现类
 * @author 章家宝
 *
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Resource
	private DepartmentRepository departmentRepository;

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

	@Override
	public List<Department> list(Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Department> departmentPage = departmentRepository.findAll(new Specification<Department>() {
			
			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				return predicate;
			}
		}, pageable);
		return departmentPage.getContent();
	}

	@Override
	public Department findByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByName(departmentName);
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return departmentRepository.count();
	}

	@Override
	public List<Department> listAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return departmentRepository.getOne(id);
	}
	
	
}
