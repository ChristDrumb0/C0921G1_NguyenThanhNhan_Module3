<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/23/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        Product: <%=request.getParameter("describe")%>
    </h2>
    <h2>
        Discount:<%=request.getAttribute("resultCalculate")%>
    </h2>
</body>
</html>
