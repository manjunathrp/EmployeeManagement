package com.sakha.service;

import com.sakha.EmployeeDao.EmployeeDao;
import com.sakha.EmployeeDao.EmployeeDaoImpl;

public class UpdateEmployee {
	EmployeeDao dao =  new EmployeeDaoImpl();
	public boolean updateEmp(String empId,float salary) throws Exception
	{
		return dao.updateEmployee(empId, salary);
	}

}
