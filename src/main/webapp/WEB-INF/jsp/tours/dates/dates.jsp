<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../../header/header.jsp"/>

<%--<jsp:useBean id="hotTours" scope="session" type="java.util.List"/>--%>
<%--<jsp:useBean id="countries" scope="session" type="java.util.List"/>--%>
<jsp:useBean id="tour" scope="session" type="com.epam.travelAgency.entity.TourEntity"/>


<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="dates.new.creator" var="title"/>
<fmt:message bundle="${loc}" key="main.arrival-date" var="arrDate"/>
<fmt:message bundle="${loc}" key="main.departure-date" var="depDate"/>
<fmt:message bundle="${loc}" key="admin.panel.saveBtn" var="saveButton"/>
<fmt:message bundle="${loc}" key="user.login.change-lang" var="changeLang"/>


<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Турагенство</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        <%@include file='/WEB-INF/jsp/tours/dates/dates.css' %>
    </style>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

</head>
<body class="text-center">
<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${requestScope.errorMsg}
    </div>
</c:if>
<main class="form-signin">

<%--    <div class="lang-buttons">--%>
<%--        <p><c:out value="${changeLang}" /></p>--%>
<%--        <a class="btn btn-outline-warning translate" id="en" href="controller?command=changelanguage&locale=en">--%>
<%--            <img src="https://pngicon.ru/file/uploads/Flag-SShA.png" style="height: 30px; width: 40px">--%>
<%--        </a>--%>
<%--        <a class="btn btn-outline-warning" id="ru" href="controller?command=changelanguage&locale=ru">--%>
<%--            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"--%>
<%--                 style="height: 30px; width: 40px">--%>
<%--        </a>--%>
<%--    </div>--%>

    <form  action="controller?command=adddates&id_tour=${tour.id}" method="post">

        <a href="controller?command=gotomainpage"><img class="mb-4" src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
                                                       alt="" width="200" height="200"></a>
        <h1 class="h3 mb-3 fw-normal">
            <c:out value="${title}"/>
        </h1>

        <div class="col-md">
            <div class="form-floating has-validation">
                <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                       aria-label="Дата прилёта"
                       id="datepicker1" required="" pattern="[0-9].[0-9].[0-9]{2,2,4}">
                <label for="datepicker1" ><c:out value="${arrDate}"/>
                </label>
            </div>

        </div>

        <div class="col-md">
            <div class="form-floating has-validation">
                <input type="date" class="form-control" name="departureDate" data-format="mm-dd-yyyy"
                       aria-label="Дата отлёта"
                       id="datepicker2" required=""
                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                <label for="datepicker2" >
                    <c:out value="${depDate}"/>
                </label>
            </div>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit" style="margin-top: 30px">
            <c:out value="${saveButton}"/>
        </button>

        <p class="mt-5 mb-3 text-muted">© 2020–2021</p>
    </form>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
