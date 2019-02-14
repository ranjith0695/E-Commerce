<%@page language="java" contentType="text/html"%>
<%@include file="header.jsp" %>
<script type="text/javascript">
function setpayment(form)
{
	if(form.csh.checked==true)
		{
	form.cc.checked=false
	form.cc.disabled=true
		}
	
	}
</script>

<div class="container">
<form action="<c:url value='/receipt'/>"method="post" id='frm'>

<table class="table table-bordered"  align="center">
<tr class="success">
<td colspan="2"><center>Payment Detail</center></td>
</tr>
<tr class="info">
<td colspan="2"><center>
    <input type="radio" name="Pmode" value="CC" id='cc' >Credit Card
     <input type="radio" name="Pmode" value="COD" id='csh' onclick=setpayment(this.frm)>Cash on Delivery
   </center>  </td>
     </tr>
     <tr class="warning">
     <td>Card Number</td>
     <td><input type="text" name="cardno" id='cno' /></td>
     </tr>
      
      <tr class="warning">
     <td>Valid<input type="text" name="Valid" /></td>
     <td>CVV<input type="text" name="CVV" /></td>
     </tr>
     
      <tr class="success">
     <td>Name </td>
     <td><input type="text" name="name"/></td>
     </tr>
      <tr class="success">
     <td colspan="2"><center><input type="Submit" value="Pay" class="btn btn-success"/></center></td>
     </tr>
     
     </table>
    </form>

</body>
</html>