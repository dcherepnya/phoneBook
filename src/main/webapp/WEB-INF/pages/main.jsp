<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dcherepnja
  Date: 08.08.2015
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoneBook</title>
</head>
<body>
<i>${message}</i>
<table align=center width="100%" cellpadding="5">
    <tr>
        <td>
            <div align=center><a href="<c:url value="/addPage"/>">Add new contact or phone number</a></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align=center><a href="<c:url value="/showAll"/>">Show all conatcts</a></div>
        </td>
    </tr>
    <tr>
        <td>
            <div align=center><a href="<c:url value="/findPage"/>">Find contact</a></div>
        </td>
    </tr>
</table>
</body>
</html>
