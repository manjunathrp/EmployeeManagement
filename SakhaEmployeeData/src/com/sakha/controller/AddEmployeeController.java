package com.sakha.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sakha.model.Employee;
import com.sakha.service.AddEmployeeService;

/**
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/AddEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		float salary = Float.parseFloat(request.getParameter("salary"));
		Employee e = new Employee();
		e.setName(name);
		LocalDate localDate = LocalDate.parse(dob);
		e.setDob(localDate);
		e.setSalary(salary);
		ServletContext context = getServletContext();
		AddEmployeeService service = new AddEmployeeService();
		String id = service.generateId(name);
		e.setEmpId(id);
		try {
			boolean b = service.addEmployee(e);
			if(b)
			{
				context.setAttribute("success", "Employee added successfully");
			}
			else
			{
				context.setAttribute("error", "User already exist");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.sendRedirect("index.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
