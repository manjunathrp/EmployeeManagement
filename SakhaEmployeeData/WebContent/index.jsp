<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Database</title>
<head>
<style>
/* body {
height: -webkit-fill-available;
}

body {
margin: 0;
background: linear-gradient(45deg, #49a09d, #5f2c82);
font-family: sans-serif;
font-weight: 100;
} */

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
   <li><a href="#">Add Employee</a></li>
      
       
      
      
     </ul>
   
 </div>
</div>
<h5>${success }</h5>
<h5>${error }</h5>
<form action="AddEmployeeController">
<table cellpadding="5">
<caption><h2>Add Employee</h2></caption>
<thead>
<tr>
<td><b>Employee name</b></td>
<td><input type="text" placeholder="name"  name="name" required></td>
</tr>
<tr>
<td><b>Date of birth</b></td>
<td><input type="date" placeholder="yyyy-mm-dd"  name="dob" required></td>
</tr>
<tr>
<td><b>Salary</b></td>
<td><input type="" placeholder="salary"  name="salary" required></td>
</tr>
<!-- Employee name<input type="text" placeholder="name"  name="name" required><br>
Date of birth<input type="date" placeholder="yyyy-mm-dd"  name="dob" required><br>
Salary<input type="" placeholder="salary"  name="salary" required><br> -->
</table>
<input type="submit"></form>


</body>
</html>