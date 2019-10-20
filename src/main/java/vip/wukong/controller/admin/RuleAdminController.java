package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.Log;
import vip.wukong.entity.Rule;
import vip.wukong.service.RuleService;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.RuleCollegeService;
import vip.wukong.service.RuleDepartmentService;
import vip.wukong.service.StudentService;
/**
 * 规则控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/rule")
public class RuleAdminController {

	@Resource
	private RuleService ruleService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private StudentService studentService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private RuleCollegeService ruleCollegeService;
	
	@Resource
	private RuleDepartmentService ruleDepartmentService;
	
	/**
	 * 列出所有的规则名称	combobox用到
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox() throws Exception{
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<Rule> ruleList = ruleService.listAll(null, Direction.ASC, "id");
		for (Rule rule : ruleList) {
			map.put(rule.getId(), rule.getName());
		}
		return map;
	}
	/**
	 * 修改或者删除规则
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(
			Rule rule
			,@RequestParam(value = "id", required = false)Integer id
			,@RequestParam(value = "field", required = false)String field
			,@RequestParam(value = "value", required = false)String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(rule.getId() == null) {
			ruleService.save(rule);
			logService.save(new Log(Log.ADD_ACTION, "添加一条规则" + rule));
		}else {
			try {
				int i = 0;
				Rule r = ruleService.findById(id);
				if("name".equals(field)) {
					r.setName(value);
				}else if("teachers".equals(field)) {
					r.setTeachers(value);
				}else if("studentNum".equals(field)) {
					i = Integer.parseInt(value);
					r.setStudentNum(i);
				}else if("boyNum".equals(field)) {
					i = Integer.parseInt(value);
					r.setBoyNum(i);
				}else if("girlNum".equals(field)) {
					i = Integer.parseInt(value);
					r.setGirlNum(i);
				}else if("isSex".equals(field)) {
					i = Integer.parseInt(value);
					r.setIsSex(i);
				}else if("isDepartment".equals(field)) {
					i = Integer.parseInt(value);
					r.setIsDepartment(i);
				}else if("groupNum".equals(field)) {
					i = Integer.parseInt(value);
					r.setGroupNum(i);
				}
				ruleService.save(r);
				logService.save(new Log(Log.UPDATE_ACTION, "修改一条规则" + r));
			}catch (Exception e) {
				map.put("success", false);
				map.put("error", "数据转换出现异常，请正确输入数据");
				return map;
			}
			
		}
		return map;
	}
	/**
	 * 列出所有的规则
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", ruleService.listAll(null, Direction.ASC, "id"));
		return map;
	}
	/**
	 * 通过id删除一个规则
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		logService.save(new Log(Log.DELETE_ACTION, "删除规则" + ruleService.findById(id)));
		ruleCollegeService.deleteByRuletId(id);
		ruleDepartmentService.deleteByRuletId(id);
		ruleService.delete(id);
		return map;
	}
}
