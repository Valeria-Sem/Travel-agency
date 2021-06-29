<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../../header/header.jsp"/>

<jsp:useBean id="tours" scope="session" type="java.util.List"/>


<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="main.arrival-date" var="arrDate"/>
<fmt:message bundle="${loc}" key="main.chill" var="chill"/>
<fmt:message bundle="${loc}" key="main.count-of-adults" var="adults"/>
<fmt:message bundle="${loc}" key="main.count-of-children" var="children"/>
<fmt:message bundle="${loc}" key="main.country" var="country"/>
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
    <div class="container">
        <div class="row">
            <div class="col col-sm">
                <div class="row g-4">
                    <div class="flex-shrink-0 p-3 sm-white" style="width: 280px;">
<%--                        <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">--%>
<%--                            <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>--%>
<%--                            <span class="fs-5 fw-semibold">Collapsible</span>--%>
<%--                        </a>--%>
                        <ul class="list-unstyled ps-0 secNav">
                            <li class="mb-1">
                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="false">
                                    Stars
                                </button>
                                <div class="collapse" id="home-collapse" style="">
                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                        <li><a href="#" class="link-dark rounded">Overview</a></li>
                                        <li><a href="#" class="link-dark rounded">Updates</a></li>
                                        <li><a href="#" class="link-dark rounded">Reports</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="mb-1">
                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
                                    Coastline
                                </button>
                                <div class="collapse" id="dashboard-collapse" style="">
                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                        <li><a href="#" class="link-dark rounded">Overview</a></li>
                                        <li><a href="#" class="link-dark rounded">Weekly</a></li>
                                        <li><a href="#" class="link-dark rounded">Monthly</a></li>
                                        <li><a href="#" class="link-dark rounded">Annually</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="mb-1">
                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
                                    Meals
                                </button>
                                <div class="collapse" id="orders-collapse" style="">
                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                        <li><a href="#" class="link-dark rounded">New</a></li>
                                        <li><a href="#" class="link-dark rounded">Processed</a></li>
                                        <li><a href="#" class="link-dark rounded">Shipped</a></li>
                                        <li><a href="#" class="link-dark rounded">Returned</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="border-top my-3"></li>
                            <li class="mb-1">
                                <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
                                    Account
                                </button>
                                <div class="collapse" id="account-collapse">
                                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                        <li><a href="#" class="link-dark rounded">New...</a></li>
                                        <li><a href="#" class="link-dark rounded">Profile</a></li>
                                        <li><a href="#" class="link-dark rounded">Settings</a></li>
                                        <li><a href="#" class="link-dark rounded">Sign out</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>



            <div class="col col-lg secNav">
                <div class="row g-2  text-center">
                    <div class="col-md">
                        <div class="form-floating">
                            <select class="form-select" id="floatingSelectGrid" aria-label="Страна">
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                            <label for="floatingSelectGrid"><c:out value="${country}"/></label>
                        </div>
                    </div>



                    <div class="col-md">
                        <%--                            <label class ="myLabel" for="datepicker1" class="form-label">--%>
                        <%--                                &lt;%&ndash;                            <c:out value="${dateBInput}"/>&ndash;%&gt;--%>
                        <%--                            </label>--%>
                        <div class="form-floating">
                            <input type="date" class="form-control" name="dateOfBirth" data-format="mm-dd-yyyy"
                                   aria-label="Дата прилёта"
                                   id="datepicker1" required>
                            <label for="datepicker2" ><c:out value="${arrDate}"/>
                                <%--                            <c:out value="${dateBInput}"/>--%>
                            </label>
                        </div>

                    </div>

                    <div class="col-md">
                        <%--                            <label class ="myLabel" for="datepicker2" class="form-label">--%>
                        <%--                                &lt;%&ndash;                            <c:out value="${dateBInput}"/>&ndash;%&gt;--%>
                        <%--                            </label>--%>
                        <div class="form-floating">
                            <input type="date" class="form-control" name="dateOfBirth" data-format="mm-dd-yyyy"
                                   aria-label="Дата отлёта"
                                   id="datepicker2" required>
                            <label for="datepicker2" >
                                <c:out value="${depDate}"/>
                                <%--                            <c:out value="${dateBInput}"/>--%>
                            </label>
                        </div>

                    </div>

                    <div class="col-md">
                        <div class="form-floating">
                            <select class="form-select" id="ad" aria-label="Количество взрослых">
                                <option value="1">1</option>
                                <option selected>2</option>
                                <option value="3">3</option>
                                <option value="3">4</option>
                            </select>
                            <label for="floatingSelectGrid"><c:out value="${adults}"/></label>
                        </div>
                    </div>

                    <div class="col-md">
                        <div class="form-floating">
                            <select class="form-select" id="chl" aria-label="Количество детей">
                                <option selected>0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                            <label for="floatingSelectGrid"><c:out value="${children}"/></label>
                        </div>
                    </div>
                </div>

                <a class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" href="controller?command=gotochillpage">
                    <c:out value="${searchBtn}"/>
                </a>

                <hr style="margin-top: 40px"/>

                <div class="container-fluid mt-5" style="background-color: #eeeeee">
                    <div class="container p-5">
                        <div class="row justify-content-center">
                            <c:forEach items="${tours}" var="tour" >

                                <div class="col col-lg-4 description" >
                                    <div class="card text-center mt-5 description-container param">
                                        <img src="${tour.imgPath}" alt="" class="card-img-top img">
                                        <c:if test="${tour.status eq 'HOT'}">
                                            <span class="badge bg-danger"> ${tour.status}</span>
                                        </c:if>
                                        <div class="card-body" >
                                            <h2 class="card-title pricing-card-title" >
                                                    ${tour.name}
                                            </h2>
                                            <h4 class="card-title" style="margin-top: 10px">
                                                <span class="badge rounded-pill bg-warning text-dark">${tour.price} $</span>
                                            </h4>
                                        </div>
                                        <div class="card-footer">
                                            <a class="btn btn-outline-primary" id="${tour.id}"
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
