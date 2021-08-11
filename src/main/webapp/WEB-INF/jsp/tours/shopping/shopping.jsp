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
<fmt:message bundle="${loc}" key="main.tourEx" var="tourEx"/>
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
<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${errorMsg}
    </div>
</c:if>

<div class="container-fluid mt-3">
    <div class="container top-container">
        <div class="row">
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
                            <c:if test="${shoppingTours.size() == 0}">
                                <div class="alert alert-warning" role="alert">
                                    <c:out value="${tourEx}"/>
                                </div>
                            </c:if>
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
                                               href="controller?command=gotodetailspage&id=${shoppingTour.id}" >
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
