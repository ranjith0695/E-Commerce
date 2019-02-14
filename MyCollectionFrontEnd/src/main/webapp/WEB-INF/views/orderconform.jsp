<%@ page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>

<div class="container">
<table class="table table-bordered">


<tr class="danger">
<td colspan="5"><center>Your Cart</center></td>

</tr>

<tr>
<td> Product ID</td>
<td> Product Name</td>
<td> Quantity  </td>
<td> Price </td>
<td> SubTotal </td> 
</tr>
<c:forEach items="${CartProductList}" var="cartproduct">

<tr class="info">
      <td>${cartproduct.productid}</td>
      <td> ${cartproduct.productname}</td>
      <td>${cartproduct.quantity}</td>
      <td>${cartproduct.price}</td>
      <td>${cartproduct.price*cartproduct.quantity}</td>
     
     
</tr>

 </c:forEach>
<tr class="warning">
<td colspan="4">Total Purchase Amount</td>
<td colspan="1">${TotalAmount}</td>
</tr>

<tr class="warning">
<td colspan="5">Billing Address</td>

</tr>

<tr class="info">

<td>
     Address 
</td>
<td colspan="3">
  <textarea name="addr" cols="100" rows="3"> ${addr}</textarea>
    </td>
    
    <tr class="warning">
<td colspan="5">shipping Address</td>

</tr>
<form action="<c:url value="/updateaddress"/>"method="post">
<tr class="info">

<td>
     Address 
</td>
<td colspan="3">
  <textarea name="saddr" cols="100" rows="3"> ${saddr}</textarea>
    </td>    
    
    <td>
    <input type="submit" value="Update Address" class="btn btn-success"/>
    </td>
    
</tr>
</form>
<tr class="warning">
<td colspan="4"></td>
<td></td>
</tr>
<tr class="info">
<td colspan="2">
  <center> <a href="<c:url value="/cart"/>" class="btn btn-success">Modify Cart</a></center>
    </td>
    <td colspan="4">
   <center> <a href="<c:url value="/payment"/>" class="btn btn-success">Order Conform</a></center>
  </td> 
</tr>

</table>
</div>

</body>
</html>