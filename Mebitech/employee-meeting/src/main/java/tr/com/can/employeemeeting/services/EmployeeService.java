package tr.com.can.employeemeeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.can.employeemeeting.daos.EmployeeDAO;
import tr.com.can.employeemeeting.entities.Employee;

@Transactional
@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public List<Employee> listAll(){
		return employeeDao.list();
	}
	
	public Employee findById(Integer id){
		return employeeDao.findById(id);
	}
	
	public Boolean saveEmployee(Employee e){
		Boolean result = employeeDao.save(e);
		return result;
	}
	
	public Boolean updateEmployee(Employee e){
		Employee emp = employeeDao.findById(e.getId());
		if(emp != null){
			emp.setName(e.getName());
			emp.setSurname(e.getSurname());
			emp.setSalary(e.getSalary());
			emp.setId(e.getId());
			employeeDao.update(emp);
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean deleteById(Integer id){
		Employee emp = employeeDao.findById(id);
		if (emp != null) {
			employeeDao.delete(emp);
			return true;
		}else{
			return false;
		}
	}
}
