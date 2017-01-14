<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js">
	
</script>
<%@include file="Header.jsp"%>
Session ID:
<%=session.getId()%>
<!--<c:out value="${check}"></c:out>-->
<div class="container">
	<%
		int x = 0;
	%>
	<table class="table table-bordered table-hover table-striped">

		<tr>

			<th>Product name</th>
			<th>Quantity</th>
			<th>Item Price</th>
			<th>Total Price</th>
			<th>Image</th>
		</tr>
		<c:forEach var="ad" items="${CartList}">

			<tr>

				<td>${ad.itemname}</td>

				<td>${ad.qty}</td>
				<td>${ad.price}</td>
				<td>${ad.total}</td>

				<td><img src="resources/images/${ad.pid}.jpg"
					style="width: 180px; height: 150px" /></td>

			</tr>


		</c:forEach>
	</table>
	<table class="table table-bordered table-hover table-striped">
		<tr>
			<td colspan="5"><a href="Product">ContinueShop</a></td>
			<td colspan="5"><a href="OrderConfirm">ConfirmOrder</a></td>
		</tr>
	</table>

</div>


<%@include file="Footer.jsp"%>