package tr.com.can.employeemeeting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.com.can.employeemeeting.entities.Employee;
import tr.com.can.employeemeeting.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = this.empService.listAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    	this.empService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
		Employee emp = this.empService.findById(id);
		if (emp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
	}
	
	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee e){
		this.empService.updateEmployee(e);
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
    	//TODO: check result		
		this.empService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
