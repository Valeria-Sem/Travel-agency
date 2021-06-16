<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"--%>
<%--"http://www.w3.org/TR/html4/loose.dtd">--%>
<jsp:include page="../header/header.jsp"/>
<html >
<head>
    <!-- Обязательные метатеги -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        <%@include file='/WEB-INF/jsp/main/mainPage.css' %>
    </style>
    <title>Турагенство</title>
</head>
<body>

<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
<%--            data-bs-interval="10000"--%>
            <img src="assets\img\tailand.jpg" class="d-block w-100" alt="first slide">
            <div class="carousel-caption d-none d-md-block">
                <h2>
                <a href="controller?command=gotologinpage" class="link">Неповторимый отдых в Тайланде</a>
                </h2>
                    <p>Некоторый репрезентативный заполнитель для первого слайда.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="assets\img\gdansk.jpg" class="d-block w-100" alt="second slide">
        </div>
        <div class="carousel-item">
            <img src="assets\img\bora-bora.jpg" class="d-block w-100" alt="third slide">
        </div>
        <div class="carousel-item">
            <img src="assets\img\indonezia.jpg" class="d-block w-100" alt="forth slide">
        </div>
        <div class="carousel-item">
            <img src="assets\img\melbyrn.jpg" class="d-block w-100" alt="fifth slide">
        </div>
        <div class="carousel-item">
            <img src="assets\img\piter.jpg" class="d-block w-100" alt="sixth slide">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade"  data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Предыдущий</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade"  data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Следующий</span>
    </button>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
