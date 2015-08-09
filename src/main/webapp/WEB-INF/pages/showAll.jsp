<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Contacts</title>
</head>
<body>
<h1></h1>
<table border="1" width="100%" cellpadding="5">
    <i>${message}</i>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>
                <c:out value="${contact.address}"/>
            </td>
            <td>
                <a href="<c:url value="/showNumbers/${contact.id}"/>">Show numbers</a>
            </td>
            <td>
                <a href="<c:url value="/deleteContact/${contact.id}"/>">Delete contact</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty contacts}">
        <p> no contacts added yet.</p>
    </c:if>
</table>
<a href="/">Main page</a>
</body>
</html>