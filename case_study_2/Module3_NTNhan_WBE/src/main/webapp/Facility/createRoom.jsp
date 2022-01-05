<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        text {
            font-size: 15px;
        }
        .navbar-light .navbar-nav .nav-link:hover,
        .navbar-light .navbar-nav .nav-link.active4 {
            color: #D19C97;
        }
    </style>
</head>
<body>

<div class="wrapper ">
    <div class="main-panel">
        <jsp:include page="/share/header.jsp"/>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-12 text-center">
                        <%--                        <h1>Add new Facility</h1>--%>
                        <%--                        <c:if test='${requestScope["message"] != null}'>--%>
                        <%--                            <span class="col-12 border bg-light">${requestScope["message"]}</span>--%>
                        <%--                        </c:if>--%>
                        <div class="row align-items-center py-3 px-xl-5">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                    +Add new
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a class="dropdown-item" href="/facility?action=house">House</a></li>
                                    <li><a class="dropdown-item" href="/facility?action=villa">Villa</a></li>
                                    <li><a class="dropdown-item" href="/facility?action=room">Room</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <form class="col-lg-8 col-12" method="post">

                        <%--(`name`,area,cost,capacity,rent_type_id,service_type_id,`description`)--%>
                        <h2>Create Room</h2>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput1">Name:</label>
                            <input type="text" name="name" class="form-control col-12  mt-2"
                                   id="exampleInput1" placeholder="Enter name" value="${house.name}" required="required">
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput2">Area:</label>
                            <input type="text" name="area" class="form-control col-12  mt-2"
                                   id="exampleInput2" placeholder="Enter area" value="${house.area}" required="required">
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput3">Cost:</label>
                            <input type="text" name="cost" class="form-control col-12  mt-2"
                                   id="exampleInput3" placeholder="Enter cost" value="${house.cost}" required="required">
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput4">Capacity:</label>
                            <input type="text" name="capacity" class="form-control col-12  mt-2"
                                   id="exampleInput4" placeholder="Enter capacity" value="${house.capacity}" required="required">
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Rent Type Id :</label>
                            <select name="rentType" id="exampleInputPosition" class="form-control col-12" required="required">
                                <option value="">Chose option ...</option>
                                <c:forEach items="${getRentType}" var="item">
                                    <%--                                     <c:choose>--%>
                                    <%--                                         <c:when test="${item.id == employee.position.id}">--%>
                                    <%--                                             <option value="${item.id}" selected> ${item.name} </option>--%>
                                    <%--                                         </c:when>--%>
                                    <%--                                         <c:otherwise>--%>
                                    <%--                                             <option value="${item.id}"> ${item.name} </option>--%>
                                    <%--                                         </c:otherwise>--%>
                                    <%--                                     </c:choose>--%>
                                    <option value="${item.rentTypeId}"> ${item.rentTypeName} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput6"> Service description:</label>
                            <input type="text" name="description" class="form-control col-12  mt-2"
                                   id="exampleInput6" placeholder="Enter description" value="${house.description}" required="required">
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>

                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <button type="submit" class="btn btn-primary ">Create Room</button>
                            <a href="/home">
                                <button type="button" class="btn btn-dark ">Back Home</button>
                            </a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <%-- Footer --%>
        <jsp:include page="/share/footer.jsp"/>
    </div>
</div>


<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>

