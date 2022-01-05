<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="img/favicon.ico" rel="icon">
        <link rel="stylesheet" href="Style.css">

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

<jsp:include page="/share/Header.jsp"/>

<div class="container">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 col-3 ">
            <div class=" py-3 px-xl-3">
                <button type="button" style="background-color: #D19C97 "><a href="/patient?action=create" class="text-dark" >
                    +Add new Employee</a></button>
            </div>
        </div>
        <div class="col-lg-9 col-9">
            <div class=" py-3 px-xl-5">
                <form action="/patient">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search for patient by 'Name'">
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
                <th>STT</th>
                <th>Medical record ID</th>
                <th>Patient ID</th>
                <th>Patient name</th>
                <th>Hospitalize date</th>
                <th>Discharge date</th>
                <th>Reason</th>
                <th>Action</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="patient"  items="${listPatient}" varStatus="theCount">
                <tr>
                    <td><c:out value="${theCount.count}"/></td>
                    <td><c:out value="${patient.id}"/></td>
                    <td><c:out value="${patient.patientDescription.patientDesId}"/></td>
                    <td><c:out value="${patient.patientDescription.patientDesName}"/></td>
                    <td><c:out value="${patient.dateIn}"/></td>
                    <td><c:out value="${patient.dateOut}"/></td>
                    <td><c:out value="${patient.reason}"/></td>
                    <td>
                        <button type="button" class="btn btn-primary"><a href="/patient?action=edit&id=${patient.id}"><i class="bi bi-pen text-dark"></i></a></button></span>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary " data-bs-toggle="modal" data-bs-target="#exampleModal-${patient.id}">
                            <i class="bi bi-trash"></i>
                        </button>
                    </td>
                </tr>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal-${patient.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                this is patient  ${patient.patientDescription.patientDesName} with ID: ${patient.patientDescription.patientDesId} and you want to delete, Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <a href="patient?action=delete&id=${patient.id}" class="btn btn-primary">Save changes</a>
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
<jsp:include page="/share/Footer.jsp"/>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
    <%--script for fun--%>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="Main.js"></script>

    <%--js for table--%>
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

