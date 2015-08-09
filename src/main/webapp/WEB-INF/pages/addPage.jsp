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
    <title>Add Contact</title>
</head>
<body>
<form action="/addFrom" method="POST">
    <i>${message}</i>

    <p><label for="address">Address:</label>
        <input id="address" name="address" type="text"/></p>

    <p><label for="number">Number:</label>
        <input id="number" name="number" type="text"/></p>

    <p><input type="submit" value="Add"/> <input type="reset" value="Reset"/></p>
</form>
<a href="/">Main page</a>
</body>
</html>
