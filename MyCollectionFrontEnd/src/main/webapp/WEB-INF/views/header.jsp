<%@ page language="java" contentType="text/html"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<style>
li a {
  display: block;
  color:black;
}
</style>

<title>${pageinfo} - MyCollections</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<nav  class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a  class="navbar-brand" href="<c:url value="/index1"/>">MYCOLLECTIONS</a>
    </div>
    <c:if test="${!sessionScope.loggedIn}">
    <ul  class="nav navbar-nav">
      <li ><a href="home">Home</a></li>
      <li><a href="<c:url value="/login"/>">Login</a></li>
      <li><a href="<c:url value="/register"/>">Register</a></li>
      <li><a href="<c:url value="/contactus"/>">Contact Us</a></li>
            <li><a href="<c:url value="/aboutus"/>">About Us</a></li>
            </ul>
            </c:if>
            
            <c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='Admin'}">
						<ul class="nav navbar-nav" >
            <li><a href="<c:url value="/category"/>">Manage Category</a></li>
            <li><a href="<c:url value="/supplier"/>">Suppliers</a></li>
      <li><a href="<c:url value="/product"/>">Manage Product</a></li>
      </ul>
      </c:if>
      </c:if>
      <c:if test="${sessionScope.role=='User'}">
						<ul class="nav navbar-nav">
						<li><a href="<c:url value="/userhome"/>">Home</a></li>
      <li><a href="<c:url value="/productdisplay"/>">Products</a></li>
      <li ><a href="<c:url value="/cart"/>"><i class="fa fa-shopping-cart" style="font-size:22px;color:Violet"></i>Cart</a></li>
    </ul>
    </c:if>
    <c:if test="${sessionScope.loggedIn}">
		<div class="nav navbar-nav navbar-right">
			<font color="white" face="calibri" size="4">Welcome : ${sessionScope.username}</font>
			<a href="<c:url value="/perform_logout"/>" class="btn btn-info btn-md">Logout</a>
		</div>
		</c:if>
  </div>
</nav>
</body>
</html>