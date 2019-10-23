package vip.wukong.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import vip.wukong.entity.Student;
import vip.wukong.repository.StudentRepository;
import vip.wukong.service.StudentService;
import vip.wukong.util.Md5Utils;
import vip.wukong.util.StringUtils;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		if(student.getId() == null) {
			student.setPassword(Md5Utils.md5(student.getName(), "sports"));
			student.setbTime(new Date());
		}
		studentRepository.save(student);
	}

	@Override
	public List<Student> list(Student student, Integer page, Integer pageSize, Direction direction,
			String... properties) {
		Pageable pageable = PageRequest.of(page - 1, pageSize, direction, properties);
		Page<Student> studentPage = studentRepository.findAll(new Specification<Student>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (student != null) {
					if (StringUtils.isNotEmpty(student.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + student.getName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getStudentNumber())) {
						predicate.getExpressions()
								.add(cb.like(root.get("studentNumber"), "%" + student.getStudentNumber() + "%"));
					}
					if (student.getSex() != 0) {
						predicate.getExpressions().add(cb.equal(root.get("sex"), student.getSex()));
					}
					if (StringUtils.isNotEmpty(student.getTrueName())) {
						predicate.getExpressions()
								.add(cb.like(root.get("trueName"), "%" + student.getTrueName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getGrade())) {
						predicate.getExpressions().add(cb.equal(root.get("grade"), student.getGrade()));
					}
					if (StringUtils.isNotEmpty(student.getProjectName())) {
						predicate.getExpressions()
								.add(cb.like(root.get("projectName"), "%" + student.getProjectName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getCollege())) {
						predicate.getExpressions().add(cb.like(root.get("college"), "%" + student.getCollege() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getDepartment())) {
						predicate.getExpressions()
								.add(cb.like(root.get("department"), "%" + student.getDepartment() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getAddr())) {
						predicate.getExpressions().add(cb.equal(root.get("addr"), student.getAddr()));
					}
					if (student.getbTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), student.getbTime()));
					}
					if (student.geteTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), student.geteTime()));
					}
				}
				return predicate;
			}
		}, pageable);
		return studentPage.getContent();
	}

	@Override
	public Student findByStudentName(String studnetName) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentName(studnetName);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.getOne(id);
	}

	@Override
	public Long getCount(Student student) {
		Long count = studentRepository.count(new Specification<Student>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (student != null) {
					if (StringUtils.isNotEmpty(student.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + student.getName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getStudentNumber())) {
						predicate.getExpressions()
								.add(cb.like(root.get("studentNumber"), "%" + student.getStudentNumber() + "%"));
					}
					if (student.getSex() != 0) {
						predicate.getExpressions().add(cb.equal(root.get("sex"), student.getSex()));
					}
					if (StringUtils.isNotEmpty(student.getTrueName())) {
						predicate.getExpressions()
								.add(cb.like(root.get("trueName"), "%" + student.getTrueName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getGrade())) {
						predicate.getExpressions().add(cb.equal(root.get("grade"), student.getGrade()));
					}
					if (StringUtils.isNotEmpty(student.getProjectName())) {
						predicate.getExpressions().add(cb.like(root.get("projectName"), "%" + student.getProjectName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getCollege())) {
						predicate.getExpressions().add(cb.like(root.get("college"), "%" + student.getCollege() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getDepartment())) {
						predicate.getExpressions().add(cb.like(root.get("department"), "%" + student.getDepartment() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getAddr())) {
						predicate.getExpressions().add(cb.equal(root.get("addr"), student.getAddr()));
					}
					if (student.getbTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), student.getbTime()));
					}
					if (student.geteTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), student.geteTime()));
					}
				}
				return predicate;
			}
		});
		return count;
	}



	@Override
	public List<Student> listAll(Student student, Direction asc, String...properties) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(new Specification<Student>() {
			
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (student != null) {
					if (StringUtils.isNotEmpty(student.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), "%" + student.getName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getStudentNumber())) {
						predicate.getExpressions()
								.add(cb.like(root.get("studentNumber"), "%" + student.getStudentNumber() + "%"));
					}
					if (student.getSex() != 0) {
						predicate.getExpressions().add(cb.equal(root.get("sex"), student.getSex()));
					}
					if (StringUtils.isNotEmpty(student.getTrueName())) {
						predicate.getExpressions()
								.add(cb.like(root.get("trueName"), "%" + student.getTrueName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getGrade())) {
						predicate.getExpressions().add(cb.equal(root.get("grade"), student.getGrade()));
					}
					if (StringUtils.isNotEmpty(student.getProjectName())) {
						predicate.getExpressions().add(cb.like(root.get("projectName"), "%" + student.getProjectName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getCollege())) {
						predicate.getExpressions().add(cb.like(root.get("college"), "%" + student.getCollege() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getAddr())) {
						predicate.getExpressions().add(cb.equal(root.get("addr"), student.getAddr()));
					}
					if (StringUtils.isNotEmpty(student.getDepartment())) {
						predicate.getExpressions().add(cb.like(root.get("department"), "%" + student.getDepartment() + "%"));
					}
				}
				return predicate;
			}
		},new Sort(asc, properties));
	}

	@Override
	public List<Student> findByCollegeName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByCollegeName(name);
	}


	@Override
	public List<Student> findByDepartmentName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByDepartment(name);
	}

	@Override
	public List<Student> listNoPage(Student student) {
		return studentRepository.findAll(new Specification<Student>() {
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (student != null) {
					if (student.getSex() != 0) {
						predicate.getExpressions().add(cb.equal(root.get("sex"), student.getSex()));
					}
					if (StringUtils.isNotEmpty(student.getProjectName())) {
						predicate.getExpressions().add(cb.like(root.get("projectName"),"%" + student.getProjectName() + "%"));
					}
					if (StringUtils.isNotEmpty(student.getCollege())) {
						predicate.getExpressions().add(cb.like(root.get("college"),student.getCollege()));
					}
					if (StringUtils.isNotEmpty(student.getAddr())) {
						predicate.getExpressions().add(cb.equal(root.get("addr"), student.getAddr()));
					}
					if (StringUtils.isNotEmpty(student.getDepartment())) {
						predicate.getExpressions().add(cb.equal(root.get("department"),student.getDepartment()));
					}
				}
				return predicate;
			}
		});
	}

	@Override
	public List<Student> findBySchoolAddrName(String name) {
		return studentRepository.findBySchoolAddrName(name);
	}

}
