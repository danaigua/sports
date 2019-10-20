package vip.wukong.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vip.wukong.service.LogService;
import vip.wukong.service.StudentService;
/**
 * 根目录控制层
 * @author 章家宝
 *
 */
@Controller
public class IndexController {

	@Resource
	private StudentService studentService;
	
	@Resource
	private LogService logService;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/login.html";
	}
}
