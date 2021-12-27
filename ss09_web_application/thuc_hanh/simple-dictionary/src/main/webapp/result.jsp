<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/23/2021
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2 style="color: rebeccapurple;background-color: lavenderblush">
        from: <%= request.getParameter("txtSearch")%>
    </h2>
    <h2 style="color: burlywood;background-color: saddlebrown">
        translated: <%=request.getAttribute("transResult")%>
    </h2>
</div>
</body>
</html>
