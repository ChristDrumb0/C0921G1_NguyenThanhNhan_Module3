
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1" style="border: solid 1px">
    <tr>
        <th colspan="5">Danh Sách khách hàng</th>
    </tr>
    <tr>
        <th>id</th>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="cusObj" items="${customList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${cusObj.name}</td>
            <td>${cusObj.dOB}</td>
            <td>${cusObj.address}</td>
            <td><img src="${cusObj.img}" style="width: 100px; height: 100px" alt="hinh khach hang"></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
