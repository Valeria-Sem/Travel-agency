<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>

<jsp:useBean id="hotTours" scope="session" type="java.util.List"/>
<jsp:useBean id="countries" scope="session" type="java.util.List"/>


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

<html >
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <style>
        <%@include file='/WEB-INF/jsp/main/mainPage.css' %>
    </style>
    <title>Турагенство</title>
</head>

<body>
<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${requestScope.errorMsg}
    </div>
</c:if>
    <nav class="secNav">
        <div class="nav nav-tabs justify-content-md-center" id="nav-tab" role="tablist">
            <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home"
                    type="button" role="tab" aria-controls="nav-home" aria-selected="true"><c:out value="${chill}"/></button>
            <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile"
                    type="button" role="tab" aria-controls="nav-profile" aria-selected="false"><c:out value="${excursions}"/></button>
            <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact"
                    type="button" role="tab" aria-controls="nav-contact" aria-selected="false"><c:out value="${shopping}"/></button>
        </div>
    </nav>

        <div class="tab-content needs-validation" id="nav-tabContent">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <form class="form-registration" id="1" action="controller?command=showchilltoursdata" method="post">

                    <div class="container-fluid mt-3">
                        <div class="container">

                            <div class="row text-center">

                                <div class="row g-2">
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

                                    <div class="col-md">
                                        <div class="form-floating has-validation">
                                            <select class="form-select" id="add" aria-label="Количество взрослых"
                                                    required="" name="adults">
                                                <option value="1">1</option>
                                                <option selected>2</option>
                                                <option value="3">3</option>
                                                <option value="3">4</option>
                                            </select>
                                            <label for="floatingSelectGrid"><c:out value="${adults}"/></label>
                                        </div>
                                    </div>

                                    <div class="col-md">
                                        <div class="form-floating has-validation">
                                            <select class="form-select" id="chl1" aria-label="Количество детей"
                                                    required="" name="children">
                                                <option selected>0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                            <label for="floatingSelectGrid"><c:out value="${children}"/></label>
                                        </div>
                                    </div>
                                </div>

                                <button class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" type="submit" >
                                    <c:out value="${searchBtn}"/>
                                </button>

                                <hr style="margin-top: 40px"/>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>

                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                    <form class="form-registration" id="2" action="controller?command=showexcursiondata" method="post">
                        <div class="container-fluid mt-3">
                            <div class="container">
                                <div class="row text-center">
                                    <div class="row g-2">
                                        <div class="col-md">
                                            <div class="form-floating has-validation">
                                                <select class="form-select" id="floatingSelectGrid4"
                                                        required="" name="countries"
                                                        aria-label="Страна">
                                                    <c:forEach items="${countries}" var="country">
                                                        <option value="${country.name}">
                                                                ${country.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                                <label for="floatingSelectGrid1"><c:out value="${countr}"/></label>
                                            </div>
                                        </div>

                                        <div class="col-md">
                                            <div class="form-floating has-validation">
                                                <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                                       aria-label="Дата прилёта"
                                                       id="datepicker3" required=""
                                                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                                <label for="datepicker3" ><c:out value="${arrDate}"/>
                                                </label>
                                            </div>
                                        </div>

                                        <div class="col-md">
                                            <div class="form-floating has-validation">
                                                <input type="date" class="form-control" name="departureDate" data-format="mm-dd-yyyy"
                                                       aria-label="Дата отлёта"
                                                       id="datepicker4" required=""
                                                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                                <label for="datepicker4" >
                                                    <c:out value="${depDate}"/>
                                                </label>
                                            </div>
                                        </div>
                                    </div>



                                    <button class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" type="submit" >
                                        <c:out value="${searchBtn}"/>
                                    </button>

                                    <hr style="margin-top: 40px"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                    <form class="form-registration" id="4" action="controller?command=showshoppingdata" method="post">

                    <div class="container-fluid mt-3">
                        <div class="container">
                            <div class="row text-center">
                                <div class="row g-2">
                                    <div class="col-md">
                                        <div class="form-floating has-validation">
                                            <select class="form-select" id="floatingSelectGrid1"
                                                    required="" name="countries"
                                                    aria-label="Страна">
                                                <c:forEach items="${countries}" var="country">
                                                    <option value="${country.name}">
                                                            ${country.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <label for="floatingSelectGrid1"><c:out value="${countr}"/></label>
                                        </div>
                                    </div>

                                    <div class="col-md">
                                        <div class="form-floating has-validation">
                                            <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                                   aria-label="Дата прилёта"
                                                   id="datepicker5" required=""
                                                   pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                            <label for="datepicker5" ><c:out value="${arrDate}"/>
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <button class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" type="submit" >
                                    <c:out value="${searchBtn}"/>
                                </button>

                                <hr style="margin-top: 40px"/>
                            </div>
                        </div>
                    </div>
                    </form>

                </div>
        </div>

    <div class="container-fluid mt-3" style="padding-top: 20px">
        <div class="container">
            <div class="row text-center">
                    <h1><span class="badge bg-danger">HOT</span></h1>
                    <h2><c:out value="${hotText}"/></h2>

            </div>
        </div>
    </div>

    <div class="container-fluid mt-5" style="background-color: #eeeeee">
        <div class="container p-5">
            <div class="row justify-content-center">
                <c:forEach items="${hotTours}" var="tour" >

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
                                   href="controller?command=gotodetailspage&id=${tour.id}">
                                    <c:out value="${detailsBtn}"/>
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
