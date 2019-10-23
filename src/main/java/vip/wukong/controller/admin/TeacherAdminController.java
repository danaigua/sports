package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.College;
import vip.wukong.entity.Department;
import vip.wukong.entity.Log;
import vip.wukong.entity.Teacher;
import vip.wukong.service.CollegeService;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.TeacherService;
import vip.wukong.util.DateUtils;
import vip.wukong.util.Md5Utils;
import vip.wukong.util.StringUtils;
/**
 * 教师控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/teacher")
public class TeacherAdminController {

	@Resource
	private TeacherService teacherService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private CollegeService collegeService;
	/**
	 * 保存或者修改一个老师
	 * 
	 * @param teacher
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(Teacher teacher,
			@RequestParam(value = "field", required =false) String field,
			@RequestParam(value = "value", required = false) String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(teacher.getId() != null) {
			Teacher oldTeacher = teacherService.findById(teacher.getId());
			if("name".equals(field)) {
				oldTeacher.setName(value);
			}else if("trueName".equals(field)) {
				oldTeacher.setTrueName(value);
			}else if("telephone".equals(field)) {
				oldTeacher.setTelephone(value);
			}else if("department".equals(field)) {
				Department department = departmentService.findByName(value);
				if(department == null) {
					map.put("errorInfo", "修改不成功，您输入的系部不存在，请重新输入。");
					return map;
				}else {
					oldTeacher.setDepartment(department.getName());
				}
			}else if("college".equals(field)) {
				College college = collegeService.findByName(value);
				if(college == null) {
					map.put("errorInfo", "修改不成功，您输入的学院不存在，请重新输入。");
					return map;
				}else {
					oldTeacher.setCollege(college.getName());
				}
			}else if("password".equals(field)) {
				oldTeacher.setPassword(Md5Utils.md5(value, "sports"));
			}else if("remarks".equals(field)) {
				oldTeacher.setRemarks(value);
			}
			teacherService.save(oldTeacher);
			logService.save(new Log(Log.UPDATE_ACTION, "修改教师" + teacher));
		}else {
			logService.save(new Log(Log.ADD_ACTION, "添加教师" + teacher));
			teacherService.save(teacher);
		}
		map.put("success", true);
		return map;
	}
	/**
	 * 删除一个老师
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		teacherService.delete(id);
		map.put("success", true);
		return map;
	}
	/**
	 * 分页查询所有教师
	 * @param teacher
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(Teacher teacher, @RequestParam(value = "page", required = false)Integer page, 
			 @RequestParam(value = "limit", required = false)Integer limit,
			 @RequestParam(value = "beginAndEndTime", required = false) String beginAndEndTime) throws Exception{
		if(teacher != null && StringUtils.isNotEmpty(beginAndEndTime)) {
		//日期时间格式
		//2019-10-09 - 2019-11-21
			String[] dateStr = beginAndEndTime.split(" - ");
			teacher.setbTime(DateUtils.formatString2Date(dateStr[0]));
			teacher.seteTime(DateUtils.formatString2Date(dateStr[1]));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", teacherService.list(teacher, page - 1, limit, Direction.DESC, "time"));
		map.put("count", teacherService.getCount(teacher));
		logService.save(new Log(Log.SEARCH_ACTION, "查询所有的教师"));
		return map;
	}
}
