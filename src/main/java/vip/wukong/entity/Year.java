package vip.wukong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 日志实体
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_year")
public class Year {
	@Id
	@GeneratedValue
	private Integer id;		//编号
	
	@Column(length = 100)
	private String name;	//日志类型

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
