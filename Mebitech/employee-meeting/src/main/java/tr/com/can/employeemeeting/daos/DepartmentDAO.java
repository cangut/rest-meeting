package tr.com.can.employeemeeting.daos;

import org.springframework.stereotype.Repository;

import tr.com.can.employeemeeting.daos.BaseDAO;
import tr.com.can.employeemeeting.entities.Department;

@Repository("departmentDAO")
public class DepartmentDAO extends BaseDAO<Integer, Department>{
	
    public Department findById(Integer id) {
    	Department department = getByID(id);
        return department;
    }
 
    public Boolean save(Department department) {
		Boolean result = create(department);
		return result;
    }
}
