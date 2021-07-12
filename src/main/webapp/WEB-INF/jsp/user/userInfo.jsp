<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<jsp:include page="../header/header.jsp"/>

<jsp:useBean id="userDet" scope="session" type="com.epam.travelAgency.entity.UserDetailsEntity"/>
<jsp:useBean id="userSale" scope="session" type="com.epam.travelAgency.entity.SaleEntity"/>


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
<body class="bg-light text-center">
<c:if test="${requestScope.errorMsg != null}">

    <div class="alert alert-danger" role="alert">
            ${errorMsg}
    </div>
</c:if>
<div class="alert alert-info" role="alert">
    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
    </svg>

</div>
    <div class="col-md-7 col-lg-8 passp">
        <h4 class="mb-3"><c:out value="${passportDate}"/></h4>
            <div class="row g-3">
                <div class="col-sm-6">
                    <label for="name" class="form-label"><c:out value="${nameInput}"/></label>
                    <input type="text" class="form-control caps" id="name" name="name" placeholder=""
                           value="${userDet.name}" required="" disabled>
                    <div class="invalid-feedback">
                        Valid first name is required.
                    </div>
                </div>

                <div class="col-sm-6">
                    <label for="surname" class="form-label"><c:out value="${surnameInput}"/></label>
                    <input type="text" class="form-control caps" id="surname" name="surname" placeholder=""
                           value="${userDet.surname}" required="" disabled>
                    <div class="invalid-feedback">
                        Valid last name is required.
                    </div>
                </div>

                <div class="col-12">
                    <label for="datepicker1" class="form-label"><c:out value="${dateBInput}"/></label>
                    <input type="date" class="form-control" name="date_of_birth" data-format="mm-dd-yyyy"
                           aria-label="Дата прилёта"
                           id="datepicker1" required=""
                           value="${userDet.dateOfBirth}"
                           pattern="[0-9].[0-9].[0-9]{2,2,4}" disabled>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <div class="col-12">
                    <label for="citizenship" class="form-label"><c:out value="${nationalityInput}"/></label>
                    <input type="text" class="form-control caps" id="citizenship" name="citizenship"
                           value="${userDet.citizenship}"
                           placeholder="Republic of Belarus" required="" disabled>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <div class="col-12">
                    <label for="address2" class="form-label"> <c:out value="${passportInput}"/> </label>
                    <input type="text" class="form-control caps" id="address2" name="passport"
                           value="${userDet.passport}" placeholder="MP1234567" disabled>
                </div>

                <div class="col-12">
                    <label for="datepicker2" class="form-label"><c:out value="${dateIInput}"/></label>
                    <input type="date" class="form-control" name="date_of_issue" data-format="mm-dd-yyyy"
                           aria-label="Дата прилёта"
                           id="datepicker2" required=""
                           value="${userDet.dateOfIssue}"
                           pattern="[0-9].[0-9].[0-9]{2,2,4}" disabled>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <div class="col-12">
                    <label for="datepicker3" class="form-label"><c:out value="${dateEInput}"/></label>
                    <input type="date" class="form-control" name="expiration_date" data-format="mm-dd-yyyy"
                           aria-label="Дата прилёта"
                           id="datepicker3" required="" pattern="[0-9].[0-9].[0-9]{2,2,4}"
                           value="${userDet.expirationDate}" disabled>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>

                <div class="col-12">
                    <label for="dd" class="form-label"><c:out value="${count}"/></label>
                    <input type="text" class="form-control" name="count"
                           aria-label="Дата прилёта"
                           id="dd" required=""
                           value="${userSale.toursCount}" disabled>
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>
                <form action="controller?command=updateusersale" method="post">
                    <div class="col-12">
                        <select class="form-select" id="floatingSelectGrid"
                                required="" name="sale"
                                aria-label="Скидка">
                            <option value="${userSale.sale}"> ${userSale.sale}% </option>
                            <option value="0"> 0% </option>
                            <option value="3"> 3% </option>
                            <option value="5"> 5% </option>
                            <option value="7"> 7% </option>
                            <option value="10"> 10% </option>
                            <option value="15"> 15% </option>
                            <option value="20"> 20% </option>
                        </select>
                        <label for="floatingSelectGrid">
                            <c:out value="${newSale}"/>
                        </label>
                    </div>

                    <button class="w-100 btn btn-primary btn-lg" style="margin-top: 30px; width: 200px !important;"
                            type="submit"><c:out value="${updateBtn}"/></button>
                </form>

            </div>
    </div>

</body>
</html>
