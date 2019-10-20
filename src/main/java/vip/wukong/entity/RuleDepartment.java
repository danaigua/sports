package vip.wukong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_ruleDepartment")
public class RuleDepartment {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ruleId")
	private Rule rule;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
