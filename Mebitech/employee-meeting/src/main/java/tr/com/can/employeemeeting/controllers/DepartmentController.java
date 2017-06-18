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

import tr.com.can.employeemeeting.entities.Department;
import tr.com.can.employeemeeting.services.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService depService;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getDepartments(){
		List<Department> deps = this.depService.listAll();
		return new ResponseEntity<List<Department>>(deps, HttpStatus.OK);
	}
	
	@GetMapping(value = "/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id){
		Department dep = this.depService.findById(id);
		
		if (dep == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Department>(dep, HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department d){
		this.depService.saveDepartment(d);
		return new ResponseEntity<Department>(d, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Integer id, @RequestBody Department d){
		this.depService.updateDepartment(d);
		return new ResponseEntity<Department>(d, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/departments/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Integer id) {
		this.depService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}    
}
