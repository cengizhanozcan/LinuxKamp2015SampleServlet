
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body> 
	  
	<h2> ${headerName} </h2>
	<h2> ${info} </h2>
	  
	 <form action="update" method="post" >

	<input type="hidden" name="id" value ="${todo.id}" />	 
	 <table>
 
	 	<tr>
	 		<td>Name: </td>
	 		<td> <input type="text" name="name" value="${todo.name}" /> </td>
	 	</tr>
	 	<tr>
	 		<td>Descriptions: </td>
	 		<td> <textarea rows="6" cols="6" name="desc"  >${todo.desc}</textarea> </td>
	 	</tr>
	 	<tr>
	 		<td>Date: </td>
	 		<td> <input type="date" name="dueDate" value="${todo.date}"> </td>
	 	</tr>
	 	<tr>
	  		<td>Checked</td>
	 		<td><input type="checkbox" name="check" <c:if test="${todo.isDone}">checked</c:if> />  </td>
	 	
	 	</tr>
	 </table>
	 <br>
	 <button>Update</button>
	 
	 </form>
</body>
</html>
