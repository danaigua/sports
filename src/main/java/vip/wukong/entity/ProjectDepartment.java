package vip.wukong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_projectDepartment")
public class ProjectDepartment {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
