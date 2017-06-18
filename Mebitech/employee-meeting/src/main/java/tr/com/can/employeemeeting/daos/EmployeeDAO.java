package tr.com.can.employeemeeting.daos;

import org.springframework.stereotype.Repository;

import tr.com.can.employeemeeting.entities.Employee;

@Repository("employeeDAO")
public class EmployeeDAO extends BaseDAO<Integer, Employee>{
	
	  public Employee findById(Integer id) {
	    	Employee employee = getByID(id);
	        return employee;
	    }
	 
	    public Boolean save(Employee employee) {
			Boolean result = create(employee);
			return result;
	    }
}
