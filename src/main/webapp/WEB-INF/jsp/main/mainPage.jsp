<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>
<jsp:useBean id="tours" scope="session" type="java.util.List"/>

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
    <nav class="secNav">
        <div class="nav nav-tabs justify-content-md-center" id="nav-tab" role="tablist">
            <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home"
                    type="button" role="tab" aria-controls="nav-home" aria-selected="true">Отдых</button>
            <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile"
                    type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Экскурсии</button>
            <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact"
                    type="button" role="tab" aria-controls="nav-contact" aria-selected="false">Шоппинг</button>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <div class="container-fluid mt-3">
                <div class="container">
                    <div class="row text-center">

                        <div class="row g-2">
                            <div class="col-md">
                                <div class="form-floating">
                                    <select class="form-select" id="floatingSelectGrid" aria-label="Страна">
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                    <label for="floatingSelectGrid">Страна</label>
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
                                        <label for="datepicker2" >Дата прилёта
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
                                    <label for="datepicker2" >Дата отлёта
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
                                    <label for="floatingSelectGrid">Количество взрослых</label>
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
                                    <label for="floatingSelectGrid">Количество детей</label>
                                </div>
                            </div>
                        </div>

                        <a class="btn btn-warning" style="margin-top: 20px; margin-left: 48%; width: 80px" href="controller?command=gotochillpage">
                            Search
                        </a>

                        <hr style="margin-top: 40px"/>

                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>
        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">...</div>
    </div>


    <div class="container-fluid mt-3" style="padding-top: 20px">
        <div class="container">
            <div class="row text-center">
                    <h1><span class="badge bg-danger">HOT</span></h1>
                    <h2>Самые горячие туры этого сезона !</h2>

            </div>
        </div>
    </div>

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
                                    Show details
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
