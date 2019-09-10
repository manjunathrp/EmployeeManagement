package com.sakha.service;

import com.sakha.EmployeeDao.EmployeeDao;
import com.sakha.EmployeeDao.EmployeeDaoImpl;
import com.sakha.model.Employee;

public class GetEmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();
	public Employee getEmployee(String empId) throws Exception
	{
		return dao.getEmp(empId);
	}

}
