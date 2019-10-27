package vip.wukong.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vip.wukong.entity.Log;
import vip.wukong.entity.Project;
import vip.wukong.entity.Student;
import vip.wukong.entity.StudentProject;
import vip.wukong.entity.Year;
import vip.wukong.service.ProjectService;
import vip.wukong.service.StudentProjectService;
import vip.wukong.service.StudentService;
import vip.wukong.service.YearService;
import vip.wukong.util.DateUtils;
import vip.wukong.util.StringUtils;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;
	
	@Resource
	private YearService yearService;
	
	@Resource
	private StudentProjectService studentProjectService;
	
	@Resource
	private ProjectService projectService;
	
	/**
	 * 添加学生
	 * 
	 * @param student
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Map<String, Object> save(Student student, 
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "collegeName", required = false) String collegeName,
			@RequestParam(value = "departmentName", required = false) String departmentName,
			@RequestParam(value = "projectId", required = false) String projectId,
			@RequestParam(value = "studentJson", required = false) String studentJson) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
 			if (StringUtils.isNotEmpty(studentJson)) {
				Gson gson = new Gson();
				List<Student> studentList = gson.fromJson(studentJson, new TypeToken<List<Student>>() {
				}.getType());
				for (Student student2 : studentList) {
					if (StringUtils.isNotEmpty(student2.getTrueName())) {
						student2.setName(student2.getTrueName());
					}
					student2.setAddr(address);
					student2.setTime(new Date());
					student2.setCollege(collegeName);
					student2.setProjectName(" ");
					student2.setYear(DateUtils.getCurrentYear());
					student2.setDepartment(departmentName);
					if (StringUtils.isNotEmpty(student2.getSexName())) {
						if ("男".equals(student2.getSexName())) {
							student2.setSex(1);
						} else if ("女".equals(student2.getSexName())) {
							student2.setSex(2);
						}
					}
					Student s2 = studentService.findByStudentName(student2.getName());
					if(s2 == null) {
						studentService.save(student2);
					}
					//保存并且报名
					if(StringUtils.isNotEmpty(projectId)) {
						String year = DateUtils.getCurrentYear();
						if(yearService.getByName(year) == null){
							Year y = new Year();
							y.setName(year);
							yearService.save(y);
						}
						Student s = studentService.findByStudentName(student2.getName());
						if(s != null) {
							if(studentProjectService.findByProjectIdAndStudentId(Integer.parseInt(projectId), s.getId())) {
								map.put("success", false);
								map.put("errorInfo", "报名失败，您已经报名，请勿重复报名！");
								return map;
							}
						}
						Project project = projectService.findById(Integer.parseInt(projectId));
						StudentProject studentProject = new StudentProject();
						student2.setId(s.getId());
						studentProject.setProject(project);
						studentProject.setStudent(student2);
						studentProjectService.save(studentProject);
						student2.setProjectName(DateUtils.getCurrentYear() + project.getName() + "," + student.getProjectName());
						studentService.save(student2);
					}
				}
				map.put("success", true);
				return map;
			}else {
				boolean flag = studentService.findByTrueName(student.getTrueName());
				if(!flag) {
					student.setName(student.getTrueName());
					student.setTime(new Date());
					studentService.save(student);
				}
				if(StringUtils.isNotEmpty(projectId)) {
					String year = DateUtils.getCurrentYear();
					if(yearService.getByName(year) == null){
						Year y = new Year();
						y.setName(year);
						yearService.save(y);
					}
					Student s = studentService.findByStudentName(student.getName());
					if(s != null) {
						if(studentProjectService.findByProjectIdAndStudentId(Integer.parseInt(projectId), s.getId())) {
							map.put("success", false);
							map.put("errorInfo", "报名失败，您已经报名，请勿重复报名！");
							return map;
						}
					}
					Project project = projectService.findById(Integer.parseInt(projectId));
					StudentProject studentProject = new StudentProject();
					student.setId(s.getId());
					studentProject.setProject(project);
					studentProject.setStudent(student);
					studentProjectService.save(studentProject);
					student.setProjectName(DateUtils.getCurrentYear() + project.getName() + "," + student.getProjectName());
					studentService.save(student);
				}
				map.put("success", true);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "发生未知错误，请联系管理员！");
			return map;
		}
	}
	/**
	 * 学生查找的外部接口
	 * @param name
	 * @param grade
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchStudentProject")
	public Map<String, Object> searchStudentProject(String name, String grade){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Student student = studentService.findByNameAndGrade(name, grade);
			if(StringUtils.isNotEmpty(student.getProjectName())) {
				map.put("info", student.getProjectName());
			}else {
				map.put("info", "请暂时没有任何参加的体育项目的信息");
			}
		}catch(Exception e) {
			map.put("info", "系统发生了异常，请联系系统管理员！");
		}
		return map;
	}

}
