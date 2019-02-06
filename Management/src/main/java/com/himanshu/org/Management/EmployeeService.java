package com.himanshu.org.Management;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.himanshu.org.Management.model.Employee;
import com.himanshu.org.Management.model.Project;

@Path("/employees")
public class EmployeeService {
	
	public static HashMap projectMap = new HashMap();
	public static Map<Integer,Employee> employees  = new HashMap();
	public static int lastEmp = 16;
	static {
		employees.put(1,new Employee(1, "Rakesh", 12000));
		employees.put(2,new Employee(2, "Kamal", 1270));
		employees.put(3,new Employee(3, "Suresh", 7600));
		employees.put(4,new Employee(4, "Seema", 34000));
	}
	@GET
	@Produces(value = {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Employee> getEmpolyee(@QueryParam("id") int eid){	
		if(eid == 0)
		return  (List) employees.values();
		
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employees.get(eid));
		return employeeList;
	}
	
	@GET
	@Produces(value = {MediaType.TEXT_XML,MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public  Employee getEmpolyees(@PathParam("id") int emp_id){		
		return employees.get(emp_id);
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addEmpoyee(Employee emp) {
		emp.setEno(employees.size());
		employees.put(emp.getEno(),emp);
		return "Added successfull";
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateEmployee(Employee emp) {
		
		int salary = emp.getSalary();
		
		Employee employee = employees.get(emp.getEno());
		employee.setSalary(salary);
		return "Employee updated successfully";
		
		
	}
	
	@DELETE
	public String deleteEmp(Employee emp) {
		if(employees.containsKey(emp.getEno()))
		{
			employees.remove(emp.getEno());
			return "Employee deleted successfully";
			
		}else {
			return "Unable to find employee "+emp.getEno();
		}
	}
	
	/*@Produces(MediaType.APPLICATION_JSON)
	@Path("/a/b")
	public String getProjectResource() {
		return "getProjectResource return string";
	}*/
	

	
	@Path("/{id}/projects")
	@Produces(MediaType.APPLICATION_JSON)
	public  ProjectService getProjectResource(){		
		return new ProjectService();
	}
		
		
	
	
	
	
	
	
	

}
