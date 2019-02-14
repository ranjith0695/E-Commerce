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
<div class="container">
<table id="t01" class="table table-bordered">


<tr class="danger">
<td colspan="6"><center>Your Cart</center></td>

</tr>

<tr>
<td> Product ID</td>
<td> Product Name</td>
<td> Quantity  </td>
<td> Price </td>
<td> SubTotal </td>
<td> Operation </td> 
</tr>
<c:forEach items="${CartProductList}" var="cartproduct">
<form action="<c:url value="/updateCartProduct/${cartproduct.cartid}"/>" method="get">
<tr class="info">
      <td>${cartproduct.productid}</td>
      <td> ${cartproduct.productname}</td>
      <td><input type="text" value="${cartproduct.quantity}" name="quantity"></td>
      <td>${cartproduct.price}</td>
      <td>${cartproduct.price*cartproduct.quantity}</td>
      <td>
        <input type="submit" value="UPDATE" class="btn btn-success"/>
         <a href="<c:url value="/deleteCartProduct/${cartproduct.cartid}"/>" class="btn btn-danger">DELETE</a>
      </td>
</tr>
</form>
 </c:forEach>
<tr class="warning">
<td colspan="4">Total Purchase Amount</td>
<td colspan="2">${TotalAmount}</td>
</tr>
<tr class="info">
<td colspan="3">
  <center> <a href="<c:url value="/productdisplay"/>" class="btn btn-success">Continue Shopping</a></center>
    </td>
    <td colspan="3">
   <center> <a href="<c:url value="/checkout"/>" class="btn btn-success">Check Out</a></center>
  </td> 
</tr>
</table>
</div>
</body>
</html>