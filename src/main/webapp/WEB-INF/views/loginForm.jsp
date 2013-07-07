<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	
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

<h2>Spring's form tags example</h2>
 
	<form:form method="POST" commandName="loginForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>UserName :</td>
				<td><form:input path="userName" />
				</td>
				<td><form:errors path="userName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" />
				</td>
				<td><form:errors path="password" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>



</body>
</html>
