<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center">Reading simple values</h1>
<b>name:: ${name}</b>
<br>
<b>age::${age}</b>
<br>
<b>address::${addrs}</b>
<br>
<hr>
<hr>

<h1 style="color: red; text-align: center">Reading Array,Collection
	values</h1>

<b>Nick Names(Array)::</b>
<br>
<c:forEach var="name" items="${nickNames }">
${name}<br>
</c:forEach>
<hr>

<b>Phone Number(Set)::</b>
<br>
<c:forEach var="ph" items="${phonesInfo }">
${ph }<br>
</c:forEach>
<hr>

<b>Course List(List)::</b>
<br>
<c:forEach var="course" items="${courseInfo }">
${course}<br>
</c:forEach>
<hr>

<b>ids Info(Map)::</b>
<br>
<c:forEach var="ids" items="${idsInfo }">
${ids.key}===>${ids.value }<br>
</c:forEach>
<hr>

<hr>

<h1 style="color: red; text-align: center">Reading List of Model
	class</h1>

<table border="2" align="center" >
	<tr>
		<th>eno</th>
		<th>ename</th>
		<th>desg</th>
		<th>salary</th>
	</tr>
	<c:forEach var="emp" items="${empsInfo}">
		<tr>
			<td>${emp.eno }</td>
			<td>${emp.ename }</td>
			<td>${emp.desg }</td>
			<td>${emp.salary }</td>
		</tr>
	</c:forEach>
</table>