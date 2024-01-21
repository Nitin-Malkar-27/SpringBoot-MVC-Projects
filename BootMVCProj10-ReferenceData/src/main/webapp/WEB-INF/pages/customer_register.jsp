<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="customer_register" modelAttribute="cust">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Customer No::</td>
			<td><form:input path="cno" /></td>
		</tr>
		<tr>
			<td>Customer Name::</td>
			<td><form:input path="cname" /></td>
		</tr>
		<tr>
			<td>Select Country::</td>
			<td><form:select path="country">
					<form:options items="${countriesInfo }" />
				</form:select></td>
		</tr>

		<tr>
			<td>Select known language::</td>
			<td><form:select path="languages" multiple="multiple" size="5">
					<form:options items="${languagesInfo }" />
				</form:select></td>
		</tr>
		<tr>
			<td>Select Hobbies::</td>
			<td><form:checkboxes items="${hobbiesInfo}" path="hb" /></td>
		</tr>
		<tr>
			<td>Select Gender::</td>
			<td><form:radiobuttons items="${genderInfo}" path="gender" />
		</tr>

		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="Cnncel"></td>
		</tr>
	</table>

</form:form>