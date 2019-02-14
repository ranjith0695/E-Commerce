<%@ page language="java" contentType="text/html"%>

<%@include file="header.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br> 

<form action="<c:url value="/addtocart/${product.productid}" />" >
<table class="table-bordered"> 
 <tr>
   <td rowspan="8"> 
   <img src="<c:url value="/resources/images/${product.productid}.jpg" />" style="max-height:250x;min-height:250px;" alt = "Generic placeholder thumbnail"/>
   </td>
   <td> Product Id </td>
   <td> ${product.productid}</td>
 </tr>
 
 <tr>
   <td> Product Name </td>
   <td> ${product.productname}</td>
 </tr>
 
 <tr>
   <td> Price </td>
   <td> INR ${product.price}/-</td>
 </tr>
 
 <tr>
   <td> Stock </td>
   <td> ${product.stock}</td>
 </tr>
 
  <tr>
   <td> Category</td>
   <td> ${product.categoryID}</td>
 </tr>
 
  <tr>
   <td> SupplierID </td>
   <td> ${product.supplierID}</td>
 </tr>
 
  <tr>
   <td> Product Desc </td>
   <td> ${product.productdesc}</td>
 </tr>
 
<tr>
   <td> Quantity 
          <select name="quantity">
            <option value="1"> 1 </option>
            <option value="2"> 2 </option>
            <option value="3"> 3 </option>
            <option value="4"> 4 </option>
            <option value="5"> 5 </option>
             <option value="6"> 6</option>
              <option value="7">7 </option>
               <option value="8">8</option>
                <option value="9"> 9 </option>
          </select>    
   </td>
   <td> <input type="submit" value ="Add To Cart" class="btn btn-success"> </td>
 </tr>
 
</table>
 </form>