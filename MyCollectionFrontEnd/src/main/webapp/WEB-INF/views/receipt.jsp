<%@page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
  
  
  
  <div class="container">
  <table class="table table-bordered" align="center">
  
  <tr class="danger">
  <td colspan="5"><Center>Receipt</Center></td>
  </tr>
  <tr class="info">
  <td>ORDER ID</td>
  <td>ODR1234${orderInfo.orderid}</td>
  <td>Date</td>
  <td colspan="2">${orderInfo.orderdate}</td>
  </tr> 
  <tr class="warning">
  <td colspan="5"><h3>Order Items</h3></td>
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
<td colspan="1">${TotalAmount}/-</td>
</tr>
  <tr class="info">
<td colspan="5"><h2>Billing Address</h2></td>

</tr>

<tr class="warning">

<td>
     Address 
</td>
<td colspan="4">${addr}</td>
    </tr>
    
      <tr class="info">
<td colspan="5"><h2>Shipping Address</h2></td>

</tr>

<tr class="warning">

<td>
     Address 
</td>
<td colspan="4">${saddr}</td>
    </tr>


  
  </table>
  </div>

</body>
</html>