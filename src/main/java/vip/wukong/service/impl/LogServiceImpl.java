package vip.wukong.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vip.wukong.entity.Log;
import vip.wukong.entity.Student;
import vip.wukong.entity.Teacher;
import vip.wukong.repository.LogRepository;
import vip.wukong.repository.StudentRepository;
import vip.wukong.repository.TeacherRepository;
import vip.wukong.service.LogService;
import vip.wukong.util.StringUtils;

/**
 * 日志业务层接口实现类
 * 
 * @author 章家宝
 *
 */
@Service("logService")
public class LogServiceImpl implements LogService {

	@Resource
	private LogRepository logRepository;
	
	@Resource
	private StudentRepository studentRepository;
	
	@Resource
	private TeacherRepository teacherRepository;

	@Override
	public void save(Log log) {
		// TODO Auto-generated method stub
		log.setTime(new Date());
		String userName = SecurityUtils.getSubject().getPrincipal().toString();
		Teacher teacher = teacherRepository.findByTeacherName(userName);
		Student student = studentRepository.findByStudentName(userName).get(0);
		String user = "";
		if(teacher != null) {
			user = "(" + teacher.getName() + ")" + teacher.getTrueName();
		}
		if(student != null) {
			user = "(" + student.getName() + ")" + student.getTrueName();
		}
		log.setUser(user);
		logRepository.save(log);
	}

	@Override
	public List<Log> list(Log log, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable = PageRequest.of(page, pageSize, direction, properties);
		Page<Log> logPage = logRepository.findAll(new Specification<Log>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (log != null) {
					if (StringUtils.isNotEmpty(log.getType())) {
						predicate.getExpressions().add(cb.equal(root.get("type"), log.getType()));
					}
					if (StringUtils.isNotEmpty(log.getUser())) {
						predicate.getExpressions().add(cb.equal(root.get("user"), log.getUser()));
					}
					if (log.getBtime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), log.getBtime()));
					}
					if (log.getEtime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), log.getEtime()));
					}
				}
				return predicate;
			}
		}, pageable);
		return logPage.getContent();
	}

	@Override
	public Long getCount(Log log) {
		Long count = logRepository.count(new Specification<Log>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (log != null) {
					if (StringUtils.isNotEmpty(log.getType())) {
						predicate.getExpressions().add(cb.equal(root.get("type"), log.getType()));
					}
					if (StringUtils.isNotEmpty(log.getUser())) {
						predicate.getExpressions().add(cb.equal(root.get("user"), log.getUser()));
					}
					if (log.getBtime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), log.getBtime()));
					}
					if (log.getEtime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), log.getEtime()));
					}
				}
				return predicate;
			}
		});
		return count;
	}
}
