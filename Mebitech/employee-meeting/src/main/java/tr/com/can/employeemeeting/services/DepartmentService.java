package tr.com.can.employeemeeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.can.employeemeeting.daos.DepartmentDAO;
import tr.com.can.employeemeeting.entities.Department;

@Transactional
@Service("departmentService")
public class DepartmentService {
	
	@Autowired
	private DepartmentDAO depDao;
	
	public List<Department> listAll(){
		return depDao.list();
	}
	
	public Department findById(Integer id){
		return depDao.findById(id);
	}
	
	public Boolean saveDepartment(Department d){
		 Boolean result = depDao.save(d);
		 return result;
	}
	
	public Boolean updateDepartment(Department d){
		Department dep = depDao.findById(d.getId());
		if (dep != null) {
			dep.setName(d.getName());
			dep.setDescription(d.getDescription());
			dep.setEmployeeList(d.getEmployeeList());
			depDao.update(dep);
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean deleteById(Integer id){
		Department dep = depDao.findById(id);
		if (dep != null) {
			depDao.delete(dep);
			return true;
		}else{
			return false;
		}
	}
}
