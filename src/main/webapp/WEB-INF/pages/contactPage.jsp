<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dcherepnja
  Date: 09.08.2015
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number</title>
</head>
<body>

<div align=center><h2>${contact.address} <a href="<c:url value="/deleteContact/${contact.id}"/>">delete contact</a></h2>
</div>

<table>
    <i>${message}</i>
    <c:forEach var="number" items="${contact.numbers}">
        <tr>
            <td>
                <c:out value="${number}"/>
            </td>
            <td>
                <a href="<c:url value="/deleteNumber/${contact.id}&${number}"/>">Delete number</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty contact.numbers}">
        <p> no numbers added yet.</p>
    </c:if>
</table>
<a href="/">Main page</a>

</body>
</html>
