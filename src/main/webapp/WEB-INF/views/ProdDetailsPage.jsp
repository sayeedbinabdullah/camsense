<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<%@include file="Header.jsp"%>

Session ID:
<%=session.getId()%>




<div>

	<table class="table table-bordered table-hover table-striped">
		<tr>
			<th>Product name</th>

			<th>Product Description</th>
			<th>Stock</th>
			<th>Price</th>

			<th>Image</th>
		</tr>
		<c:forEach var="ad" items="${data3}">


			<td>"${ad.aprodName}"</td>
			<td>${ad.adesciption}</td>
			<td>${ad.astock}</td>
			<td>${ad.aprice}</td>


			<td><img src="resources/images/${ad.aproductId}.jpg"
				style="width: 330px; height: 315px" /></td>

			<td><form action="AddToCart">

					<input type="hidden" name="adpid" value=${ad.aproductId } />
					Quantity<input type="text" name="d" value=1 /> <input
						type="submit" value="AddToCart" />
				</form></td>
		



			</tr>
		</c:forEach>
	</table>
</div>
</div>

<%@include file="Footer.jsp"%>
