package tr.com.can.employeemeeting.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@SequenceGenerator(initialValue=1, name="idgen", sequenceName="DEP_SEQ")
public class Department extends BaseEntity implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Column(name="D_NAME")
	private String name;
	
	@Column(name="D_DESCRIPTION")
	private String description;
	
	//relations
	@OneToMany(mappedBy="department")
	@JsonIgnore
	@Fetch(value = FetchMode.SELECT)
	private List<Employee>employeeList;
	
	
	
	public Department(){}

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

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	
}
