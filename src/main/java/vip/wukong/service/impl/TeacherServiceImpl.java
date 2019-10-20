package vip.wukong.service.impl;

import java.util.Date;
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

import vip.wukong.entity.Teacher;
import vip.wukong.repository.TeacherRepository;
import vip.wukong.service.TeacherService;
import vip.wukong.util.Md5Utils;
import vip.wukong.util.StringUtils;

/**
 * 教师业务层接口实现类
 * @author 章家宝
 *
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherRepository teacherRepository;

	@Override
	public void delete(Integer id) {
		teacherRepository.deleteById(id);
	}

	@Override
	public void save(Teacher teacher) {
		teacher.setPassword(Md5Utils.md5(teacher.getName(), "sports"));
		teacher.setTime(new Date());
		teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> list(Teacher teacher, Integer page, Integer pageSize, Direction direction,
			String... properties) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, pageSize, direction, properties);
		Page<Teacher> teacherPage = teacherRepository.findAll(new Specification<Teacher>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate predicate = cb.conjunction();
				if(teacher != null) {
					if(StringUtils.isNotEmpty(teacher.getTrueName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + teacher.getTrueName() + "%"));
					}
					if(teacher.getbTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), teacher.getbTime()));
					}
					if(teacher.geteTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), teacher.geteTime()));
					}
				}
				return predicate;
			}
		}, pageable);
		return teacherPage.getContent();
	}

	@Override
	public Teacher findByTeacherName(String teacherName) {
		// TODO Auto-generated method stub
		return teacherRepository.findByTeacherName(teacherName);
	}

	@Override
	public Teacher findById(Integer id) {
		// TODO Auto-generated method stub
		return teacherRepository.getOne(id);
	}

	@Override
	public Long getCount(Teacher teacher) {
		Long count = teacherRepository.count(new Specification<Teacher>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if(teacher != null) {
					if(StringUtils.isNotEmpty(teacher.getTrueName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + teacher.getTrueName() + "%"));
					}
					if(teacher.getbTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), teacher.getbTime()));
					}
					if(teacher.geteTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), teacher.geteTime()));
					}
				}
				return predicate;
			}
		});
		return count;
	}
	
	
}
