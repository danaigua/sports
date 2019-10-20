package vip.wukong.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 规则实体类
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_rule")
public class Rule {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50)
	private String teachers;//老师名称
	
	private int studentNum;//每一组的学生人数
	
	private int boyNum;
	
	private int girlNum;
	
	private int isSex;		//是否按照性别分组	 1是2不是
	
	private int isDepartment;//是否按照系院不同分组  1是2不是
	
	private int groupNum;//分组数
	
	private int troops;//队伍
	
	@Column(length = 1000)
	private String remarks;//备注
	
	@Transient
	private String isSexName;
	
	@Transient
	private String isDepartmentName;

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

	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public int getBoyNum() {
		return boyNum;
	}

	public void setBoyNum(int boyNum) {
		this.boyNum = boyNum;
	}

	public int getGirlNum() {
		return girlNum;
	}

	public void setGirlNum(int girlNum) {
		this.girlNum = girlNum;
	}

	public int getIsSex() {
		return isSex;
	}

	public void setIsSex(int isSex) {
		this.isSex = isSex;
	}

	public int getIsDepartment() {
		return isDepartment;
	}

	public void setIsDepartment(int isDepartment) {
		this.isDepartment = isDepartment;
	}


	@Override
	public String toString() {
		return "Rule [id=" + id + ", name=" + name + ", teachers=" + teachers + ", studentNum=" + studentNum
				+ ", boyNum=" + boyNum + ", girlNum=" + girlNum + ", isSex=" + isSex + ", isDepartment=" + isDepartment
				+ ", groupNum=" + groupNum + ", troops=" + troops + ", remarks=" + remarks + "]";
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getTroops() {
		return troops;
	}

	public void setTroops(int troops) {
		this.troops = troops;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getIsSexName() {
		return isSexName;
	}

	public void setIsSexName(String isSexName) {
		this.isSexName = isSexName;
	}

	public String getIsDepartmentName() {
		return isDepartmentName;
	}

	public void setIsDepartmentName(String isDepartmentName) {
		this.isDepartmentName = isDepartmentName;
	}

	
	
}
