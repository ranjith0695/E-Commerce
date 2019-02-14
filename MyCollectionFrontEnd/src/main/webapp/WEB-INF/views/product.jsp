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

<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table id="t01" align="center" class="table-bordered">
     <tr>
        <td colspan="2"><center>Products</center></td>
     </tr>
     <tr>
         <td>Product Name</td>
         <td><form:input path="productname" required="required"/></td>
      </tr>
      <tr>
          <td>Price</td>
          <td><form:input path="price" required="required"/></td>
       </tr>
       <tr>
          <td>Stock</td>
          <td><form:input path="stock" required="required"/></td>
       </tr>
       <tr>
           <td>Category</td>
           <td> 
              <form:select path="categoryID">
                   <form:option value="0" label="---Select ---"/>
                   <form:options items="${catList}"/>
              </form:select>
            </td>
         </tr>
         <tr>
             <td>Supplier</td>
               <td> 
              <form:select path="supplierID">
                   <form:option value="0" label="---Select ---"/>
                   <form:options items="${supList}"/>
              </form:select>
            </td>
          </tr>
          <tr>
              <td>Product Desc</td>
              <td><form:input path="productdesc" required="required"/></td>
           </tr>
           <tr>
              <td>Product Image</td>
              <td><form:input type="file" path="pimage"/></td>
           </tr>
           <tr>
              <td colspan="2"><center><input type="submit" value="InsertProduct"/></center></td>
           </tr>
        </table>
        </form:form>
        <br>
         <table align="center" class="table-bordered">
        <tr>
           <td>Product ID</td>
           <td>Product Name</td>
           <td>Product Desc</td>
           <td>Price</td>
           <td>Stock</td>
           <td>Supplier</td>
          
           <td>Operations</td>
         </tr>
         <c:forEach items="${productList}" var="product">
         <tr>
            <td>${product.productid}</td>
            <td>${product.productname}</td>
            <td>${product.productdesc}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>${product.supplierID}</td>
            
            <td>
                  <a href="<c:url value="/editProduct/${product.productid}"/>"class="btn btn-success">Edit</a>/
                  <a href="<c:url value="/deleteProduct/${product.productid}"/>"class="btn btn-danger">Delete</a>
            </td>   
          </tr>
          </c:forEach>
          </table>
        
</body>
</html>