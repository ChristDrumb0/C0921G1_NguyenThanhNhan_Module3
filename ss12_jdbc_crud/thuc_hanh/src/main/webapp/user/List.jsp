<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
    <style>
        .height {
            height: 25vh
        }

        .form {
            position: relative
        }

        .form .fa-search {
            position: absolute;
            top: 20px;
            left: 20px;
            color: #9ca3af
        }

        .form span {
            position: absolute;
            right: 17px;
            top: 13px;
            padding: 2px;
            border-left: 1px solid #d1d5db
        }

        .left-pan {
            padding-left: 7px
        }

        .left-pan i {
            padding-left: 10px
        }

        .form-input {
            height: 55px;
            text-indent: 33px;
            border-radius: 10px
        }

        .form-input:focus {
            box-shadow: none;
            border: none
        }
    </style>
</head>
<body>
<center>
    <h1 style="font-family: Audiowide, sans-serif;">User Management</h1>
    <h2>
        <a href="/users?action=create" style="font-family: Audiowide, sans-serif;">+Add New User</a>
    </h2>
</center>
<div class="container">
    <div class="row height d-flex justify-content-center align-items-center">
        <div class="col-md-6">
            <form action="/users" method="get">
                <div class="form">
                    <input type="text" name="search" class="form-control form-input" placeholder="Search anything...">
                    <span class="left-pan"><i class="bi bi-mic-fill"></i></span>
                    <span>
                    <button type="submit" name="action" value="search"> Search <i class="bi bi-search"></i> </button>
                    </span>
                </div>
            </form>
        </div>
    </div>
</div>

<div align="center">
    <form action="/users">
        <select class="mdb-select md-form" name="sortByName">
            <option value="asc">Sort a-z (by Name)</option>
            <option value="desc">Sort z-a (by Name)</option>
        </select>
        <span>
            <button type="submit" name="action" value="sort"> Sort </button>
        </span>
    </form>
</div>
<div class="container">

    <div align="center" class="table-wrap">

        <table border="1" cellpadding="5" class="table">
            <caption><h2>List of Users</h2></caption>
            <thead class="bg-info">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            </thead>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}">Edit</a>
                        <a href="/users?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">

</script>

</body>
</html>