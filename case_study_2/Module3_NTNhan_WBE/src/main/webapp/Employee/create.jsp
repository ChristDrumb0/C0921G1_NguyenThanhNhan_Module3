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
        .navbar-light .navbar-nav .nav-link.active2 {
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
                        <h1>Add new employee</h1>
                        <c:if test='${requestScope["message"] != null}'>
                            <span class="col-12 border bg-light">${requestScope["message"]}</span>
                        </c:if>
                    </div>
                    <form class="col-lg-8 col-12" method="post">

                        <%-- name,dob,gender,personalId,salary,phone,email,address,position,education,division,username--%>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput1">Employee's Name:</label>
                            <input type="text" name="name" class="form-control col-12 mt-2"
                                   id="exampleInput1" placeholder="Enter full name" value="${employee.name}" required="required">
                            <p style="color: red"> ${msgName} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput2">Date of Birth:</label>
                            <input type="text" name="dob" class="form-control col-12  mt-2"
                                   id="exampleInput2" placeholder="Enter day of birth" value="${employee.dob}" required="required">
                            <p style="color: red"> ${msgDate} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput3">Gender :</label>

                            <select name="gender" id="exampleInput3" class="form-control col-12  mt-2">
                                <option value="0">Female</option>
                                <option value="1">Male</option>

                            </select>
<%--                            <p style="color: red"> ${msgIdCard} </p>--%>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput4">Personal-Id:</label>
                            <input type="text" name="personalId" class="form-control col-12  mt-2"
                                   id="exampleInput4" placeholder="Enter personal id" value="${employee.cmnd}" required="required">
                            <p style="color: red"> ${msgPersonalId} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput5">Salary :</label>
                            <input type="text" name="salary" class="form-control col-12  mt-2"
                                   id="exampleInput5" placeholder="Enter salary" value="${employee.salary}" required="required">
<%--                            <p style="color: red"> ${msgIdCard} </p>--%>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput6">Phone:</label>
                            <input type="text" name="phone" class="form-control col-12  mt-2"
                                   id="exampleInput6" placeholder="Enter phone" value="${employee.phone}" required="required">
                            <p style="color: red"> ${msgPhone} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput7">Email:</label>
                            <input type="text" name="email" class="form-control col-12  mt-2"
                                   id="exampleInput7" placeholder="Enter email" value="${employee.email}" required="required">
                            <p style="color: red"> ${msgEmail} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput8">Address:</label>
                            <input type="text" name="address" class="form-control col-12  mt-2"
                                   id="exampleInput8" placeholder="Enter address" value="${employee.address}" required="required">
<%--                            <p style="color: red"> ${msgIdCard} </p>--%>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputPosition">Position:</label>
                            <select name="position" id="exampleInputPosition" class="form-control col-12" required="required">
                                <option value="">Chose option ...</option>
                                <c:forEach items="${getPosition}" var="item">
                                    <%--                                     <c:choose>--%>
                                    <%--                                         <c:when test="${item.id == employee.position.id}">--%>
                                    <%--                                             <option value="${item.id}" selected> ${item.name} </option>--%>
                                    <%--                                         </c:when>--%>
                                    <%--                                         <c:otherwise>--%>
                                    <%--                                             <option value="${item.id}"> ${item.name} </option>--%>
                                    <%--                                         </c:otherwise>--%>
                                    <%--                                     </c:choose>--%>
                                    <option value="${item.positionId}"> ${item.positionName} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputEducation">Education:</label>
                            <select name="education" id="exampleInputEducation" class="form-control col-12" required="required">
                                <option value="">Chose option ...</option>
                                <c:forEach items="${getEducation}" var="item">
                                    <%--                                    <c:choose>--%>
                                    <%--                                        <c:when test="${item.id == employee.education.id}">--%>
                                    <%--                                            <option value="${item.educationId}"--%>
                                    <%--                                                    selected> ${item.educationName} </option>--%>
                                    <%--                                        </c:when>--%>
                                    <%--                                        <c:otherwise>--%>
                                    <%--                                            <option value="${item.id}"> ${item.name} </option>--%>
                                    <%--                                        </c:otherwise>--%>
                                    <%--                                    </c:choose>--%>
                                    <option value="${item.educationId}"> ${item.educationName} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1" for="exampleInputDivision">Division:</label>
                            <select name="division" id="exampleInputDivision" class="form-control col-12" required="required">
                                <option value="">Chose option ...</option>
                                <c:forEach items="${getDivision}" var="item">
                                    <%--                                    <c:choose>--%>
                                    <%--                                        <c:when test="${item.id == employee.division.id}">--%>
                                    <%--                                            <option value="${item.id}" selected> ${item.name} </option>--%>
                                    <%--                                        </c:when>--%>
                                    <%--                                        <c:otherwise>--%>
                                    <%--                                            <option value="${item.id}"> ${item.name} </option>--%>
                                    <%--                                        </c:otherwise>--%>
                                    <%--                                    </c:choose>--%>
                                    <option value="${item.divisionId}"> ${item.divisionName} </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput12">Username :</label>

                            <select name="username" id="exampleInput12" class="form-control col-12  mt-2">
                                <option value="view">Normal level</option>
                                <option value="hr">HR level</option>
                                <option value="admin">Admin level</option>
                                <option value="gm">GM level</option>
                                <option value="owner">Owner level</option>

                            </select>
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>

                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <button type="submit" class="btn btn-primary ">Create</button>
                            <a href="/employee">
                                <button type="button" class="btn btn-dark ">Back</button>
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
