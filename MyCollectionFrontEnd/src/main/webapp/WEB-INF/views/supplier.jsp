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
<form:form action="AddSupplier" modelAttribute="supplier" method="post">
<table id="t01" align="center" class="table-bordered">
<tr>
<td colspan="2"><center><h2>Supplier</h2></center></td>
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
<td colspan="2"><center><input type="submit" value="Add Supplier"/></center></td>
</tr>
</table>
</form:form>
<br>
<table class="table-bordered">
<table style="width:100%">
<tr>
<td>supplier ID</td>
<td>supplier Name</td>
<td>supplier Addr</td>
<td>operations</td>
</tr>

<c:forEach items="${listSuppliers}" var="supplier">
<tr>
<td>${supplier.supplierID}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierAddr}</td>
<td>
<a href="<c:url value="/editSupplier/${supplier.supplierID}"/>" class="btn btn-success">Edit</a>
<a href="<c:url value="/deleteSupplier/${supplier.supplierID}"/>" class="btn btn-danger">Delete</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>