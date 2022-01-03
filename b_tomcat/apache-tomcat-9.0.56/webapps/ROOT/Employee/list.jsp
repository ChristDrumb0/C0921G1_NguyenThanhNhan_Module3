<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
    <style>
        text{
            font-size: 15px;
        }

        .navbar-light .navbar-nav .nav-link:hover,
        .navbar-light .navbar-nav .nav-link.active2 {
             color: #D19C97;
        }

    </style>
</head>
<body>

<jsp:include page="/share/header.jsp"/>

<div class="container">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 col-3 ">
            <div class=" py-3 px-xl-3">
                <button type="button" style="background-color: #D19C97 "><a href="/employee?action=create" class="text-dark" >
                    +Add new Employee</a></button>
            </div>
        </div>
        <div class="col-lg-9 col-9">
            <div class=" py-3 px-xl-5">
                <form action="/employee">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search for employee by 'Name'">
                        <span class="input-group-text bg-transparent text-primary"><button type="submit" name="action" value="search"> <i class="bi bi-search"></i> </button></span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="row px-xl-5 container-fluid" >
    <div align="center" class="table-wrap ">
        <caption><h2>List of Employee</h2></caption>
        <table border="1" cellpadding="5" id="table" class="table table-striped table-bordered" >
            <thead style="background-color: #D19C97">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Day of Birth</th>
                <th>Gender</th>
                <th>Personal Id</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position</th>
                <th>Education</th>
                <th>Division</th>
                <th>Username</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.dob}"/></td>
                    <td><c:out value="${employee.gender}"/></td>
                    <td><c:out value="${employee.cmnd}"/></td>
                    <td><c:out value="${employee.salary}"/></td>
                    <td><c:out value="${employee.phone}"/></td>
                    <td><c:out value="${employee.email}"/></td>
                    <td><c:out value="${employee.address}"/></td>
                    <td><c:out value="${employee.position}"/></td>
                    <td><c:out value="${employee.education}"/></td>
                    <td><c:out value="${employee.division}"/></td>
                    <td><c:out value="${employee.username}"/></td>
                    <td>
                        <button type="button" class="btn btn-primary"><a href="/employee?action=edit&id=${employee.id}"><i class="bi bi-pen text-dark"></i></a></button></span>
                        <!-- Button trigger modal -->
                       <button type="button" class="btn btn-primary " data-bs-toggle="modal" data-bs-target="#exampleModal-${employee.id}">
                            <i class="bi bi-trash"></i>
                       </button>
<%--                        <a href="/employee?action=delete&id=${employee.id}"></a>--%>
                    </td>
                </tr>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal-${employee.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                               this ID is ${employee.id} called ${employee.name} and you want to delete, Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <a href="employee?action=delete&id=${employee.id}" class="btn btn-primary">Save changes</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
<jsp:include page="/share/footer.jsp"/>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function(){
        $('#table').dataTable({
                "dom": 'ltrip',
                "lengthChange" : false,
                "pageLength": 5
        })
    });
</script>
</body>
</html>
