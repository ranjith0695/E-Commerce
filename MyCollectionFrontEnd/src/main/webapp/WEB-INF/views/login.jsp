<%@ page language="java" contentType="text/html"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@include file="header.jsp" %>
<style>
table, th, td {
  border: 2px solid blue;
}
th, td {
  padding: 8px;
  text-align: left;
}
table#t01 
{  
border: 3px solid blue;
  background-color: #00BFFF;
}
</style>

<form action="perform_login" method="post">  
<table id="t01" border="1" align="center">
 
  <tr >
    <td colspan="2"> <center>Sign in </center> </td>
  </tr>
  
  <tr >
    <td> Login Name </td>
    <td> <input type="text" name="username" required/> </td>
  </tr>
   
  <tr >
    <td> Password </td>
    <td> <input type="password" name="password" required/></td>
  </tr>
  
  <tr>
    <td colspan="2"> <center><input type="submit" value="LOGIN"/></center> </td>
  </tr>
  
     
</table>
<br>

  <center><b><i><font size="6" color="red">${errmsg}</font></i></b></center> 	

</form>
</body>
</html>