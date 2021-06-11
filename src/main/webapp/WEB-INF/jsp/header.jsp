<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html >
<head>
    <!-- Обязательные метатеги -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    <style>
        <%@include file="/WEB-INF/css/header.css" %>
    </style>
    <title>Турагенство</title>
</head>
<body>
<%@ page import="com.epam.travelAgency.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<form action="controller?command=showcategories" method="get">
<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
    <div class="container-fluid">
        <a href="#" class="navbar-brand">
            <img src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
                 width="50" height="50" alt="logo">
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item dropdown">

                   <a class="nav-link dropdown-toggle"
                       role="button" id="navbarDropdown"
                       data-bs-toggle="dropdown" aria-expanded="false"
                       href="controller?command=showcategories">Категории тура</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">

<%--                        <% List<CategoryEntity> categories = (List<CategoryEntity>) session.getAttribute("categories"); %>--%>
                        <c:forEach items="${categories}" var="category" >
                            <li><a class="dropdown-item" href="#">
                                ${category.name}</a></li>

                        </c:forEach>
                    </ul>

                </li>
                <div class="vl"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#">HOT</a>
                </li>
                <div class="vl"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#">О нас</a>
                </li>
                <div class="vl"></div>
                <li class="nav-item">
                    <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Помощь</a>
                </li>
            </ul>

<%--            <div class="option-field-inner">--%>
                <div class="option-icon field-i">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="92px" height="92px" viewBox="0 0 92 92"
                         enable-background="new 0 0 92 92" class="app-icon">
                        <path d="M46,57.1c14.8,0,26.9-12.1,26.9-27C72.9,15.1,60.8,3,46,3S19.1,15.1,19.1,30C19.1,45,31.2,57.1,46,57.1zM46,11c10.4,0,18.9,8.5,18.9,19c0,10.5-8.5,19-18.9,19s-18.9-8.5-18.9-19C27.1,19.5,35.6,11,46,11z M58.5,59.7c-1.3-0.4-2.8-0.1-3.8,0.8L46,67.9l-8.7-7.4c-1.1-0.9-2.5-1.2-3.8-0.8C27.9,61.5,0,71.1,0,85c0,2.2,1.8,4,4,4h84c2.2,0,4-1.8,4-4C92,71.1,64.1,61.5,58.5,59.7z M10.1,81c4.4-4.7,15-9.9,23.8-12.9l9.5,8.1c1.5,1.3,3.7,1.3,5.2,0l9.5-8.1c8.8,3.1,19.4,8.3,23.8,12.9H10.1z"></path></svg>
                        </li>
                    </ul>
                </div>
                <div id="userInfo-place" class="field-i">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="controller?command=gotologinpage" >Личный кабинет</a>
                        </li>
                    </ul>
<%--                    <script type="text/javascript" wfd-invisible="true">--%>
<%--                        var HEADER_CHOSEN = 'Избранное',--%>
<%--                            HEADER_USER = 'Профиль',--%>
<%--                            HEADER_ORDERS = 'Мои заказы',--%>
<%--                            HEADER_MORE = 'header.more',--%>
<%--                            SIGN_OUT = 'Выход',--%>
<%--                            SIGN_IN = 'Мой кабинет',--%>
<%--                            REG = 'Регистрация',--%>
<%--                            SCRIPT_ADDRESS = 'https://r.tez-tour.com/portal/scripts/',--%>
<%--                            LANG = 'ru',--%>
<%--                            RUSSIA_CITY = 'false',--%>
<%--                            UKRAINE_CITY = 'false',--%>
<%--                            VILNIUS_CITY = 'false',--%>
<%--                            BELARUS_CITY = 'true',--%>
<%--                            BULGARIA_CITY = 'false',--%>
<%--                            ESTONIA_CITY = 'false',--%>
<%--                            DOMAIN = 'tez-tour.com',--%>
<%--                            IS_AGENT_COUNTRY = true,--%>
<%--                            ALLADYN_LOGIN_URL = 'https://tourist.teztour.by/?login=1',--%>
<%--                            PREFIX_URL = '/ru/minsk/';--%>

<%--                        var src = ((BELARUS_CITY || BULGARIA_CITY) || (undefined != Helper.getCookie('_atl') && '1'=== Helper.getCookie('_atl'))) ? "userInfo.js" : "userInfo.js";--%>
<%--                        var script = document.createElement( 'script' );--%>
<%--                        script.type = 'text/javascript';--%>
<%--                        script.src = "https://r.tez-tour.com/portal/scripts/" + src;--%>
<%--                        $("#userInfo-place").append( script );--%>

<%--                    </script>--%>

<%--                    <div class="userInfoId-html" style="display: none" wfd-invisible="true">--%>
<%--                        <div class="modal-small-container">--%>
<%--                            <div class="userInfo-version-select">--%>
<%--                                <b>Какую версию кабинета для агентств использовать?</b>--%>
<%--                                <div class="text-center content-spacer">--%>
<%--                                    <a class="std-main-btn" href="https://online.tez-tour.com">Кабинет агентства</a>--%>







<%--                                    <a class="std-main-btn" href="https://agent.teztour.by">Новый онлайн кабинет  (TEZ Plus)</a>--%>

<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

            </div>
<%--            <form class="d-flex form-inline my-2 my-lg-0" action="controller?command=gotologinpage" method="post">--%>
<%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-primary btn-search-style" type="submit">Search</button>--%>
<%--            </form>--%>
        </div>
    </div>
<%--    </div>--%>
</form>
</nav>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>--%>
</body>
</html>
