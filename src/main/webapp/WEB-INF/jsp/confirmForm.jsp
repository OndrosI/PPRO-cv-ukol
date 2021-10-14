<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	.err {
		color : red;
	}
</style>
<title>Heslo</title>
</head>
<body>
	<h1>Heslo</h1>
	<form:form modelAttribute="inzerat">
		<table>
			<tr>
				<td>Heslo</td>
				<td> <input type='text' name='heslo' /></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="Uložit"/>
					<input type="hidden" id="id" name="id" value="${inzerat.id}">
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>