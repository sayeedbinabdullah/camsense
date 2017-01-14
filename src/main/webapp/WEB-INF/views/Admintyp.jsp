<%@include file="AdminHead.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>


	  var prod = ${data};
	  angular.module('repeatSample', []).controller('AdminTypeController', function($scope)
	   {
	                 $scope.typts=prod;
	   
	          $scope.sort = function(keyname)
	          {
	              $scope.sortKey = keyname;   //set the sortKey to the param passed
	              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
	          }
	              
	    });
	</script>
</head>
<body style="padding-top: 75px">

	<div class="container row">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
			
			<form:form action="addtype" commandName="type">


				<table>
					<tr>
						<td><form:label class="btn btn-default btn-block" path="id">
								<spring:message text="Id" />
							</form:label></td>
						<c:choose>
							<c:when test="${!empty type.id}">
								<td><form:input class="form-control" path="id"
										readonly="true" /></td>
							</c:when>
							<c:otherwise>
								<td><form:input class="form-control" path="id"
										pattern=".{3,10}" required="true"
										title="id should contains 3 to 10 characters" /></td>
							</c:otherwise>
						</c:choose>
					<tr>
						<td><form:label class="btn btn-default btn-block" path="name">
								<spring:message text="Name" />
							</form:label></td>
						<td><form:input class="form-control" path="name"
								required="true" /></td>
					</tr>
					<tr>
						<td><form:label class="btn btn-default btn-block" path="description">
								<spring:message text="Description" />
							</form:label></td>
						<td><form:input class="form-control" path="description"
								required="true" /></td>
					</tr>
				</table>
				<br>
				<c:if test="${!empty type.name}">
					<input class="btn btn-block btn-primary" type="submit"
						value="Edit type" />
				</c:if>
				<c:if test="${empty type.name}">
					<input class="btn btn-block btn-primary" type="submit"
						value="Add type" />
				</c:if>
			</form:form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<!--  -->
	
					
					<div ng-app="repeatSample" ng-controller="AdminTypeController">
					<br>
				<table class="table table-bordered table-hover ">
					<thead>
						<tr >
							<th>Type ID</th>
							<th>Type Name</th>
							<th>Type Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						
							<tr class="success" ng-repeat="Type in typts|filter:sB">
	<td >{{type.id}}</td>
							<td>{{type.name}}</td>
							<td>{{type.description}}</td>
							<td><a class="btn btn-info btn-xs"
								href="edittype/{{type.id}}">Edit</a></td>
							<td><a class="btn btn-danger btn-xs"
								href="removetype/{{type.id}}">Delete</a></td>
						</tr>
					</tbody>
				</table>
	                
	
				
			</div>
	

<%@include file="Footer.jsp"%>