package vip.wukong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 项目-规则关联表
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_projectCollege")
public class ProjectCollege {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "collegeId")
	private College college;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "ProjectCollege [id=" + id + ", project=" + project + ", college=" + college + "]";
	}
	
	
}
