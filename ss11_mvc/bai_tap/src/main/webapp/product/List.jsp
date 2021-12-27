<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<h1>Phone In-stock</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<div style="position: relative;">
    <form action="/products?action=search" method="get">
        <input type="hidden" value="search" name="action">
    <input type="text" name="search" id="search" placeholder="Search by name" style="float: left">
    <input type="submit" value="Search product" style="float: left">
    </form>
</div>
<table border="1" style="clear:left; position: relative; margin: 5px 0 5px 0">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["productmanage"]}' var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getProductName()}</a></td>
            <td>${product.getManufacturer()}</td>
            <td>${product.getPrice()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
