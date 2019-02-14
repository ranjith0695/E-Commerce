<%@ page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>

<script type="text/javascript">
	function fillShippingAddress(form) {
		
		form.shippingAddr.value=form.customerAddr.value
		if(form.shippingaddressform.checked==false)
			{
			form.shippingAddr.value=""
			}
	    
	}
	</script>

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

  background-color: #FFE4C4;
}
</style>
</head>
<form:form action="registeruser" modelAttribute="user" method="post" id="form">
<table id="t01" align="center" class="table-bordered">
<tr>
<td colspan="2"><center><h2>Sign Up</h2></center></td>
</tr>

<tr>
<td>Customer Name</td>
<td><form:input path="customerName" required="required"/></td>
</tr>

<tr>
<td>User Name</td>
<td><form:input type="email" path="username" required="required"/></td>
</tr>

<tr>
<td>Password</td>
<td><form:password path="password" required="required"/></td>
</tr>

<tr>
<td>Customer Address</td>
<td><form:textarea path="customerAddr" rows="5" required="required" id="customerAddr"/></td>
</tr>

<tr>
<td colspan="2">
Check this if shipping address is same as billing address
<input type="checkbox" onclick="fillShippingAddress(this.form)" id="shippingaddressform">
</td>
</tr>


<tr>
<td>ShippingAddr</td>
<td><form:textarea path="shippingAddr" rows="4" required="required"/></td>
</tr>

<tr>
<td>PhoneNumber</td>
<td><form:input path="phonenumber" required="required"/></td>

<tr>
<td><!--Enabled--></td>
<td><form:hidden path="enabled"/></td>
</tr>

<tr>
<td><!-- Role --></td>
<td><form:hidden path="role"/></td>

</tr>
<tr>
<td colspan="2"><center><input type="submit" value="Register User"/></center></td>
</tr>
</table>
</form:form>

</body>
</html>