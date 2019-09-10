<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#navigation-container {
 width: 1200px;
 margin: 0 auto;
 height: 70px;
}

.navigation-bar {
 background-color: #111;
 height: 70px;
 width: 100%;
 text-align:center;
}
.navigation-bar img{
float:left;
}
ul {
 list-style-type: none;
 margin: 0;
 padding: 0;
 overflow: hidden;
 background-color: #333;
}

li {
 float: right;
}

li a {
 display: block;
 color: white;
 text-align: center;
 padding: 14px 16px;
 text-decoration: none;
}

li a:hover {
 background-color: #grey;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="navigation-bar">


   <div id="navigation-container">

     <img src="sak.png" height=70 width=250>

<ul>
<li><a href="update.jsp">Update Employee</a></li>
<li><a href="delete.jsp">Delete Employee</a></li> 
<li><a href="getEmp.jsp">Get Employee</a></li>  
 <li><a href="getallemp.jsp">View All Employee</a></li>
   <li><a href="index.jsp">Add Employee</a></li>
      
       
      
      
     </ul>
   
 </div>
</div>

<h5>${success }</h5>
<h5>${error }</h5>
<form action="DeleteEmployeeController">
Delete employee:<input type="text" name="empId">
<input type="submit">
</form>
</body>
</html>