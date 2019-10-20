package vip.wukong.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.wukong.entity.Log;
import vip.wukong.service.LogService;
import vip.wukong.util.DateUtils;
import vip.wukong.util.StringUtils;

@RestController
@RequestMapping("/admin/log")
public class LogAdminController {

	@Resource
	private LogService logService;
	
	/**
	 * 列出所有日志
	 * @param log
	 * @param page
	 * @param time
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String, Object> list(Log log, @RequestParam(value = "page", required = false)Integer page,
			 @RequestParam(value = "beginAndEndTime", required = false)String beginAndEndTime,
			 @RequestParam(value = "limit", required = false)Integer limit) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(log != null && StringUtils.isNotEmpty(beginAndEndTime)) {
		//日期时间格式
		//2019-10-09 - 2019-11-21
			String[] dateStr = beginAndEndTime.split(" - ");
			log.setBtime(DateUtils.formatString2Date(dateStr[0]));
			log.setEtime(DateUtils.formatString2Date(dateStr[1]));
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", logService.list(log, page, limit, Direction.DESC, "time"));
		map.put("count", logService.getCount(log));
		logService.save(new Log(Log.ADD_ACTION, "查询系统日志"));
		return map;
	}
}
