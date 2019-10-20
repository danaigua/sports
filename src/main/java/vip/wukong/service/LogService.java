package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.Log;

/**
 * 学院业务层接口
 * @author 章家宝
 *
 */
public interface LogService {

	/**
	 * 新建一条日志
	 * @param log
	 */
	public void save(Log log);
	/**
	 * 获取总记录数
	 * @param log
	 * @return
	 */
	public Long getCount(Log log);
	/**
	 * 分页查询一条日志
	 * @param log
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Log> list(Log log,Integer page, Integer pageSize, Direction direction, String...properties);
}
