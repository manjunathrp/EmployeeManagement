package com.sakha.service;

import java.util.List;

import com.sakha.EmployeeDao.EmployeeDao;
import com.sakha.EmployeeDao.EmployeeDaoImpl;
import com.sakha.model.Employee;

public class GetAllEmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();
	public List<Employee> getAllEmployee() throws Exception
	{
		 return dao.getAllEmployee();
	}
}
