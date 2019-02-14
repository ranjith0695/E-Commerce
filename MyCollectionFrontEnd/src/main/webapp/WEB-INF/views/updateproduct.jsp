<%@ page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

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
<form:form action="updateproduct" modelAttribute="product" method="post">  
<table id="t01" align="center" class="table-bordered">
  
  <tr>
    <td colspan="2"> <center>Update Product </center> </td>
  </tr>
  
  <tr>
    <td> Product ID </td>
    <td><form:input path="productid" required="required"/></td>
  </tr>
  
  <tr>
    <td> Product Name </td>
    <td> <form:input path="productname" required="required"/></td>
  </tr>
   
  <tr>
    <td> Price </td>
    <td> <form:input path="price" required="required"/></td>
  </tr>
  
  <tr>
    <td> Stock </td>
    <td> <form:input path="stock" required="required"/></td>
  </tr>
  
  <tr>
    <td> Category </td>
    <td> 
        <form:select path="categoryID">
           <form:option value="0" label="--Select --" />
           <form:options items="${catList}" />
        </form:select>
    
    </td>
  </tr>
  
  <tr>
     <td> Supplier</td>
     <td> 
              <form:select path="supplierID">
                   <form:option value="0" label="---Select ---"/>
                   <form:options items="${supList}"/>
              </form:select>
            </td>
  </tr>
  
  <tr>
     <td> Product Desc </td>
     <td> <form:input path="productdesc" required="required" /> </td>
  </tr>
  
  <tr>
     <td colspan="2"> <center><input type="submit" value="UpdateProduct" /> </center> </td>
  </tr>
     
</table>
</form:form>

</body>
</html>