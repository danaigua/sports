package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.College;
import vip.wukong.entity.Department;
import vip.wukong.entity.Log;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.StudentService;
/**
 * 系部控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/department")
public class DepartmentAdminController {

	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private StudentService studentService;
	
	@Resource
	private ProjectService projectService;
	/**
	 * 列出所有的系部
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", departmentService.listAll());
		map.put("count", departmentService.getCount());
		map.put("msg", "");
		map.put("code", 0);
		logService.save(new Log(Log.SEARCH_ACTION, "查询所有系部"));
		return map;
	}
	/**
	 * 列出所有的学院名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<Department> departmentList = departmentService.listAll();
		for (Department department : departmentList) {
			map.put(department.getId(), department.getName());
		}
		return map;
	}
	/**
	 * 保存或者修改系部
	 * @param department
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(Department department
			,@RequestParam(value = "id", required = false)Integer id
			,@RequestParam(value = "field", required = false)String field
			,@RequestParam(value = "value", required = false)String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(id != null) {
			Department oldDepartment = departmentService.findById(id);
			if("remarks".equals(field)) {
				oldDepartment.setRemarks(value);
			}
			if("name".equals(field)) {
				oldDepartment.setName(value);
			}
			logService.save(new Log(Log.UPDATE_ACTION, "修改系部" + department));
		}else {
			departmentService.save(department);
			logService.save(new Log(Log.ADD_ACTION, "添加系部" + department));
		}
		map.put("success", true);
		return map;
	}
	/**
	 * 通过id删除一个系部
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		//需要查找是否有绑定别的
		if(studentService.findByDepartmentName(departmentService.findById(id).getName()).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该系部下面有学生信息，不能删除，如需删除请将学生更改为其他系部");
			return map;
		}
		if(projectService.findByDepartmentId(id).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该系部下面有项目信息，不能删除，如需删除请将项目更改为其他系部");
			return map;
		}
		logService.save(new Log(Log.DELETE_ACTION, "删除一个系部" + departmentService.findById(id)));
		departmentService.delete(id);
		map.put("success", true);
		return map;
	}
}
