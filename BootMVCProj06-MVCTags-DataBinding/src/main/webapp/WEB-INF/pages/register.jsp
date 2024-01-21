<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: green; text-align: center">Employeee Registration
	Form</h1>

<form:form modelAttribute="emp">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Employee Number::</td>
			<td><form:input path="eno" /></td>
		</tr>
		<tr>
			<td>Employee Name::</td>
			<td><form:input path="ename" /></td>
		</tr>
		<tr>
			<td>Employee Address::</td>
			<td><form:input path="eadd" /></td>
		</tr>

		<tr>
			<td>Employee Salary::</td>
			<td><form:input path="esalary" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="register"></td>
		</tr>
	</table>
</form:form>
