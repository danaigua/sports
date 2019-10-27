package vip.wukong.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.Log;
import vip.wukong.entity.Project;
import vip.wukong.entity.Student;
import vip.wukong.entity.StudentProject;
import vip.wukong.entity.Year;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.RuleService;
import vip.wukong.service.StudentProjectService;
import vip.wukong.service.StudentService;
import vip.wukong.service.TeacherService;
import vip.wukong.service.YearService;
import vip.wukong.util.DateUtils;

@RestController
@RequestMapping("/student/project")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	@Resource
	private StudentService studentService;
	
	@Resource
	private StudentProjectService studentProjectService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private RuleService ruleService;
	
	@Resource
	private YearService yearService;
	/**
	 * 报名参赛
	 * 
	 * @param id
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/apply")
	public Map<String, Object> apply(@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "projectId", required = false) Integer projectId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String year = DateUtils.getCurrentYear();
		if(yearService.getByName(year) == null){
			Year y = new Year();
			y.setName(year);
			yearService.save(y);
		}
		if (projectId == null) {
			map.put("success", false);
			map.put("errorInfo", "报名失败，请先填选项目名称");
			return map;
		}
		if(studentProjectService.findByProjectIdAndStudentId(projectId, id)) {
			map.put("success", false);
			map.put("errorInfo", "报名失败，您已经报名，请勿重复报名！");
			return map;
		}
		Project project = projectService.findById(projectId);
		Student student = studentService.findById(id);
		StudentProject studentProject = new StudentProject();
		studentProject.setProject(project);
		studentProject.setStudent(student);
		studentProjectService.save(studentProject);
		student.setProjectName(DateUtils.getCurrentYear() + project.getName() + "," + student.getProjectName());
		logService.save(new Log(Log.ADD_ACTION, student.getTrueName() + "报名参赛：" + project.getName()));
		studentService.save(student);
		map.put("success", true);
		return map;
	}
}
