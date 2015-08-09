<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dcherepnja
  Date: 08.08.2015
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Contact</title>
</head>
<body>
<i>${message}</i>

<form action="/findForm" method="POST">
    <p><label for="address">Address:</label>
        <input id="address" name="address" type="text"/></p>

    <p><input type="submit" value="Find"/> <input type="reset" value="Reset"/></p>
</form>
<a href="/">Main page</a>
</body>
</html>
