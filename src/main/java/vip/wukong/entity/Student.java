package vip.wukong.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 学生实体
 * 
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_student")
public class Student {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 50)
	private String name; // 学生账号

	@Column(length = 50)
	private String trueName; // 学生真实姓名

	@Column(length = 12)
	private String studentNumber; // 学生学号

	@Column(length = 20)
	private String password; // 学生密码（初始密码为学号）

	@Column(length = 20)
	private String telephone; // 学生电话

	@Column(length = 40)
	private String department; // 学生所在系部

	@Column(length = 10)
	private String grade; // 学生所在年级

	@Column(length = 20)
	private String major; // 学生所在的专业

	@Column(length = 20)
	private String clazz; // 学生所在班级

	@Column(length = 1000)
	private String remarks; // 备注

	@Column(length = 40)
	private String college; // 学院

	private int sex; // 性别 1男 2女

	private Date time; // 创建添加时间
	
	@Column(length = 40)
	private String addr;	//校区

	@Transient
	private Date bTime;

	@Transient
	private Date eTime;
	
	@Transient
	private String sexName;

	@Column(length = 1000)
	private String projectName;
	
	@Transient
	private String queue;//队伍信息

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

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}



	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", trueName=" + trueName + ", studentNumber=" + studentNumber
				+ ", password=" + password + ", telephone=" + telephone + ", department=" + department + ", grade="
				+ grade + ", major=" + major + ", clazz=" + clazz + ", remarks=" + remarks + ", college=" + college
				+ ", sex=" + sex + ", time=" + time + ", bTime=" + bTime + ", eTime=" + eTime + ", projectName="
				+ projectName + "]";
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getbTime() {
		return bTime;
	}

	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date geteTime() {
		return eTime;
	}

	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}
	
}
