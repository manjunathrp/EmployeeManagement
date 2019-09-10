package com.sakha.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.sakha.EmployeeDao.EmployeeDao;
import com.sakha.EmployeeDao.EmployeeDaoImpl;
import com.sakha.model.Employee;

public class AddEmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();
	public boolean addEmployee(Employee e) throws Exception
	{
		return dao.addEmployee(e);
	}
	public String generateId(String empName) {
		// TODO Auto-generated method stub
		String nameChar = empName.substring(0,2).toUpperCase();
		Random rand = new Random();
		int dgt = (int)(rand.nextDouble()*10000);
		return nameChar+dgt;
		//return null;
	}
	
}
