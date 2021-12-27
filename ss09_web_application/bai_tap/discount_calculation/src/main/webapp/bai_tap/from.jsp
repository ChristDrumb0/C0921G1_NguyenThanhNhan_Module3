<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/23/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculated" method="post">
    <label>Product Description:</label>
    <textarea name="describe" ></textarea>
    <input type="text" name="price" placeholder="Listed Price">
    <input type="text" name="discount" placeholder="Discount Percent">
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
