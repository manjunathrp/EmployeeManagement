package com.sakha.EmployeeDao;

import java.sql.Connection;
import java.util.List;

import com.sakha.model.Employee;

public interface EmployeeDao {
	public Connection getConnection() throws Exception;
	public boolean addEmployee(Employee e) throws Exception;
	public boolean deleteEmployee(String empId) throws Exception;
	public Employee getEmp(String empId) throws Exception;
	public List<Employee> getAllEmployee() throws Exception;
	public boolean updateEmployee(String empId,float salary) throws Exception;
}
