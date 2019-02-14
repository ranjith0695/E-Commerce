<%@ page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
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
  background-color: #FFE4C4;
}
</style>
<form:form action="updatesupplier" modelAttribute="supplier" method="post">
<table id="t01" align="center" class="table-border">

<tr>
<td colspan="2"><center><h2>Supplier</h2></center></td>
</tr>

<tr>
<td>Supplier ID</td>
<td><form:input path="supplierID" required="required"/></td>
</tr>

<tr>
<td>Supplier Name</td>
<td><form:input path="supplierName" required="required"/></td>
</tr>

<tr>
<td>Supplier Address</td>
<td><form:input path="supplierAddr" required="required"/></td>
</tr>

<tr>
<td colspan="2"><center><input type="submit" value="Update Supplier"/></center></td>
</tr>
</table>
</form:form>
</body>
</html>