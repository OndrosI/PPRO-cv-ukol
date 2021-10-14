<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Katalog</title>
</head>
<body>
<h1>Katalog</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Text</th>
        <th>Cena</th>
        <th>Kategorie</th>
        <th>Akce</th>
        <th>Heslo</th>
    </tr>
    <select name="kategorie" onchange="if (this.value) window.location.href='inzeraty?kategorie='+this.value">
        <option value=""></option>
        <option value="nakup">Nákup</option>
        <option value="prodej">Prodej</option>
        <option value="vymena">Výměna</option>
    </select>
    <button onclick="window.location.href='inzeraty'">Zruš filter</button>
    <c:forEach var="i" items="${inzerat}">
        <tr>
            <td>${i.id }</td>
            <td>${i.text }</td>
            <td align="right">
                <fmt:formatNumber pattern="#,##0.00 Kč" value="${i.cena }"/>
            </td>
            <td>${i.kategorie }</td>
            <td>
                <form action="inzerat-confirm" style="display: inline">
                    <input type="hidden" name="akce" value="remove"/>
                    <input type="hidden" name="id" value="${i.id }"/>
                    <input type="submit" value=" X ">
                </form>
                <form action="inzerat-confirm" style="display: inline">
                    <input type="hidden" name="id" value="${i.id }"/>
                    <input type="submit" value=" E ">
                </form>
            </td>
            <td>${i.hesloProUpravu}</td>
        </tr>
    </c:forEach>

</table>
[<a href="inzerat-add">Přidat inzerat</a>]<br/>
</body>
</html>