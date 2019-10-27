package vip.wukong.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 项目实体
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_project")
public class Project {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String name;		//项目名称
	
	private int totalPerson;	//项目总人数
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher;			//领队
	
	@Column(length = 100)
	private String coach;				//教练名称
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;			//开始时间
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;					//立项目时间
	
	@Column(length = 100)
	private String year;				//年度如2017年度
	
	private Integer state;				//节点状态
	
	private Integer pid;				//父节点状态
	/**
	 * 填写校区
	 */
	@Column(length = 100)
	private String addr;
	
	@Column(length = 1000)
	private String remarks;		//备注
	
	@Column(length = 300)
	private String collegeOrDepartmentNum;//二级学院:30,计算机系:50
	
	@Transient
	private String eTime;
	
	@Transient
	private String bTime;

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", totalPerson=" + totalPerson + ", teacher=" + teacher
				+ ", coach=" + coach + ", startTime=" + startTime + ", time=" + time + ", year=" + year + ", state="
				+ state + ", pid=" + pid + ", addr=" + addr + ", remarks=" + remarks + ", collegeOrDepartmentNum="
				+ collegeOrDepartmentNum + ", eTime=" + eTime + ", bTime=" + bTime + "]";
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

	public int getTotalPerson() {
		return totalPerson;
	}

	public void setTotalPerson(int totalPerson) {
		this.totalPerson = totalPerson;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getbTime() {
		return bTime;
	}

	public void setbTime(String bTime) {
		this.bTime = bTime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCollegeOrDepartmentNum() {
		return collegeOrDepartmentNum;
	}

	public void setCollegeOrDepartmentNum(String collegeOrDepartmentNum) {
		this.collegeOrDepartmentNum = collegeOrDepartmentNum;
	}
	
}
