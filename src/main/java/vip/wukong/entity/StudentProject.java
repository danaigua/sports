package vip.wukong.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 学生项目关联表
 * @author 章家宝
 *
 */
@Entity
@Table(name = "t_studentProject")
public class StudentProject {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
