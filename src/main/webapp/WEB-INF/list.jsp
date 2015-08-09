
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="tr.org.lkd.lyk2015.model.*" %>

<html>
<body>
	<form action="list" method="post">

		<h1>${deneme}</h1>

		<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Check</td>
				<td>Date</td>
			</tr>
			<c:forEach var="element" items="${list}">
				<tr>
				
					<c:if test="${element.isDone}">
					
						<td><strike><c:out value="${element.id}" /></strike></td>
						<td><strike><c:out value="${element.name}" /></strike></td>
						<td><strike><c:out value="${element.desc}" /></strike></td>
						<td>  </td>
						<td><strike><c:out value="${element.readableDate()}" /></strike></td>
						<td><a href="update?id=${element.id}" > Edit </a></td>
					</c:if>
					<c:if test="${!element.isDone}">
							<td><c:out value="${element.id}" /></td>
							<td><c:out value="${element.name}" /></td>
							<td><c:out value="${element.desc}" /></td>
							<td><input type="checkbox"  name="id" value="${element.id}"></td>
							<td>${element.readableDate()}</td>
							<td><a href="update?id=${element.id}" > Edit </a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<br>
	<button>Checked</button>


	</form>
</body>
</html>
