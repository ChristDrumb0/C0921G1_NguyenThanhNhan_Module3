<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/24/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>
<p><%=request.getParameter("first-operand")
        +request.getParameter("operator")
        +request.getParameter("second-operand")
        + "="+ request.getAttribute("result")%></p>

</body>
</html>
