package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.College;
import vip.wukong.entity.Log;
import vip.wukong.service.CollegeService;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.StudentService;
import vip.wukong.util.StringUtils;
/**
 * 学院控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/college")
public class CollegeAdminController {

	@Resource
	private CollegeService collegeService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private StudentService studentService;
	
	@Resource
	private ProjectService projectService;
	
	/**
	 * 列出所有的学院名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<College> collegetList = collegeService.listAll();
		for (College college : collegetList) {
			map.put(college.getId(), college.getName());
		}
		return map;
	}
	/**
	 * 修改或者删除学院
	 * @param college
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(
			College college
			,@RequestParam(value = "id", required = false)Integer id
			,@RequestParam(value = "field", required = false)String field
			,@RequestParam(value = "value", required = false)String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(id != null) {
			College oldCollege = collegeService.findById(id);
			if("remarks".equals(field)) {
				oldCollege.setRemarks(value);
			}
			if("name".equals(field)) {
				oldCollege.setName(value);
			}
			collegeService.save(oldCollege);
			logService.save(new Log(Log.UPDATE_ACTION, "修改了学院的字段" + college));
		}else {
			logService.save(new Log(Log.ADD_ACTION, "新添加学院的字段" + college));
			collegeService.save(college);
		}
		map.put("success", true);
		return map;
	}
	/**
	 * 列出所有的学院
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", collegeService.listAll());
		map.put("count", collegeService.getCount());
		map.put("msg", "");
		map.put("code", 0);
		return map;
	}
	/**
	 * 通过id删除一个学院
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		College college = collegeService.findById(id);
		//需要查找是否有绑定别的
		if(studentService.findByCollegeName(college.getName()).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该学院下面有学生信息，不能删除，如需删除请将学生更改为其他学院");
			return map;
		}
		if(projectService.findByCollege(id).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该学院下面有项目信息，不能删除，如需删除请将项目更改为其他学院");
			return map;
		}
		logService.save(new Log(Log.DELETE_ACTION, "删除一个学院" + collegeService.findById(id)));
		collegeService.delete(id);
		map.put("success", true);
		return map;
	}
}
