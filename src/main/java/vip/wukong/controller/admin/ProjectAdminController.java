package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
import vip.wukong.util.StringUtils;

/**
 * 项目控制层
 * 
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/project")
public class ProjectAdminController {

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
	 * 列出所有的项目名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<Project> projectList = projectService.listAll();
		for (Project project : projectList) {
			map.put(project.getId(), project.getName());
		}
		//logService.save(new Log(Log.SEARCH_ACTION, "查询所有的项目名称"));
		return map;
	}
	/**
	 * 列出所有的项目名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/comboboxYear")
	public Map<Integer, Object> comboboxYear() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<Project> projectList = projectService.listAll();
		for (Project project : projectList) {
			map.put(project.getId(), project.getYear());
		}
		logService.save(new Log(Log.SEARCH_ACTION, "查询所有的项目名称年度"));
		return map;
	}
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
	/**
	 * 取消报名比赛
	 * @param id
	 * @param projectId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancelApply")
	public Map<String, Object> cancelApply(@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "projectId", required = false) Integer projectId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if (projectId == null) {
			map.put("success", false);
			map.put("errorInfo", "取消报名失败，请先填选项目名称");
			return map;
		}
		if(!studentProjectService.findByProjectIdAndStudentId(projectId, id)) {
			map.put("success", false);
			map.put("errorInfo", "报名失败，该学生没有报名该比赛！");
			return map;
		}
		Project project = projectService.findById(projectId);
		Student student = studentService.findById(id);
		studentProjectService.deleteByStudentIdAndProjectId(id, projectId);
		String projectName = student.getProjectName();
		String newProjectName = "";
		String p = DateUtils.getCurrentYear() + project.getName() + ",";
		String[] projectNames = projectName.split(p);
		for (String string : projectNames) {
			newProjectName += string;
		}
		student.setProjectName(newProjectName);
		studentService.save(student);
		logService.save(new Log(Log.DELETE_ACTION, student.getTrueName() + "取消参赛：" + project.getName()));
		map.put("success", true);
		return map;
	}
	/**
	 * 通过id删除项目
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(studentProjectService.findByProjectId(id).size() > 0) {
			map.put("success", false);
			map.put("errorInfo", "该项目有学生参加了比赛项目，不能删除！");
			return map;
		}
		Project project = projectService.findById(id);
		if(project.getState() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该项目下面有比赛项目，不能删除！");
			return map;
		}
		if(projectService.findByParentId(project.getPid()).size() == 1) {
			Project oldProject = projectService.findById(project.getPid());
			oldProject.setState(0);
			projectService.save(oldProject);
		}
		logService.save(new Log(Log.DELETE_ACTION, "删除比赛项目" + projectService.findById(id)));
		projectService.delete(id);
		map.put("success", true);
		return map;
	}
	/**
	 * 获取项目以及报名比赛的学生信息信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPorjectInfo")
	public Map<String, Object> getPorjectInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", projectService.getCount(null));//获取总项目数目
		map.put("student", studentService.getCount(null));//获取学生人数
		map.put("teacher", teacherService.getCount(null));//获取老师人数
		map.put("rule", ruleService.getCount(null));//获取到规则
		logService.save(new Log(Log.SEARCH_ACTION, "获取项目以及报名比赛的学生信息信息"));
		return map;
	}
	
	
	/**
	 * 新建或者保存项目
	 * @return
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(Project project, 
			@RequestParam(value = "parentId")Integer parentId,
			@RequestParam(value = "projectName")String projectName,
			@RequestParam(value = "collegeOrProjectNum")String collegeOrProjectNum
			)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		projectService.findByName(projectName);
		if(projectService.findByName(projectName) != null) {
			map.put("error", "项目名称已经存在，添加项目失败。");
			map.put("success", true);
		}
		if(project.getId() == null) {
			project.setCollegeOrDepartmentNum(collegeOrProjectNum);
			project.setTotalPerson(0);//初始化为0
			Project parentProject = projectService.findById(parentId);
			parentProject.setState(1);//把状态设置为1
			project.setPid(parentId);
			project.setState(0);
			project.setName(projectName);
			projectService.save(project);
		}else if(project.getId() == null && StringUtils.isNotEmpty(projectName)){
			Project oldProject = projectService.findById(project.getId());
			oldProject.setName(projectName);
			projectService.save(project);
		}
		map.put("success", true);
		return map;
	}
	
	/**
	 * //手风琴模式  data: [{ title: '优秀' ,children: [{title: '80 ~ 90' },{ title: '90 ~ 100' }] },{ title: '良好' ,children: [{
	 * title: '70 ~ 80' },{ title: '60 ~ 70' }] },{ title: '要努力奥' ,children: [{title: '0 ~ 60' }] }]
	 */
	
	/**
	 * 获取项目菜单
	 * @return
	 */
	@RequestMapping("/getChildren")
	private String getChildren() {
		String children = getAllCheckMenuByParentId(0).toString();
		logService.save(new Log(Log.SEARCH_ACTION, "获取项目菜单"));
		return children;
	}
	
	private JsonArray getAllCheckMenuByParentId(Integer id) {
		JsonArray jsonArray = getCheckMenuByParentId(id);
		for(int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject= (JsonObject) jsonArray.get(i);
			if(jsonObject.get("spread") == null) {
				continue;
			}else {
				jsonObject.add("children", this.getAllCheckMenuByParentId(jsonObject.get("id").getAsInt()));
			}
		}
		return jsonArray;
	}

	/**
	 * 1
	 * 2019年度,2018年度,2017年度
	 * 	1		1		1
	 * 	2		2		2
	 * 	3		3		3
	 *	4		4		4
	 * @param id
	 * @return
	 */
	private JsonArray getCheckMenuByParentId(Integer id) {
		JsonArray jsonArray = new JsonArray();
		List<Project> projectList = projectService.findByParentId(id);//查出父亲节点
		for (Project project : projectList) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("title", project.getName());
			jsonObject.addProperty("id", project.getId());
			if(project.getState() == 1) {
				jsonObject.addProperty("spread", true);
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
}
