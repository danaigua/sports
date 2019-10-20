package vip.wukong.service;

import java.util.List;

import vip.wukong.entity.Year;

public interface YearService {

	public void save(Year year);
	
	public List<Year> combobox();
	
	/**
	 * 通过名称获取年份表
	 * @param year
	 * @return
	 */
	public Year getByName(String year);
}
