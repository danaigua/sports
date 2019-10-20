package vip.wukong.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 老师实体
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String name;			//老师账号	
	
	@Column(length = 50)
	private String trueName;		//真实姓名
	
	@Column(length = 50)
	private String telephone;		//老师电话
	
	@Column(length = 50)
	private String department;	//所属系部
	
	@Column(length = 50)
	private String college;		//学院
	
	@Column(length = 100)
	private String password;		//老师密码，默认是老师账号
	
	private Date time;				//创建添加时间
	
	@Column(length = 1000)
	private String remarks;		//备注
	
	@Transient
	private Date bTime;
	
	@Transient
	private Date eTime;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getbTime() {
		return bTime;
	}

	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}

	public Date geteTime() {
		return eTime;
	}

	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", trueName=" + trueName + ", telephone=" + telephone
				+ ", department=" + department + ", college=" + college + ", password=" + password + ", time=" + time
				+ ", remarks=" + remarks + ", bTime=" + bTime + ", eTime=" + eTime + "]";
	}
	
	
}
