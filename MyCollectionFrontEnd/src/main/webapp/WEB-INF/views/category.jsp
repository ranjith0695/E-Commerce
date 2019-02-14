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
  background-color: #eee;
}
</style>
<form:form action="AddCategory" modelAttribute="category" method="post">
<table id="t01" align="center" class="table-border">

<tr>
<td colspan="2"><center><h2>Category</h2></center></td>
</tr>

<tr>
<td>Category Name</td>
<td><form:input path="categoryName" required="required"/></td>
</tr>

<tr>
<td>Category Desc</td>
<td><form:input path="categoryDesc" required="required"/></td>
</tr>

<tr>
<td colspan="2"><center><input type="submit" value="Add Category"/></center></td>
</tr>
</table>
</form:form>
<br>
<table class="table-bordered">
<table style="width:100%">
<tr>
<td>category ID</td>
<td>category Name</td>
<td>category Desc</td>
<td>operations</td>
</tr>

<c:forEach items="${listCategories}" var="category">
<tr>
<td>${category.categoryID}</td>
<td>${category.categoryName}</td>
<td>${category.categoryDesc}</td>
<td>
<a href="<c:url value="/editCategory/${category.categoryID}"/>" class="btn btn-success">Edit</a>
<a href="<c:url value="/deleteCategory/${category.categoryID}"/>" class="btn btn-danger">Delete</a>
</td>
</tr>
</c:forEach>
</table>


</body>
</html>