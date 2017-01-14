<%@include file="AdminHead.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
  var prov = ${data};
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
                 $scope.provider=prov;
   
          $scope.sort = function(keyname)
          {
              $scope.sortKey = keyname;   //set the sortKey to the param passed
              $scope.reverse = !$scope.reverse; //if true make it false and vice versa
          }
              
    });
</script>


<c:choose>
<c:when test="${check}">

<div class="container">
    <h1 class="well">Add Provider</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="ProviderView" commandName="Provider">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Provider Id</label>
								<form:input  path="provId" placeholder="" class="form-control" readonly="true" value="${prvid+1}"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Provider Name</label>
								<form:input type="text" path="provName" placeholder="" class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Contact No</label>
								<form:input type="text" path="contactNo" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Provider Address</label>
							<form:textarea path="provAdd" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
		<div ng-app="repeatSample" ng-controller="repeatController">
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Provider Id</th>
<th>Provider name</th>
<th>Contact No</th>
<th>Address</th>
<th>Edit</th>
<th>Delete</th>
</tr> 
<tr class="success" ng-repeat="p in provider|filter:searchprd">
                <td>{{p.provId}}</a></td> 
                 <td>{{p.provName}}</td>
                <td>{{p.contactNo}}</td>
                <td> {{p.provAdd}}</td>
            <td><a href="UpdateProvider?provId={{p.provId}}">Edit</a></td>
                <td><a href="delprovider?provId={{p.provId}}">Delete</a></td>
               <!--   <td><img src="./Resources/img/{{product.img}}.jpg" height="50px" width="50px"/></td> -->  
</tr>
</table>
</div>  
</c:when>
<c:otherwise >
<div class="container">
    <h1 class="well">Update Provider</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form method="post" action="UpdateProvider" commandName="Provider">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Provider Id</label>
								<form:input  path="provId" placeholder="" class="form-control" readonly="true"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Provider Name</label>
								<form:input type="text" path="provName" placeholder="" class="form-control"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Contact No</label>
								<form:input type="text" path="contactNo" placeholder="" class="form-control"></form:input>
							</div>
						</div>					
						<div class="form-group">
							<label>Provider Address</label>
							<form:textarea path="provAdd" placeholder="" rows="3" class="form-control"></form:textarea>
						</div>	
						
					
					<input type="submit" class="btn btn-lg btn-info" value="submit" ></input>
							
					</div>
					
				</form:form> 
				
				
 
				</div>
	</div>
	</div>
	</c:otherwise>

</c:choose>


<%@include file="Footer.jsp"%>