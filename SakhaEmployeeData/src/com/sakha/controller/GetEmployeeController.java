package com.sakha.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sakha.service.GetEmployeeService;

/**
 * Servlet implementation class GetEmployeeController
 */
@WebServlet("/GetEmployeeController")
public class GetEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		ServletContext context = getServletContext();
		
		GetEmployeeService es = new GetEmployeeService();
		try {
			if(es.getEmployee(empId)!=null)
			{
				request.getSession().setAttribute("emp", es.getEmployee(empId));
			}
			else
			{
				context.setAttribute("error1","no employee in db");
			}
			response.sendRedirect("getEmp.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
