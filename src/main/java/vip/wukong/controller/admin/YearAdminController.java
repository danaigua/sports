package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.Year;
import vip.wukong.service.YearService;

@RestController
@RequestMapping("/admin/year")
public class YearAdminController {

	@Resource
	private YearService yearService;
	/**
	 * 获取年份的combobox
	 * @return
	 */
	@RequestMapping("/combobox")
	public Map<Integer, Object> combobox(){
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		List<Year> yearList = yearService.combobox();
		for (Year year : yearList) {
			map.put(year.getId(), year.getName());
		}
		return map;
	}
}
