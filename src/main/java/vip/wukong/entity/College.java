package vip.wukong.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 学院实体
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_college")
public class College {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String name;		//学院名称
	
	@Column(length = 1000)
	private String remarks;		//备注
	
	private Integer num;		//院可以报名的人数
	
	
	@Column(length = 50)
	private String leader;
	
	@Column(length = 50)
	private String coach;
	
	@Column(length = 50)
	private String coach1;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", remarks=" + remarks + ", num=" + num + ", leader=" + leader
				+ ", coach=" + coach + ", coach1=" + coach1 + ", time=" + time + "]";
	}
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getCoach1() {
		return coach1;
	}

	public void setCoach1(String coach1) {
		this.coach1 = coach1;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
