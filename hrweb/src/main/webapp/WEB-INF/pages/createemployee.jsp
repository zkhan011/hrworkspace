<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>New Employee Page</title>
		
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
		<h1>New Employee Page</h1>
		
		<form:form method="POST" modelAttribute="createemployeebean" commandName="createemployeebean" action="${pageContext.request.contextPath}/employee/create.html" >
		<form:errors path="*" cssClass="errorblock" element="div" />
			
		
			<table>
				<tbody>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssStyle="color: red;"/></td>
					</tr>
					
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssStyle="color: red;"/></td>
					</tr>
					
					<tr>
						<td>Email:</td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="errorBlock" cssStyle="color: red;"/></td>
					</tr>
					
					<tr>
						<td>Phone Number:</td>
						<td><form:input path="phoneNumber" /></td>
						<td><form:errors path="phoneNumber" cssClass="errorBlock" cssStyle="color: red;"/></td>
					</tr>
					<td>JOB:</td>
	                   <td><form:select  path="job"  cssStyle="width:150px;">
	                      <option value="null"> Select JOB TYPE</option>
		                    <c:forEach var="jobName" items="${job}"  >
		                    <option value="${jobName.id}">${jobName.title}</option>
		                    </c:forEach>
	                        </form:select></td>
					</tr>
					<tr>
						<td>SALARY:</td>
						<td><form:input path="salary" /></td>
						<td><form:errors path="salary" cssClass="errorBlock" cssStyle="color: red;"/></td>
					</tr>
					<tr>
					 <td>Department:</td>
              	<td><form:select path="department"  cssStyle="width:150px;">
	    <option value="null"> Select department</option>
		<c:forEach var="departmentName" items="${department}"  >
		<option value="${departmentName.id}">${departmentName.name}</option>
		
		</c:forEach>
	</form:select></td>
					</tr>
					
					
					
					
					<tr>
						<td><input type="submit" value="Create" /></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<a href="${pageContext.request.contextPath}/">Home page</a>
	</body>
</html>