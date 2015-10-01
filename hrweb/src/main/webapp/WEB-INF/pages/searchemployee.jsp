<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Search Employee Page</title>
		
		<style>
		.error {
			color: #ff0000;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
		</style>		
		
	</head>
	
	<body>
	<h1>Employee Search Page</h1>
	
	<table>
	<tbody>
	<form:form id="ajaxSearch" method="POST" commandName="search" action="${pageContext.request.contextPath}/search/searchbyname.html" >
		
								<tr>
						<td>keyword:</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="errorBlock"   cssStyle="color: red;"/></td>
					</tr>
					
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssStyle="color: red;"/></td>
					</tr>
					
						<tr>				    
					
         <td>Location:</td>
	<td><form:select name="location" path="location"  cssStyle="width:150px;">
	    <option value="null"> Select Location</option>
		<c:forEach var="locationName" items="${location}"  >
		<option value="${locationName.country.id}">${locationName.country.countryName}</option>
		
		</c:forEach>
	</form:select></td>
 
          </tr>
         				
									
		         	<tr>				    
					
         <td>Country:</td>
	<td><form:select name="country" path="countryName"  cssStyle="width:150px;">
	    <option value="null"> Select Country</option>
		<c:forEach var="countryName" items="${country}"  >
		<option value="${countryName.countryName}">${countryName.countryName}</option>
		
		</c:forEach>
	</form:select></td>
 
          </tr>
         	<tr>
         	<td><input type="submit" value="search">  </input>   </td>
         	
         	
         	
         	</tr>
					
					
					
		</form:form>
		
		
		
		
		<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
		
		
</html>