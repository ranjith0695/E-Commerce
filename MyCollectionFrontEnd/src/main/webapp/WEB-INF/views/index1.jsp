<%@ page language="java" contentType="text/html"%>
<%@include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
h2
{
color:#ee82ee;
font-size:200%;
font-family:Lucida Calligraphy;
}
h3
{
font-family:Freestyle Script;
font-size:400%;
color:blue;
}
</style>

<h2 align="center"><b><i>Welcome to MyCollections</i></b></h2>
<br>
<br>

 

 <div class="container">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
<img src="<c:url value="/resources/images/mens1.jpg"/>"  class ="img-responsive"/>
        <div class="carousel-caption">
          <h3>Mens Wear</h3>
          
        </div>
      </div>

      <div class="item">
       <img src="<c:url value="/resources/images/kids.jpg"/>"  class ="img-responsive"/>
        <div class="carousel-caption">
          <h3>Kids Wear Boys</h3>
          
        </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/girlkids.jpg"/>"  class ="img-responsive"/>
        <div class="carousel-caption">
          <h3>Kids Wear Girls</h3>
      
        </div>
      </div>
      
       <div class="item">
       <img src="<c:url value="/resources/images/access.jpg"/>"  class ="img-responsive"/>
        <div class="carousel-caption">
          <h3>Accessories</h3>
          
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

 
</body>
</html>
