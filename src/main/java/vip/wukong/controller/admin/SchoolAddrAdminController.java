package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.SchoolAddr;
import vip.wukong.entity.Log;
import vip.wukong.service.SchoolAddrService;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.StudentService;
/**
 * 校区控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/schoolAddr")
public class SchoolAddrAdminController {

	@Resource
	private SchoolAddrService schoolAddrService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private StudentService studentService;
	
	@Resource
	private ProjectService projectService;
	
	/**
	 * 列出所有的校区名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<SchoolAddr> schoolAddrtList = schoolAddrService.listAll();
		for (SchoolAddr schoolAddr : schoolAddrtList) {
			map.put(schoolAddr.getId(), schoolAddr.getName());
		}
		return map;
	}
	/**
	 * 修改或者删除校区
	 * @param schoolAddr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(
			SchoolAddr schoolAddr
			,@RequestParam(value = "id", required = false)Integer id
			,@RequestParam(value = "field", required = false)String field
			,@RequestParam(value = "value", required = false)String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(id != null) {
			SchoolAddr oldSchoolAddr = schoolAddrService.findById(id);
			if("remarks".equals(field)) {
				oldSchoolAddr.setRemarks(value);
			}
			if("name".equals(field)) {
				oldSchoolAddr.setName(value);
			}
			schoolAddrService.save(oldSchoolAddr);
			logService.save(new Log(Log.UPDATE_ACTION, "修改了校区的字段" + schoolAddr));
		}else {
			logService.save(new Log(Log.ADD_ACTION, "新添加校区的字段" + schoolAddr));
			schoolAddrService.save(schoolAddr);
		}
		map.put("success", true);
		return map;
	}
	/**
	 * 列出所有的校区
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", schoolAddrService.listAll());
		map.put("count", schoolAddrService.getCount());
		map.put("msg", "");
		map.put("code", 0);
		return map;
	}
	/**
	 * 通过id删除一个校区
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		SchoolAddr schoolAddr = schoolAddrService.findById(id);
		//需要查找是否有绑定别的
		if(studentService.findBySchoolAddrName(schoolAddr.getName()).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该校区下面有学生信息，不能删除，如需删除请将学生更改为其他校区");
			return map;
		}
		if(projectService.findBySchoolAddr(schoolAddr.getName()).size() != 0) {
			map.put("success", false);
			map.put("errorInfo", "该校区下面有项目信息，不能删除，如需删除请将项目更改为其他校区");
			return map;
		}
		logService.save(new Log(Log.DELETE_ACTION, "删除一个校区" + schoolAddrService.findById(id)));
		schoolAddrService.delete(id);
		map.put("success", true);
		return map;
	}
}
