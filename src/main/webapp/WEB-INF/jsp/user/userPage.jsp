<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="user.logout" var="logout"/>
<fmt:message bundle="${loc}" key="user.registration.title" var="regTitle"/>
<fmt:message bundle="${loc}" key="user.registration.email-input" var="emailInput"/>
<fmt:message bundle="${loc}" key="user.registration.password-input" var="passwordInput"/>
<fmt:message bundle="${loc}" key="user.registration.name-input" var="nameInput"/>
<fmt:message bundle="${loc}" key="user.registration.surname-input" var="surnameInput"/>
<fmt:message bundle="${loc}" key="user.registration.dateB-input" var="dateBInput"/>
<fmt:message bundle="${loc}" key="user.registration.passport-input" var="passportInput"/>
<fmt:message bundle="${loc}" key="user.registration.nationality-input" var="nationalityInput"/>
<fmt:message bundle="${loc}" key="user.registration.dateI-input" var="dateIInput"/>
<fmt:message bundle="${loc}" key="user.registration.dateE-input" var="dateEInput"/>
<fmt:message bundle="${loc}" key="user.registration.registration-button" var="regButton"/>
<fmt:message bundle="${loc}" key="user.registration.check-box" var="checkBox"/>
<fmt:message bundle="${loc}" key="user.login.change-lang" var="changeLang"/>
<fmt:message bundle="${loc}" key="admin.modal.summ" var="summ"/>
<fmt:message bundle="${loc}" key="admin.panel.saveBtn" var="saveBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.saleH" var="saleH"/>
<fmt:message bundle="${loc}" key="admin.panel.balanceH" var="balanceH"/>
<fmt:message bundle="${loc}" key="user.login.email-input" var="emailI"/>
<fmt:message bundle="${loc}" key="user.login.password-input" var="passwordI"/>
<fmt:message bundle="${loc}" key="user.panel" var="panel"/>
<fmt:message bundle="${loc}" key="admin.panel.customers" var="customers"/>
<fmt:message bundle="${loc}" key="admin.panel.auth" var="auth"/>
<fmt:message bundle="${loc}" key="admin.panel.balanceSale" var="balanceSale"/>
<fmt:message bundle="${loc}" key="admin.panel.tours" var="toursP"/>
<fmt:message bundle="${loc}" key="admin.panel.updateBtn" var="updateBtn"/>
<fmt:message bundle="${loc}" key="admin.panel.updateBalanceBtn" var="updateBalanceBtn"/>
<fmt:message bundle="${loc}" key="user.text1" var="text1"/>
<fmt:message bundle="${loc}" key="user.text2" var="text2"/>
<fmt:message bundle="${loc}" key="user.text3" var="text3"/>
<fmt:message bundle="${loc}" key="user.passport.data" var="passportDate"/>
<fmt:message bundle="${loc}" key="user.new.sale" var="newSale"/>
<fmt:message bundle="${loc}" key="user.tours.count" var="count"/>
<fmt:message bundle="${loc}" key="bill.close.btn" var="close"/>
<fmt:message bundle="${loc}" key="user.delete" var="delete"/>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="main.details-btn" var="detailsBtn"/>

<html>
<head>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/jsp/user/user.css" %>
    </style>

    <title>Title</title>

</head>
<body class="bg-light text-center pad">

<div class="alert alert-info" role="alert">
    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
    </svg>
    <h4 class="alert-heading"><c:out value="${panel}"/></h4>
    <p><c:out value="${text1}"/></p>
    <p class="mb-0"><c:out value="${text2}"/></p>
    <hr>
    <p class="mb-0" style="text-align: center"><c:out value="${text3}"/></p>
    <a href="controller?command=logout"><c:out value="${logout}"/></a>
    <a href="controller?command=deleteuseracc" style="margin-left: 10px"><c:out value="${delete}"/></a>
</div>

<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${errorMsg}
    </div>
</c:if>

<div class="container">
    <main>
        <div class="py-5">
            <nav>
                <div class="nav nav-tabs" id="nav-tab1" role="tablist">
                    <a class="nav-link active" id="nav-home-tab1" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true"><c:out value="${auth}"/></a>
                    <a class="nav-link" id="nav-profile-tab1" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false"><c:out value="${passportDate}"/></a>
                    <a class="nav-link" id="nav-balance-tab" data-toggle="tab" href="#nav-balance" role="tab" aria-controls="nav-balance" aria-selected="false"><c:out value="${balanceSale}"/></a>
                    <a class="nav-link" id="nav-booking-tab" data-toggle="tab" href="#nav-booking" role="tab" aria-controls="nav-booking" aria-selected="false"><c:out value="${toursP}"/></a>
                </div>
            </nav>

        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active pad" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="col-md-7 col-lg-8 profile">
                    <form class="needs-validation" novalidate="" action="controller?command=updateuserinfo" method="post">
                        <div class="row g-3">

                            <div class="col-12">
                                <label for="email" class="form-label"><c:out value="${emailInput}"/></label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">@</span>
                                    <input type="email" class="form-control " id="email" name="email" placeholder="Почта"
                                           value="${current_user.email}" required="" disabled>
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label"><c:out value="${passwordInput}"/></label>
                                <input type="password" class="form-control" id="password" name="password"
                                       value="${current_user.password}" minlength="8" maxlength="25">
                                <div class="invalid-feedback">
                                    Please enter a valid password for shipping updates.
                                </div>
                            </div>
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" type="submit"
                                style="margin-top: 30px; width: 200px !important"><c:out value="${updateBtn}"/></button>
                    </form>
                </div>
            </div>

            <div class="tab-pane fade pad" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">

                <div class="col-md-7 col-lg-8 passp">
                    <h4 class="mb-3"><c:out value="${passportDate}"/></h4>
                    <c:choose>
                        <c:when test="${current_userDet.id == 0}">
                            <form class="needs-validation" method="post" action="controller?command=saveuserdetails" novalidate>
                                <div class="row g-3">
                                    <div class="col-sm-6">
                                        <label for="newName" class="form-label"><c:out value="${nameInput}"/></label>
                                        <input type="text" class="form-control caps" id="newName" name="name" placeholder=""
                                               value="${current_userDet.name}"
                                               pattern="[A-Za-z]{3,25}"
                                               required>
                                        <div class="invalid-feedback">
                                            Only english letters!
                                        </div>
                                        <div class="valid-feedback">
                                            Ok!
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <label for="newSurname" class="form-label"><c:out value="${surnameInput}"/></label>
                                        <input type="text" class="form-control caps" id="newSurname" name="surname" placeholder=""
                                               value="${current_userDet.surname}"
                                               pattern="[A-Za-z]{3,50}"
                                               required>
                                        <div class="invalid-feedback">
                                            Valid last name is required.
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="datepicker121" class="form-label"><c:out value="${dateBInput}"/></label>
                                        <input type="date" class="form-control" name="date_of_birth" data-format="mm-dd-yyyy"
                                               aria-label="Дата прилёта"
                                               id="datepicker121"
                                               value="${current_userDet.dateOfBirth}"
                                               pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                               required>
                                        <div class="invalid-feedback">
                                            Please enter your shipping address.
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="newcitizenship" class="form-label"><c:out value="${nationalityInput}"/></label>
                                        <input type="text" class="form-control caps" id="newcitizenship" name="citizenship"
                                               value="${current_userDet.citizenship}"
                                               pattern="[A-Za-z ]{5,50}"
                                               placeholder="Republic of Belarus" required>
                                        <div class="invalid-feedback">
                                            Please enter your shipping address.
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="address2w" class="form-label"> <c:out value="${passportInput}"/> </label>
                                        <input type="text" class="form-control caps" id="address2w" name="passport"
                                               value="${current_userDet.passport}" pattern="^([a-zA-Z]{2}[0-9]{7})?$" placeholder="MP1234567"
                                               required>
                                    </div>

                                    <div class="col-12">
                                        <label for="datepicker2" class="form-label"><c:out value="${dateIInput}"/></label>
                                        <input type="date" class="form-control" name="date_of_issue" data-format="mm-dd-yyyy"
                                               aria-label="Дата прилёта"
                                               id="datepicker332"
                                               value="${current_userDet.dateOfIssue}"
                                               pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                               required>
                                        <div class="invalid-feedback">
                                            Please enter your shipping address.
                                        </div>
                                    </div>




                                    <div class="col-12">
                                        <label for="datepicker3r" class="form-label"><c:out value="${dateEInput}"/></label>
                                        <input type="date" class="form-control" name="expiration_date" data-format="mm-dd-yyyy"
                                               aria-label="Дата прилёта"
                                               id="datepicker3r" pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                               value="${current_userDet.expirationDate}" required>
                                        <div class="invalid-feedback">
                                            Please enter your shipping address.
                                        </div>
                                    </div>
                                </div>

                                <button class="w-100 btn btn-primary btn-lg" style="margin-top: 30px; width: 200px !important;"
                                        type="submit"><c:out value="${saveBtn}"/></button>
                            </form>
                        </c:when>

                    <c:when test="${current_userDet.id != 0}">
                    <form class="needs-validation" novalidate="" method="post" action="controller?command=updateuserdetinfo">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="name" class="form-label"><c:out value="${nameInput}"/></label>
                                <input type="text" class="form-control caps" id="name" name="name" placeholder=""
                                       value="${current_userDet.name}"
                                       pattern="[A-Za-z]{3, 25}" required>
                                <div class="invalid-feedback">
                                    Valid first name is required.
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="surname" class="form-label"><c:out value="${surnameInput}"/></label>
                                <input type="text" class="form-control caps" id="surname" name="surname" placeholder=""
                                       value="${current_userDet.surname}"
                                       required
                                       pattern="[A-Za-z]{3, 50}">
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="datepicker1" class="form-label"><c:out value="${dateBInput}"/></label>
                                <input type="date" class="form-control" name="date_of_birth" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker1" required
                                       value="${current_userDet.dateOfBirth}"
                                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="citizenship" class="form-label"><c:out value="${nationalityInput}"/></label>
                                <input type="text" class="form-control caps" id="citizenship" name="citizenship"
                                       value="${current_userDet.citizenship}"
                                       pattern="[A-Za-z ]{5, 50}"
                                       placeholder="Republic of Belarus"
                                       required>
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="address2" class="form-label"> <c:out value="${passportInput}"/> </label>
                                <input type="text" class="form-control caps" id="address2" name="passport"
                                       value="${current_userDet.passport}" pattern="[a-zA-Z]+[0-9]{2,7}" placeholder="MP1234567"
                                required>
                            </div>

                            <div class="col-12">
                                <label for="datepicker2" class="form-label"><c:out value="${dateIInput}"/></label>
                                <input type="date" class="form-control" name="date_of_issue" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker2" required
                                       value="${current_userDet.dateOfIssue}"
                                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="datepicker3" class="form-label"><c:out value="${dateEInput}"/></label>
                                <input type="date" class="form-control" name="expiration_date" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker3" required pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                value="${current_userDet.expirationDate}">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" style="margin-top: 30px; width: 200px !important;"
                                type="submit"><c:out value="${updateBtn}"/></button>
                    </form>
                    </c:when>
                    </c:choose>
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
                            <c:forEach items="${userTours}" var="userTour" >

                                <div class="col col-lg-4 description" >
                                    <div class="card text-center mt-5 description-container param">
                                        <img src="${userTour.imgPath}" alt="" class="card-img-top img">
                                        <c:if test="${userTour.status eq 'HOT'}">
                                            <span class="badge bg-danger"> ${userTour.status}</span>
                                        </c:if>
                                        <div class="card-body" >
                                            <h2 class="card-title pricing-card-title" >
                                                    ${userTour.name}
                                            </h2>
                                            <h4 class="card-title" style="margin-top: 10px">
                                                <span class="badge rounded-pill bg-warning text-dark">${userTour.price} $</span>
                                            </h4>
                                        </div>
                                        <div class="card-footer">
                                            <a class="btn btn-outline-primary" id="${userTour.id}"
                                               href="controller?command=gotodetailspage&id=${userTour.id}">
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
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2020–2021 Happy Tour :) <img src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
                                                       width="40" height="40" alt="logo">
        </p>
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
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><c:out value="${close}"/></button>
                    <button class="btn btn-primary" type="submit"><c:out value="${saveBtn}"/></button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src=" ${pageContext.request.contextPath}/user.js"  type="text/javascript"></script>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
