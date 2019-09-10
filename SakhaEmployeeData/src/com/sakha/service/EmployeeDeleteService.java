package com.sakha.service;

import com.sakha.EmployeeDao.EmployeeDao;
import com.sakha.EmployeeDao.EmployeeDaoImpl;

public class EmployeeDeleteService {
	EmployeeDao dao = new EmployeeDaoImpl();
	public boolean delete(String empId) throws Exception
	{
		
		return dao.deleteEmployee(empId);
	}

}
