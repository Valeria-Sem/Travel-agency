<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../../header/header.jsp"/>

<jsp:useBean id="countries" scope="session" type="java.util.List"/>
<jsp:useBean id="shoppingTours" scope="session" type="java.util.Set"/>




<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="main.arrival-date" var="arrDate"/>
<fmt:message bundle="${loc}" key="main.chill" var="chill"/>
<fmt:message bundle="${loc}" key="main.count-of-adults" var="adults"/>
<fmt:message bundle="${loc}" key="main.count-of-children" var="children"/>
<fmt:message bundle="${loc}" key="main.country" var="countr"/>
<fmt:message bundle="${loc}" key="main.departure-date" var="depDate"/>
<fmt:message bundle="${loc}" key="main.details-btn" var="detailsBtn"/>
<fmt:message bundle="${loc}" key="main.excursions" var="excursions"/>
<fmt:message bundle="${loc}" key="main.hot-text" var="hotText"/>
<fmt:message bundle="${loc}" key="main.search-btn" var="searchBtn"/>
<fmt:message bundle="${loc}" key="main.shopping" var="shopping"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        <%@include file='/WEB-INF/jsp/tours/chill/chill.css' %>
    </style>

    <title>Title</title>
</head>
<body>


<div class="container-fluid mt-3">
    <div class="container top-container">
        <div class="row">
            <%--            <div class="col col-sm side-menu">--%>
            <%--                <div class="row g-4">--%>
            <%--                    <div class="flex-shrink-0 p-3 sm-white" style="width: 280px;">--%>
            <%--                        <ul class="list-unstyled ps-0 secNav">--%>
            <%--                            <li class="mb-1">--%>
            <%--                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="false">--%>
            <%--                                    Stars--%>
            <%--                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16">--%>
            <%--                                        <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"></path>--%>
            <%--                                    </svg>--%>
            <%--                                </button>--%>
            <%--                                <div class="collapse" id="home-collapse" style="">--%>
            <%--                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Overview</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Updates</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Reports</a></li>--%>
            <%--                                    </ul>--%>
            <%--                                </div>--%>
            <%--                            </li>--%>
            <%--                            <li class="mb-1">--%>
            <%--                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">--%>
            <%--                                    Coastline--%>
            <%--                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-tsunami" viewBox="0 0 16 16">--%>
            <%--                                        <path d="M.036 12.314a.5.5 0 0 1 .65-.278l1.757.703a1.5 1.5 0 0 0 1.114 0l1.014-.406a2.5 2.5 0 0 1 1.857 0l1.015.406a1.5 1.5 0 0 0 1.114 0l1.014-.406a2.5 2.5 0 0 1 1.857 0l1.015.406a1.5 1.5 0 0 0 1.114 0l1.757-.703a.5.5 0 1 1 .372.928l-1.758.703a2.5 2.5 0 0 1-1.857 0l-1.014-.406a1.5 1.5 0 0 0-1.114 0l-1.015.406a2.5 2.5 0 0 1-1.857 0l-1.014-.406a1.5 1.5 0 0 0-1.114 0l-1.015.406a2.5 2.5 0 0 1-1.857 0l-1.757-.703a.5.5 0 0 1-.278-.65zm0 2a.5.5 0 0 1 .65-.278l1.757.703a1.5 1.5 0 0 0 1.114 0l1.014-.406a2.5 2.5 0 0 1 1.857 0l1.015.406a1.5 1.5 0 0 0 1.114 0l1.014-.406a2.5 2.5 0 0 1 1.857 0l1.015.406a1.5 1.5 0 0 0 1.114 0l1.757-.703a.5.5 0 1 1 .372.928l-1.758.703a2.5 2.5 0 0 1-1.857 0l-1.014-.406a1.5 1.5 0 0 0-1.114 0l-1.015.406a2.5 2.5 0 0 1-1.857 0l-1.014-.406a1.5 1.5 0 0 0-1.114 0l-1.015.406a2.5 2.5 0 0 1-1.857 0l-1.757-.703a.5.5 0 0 1-.278-.65zM2.662 8.08c-.456 1.063-.994 2.098-1.842 2.804a.5.5 0 0 1-.64-.768c.652-.544 1.114-1.384 1.564-2.43.14-.328.281-.68.427-1.044.302-.754.624-1.559 1.01-2.308C3.763 3.2 4.528 2.105 5.7 1.299 6.877.49 8.418 0 10.5 0c1.463 0 2.511.4 3.179 1.058.67.66.893 1.518.819 2.302-.074.771-.441 1.516-1.02 1.965a1.878 1.878 0 0 1-1.904.27c-.65.642-.907 1.679-.71 2.614C11.076 9.215 11.784 10 13 10h2.5a.5.5 0 0 1 0 1H13c-1.784 0-2.826-1.215-3.114-2.585-.232-1.1.005-2.373.758-3.284L10.5 5.06l-.777.388a.5.5 0 0 1-.447 0l-1-.5a.5.5 0 0 1 .447-.894l.777.388.776-.388a.5.5 0 0 1 .447 0l1 .5a.493.493 0 0 1 .034.018c.44.264.81.195 1.108-.036.328-.255.586-.729.637-1.27.05-.529-.1-1.076-.525-1.495-.426-.42-1.19-.77-2.477-.77-1.918 0-3.252.448-4.232 1.123C5.283 2.8 4.61 3.738 4.07 4.79c-.365.71-.655 1.433-.945 2.16-.15.376-.301.753-.463 1.13z"></path>--%>
            <%--                                    </svg>--%>
            <%--                                </button>--%>
            <%--                                <div class="collapse" id="dashboard-collapse" style="">--%>
            <%--                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Overview</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Weekly</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Monthly</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Annually</a></li>--%>
            <%--                                    </ul>--%>
            <%--                                </div>--%>
            <%--                            </li>--%>
            <%--                            <li class="mb-1">--%>
            <%--                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">--%>
            <%--                                    Meals--%>
            <%--                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-egg-fried" viewBox="0 0 16 16">--%>
            <%--                                        <path d="M8 11a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>--%>
            <%--                                        <path d="M13.997 5.17a5 5 0 0 0-8.101-4.09A5 5 0 0 0 1.28 9.342a5 5 0 0 0 8.336 5.109 3.5 3.5 0 0 0 5.201-4.065 3.001 3.001 0 0 0-.822-5.216zm-1-.034a1 1 0 0 0 .668.977 2.001 2.001 0 0 1 .547 3.478 1 1 0 0 0-.341 1.113 2.5 2.5 0 0 1-3.715 2.905 1 1 0 0 0-1.262.152 4 4 0 0 1-6.67-4.087 1 1 0 0 0-.2-1 4 4 0 0 1 3.693-6.61 1 1 0 0 0 .8-.2 4 4 0 0 1 6.48 3.273z"></path>--%>
            <%--                                    </svg>--%>
            <%--                                </button>--%>
            <%--                                <div class="collapse" id="orders-collapse" style="">--%>
            <%--                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">--%>
            <%--                                        <li><a href="#" class="link-dark rounded">New</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Processed</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Shipped</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Returned</a></li>--%>
            <%--                                    </ul>--%>
            <%--                                </div>--%>
            <%--                            </li>--%>
            <%--                            <li class="mb-1">--%>
            <%--                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse2" aria-expanded="false">--%>
            <%--                                    Transport--%>
            <%--                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-minecart" viewBox="0 0 16 16">--%>
            <%--                                        <path d="M4 15a1 1 0 1 1 0-2 1 1 0 0 1 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm8-1a1 1 0 1 1 0-2 1 1 0 0 1 0 2zm0 1a2 2 0 1 0 0-4 2 2 0 0 0 0 4zM.115 3.18A.5.5 0 0 1 .5 3h15a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 14 12H2a.5.5 0 0 1-.491-.408l-1.5-8a.5.5 0 0 1 .106-.411zm.987.82 1.313 7h11.17l1.313-7H1.102z"></path>--%>
            <%--                                    </svg>--%>
            <%--                                </button>--%>
            <%--                                <div class="collapse" id="orders-collapse2" style="">--%>
            <%--                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">--%>
            <%--                                        <li><a href="#" class="link-dark rounded">New</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Processed</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Shipped</a></li>--%>
            <%--                                        <li><a href="#" class="link-dark rounded">Returned</a></li>--%>
            <%--                                    </ul>--%>
            <%--                                </div>--%>
            <%--                            </li>--%>
            <%--                            <li class="border-top my-3"></li>--%>

            <%--                        </ul>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>



            <div class="col col-lg secNav">
                <form class="form-registration" action="controller?command=showshoppingdata" method="post">

                    <div class="row g-2  text-center">
                        <div class="col-md">
                            <div class="form-floating has-validation">
                                <select class="form-select" id="floatingSelectGrid"
                                        required="" name="countries"
                                        aria-label="Страна">
                                    <c:forEach items="${countries}" var="country">
                                        <option value="${country.name}">
                                                ${country.name}
                                        </option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelectGrid"><c:out value="${countr}"/></label>
                            </div>
                        </div>

                        <div class="col-md">
                            <div class="form-floating has-validation">
                                <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker1" required="">
                                <label for="datepicker1" ><c:out value="${arrDate}"/>
                                </label>
                            </div>
                        </div>
                    </div>

                    <button class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" type="submit" >
                        <c:out value="${searchBtn}"/>
                    </button>

                    <hr style="margin-top: 40px"/>
                </form>

                <div class="container-fluid mt-5" style="background-color: #eeeeee">
                    <div class="container p-5">
                        <div class="row justify-content-center">
                            <c:forEach items="${shoppingTours}" var="shoppingTour" >

                                <div class="col col-lg-4 description" >
                                    <div class="card text-center mt-5 description-container param">
                                        <img src="${shoppingTour.imgPath}" alt="" class="card-img-top img">
                                        <c:if test="${shoppingTour.status eq 'HOT'}">
                                            <span class="badge bg-danger"> ${shoppingTour.status}</span>
                                        </c:if>
                                        <div class="card-body" >
                                            <h2 class="card-title pricing-card-title" >
                                                    ${shoppingTour.name}
                                            </h2>
                                            <h4 class="card-title" style="margin-top: 10px">
                                                <span class="badge rounded-pill bg-warning text-dark">${shoppingTour.price} $</span>
                                            </h4>
                                        </div>
                                        <div class="card-footer">
                                            <a class="btn btn-outline-primary" id="${shoppingTour.id}"
                                               (click)="payAndSub(choice.monthPrise, template, choice.idProduct, choice.idOrganisation)">
                                                <c:out value="${detailsBtn}"/>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>

</body>
</html>
