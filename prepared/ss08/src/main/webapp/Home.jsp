
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$HomePage$</title>
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
    .navbar-light .navbar-nav .nav-link:hover,
    .navbar-light .navbar-nav .nav-link.active1 {
      color: #D19C97;
    }
  </style>
</head>
<body>
<jsp:include page="/share/Header.jsp" />
<div>
  <div id="header-carousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
      <div class="carousel-item" style="height: 410px;">
        <img class="img-fluid" src="https://meta.vn/Data/image/2021/10/12/hinh-anh-nhom-black-pink-26.1.jpg" alt="Image">
        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
          <div class="p-3" style="max-width: 700px;">
            <h4 class="text-light text-uppercase font-weight-medium mb-3">30% Off Your fee From 1/1/2022 </h4>
            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Hospital After Pandemic</h3>
            <a href="" class="btn btn-light py-2 px-3">Book Now</a>
          </div>
        </div>
      </div>
      <div class="carousel-item active" style="height: 410px;">
        <img class="img-fluid" src="https://www.raver.vn/upload/posts/2021-06-10-10-52-40-542.jpeg" alt="Image">
        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
          <div class="p-3" style="max-width: 700px;">
            <h4 class="text-light text-uppercase font-weight-medium mb-3">20% Off if Having BlackPink's New Album</h4>
            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Hospital In Your Area</h3>
            <a href="" class="btn btn-light py-2 px-3">Book Now</a>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#header-carousel" data-slide="prev">
      <div class="btn btn-dark" style="width: 45px; height: 45px;">
        <span class="carousel-control-prev-icon mb-n2"></span>
      </div>
    </a>
    <a class="carousel-control-next" href="#header-carousel" data-slide="next">
      <div class="btn btn-dark" style="width: 45px; height: 45px;">
        <span class="carousel-control-next-icon mb-n2"></span>
      </div>
    </a>
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
</body>
</html>
