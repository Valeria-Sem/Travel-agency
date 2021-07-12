<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>

<jsp:useBean id="current_user" scope="session" type="com.epam.travelAgency.entity.UserEntity"/>
<jsp:useBean id="current_wallet" scope="session" type="com.epam.travelAgency.entity.WalletEntity"/>
<jsp:useBean id="users" scope="session" type="java.util.List"/>
<jsp:useBean id="tours" scope="session" type="java.util.List"/>
<jsp:useBean id="statuses" scope="session" type="java.util.EnumSet"/>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="user.logout" var="logout"/>
<fmt:message bundle="${loc}" key="admin.panel" var="panel"/>
<fmt:message bundle="${loc}" key="admin.panel.customers" var="customers"/>
<fmt:message bundle="${loc}" key="admin.panel.auth" var="auth"/>
<fmt:message bundle="${loc}" key="admin.panel.balanceSale" var="balanceSale"/>
<fmt:message bundle="${loc}" key="admin.panel.tours" var="toursP"/>
<fmt:message bundle="${loc}" key="admin.panel.updateBtn" var="updateBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.updateBalanceBtn" var="updateBalanceBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.detailsBtn" var="detailsBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.status" var="statusL"/>
<fmt:message bundle="${loc}" key="admin.modal.summ" var="summ"/>
<fmt:message bundle="${loc}" key="admin.panel.saveBtn" var="saveBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.saleH" var="saleH"/>
<fmt:message bundle="${loc}" key="admin.panel.balanceH" var="balanceH"/>
<fmt:message bundle="${loc}" key="user.login.email-input" var="emailI"/>
<fmt:message bundle="${loc}" key="user.login.password-input" var="passwordI"/>



<html>
<head>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/jsp/admin/adminPage.css" %>
    </style>

    <title>Title</title>

</head>
<body class="bg-light text-center">
<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${requestScope.errorMsg}
    </div>
</c:if>
<div class="alert alert-info" role="alert">

    <h4 class="alert-heading"> <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
    </svg><c:out value="${panel}"/></h4>
    <a href="controller?command=logout">
        <c:out value="${logout}"/>
    </a>


</div>

<div class="container">
    <main>
        <div class="py-5 text-center">
            <nav>
                <div class="nav nav-tabs" id="nav-tab1" role="tablist">
                    <a class="nav-link active" id="nav-users-tab" data-toggle="tab" href="#nav-users" role="tab" aria-controls="nav-users" aria-selected="true"><c:out value="${toursP}"/></a>
                    <a class="nav-link" id="nav-booking-tab" data-toggle="tab" href="#nav-booking" role="tab" aria-controls="nav-booking" aria-selected="false"><c:out value="${customers}"/></a>
                    <a class="nav-link " id="nav-home-tab1" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="false"><c:out value="${auth}"/></a>
                    <a class="nav-link" id="nav-balance-tab" data-toggle="tab" href="#nav-balance" role="tab" aria-controls="nav-balance" aria-selected="false"><c:out value="${balanceSale}"/></a>
                </div>
            </nav>

            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade pad" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <div class="col-md-7 col-lg-8">
                        <form class="needs-validation" novalidate="" action="controller?command=updateuserinfo" method="post">
                            <div class="row g-3">

                                <div class="col-12">
                                    <label for="email" class="form-label"><c:out value="${emailI}"/></label>
                                    <div class="input-group has-validation">
                                        <span class="input-group-text">@</span>
                                        <input type="email" class="form-control " id="email" name="email" placeholder="Почта"
                                               value="${current_user.email}" required="" disabled>
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="password" class="form-label"><c:out value="${passwordI}"/></label>
                                    <input type="password" class="form-control" id="password" name="password" value="${current_user.password}"
                                    minlength="8" maxlength="25">
                                    <div class="invalid-feedback">
                                        Please enter a valid password for shipping updates.
                                    </div>
                                </div>
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit" style="margin-top: 30px"><c:out value="${updateBtn}"/></button>
                        </form>
                    </div>
                </div>

                <div class="tab-pane fade pad" id="nav-balance" role="tabpanel" aria-labelledby="nav-balance-tab">
                    <div class="container-fluid mt-3">
                        <div class="container">
                            <div class="row text-center">
                                <div class="row g-2">
                                    <div class="col">
                                        <h2><c:out value="${balanceH}"/></h2>
                                        <h1>${current_wallet.balance} $</h1>

                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#myModal" style="margin-top: 30px"> <c:out value="${updateBalanceBtn}"/></button>
                                    </div>
                                    <div class="col">
                                        <h2><c:out value="${saleH}"/></h2>
                                        <h1>${current_sale.sale} %</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade pad" id="nav-booking" role="tabpanel" aria-labelledby="nav-booking-tab">
                    <div class="container-fluid mt-5" style="background-color: #E6E6FA">
                        <div class="container p-5">
                            <div class="row justify-content-center">
                                <c:forEach items="${users}" var="user">
                                    <div class="col col-lg-4 description" >
                                        <div class="card text-center mt-5 description-container detparam">
                                            <span class="badge bg-danger"> ${user.email}</span>
                                            <div class="card-footer">
                                                <a class="btn btn-outline-primary" href="controller?command=showuserinfo&id_user=${user.id}">
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
                <div class="tab-pane fade show active pad" id="nav-users" role="tabpanel" aria-labelledby="nav-users-tab">
                    <div class="container-fluid mt-5 " style="background-color: #E6E6FA">
                        <div class="container p-5">
                            <div class="row justify-content-center" style="margin: -50px;">
                                <c:forEach items="${tours}" var="tour" >

                                    <div class="col col-lg-4 description" >
                                        <div class="card text-center mt-5 description-container param">
                                            <img src="${tour.imgPath}" alt="" class="card-img-top img">
                                            <c:choose>
                                                <c:when test="${tour.status eq 'HOT'}">
                                                    <span class="badge bg-danger"> ${tour.status}</span>
                                                </c:when>
                                                <c:when test="${tour.status eq 'STANDARD'}">
                                                    <span class="badge bg-warning"> ${tour.status}</span>
                                                </c:when>
                                            </c:choose>
                                            <div class="card-body" >
                                                <p class="card-title pricing-card-title" >
                                                        ${tour.name}
                                                </p>
                                                <h4 class="card-title" style="margin-top: 10px">
                                                    <span class="badge rounded-pill bg-warning text-dark">${tour.price} $</span>
                                                </h4>
                                            </div>
                                            <div class="card-footer">
                                                <form action="controller?command=updatetourstatus&id_tour=${tour.id}" method="post">

                                                <label for="floatingSelectGrid">
                                                    <c:out value="${statusL}"/>
                                                </label>
                                                <select class="form-select" id="floatingSelectGrid"
                                                        required="" name="status"
                                                        aria-label="Скидка">
                                                    <c:forEach items="${statuses}" var="status">
                                                        <option value="${status}"> ${status} </option>
                                                    </c:forEach>
                                                </select>
                                                <button class="btn btn-outline-primary" style="margin-top: 10px"
                                                type="submit">
                                                    <c:out value="${updateBtn}"/>
                                                </button>
                                                </form>
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
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2020–2021 Happy Tour :)</p>
    </footer>
</div>


<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel"><c:out value="${updateBalanceBtn}"/></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="controller?command=updatebalance" method="post">
                <div class="modal-body">
                    <label for="bal" class="form-label"> <c:out value="${summ}"/> $ </label>
                    <input type="text" class="form-control caps" id="bal" name="newBalance"
                           pattern="[0-9]{1,3}" title="Only digits" minlength="1" maxlength="3">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button class="btn btn-primary" type="submit"><c:out value="${saveBtn}"/></button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>

</body>
</html>
