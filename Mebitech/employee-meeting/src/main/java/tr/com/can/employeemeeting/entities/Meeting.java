package tr.com.can.employeemeeting.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="MEETING")
@SequenceGenerator(initialValue=1, name="idgen", sequenceName="MEE_SEQ")
public class Meeting extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="M_NAME")
	private String name;

	@Column(name="M_DESCRIPTION")
	private String description;


   
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = EAGER)
	@JoinTable(name = "MEETING_DEPARTMENT", 
			   joinColumns = { @JoinColumn(name = "MEETING_ID") }, 
			   inverseJoinColumns = { @JoinColumn(name = "DEPARTMENT_ID") })
	@Fetch(value = FetchMode.SELECT)
	private List<Department> department;

	public Meeting() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}
}	
