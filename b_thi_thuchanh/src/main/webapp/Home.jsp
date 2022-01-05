
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$HomePage$</title>
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
        <img class="img-fluid" src="carousel-1.jpg" alt="Image">
        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
          <div class="p-3" style="max-width: 700px;">
            <h4 class="text-light text-uppercase font-weight-medium mb-3">30% Off Your First Booking From 1/1/2022 </h4>
            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Furama After Pandemic</h3>
            <a href="" class="btn btn-light py-2 px-3">Book Now</a>
          </div>
        </div>
      </div>
      <div class="carousel-item active" style="height: 410px;">
        <img class="img-fluid" src="carousel-2.jpeg" alt="Image">
        <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
          <div class="p-3" style="max-width: 700px;">
            <h4 class="text-light text-uppercase font-weight-medium mb-3">20% Off if Having BlackPink's New Album</h4>
            <h3 class="display-4 text-white font-weight-semi-bold mb-4">Furama In Your Area</h3>
            <a href="" class="btn btn-light py-2 px-3">Shop Now</a>
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
</body>
</html>
