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
/**
 * 项目业务层接口实现类
 * @author 章家宝
 *
 */

import vip.wukong.entity.Project;
import vip.wukong.repository.ProjectRepository;
import vip.wukong.service.ProjectService;
import vip.wukong.util.StringUtils;
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectRepository projectRepository;

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	@Override
	public void save(Project project) {
		// TODO Auto-generated method stub
		projectRepository.save(project);
	}

	@Override
	public Project findById(Integer id) {
		// TODO Auto-generated method stub
		return projectRepository.getOne(id);
	}

	@Override
	public Project findByName(String projectName) {
		// TODO Auto-generated method stub
		return projectRepository.findByName(projectName);
	}

	@Override
	public List<Project> list(Project project, Integer page, Integer pageSize, Direction direction,
			String... properties) {
		Pageable pageable = PageRequest.of(page, pageSize, direction, properties);
		Page<Project> projectPage = projectRepository.findAll(new Specification<Project>() {
			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if(project != null) {
					if(StringUtils.isNotEmpty(project.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), project.getName()));
					}
					if(project.geteTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), project.getTime()));
					}
					if(project.getbTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), project.getTime()));
					}
				}
				return predicate;
			}
		}, pageable);
		return projectPage.getContent();
	}

	@Override
	public Long getCount(Project project) {
		// TODO Auto-generated method stub
		Long count = projectRepository.count(new Specification<Project>() {

			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if(project != null) {
					if(StringUtils.isNotEmpty(project.getName())) {
						predicate.getExpressions().add(cb.like(root.get("name"), project.getName()));
					}
					if(project.geteTime() != null) {
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("time"), project.getTime()));
					}
					if(project.getbTime() != null) {
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("time"), project.getTime()));
					}
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public List<Project> findByCollege(Integer collegeId) {
		// TODO Auto-generated method stub
		return projectRepository.findByCollege(collegeId);
	}

	@Override
	public List<Project> findByDepartmentId(Integer department_id) {
		// TODO Auto-generated method stub
		return projectRepository.findByDepartmentId(department_id);
	}

	@Override
	public List<Project> listAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public List<Project> findByParentId(Integer id) {
		// TODO Auto-generated method stub
		return projectRepository.findByParentId(id);
	}

	@Override
	public List<Project> findBySchoolAddr(String addrName) {
		// TODO Auto-generated method stub
		return projectRepository.findBySchoolAddr(addrName);
	}
}
