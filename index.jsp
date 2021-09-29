<%-- 
    Document   : index
    Created on : 17.08.2021, 20:10:49
    Author     : Иван Петров
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItProducts</title>
</head>
<body>
<h2>ItProducts List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
<c:forEach var="itproduct" items="${itproducts}">
    
<tr>
    <td>${itproduct.id}</td>
    <td>${itproduct.name}</td>
    <td>${itproduct.price}</td>
    <td>
    <a href='<c:url value="/edit?id=${itproduct.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="id" value="${itproduct.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>