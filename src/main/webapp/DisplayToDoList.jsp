<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="DisplayToDoList" method="post">

		<table style="width: 100%" border="1">
			<tr>
				<th>Item</th>
				<th>Date</th>
				<th>Check</th>
			</tr>
			
			
			<c:forEach items="${userDetailslist}" var="list">
				<tr>
				<c:if test="${list.check == true}">
						<td><c:out value="${list.itemName}"></c:out></td>
						<td><fmt:formatDate pattern="MM/dd/yyyy" value="${list.date}"/></td>
						<td><a href="DeleteToDoList?id=${list.id}" ><font color="Blue">X</font></a></td>

				</c:if>
				</tr>
			</c:forEach>


			<c:forEach items="${userDetailslist}" var="list">
				<tr>
				<c:if test="${list.check == false}">
						<td><strike><c:out value="${list.itemName}"></c:out></strike></td>
						<td><strike><fmt:formatDate pattern="MM/dd/yyyy" value="${list.date}"/></td></strike></td>
						<td></td>
				</c:if>
				</tr>
			</c:forEach>
			
			
			<tr>
				<td><input type="text" name="item" /></td>
				<td colspan="2"><input type="submit" value="Add" name="Add"/></td>
			</tr>

		</table>

	</form>

</body>
</html>