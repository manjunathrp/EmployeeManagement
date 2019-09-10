package com.sakha.EmployeeDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.sakha.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Connection con;
	public Connection getConnection() throws Exception
	{
		con = DriverManager.getConnection("jdbc:mysql://localhost/sakhadb","root","root");
		return con;
		
	}
	@Override
	public boolean addEmployee(Employee e) throws Exception {
		con =getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement("select * from emp where name="+"'"+e.getName()+"'");
		ResultSet r =  ps.executeQuery();
		if(r.next())
		{
			return false;
		}
		ps = con.prepareStatement("insert into emp values(?,?,?,?)");
		ps.setString(1, e.getEmpId());
		ps.setString(2, e.getName());
		LocalDate dob = e.getDob();
		//String strDate = dob.getYear()+"-"+dob.getMonthValue()+"-"+dob.getDayOfMonth();
		//ps.setString(3,strDate);
		ps.setDate(3, new java.sql.Date(dob.getYear()-1900,dob.getMonthValue()-1,dob.getDayOfMonth()));
		ps.setFloat(4, e.getSalary());
		int rs = ps.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		return false;
		
	}
	@Override
	public boolean deleteEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		con = getConnection();
		PreparedStatement ps = null;
		ps = con.prepareStatement("delete from emp where empid='"+empId+"'");
		int r = ps.executeUpdate();
		if(r>0)
		{
			return true;
		}
		return false;
	}
	public Employee getEmp(String empId) throws Exception
	{
		con = getConnection();
		PreparedStatement ps = null;
		Employee e = new Employee();
		ps = con.prepareStatement("select * from emp where empid='"+empId+"'");
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			e.setEmpId(rs.getString(1));
			e.setName(rs.getString(2));
			//LocalDate dob = e.getDob();
						//String strDate = dob.getYear()+"-"+dob.getMonthValue()+"-"+dob.getDayOfMonth();
			//ps.setString(3,strDate);
			//ps.setDate(3, new java.sql.Date(dob.getYear()-1900,dob.getMonthValue()-1,dob.getDayOfMonth()));
			//e.setDob(dob);
			e.setSalary(rs.getFloat(4));
			Date dob1 = rs.getDate(3);
			//LocalDate.of(dob1.getYear(), dob1.getMonth(), dob1.getDate());
			e.setDob(((java.sql.Date) dob1).toLocalDate());
			//ps.setDate(3, new java.sql.Date(dob1.getYear()-1900,dob1.getMonthValue()-1,dob1.getDayOfMonth()));
			//e.setDOB(dob1.toLocalDate());
			e.setSalary(rs.getFloat(4));
			return e;
		}
		return null;
	}
	public List<Employee> getAllEmployee() throws Exception
	{
		con = getConnection();
		PreparedStatement ps = null;
		List<Employee> emp = new ArrayList<>();
		Employee e= null;
		ps = con.prepareStatement("select * from emp");
		System.out.println("ehllo");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			
			e = new Employee();
			e.setEmpId(rs.getString(1));
			e.setName(rs.getString(2));
			//LocalDate dob = e.getDob();
						//String strDate = dob.getYear()+"-"+dob.getMonthValue()+"-"+dob.getDayOfMonth();
			//ps.setString(3,strDate);
			//ps.setDate(3, new java.sql.Date(dob.getYear()-1900,dob.getMonthValue()-1,dob.getDayOfMonth()));
			//e.setDob(dob);
			//e.setSalary(rs.getFloat(4));
			Date dob1 = rs.getDate(3);
			//LocalDate.of(dob1.getYear(), dob1.getMonth(), dob1.getDate());
			e.setDob(((java.sql.Date) dob1).toLocalDate());
			//ps.setDate(3, new java.sql.Date(dob1.getYear()-1900,dob1.getMonthValue()-1,dob1.getDayOfMonth()));
			//e.setDOB(dob1.toLocalDate());
			e.setSalary(rs.getFloat(4));
			System.out.println("hello");
			emp.add(e);
			
		}
		return emp;
	}
	public boolean updateEmployee(String empId,float salary) throws Exception
	{
		con = getConnection();
		PreparedStatement ps = null;
		int rs =0;
		if(empId !=null && salary >0)
		{
			ps = con.prepareStatement("update emp set salary ="+salary+" where empId='"+empId+"'");
			rs = ps.executeUpdate();
		}
		if(rs>0) {
			return true;
		}
		return false;
		
	}

}
