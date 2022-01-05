<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="img/favicon.ico" rel="icon">
    <link rel="stylesheet" href="Style.css">
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
        <jsp:include page="/share/Header.jsp"/>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-12 text-center">
                        <h1>Add new Patient</h1>
                        <c:if test='${requestScope["message"] != null}'>
                            <span class="col-12 border bg-light">${requestScope["message"]}</span>
                        </c:if>
                    </div>
                    <form class="col-lg-8 col-12" method="post">

                        <%-- name,dob,gender,personalId,phone,email,address,patientDescription--%>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput1">Medical Record ID:</label>
                            <input type="text" name="mrid" class="form-control col-12  mt-2"
                                   id="exampleInput1" placeholder="Enter Medical Record ID" value="${patient.id}"
                                   required="required">
                            <p style="color: red"> ${msgMRId} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput2">Patient ID:</label>
                            <input type="text" name="pid" class="form-control col-12  mt-2"
                                   id="exampleInput2" placeholder="Enter Patient ID"
                                   value="${patient.patientDescription.patientDesId}"
                                   required="required">
                            <p style="color: red"> ${msgPId} </p>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput3">Patient Name:</label>
                            <input type="text" name="name" class="form-control col-12  mt-2"
                                   id="exampleInput3" placeholder="Enter Patient Name"
                                   value="${patient.patientDescription.patientDesName}"
                                   required="required">
                            <p style="color: red"> ${msgDate} </p>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput4">Hospitalize Date:</label>
                            <input type="date" name="datein" class="form-control col-12  mt-2"
                                   id="exampleInput4" placeholder="Enter Hospitalize Date" value="${patient.dateIn}"
                                   required="required">
                            <p style="color: red"> ${msgDateIn} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput5">Discharge Date:</label>
                            <input type="date" name="dateout" class="form-control col-12  mt-2"
                                   id="exampleInput5" placeholder="Enter Discharge Date" value="${patient.dateOut}"
                                   required="required">
                            <p style="color: red"> ${msgDateOut} ${msgDateOut2}</p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="exampleInput6">Reason for Hospitalize:</label>
                            <input type="text" name="reason" class="form-control col-12  mt-2"
                                   id="exampleInput6" placeholder="Enter Reason" value="${patient.reason}"
                                   required="required">
                            <p style="color: red"> ${msgReason} </p>
                        </div>


                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
<%--                         <button type="submit" class="btn btn-primary ">Create</button>--%>
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary " data-bs-toggle="modal"
                                    data-bs-target="#exampleModal">
                                Create
                            </button>
                            <a href="/patient">
                                <button type="button" class="btn btn-dark ">Back</button>
                            </a>
                        </div>


                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Create Patient</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Do you want to check again ?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Check again
                                        </button>
                                        <button type="submit" class="btn btn-primary ">Create Patient</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <%-- Footer --%>
        <jsp:include page="/share/Footer.jsp"/>
    </div>
</div>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
<%--script for fun--%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="Main.js"></script>
</body>
</html>
