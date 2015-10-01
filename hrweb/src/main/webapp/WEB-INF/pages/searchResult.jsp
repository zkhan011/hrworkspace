<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
</tbody>
		</table>
		<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0"  >
		<thead>
			<tr>
				<th width="25px">ID</th><th width="150px">NAME</th><th width="25px">Country</th><th width="50px">ACTIONS</th>
			</tr>
		</thead>
		<tbody id= "ajaxResult">
			<c:forEach var="employeesearch" items="${details}">
				<tr>
					<td>${employeesearch.id}</td>
					<td>${employeesearch.firstName}</td>
					<td>${employeesearch.department.location.country.countryName}</td>
					<td>
						<a href="${pageContext.request.contextPath}/employee/${employeesearch.id}/edit.html">Edit</a><br/>
						<a href="${pageContext.request.contextPath}/employee/${employeesearch.id}/delete.html">Delete</a><br/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href ="${pageContext.request.contextPath}/search/searchbyname.html">next</a>
</body>
</html>