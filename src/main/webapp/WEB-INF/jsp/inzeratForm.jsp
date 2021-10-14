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
<title>Detail Inzeratu</title>
</head>
<body>
	<h1>Detail Inzeratu</h1>
	<form:form modelAttribute="inzerat">
		<table>
			<tr>
				<td>Text Inzeratu</td>
				<td><form:input path="text"/></td>
				<td><form:errors path="text" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Cena</td>
				<td><form:input path="cena" size="10"/> Kč</td>
				<td><form:errors path="cena" cssClass="err"/></td>
			</tr>
			<tr>
				<select name="kategorie">
						<option value="nakup">Nákup</option>
						<option value="prodej">Prodej</option>
						<option value="vymena">Výměna</option>
				</select>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="Uložit"/>	
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>