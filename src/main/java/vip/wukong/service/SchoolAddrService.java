package vip.wukong.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import vip.wukong.entity.SchoolAddr;

/**
 * 校区业务层接口
 * @author 章家宝
 *
 */
public interface SchoolAddrService {

	
	/**
	 * 添加或者修改校区
	 * @param schoolAddr
	 */
	public void save(SchoolAddr schoolAddr);
	/**
	 * 通过id删除一个校区
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
	/**
	 * 列出所有校区
	 * @return
	 */
	public List<SchoolAddr> list(Integer page, Integer pageSize, Direction direction, String...properties);
	/**
	 * 列出所有的校区
	 * @return
	 */
	public List<SchoolAddr> listAll();
	/**
	 * 通过名称查找校区
	 * @param schoolAddrName
	 * @return
	 */
	public SchoolAddr findByName(String schoolAddrName);
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public SchoolAddr findById(Integer id);
	
}
