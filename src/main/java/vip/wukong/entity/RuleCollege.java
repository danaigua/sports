package vip.wukong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 学院-规则关联表
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_ruleCollege")
public class RuleCollege {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "ruleId")
	private Rule rule;
	
	@ManyToOne
	@JoinColumn(name = "collegeId")
	private College college;

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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "RuleCollege [id=" + id + ", rule=" + rule + ", college=" + college + "]";
	}
	
	
}
