<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Whut chu wan</title>
</head>
<body>
<h1>Search for product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<c:forEach var="search" items="${product}" >
<table border="1">

    <tr>
        <td>Product Name: </td>
        <td>${search.getProductName()}</td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${search.getManufacturer()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${search.getPrice()}</td>
    </tr>

</table>
</c:forEach>
</body>
</html>
