package vip.wukong.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.service.LogService;
import vip.wukong.service.StudentProjectService;
/**
 * 学生项目关联控制层
 * @author 章家宝
 *
 */
@RestController
@RequestMapping("/admin/studentProject")
public class StudentProjectAdminController {

	@Resource
	private StudentProjectService studentProjectService;
	
	@Resource
	private LogService logService;
	
	
}
