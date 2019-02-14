<%@ page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
  background-color: #eee;
}
</style>
<form:form action="updatecategory" modelAttribute="category" method="post">
<<table id="t01" align="center" class="table-border">

<tr>
<td colspan="2"><center><h2>Category</h2></center></td>
</tr>

<tr>
<td>Category ID</td>
<td><form:input path="categoryID" required="required"/></td>

<tr>
<td>Category Name</td>
<td><form:input path="categoryName" required="required"/></td>
</tr>

<tr>
<td>Category Desc</td>
<td><form:input path="categoryDesc" required="required"/></td>
</tr>

<tr>
<td colspan="2"><center><input type="submit" value="Update Category"/></center></td>
</tr>
</table>
</form:form>

</body>
</html>