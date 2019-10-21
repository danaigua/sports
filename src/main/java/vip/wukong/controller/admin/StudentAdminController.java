package vip.wukong.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vip.wukong.entity.College;
import vip.wukong.entity.Department;
import vip.wukong.entity.Log;
import vip.wukong.entity.Project;
import vip.wukong.entity.Rule;
import vip.wukong.entity.Student;
import vip.wukong.entity.StudentBean;
import vip.wukong.service.CollegeService;
import vip.wukong.service.DepartmentService;
import vip.wukong.service.LogService;
import vip.wukong.service.ProjectService;
import vip.wukong.service.ProjectCollegeService;
import vip.wukong.service.ProjectDepartmentService;
import vip.wukong.service.RuleService;
import vip.wukong.service.StudentProjectService;
import vip.wukong.service.StudentService;
import vip.wukong.util.DateUtils;
import vip.wukong.util.MathUtils;
import vip.wukong.util.StringUtils;
/**
 * 学生控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/student")
public class StudentAdminController {

	@Resource
	private StudentService studentService;
	
	@Resource
	private LogService logService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private CollegeService collegeService;
	
	@Resource
	private DepartmentService departmentService;
	
	@Resource
	private StudentProjectService studentProjectService;
	
	@Resource
	private RuleService ruleService;
	
	@Resource
	private ProjectCollegeService ruleCollegeService;
	
	@Resource
	private ProjectDepartmentService ruleDepartmentService;
	/**
	 * 获取排序之后的学生
	 * @param projectId
	 * @param ruleId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSortStudent")
	public Map<String, Object> getSortStudent(@RequestParam(value = "projectId", required = false) Integer projectId,
			@RequestParam(value = "ruleId", required = false) Integer ruleId,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "year", required = false) String year) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, List<Student>> studentMap = new HashMap<String, List<Student>>();//存放不为空的系部/学院+索引名称的集合(不分男女)
		Map<String, List<Student>> studentBoyMap = new HashMap<String, List<Student>>();//存放不为空的男生系部/学院+索引名称的集合
		Map<String, List<Student>> studentGirlMap = new HashMap<String, List<Student>>();//存放不为空的女生系部/学院+索引名称的集合
		List<String> indexNameList = new ArrayList<String>();//存放系部/学院+索引名称的集合(不分男女)
		List<String> indexBoyNameList = new ArrayList<String>();//存放系部/学院+索引名称的集合
		List<String> indexGirlNameList = new ArrayList<String>();//存放系部/学院+索引名称的集合
		List<Student> result = new ArrayList<Student>();//最终结果
		List<Student> tempResult = new ArrayList<Student>();//临时结果（没有排序）
		List<Student> tempBoyResult = new ArrayList<Student>();//临时男生结果
		List<Student> tempGirlResult = new ArrayList<Student>();//临时女生结果
		map.put("code", 0);
		map.put("msg", "");
		int[] sex = {1, 2};
		int studentNum = 1;
		String projectName = "";
		if(projectId != null && ruleId != null) {
			Project project = projectService.findById(projectId);
			if(StringUtils.isEmpty(year)) {
				projectName = DateUtils.getCurrentYear() + project.getName();
			}else {
				projectName = year + project.getName();
			}
			
			Rule rule = ruleService.findById(ruleId);
			List<Department> departmentList = departmentService.listAll();
			List<College> colegeList = collegeService.listAll();
			for (Department department : departmentList) {
				for(int i = 0; i < sex.length; i++) {
					Student s_student = new Student();
					s_student.setAddr(address);
					s_student.setSex(sex[i]);
					s_student.setDepartment(department.getName());
					s_student.setProjectName(projectName);
					List<Student> departmentStudentList = studentService.listNoPage(s_student);
					for(Student s : departmentStudentList) {
						tempResult.add(s);
					}
					if(departmentStudentList.size() != 0 && i == 0) {
						Student s_student1 = new Student();
						s_student1.setAddr(address);
						s_student1.setDepartment(department.getName());
						s_student1.setProjectName(projectName);
						indexNameList.add(department.getName());
						List<Student> departmentStudentList1 = studentService.listNoPage(s_student1);
						studentMap.put(department.getName(), departmentStudentList1);
					}
					if(i == 0 && departmentStudentList.size() != 0) {
						indexBoyNameList.add(department.getName());
						studentBoyMap.put(department.getName(), departmentStudentList);
						for(Student s : departmentStudentList) {
							tempBoyResult.add(s);
						}
					}else if(i == 1 && departmentStudentList.size() != 0) {
						indexGirlNameList.add(department.getName());
						studentGirlMap.put(department.getName(), departmentStudentList);
						for(Student s : departmentStudentList) {
							tempGirlResult.add(s);
						}
					}
				}
			}
			for (College college : colegeList) {
				for(int i = 0; i < sex.length; i++) {
					if("广州工商学院".equals(college.getName())) {
						continue;
					}
					Student s_student = new Student();
					s_student.setAddr(address);
					s_student.setSex(sex[i]);
					s_student.setCollege(college.getName());
					s_student.setProjectName(projectName);
					List<Student> collegeStudnetList = studentService.listNoPage(s_student);
					for(Student s : collegeStudnetList) {
						tempResult.add(s);
					}
					if(collegeStudnetList.size() != 0 && i == 0) {
						Student s_student1 = new Student();
						s_student1.setAddr(address);
						s_student1.setCollege(college.getName());
						s_student1.setProjectName(projectName);
						List<Student> collegeStudnetList1 = studentService.listNoPage(s_student1);
						indexNameList.add(college.getName());
						studentMap.put(college.getName(), collegeStudnetList1);
					}
					if(i == 0 && collegeStudnetList.size() != 0) {
						indexBoyNameList.add(college.getName());
						studentBoyMap.put(college.getName(), collegeStudnetList);
						for(Student s : collegeStudnetList) {
							tempBoyResult.add(s);
						}
					}else if(i == 1 && collegeStudnetList.size() != 0){
						indexGirlNameList.add(college.getName());
						studentGirlMap.put(college.getName(), collegeStudnetList);
						for(Student s : collegeStudnetList) {
							tempGirlResult.add(s);
						}
					}
				}
			}
			//得到各个系的人数
			if(rule.getIsSex() == 1 && rule.getIsDepartment() == 1) {
				//分男女不同比赛
				//一个系一个队
				//得到一个系多少个队
				//得到各个系的集合
				//获取到每个系参加比赛的男女人数
				//分队----分成几组----一组多少个学生
				//男生组
				for (String str : indexBoyNameList) {
					if("广州工商学院".equals(str)) {
						continue;
					}
					//得到索引值
					List<Student> studentList = studentBoyMap.get(str);
					int boyStudentQueue = studentList.size() % rule.getBoyNum() == 0 ? 
							studentList.size() / rule.getBoyNum() : studentList.size() / rule.getBoyNum() + 1;
					//如果不等于0并且男生集合的长度大于零说明凑不满一队，则弄为一队
					if(boyStudentQueue == 0 && studentList.size() != 0) {
						boyStudentQueue = 1;
					}
					if(boyStudentQueue > 0) {
						int s = 0;
						for(int k = 0; k < boyStudentQueue; k++) {
							studentNum ++;
							for(int l = 0; l < rule.getBoyNum(); l++) {
								s++;
								if(s < studentList.size()) {
									studentList.get(s).setQueue(str + "男生第" + studentNum + "队第" + (l + 1) + "号");
									result.add(studentList.get(s));
								}	
							}
						}
					}
				}
				for (String str : indexGirlNameList) {
					if("广州工商学院".equals(str)) {
						continue;
					}
					//得到索引值
					List<Student> studentList = studentGirlMap.get(str);
					int girlStudentQueue = studentList.size() % rule.getBoyNum() == 0 ? 
							studentList.size() / rule.getBoyNum() : studentList.size() / rule.getBoyNum() + 1;
					//如果不等于0并且男生集合的长度大于零说明凑不满一队，则弄为一队
					if(girlStudentQueue == 0 && studentList.size() != 0) {
						girlStudentQueue = 1;
					}
					if(girlStudentQueue > 0) {
						int s = 0;
						for(int k = 0; k < girlStudentQueue; k++) {
							studentNum ++;
							for(int l = 0; l < rule.getBoyNum(); l++) {
								if(s < studentList.size()) {
									studentList.get(s).setQueue(str + "男生第" + studentNum + "队第" + (l + 1) + "号");
									result.add(studentList.get(s));
								}
								s++;
							}
						}
					}
				}
				
				logService.save(new Log(Log.SEARCH_ACTION, "生成比赛报表"));
				map.put("code", 0);
				map.put("msg", "");
				map.put("data", result);
				return map;
			}else if(rule.getIsSex() == 1 && rule.getIsDepartment() == 2) {
				//分男女不同比赛
//				同一个性别不同的系混合
				int boyTeamNum = rule.getBoyNum();//获得男生一组需要多少人
				int girlTeamNum = rule.getGirlNum();//获得男生一组需要分多少人
				int boyNum = tempBoyResult.size();//实际上的男生人数
				int girlNum = tempGirlResult.size();//实际上的女生人数
				String radomBoyString = MathUtils.getNumberNoRepeat(boyNum);//获取男生的随机数
				String radomGirlString = MathUtils.getNumberNoRepeat(girlNum);//获取女生的随机数
				String[] radomBoyStrings = radomBoyString.split(",");
				String[] radomGirlStrings = radomGirlString.split(",");
				int s = 0;//记录队伍数
				int m = 0;//记录下标数
				int n = 0;//记录下标数
				//存到一个集合里面
				int forNum = boyNum % boyTeamNum == 0 ?  boyNum / boyTeamNum : boyNum / boyTeamNum + 1;//得到一个组实际上的组数
				for(int i = 0; i < forNum; i++) {
					s++;
					for(int j = 0; j < boyTeamNum; j++) {
						if(m < boyNum) {
							Student student = tempBoyResult.get(Integer.parseInt(radomBoyStrings[m]));
							m++;
							student.setQueue("第" + s + "队第" + (j + 1) + "号");
							result.add(student);
						}
					}
				}
				for(int i = 0; i < forNum; i++) {
					s++;
					for(int j = 0; j < girlTeamNum; j++) {
						if(n < girlNum) {
							Student student = tempGirlResult.get(Integer.parseInt(radomGirlStrings[n]));
							n++;
							student.setQueue("第" + s + "队第" + (j + 1) + "号");
							result.add(student);
						}
					}
				}
				logService.save(new Log(Log.SEARCH_ACTION, "生成比赛报表"));
				map.put("code", 0);
				map.put("msg", "");
				map.put("data", result);
				return map;
			}else if(rule.getIsSex() == 2 && rule.getIsDepartment() == 1) {
				//不分男女，但是一个系一个队
				//indexNameList名称下表，可以取到系/院的集合值
				//studentMap可以通过indexNameList取到值
				for(String str : indexNameList) {
					List<Student> s_list = studentMap.get(str);
					int teamNUms = s_list.size() % rule.getStudentNum() == 0 ? s_list.size() / rule.getStudentNum() : 
						s_list.size() / rule.getStudentNum() + 1;
					if(teamNUms == 0) {
						teamNUms = 1;
					}
					int t = 0;
					int p = 0;
					for(int i = 0; i < teamNUms; i++) {
						t++;
						for(int j = 0; j < rule.getStudentNum(); j++) {
							if(p < s_list.size()) {
								Student student3 = s_list.get(p);
								student3.setQueue(str + "第" + t + "队第" + (j + 1) + "号");
								result.add(student3);
								p++;
							}
						}
					}
				}
				map.put("code", 0);
				map.put("msg", "");
				map.put("data", result);
				return map;
			}else if(rule.getIsSex() == 2 && rule.getIsDepartment() == 2) {
				//不分男女， 不同系不同队
				//tempResult得到一个大集合，不分男女
				int count = tempResult.size();
				String radomPersonString = MathUtils.getNumberNoRepeat(count);
				String[] radomPersonStrings = radomPersonString.split(",");
				int studentNums = rule.getStudentNum();
				int teamNums = count % studentNums == 0 ? count / studentNums : count / studentNums + 1;
				int y = 0;
				int x = 0;
				if(count > 0) {
					for ( int i = 0; i < teamNums; i++) {
						y++;
						for(int j = 0; j < studentNums; j++) {
							if(x < count) {
								Student student = tempResult.get(Integer.parseInt(radomPersonStrings[x]));
								student.setQueue("第" + y + "队第" + (j + 1) + "号");
								result.add(student);
								x++;
							}
						}
					}
				}
				logService.save(new Log(Log.SEARCH_ACTION, "生成比赛报表"));
				map.put("code", 0);
				map.put("msg", "");
				map.put("data", result);
				return map;
			}
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", studentService.listNoPage(null));
		logService.save(new Log(Log.SEARCH_ACTION, "生成比赛报表"));
		return map;
	}
	
	/**
	 * 获取详细信息
	 * @param department
	 * @param college
	 * @param year
	 * @param projectId
	 * @param addr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCountInfo")
	public Map<String, Object> getCountInfo(
			@RequestParam(value = "department", required = false) String department,
			@RequestParam(value = "college", required = false) String college,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "projectId", required = false) Integer projectId,
			@RequestParam(value = "address", required = false) String address)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		//获取项目名称
		Project project = projectService.findById(projectId);
		if(StringUtils.isEmpty(year)) {
			year = DateUtils.getCurrentYear();
		}
		int[] sex = {1, 2};
		String teamName = year + project.getName();
		if(StringUtils.isNotEmpty(department) || StringUtils.isNotEmpty(college)) {
			for(int i = 0; i < sex.length; i++) {
				Student student = new Student();
				student.setAddr(address);
				student.setSex(sex[i]);
				student.setCollege(college);
				student.setProjectName(teamName);
				student.setDepartment(department);
				List<Student> studentList = studentService.listNoPage(student);
				String people = "";
				int k = 0;
				for (Student student2 : studentList) {
					if(k == 0) {
						people += student2.getTrueName();
					}else {
						people = people + "," + student2.getTrueName();
					}
					k++;
				}
				map.put("sex" + sex[i], people);
			}
		}
		logService.save(new Log(Log.SEARCH_ACTION, "获取详细信息"));
		
		return map;
	}
	/**
	 * 获取到项目的个院系情况
	 * @param student
	 * @param projectId
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/count")
	public Map<String, Object> count(Student student, 
			@RequestParam(value = "projectId", required = false) Integer projectId,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "address", required = false) String address) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<StudentBean> studentBeanList = new ArrayList<StudentBean>();
		//获取项目名称
		Project project = projectService.findById(projectId);
		//获取全部系部
		String y = address.replace(",", "");
		List<Department> departmentList = departmentService.listAll();
		//获取全部的学院
		List<College> collegeList = collegeService.listAll();
		//获取比赛名称
		String yearStr = year.replace(",", "");
		if(year == null) {
			yearStr = DateUtils.getCurrentYear();
		}
		String teamName = yearStr + project.getName();
		//性别 1男	2女
		int[] sex = {1, 2};
		//获取系部总人数
		for(Department department : departmentList) {
			StudentBean studnetBean = new StudentBean();
			studnetBean.setCollege("广州工商学院");
			studnetBean.setDepartment(department.getName());
			for(int i = 0; i < sex.length; i++) {
				Student s_student = new Student();
				s_student.setDepartment(department.getName());
				s_student.setSex(sex[i]);
				s_student.setProjectName(teamName);
				s_student.setAddr(y);
				if(i == 0) {
					studnetBean.setSex1(studentService.listNoPage(s_student).size());
				}else {
					studnetBean.setSex2(studentService.listNoPage(s_student).size());
				}
			}
			studentBeanList.add(studnetBean);
		}
		//获取学院总人数
		for(College college : collegeList) {
			StudentBean studnetBean = new StudentBean();
			studnetBean.setCollege(college.getName());
			for(int i = 0; i < sex.length; i++) {
				Student s_student = new Student();
				s_student.setCollege(college.getName());
				s_student.setSex(sex[i]);
				s_student.setProjectName(teamName);
				if(i == 0) {
					studnetBean.setSex1(studentService.listNoPage(s_student).size());
				}else {
					studnetBean.setSex2(studentService.listNoPage(s_student).size());
				}
			}
			studentBeanList.add(studnetBean);
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", studentBeanList);
		logService.save(new Log(Log.SEARCH_ACTION, "获取到项目的个院系情况"));
		return map;
		
	}
	/**
	 * 在项目的地方展示所有
	 * @param student
	 * @param page
	 * @param beginAndEndTime
	 * @param limit
	 * @param collegeId
	 * @param departmentId
	 * @param projectNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listAll")
	public Map<String, Object> listAll(Student student, @RequestParam(value = "page", required = false)Integer page,
			 @RequestParam(value = "limit", required = false)Integer limit,
			 @RequestParam(value = "collegeId", required = false)Integer collegeId,
			 @RequestParam(value = "departmentId", required = false)Integer departmentId,
			 @RequestParam(value = "projectNum", required = false)Integer projectNum) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(projectNum != null) {
			Project project = projectService.findById(projectNum);
			student.setProjectName(project.getName());
		}
		if(collegeId != null) {
			College college = collegeService.findById(collegeId);
			student.setCollege(college.getName());
		}
		if(departmentId != null) {
			Department department = departmentService.findById(departmentId);
			student.setDepartment(department.getName());
		}
		List<Student> studentList = studentService.listAll(student, Direction.ASC, "time");
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", studentList);
		map.put("count", studentService.getCount(student));
		logService.save(new Log(Log.SEARCH_ACTION, "查询所有的学生（无分页）"));
		return map;
	}
	/**
	 * 分页查询所有学生
	 * @param student
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(Student student, @RequestParam(value = "page", required = false)Integer page,
			 @RequestParam(value = "beginAndEndTime", required = false)String beginAndEndTime,
			 @RequestParam(value = "limit", required = false)Integer limit,
			 @RequestParam(value = "collegeId", required = false)Integer collegeId,
			 @RequestParam(value = "departmentId", required = false)Integer departmentId,
			 @RequestParam(value = "address", required = false)String address,
			 @RequestParam(value = "projectNum", required = false)Integer projectNum) throws Exception{
		if(projectNum != null) {
			Project project = projectService.findById(projectNum);
			student.setProjectName(project.getName());
		}
		if(collegeId != null) {
			College college = collegeService.findById(collegeId);
			student.setCollege(college.getName());
		}
		if(departmentId != null) {
			Department department = departmentService.findById(departmentId);
			student.setDepartment(department.getName());
		}
		if(student != null && StringUtils.isNotEmpty(beginAndEndTime)) {
		//日期时间格式
		//2019-10-09 - 2019-11-21
			String[] dateStr = beginAndEndTime.split(" - ");
			student.setbTime(DateUtils.formatString2Date(dateStr[0]));
			student.seteTime(DateUtils.formatString2Date(dateStr[1]));
		}
		if(StringUtils.isNotEmpty(address)) {
			student.setAddr(address);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> studentList = studentService.list(student, page, limit, Direction.ASC, "time");
		for (Student student2 : studentList) {
			if(student2.getSex() == 1) {
				student2.setSexName("男");
			}
			if(student2.getSex() == 2) {
				student2.setSexName("女");
			}
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", studentList);
		map.put("count", studentService.getCount(student));
		logService.save(new Log(Log.SEARCH_ACTION, "查询所有的学生"));
		return map;
	}
	/**
	 * 添加学生
	 * @param student
	 * @param page
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(Student student,
			@RequestParam(value = "field", required =false) String field,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "collegeName", required = false) String collegeName,
			@RequestParam(value = "departmentName", required = false) String departmentName,
			@RequestParam(value = "studentJson", required = false) String studentJson) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(StringUtils.isNotEmpty(studentJson)) {
				Gson gson = new Gson();
				List<Student> studentList = gson.fromJson(studentJson, new TypeToken<List<Student>>() {}.getType());
				for (Student student2 : studentList) {
					if(StringUtils.isNotEmpty(student2.getTrueName())) {
						student2.setName(student2.getTrueName());
					}
					student2.setAddr(departmentName);
					student2.setTime(new Date());
					student2.setCollege(address);
					student2.setProjectName(" ");
					student2.setDepartment(collegeName);
					if(StringUtils.isNotEmpty(student2.getSexName())) {
						if("男".equals(student2.getSexName())) {
							student2.setSex(1);
						}else if("女".equals(student2.getSexName())) {
							student2.setSex(2);
						}
					}
					//如果学院跟系部冲突，则系部设置为空
					if(StringUtils.isNotEmpty(student2.getCollege()) && (!"广州工商学院".equals(student2.getCollege()))) {
						student2.setDepartment("");
					}
					studentService.save(student2);
				}
				map.put("success", true);
				return map;
			}
		}catch(Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "格式错误，请重新输入正确格式的学生信息！");
			return map;
		}
		if(student.getId() != null) {
			Student oldStudent = studentService.findById(student.getId());
			if("name".equals(field)) {
				oldStudent.setName(value);
			}else if("trueName".equals(field)) {
				oldStudent.setTrueName(value);
			}else if("studentNumber".equals(field)) {
				oldStudent.setStudentNumber(value);
			}else if("department".equals(field)) {
				Department department = departmentService.findByName(value);
				if(department == null) {
					map.put("errorInfo", "对不起，您所输入的系部不存在，请重新输入！");
					return map;
				}else {
					oldStudent.setDepartment(department.getName());
				}
			}else if("grade".equals(field)) {
				oldStudent.setGrade(value);
			}else if("clazz".equals(field)) {
				oldStudent.setClazz(value);
			}else if("remarks".equals(field)) {
				oldStudent.setRemarks(value);
			}else if("telephone".equals(field)) {
				oldStudent.setTelephone(value);
			}else if("college".equals(field)) {
				College college = collegeService.findByName(value);
				if(college == null) {
					map.put("errorInfo", "对不起，您所输入的学院不存在，请重新输入！");
					return map;
				}else {
					oldStudent.setCollege(value);
				}
			}else if("sexName".equals(field)) {
				if("男".equals(value)) {
					oldStudent.setSex(1);
				}else if("女".equals(value)) {
					oldStudent.setSex(2);
				}else {
					map.put("errorInfo", "请输入“男” 或者 “女”");
					return map;
				}
			}else if("projectName".equals(field)) {
				oldStudent.setProjectName(value);
			}
			studentService.save(oldStudent);
			logService.save(new Log(Log.UPDATE_ACTION, "修改学生" + oldStudent));
		}else {
			studentService.save(student);
			logService.save(new Log(Log.ADD_ACTION, "添加学生" + student));
		}
		map.put("success", true);
		return map;
	}
	/**
	 * 删除学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String, Object> save(Integer id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(studentProjectService.findByStudentId(id).size() > 0) {
			map.put("success", false);
			map.put("errorInfo", "该学生参加了比赛项目不能删除！");
			return map;
		}
		logService.save(new Log(Log.DELETE_ACTION, "删除学生" + studentService.findById(id)));
		studentService.delete(id);
		map.put("success", true);
		return map;
	}
}