<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>

<%--<jsp:useBean id="current_userDet" scope="session" type="com.epam.travelAgency.entity.UserDetailsEntity"/>--%>
<%--<jsp:useBean id="current_user" scope="session" type="com.epam.travelAgency.entity.UserEntity"/>--%>
<%--<jsp:useBean id="current_wallet" scope="session" type="com.epam.travelAgency.entity.WalletEntity"/>--%>
<%--<jsp:useBean id="users" scope="session" type="java.util.List"/>--%>
<%--<jsp:useBean id="tours" scope="session" type="java.util.List"/>--%>



<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/jsp/user/user.css" %>
    </style>

    <title>Title</title>

</head>
<body class="bg-light text-center">
<div class="alert alert-info" role="alert">

    <h4 class="alert-heading"> <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
    </svg> Панель администратора</h4>

</div>

<div class="container">
    <main>
        <div class="py-5 text-center">
            <nav>
                <div class="nav nav-tabs" id="nav-tab1" role="tablist">
                    <a class="nav-link active" id="nav-home-tab1" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Авторизационные данные</a>
                    <a class="nav-link" id="nav-profile-tab1" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Паспортные данные</a>
                    <a class="nav-link" id="nav-balance-tab" data-toggle="tab" href="#nav-balance" role="tab" aria-controls="nav-balance" aria-selected="false">Баланс & Скидки</a>
                    <a class="nav-link" id="nav-booking-tab" data-toggle="tab" href="#nav-booking" role="tab" aria-controls="nav-booking" aria-selected="false">Мои путёвки</a>
                </div>
            </nav>

            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active pad" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <div class="col-md-7 col-lg-8">
                        <h4 class="mb-3">Общие данные</h4>
                        <form class="needs-validation" novalidate="" action="controller?command=updateuserinfo" method="post">
                            <div class="row g-3">

                                <div class="col-12">
                                    <label for="email" class="form-label">Почта</label>
                                    <div class="input-group has-validation">
                                        <span class="input-group-text">@</span>
                                        <input type="email" class="form-control " id="email" name="email" placeholder="Почта"
                                               value="${current_user.email}" required="">
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" value="${current_user.password}">
                                    <div class="invalid-feedback">
                                        Please enter a valid password for shipping updates.
                                    </div>
                                </div>
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit" style="margin-top: 30px">Изменить данные</button>
                        </form>
                    </div>
                </div>

                <div class="tab-pane fade pad" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                    <div class="col-md-7 col-lg-8">
                        <h4 class="mb-3">Паспортные данные</h4>
                        <form class="needs-validation" novalidate="">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="firstName" class="form-label">First name</label>
                                    <input type="text" class="form-control caps" id="firstName" placeholder=""
                                           value="${current_userDet.name}" required="">
                                    <div class="invalid-feedback">
                                        Valid first name is required.
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <label for="lastName" class="form-label">Last name</label>
                                    <input type="text" class="form-control caps" id="lastName" placeholder=""
                                           value="${current_userDet.surname}" required="">
                                    <div class="invalid-feedback">
                                        Valid last name is required.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="datepicker1" class="form-label">Дата рождения</label>
                                    <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                           aria-label="Дата прилёта"
                                           id="datepicker1" required=""
                                           value="${current_userDet.dateOfBirth}"
                                           pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                    <div class="invalid-feedback">
                                        Please enter your shipping address.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="address" class="form-label">Гражданство</label>
                                    <input type="text" class="form-control caps" id="address"
                                           value="${current_userDet.citizenship}"
                                           placeholder="Republic of Belarus" required="">
                                    <div class="invalid-feedback">
                                        Please enter your shipping address.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="address2" class="form-label"> Паспорт </label>
                                    <input type="text" class="form-control caps" id="address2"
                                           value="${current_userDet.passport}" placeholder="MP1234567">
                                </div>

                                <div class="col-12">
                                    <label for="datepicker2" class="form-label">Дата выдачи</label>
                                    <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                           aria-label="Дата прилёта"
                                           id="datepicker2" required=""
                                           value="${current_userDet.dateOfIssue}"
                                           pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                    <div class="invalid-feedback">
                                        Please enter your shipping address.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="datepicker3" class="form-label">Дата окончания</label>
                                    <input type="date" class="form-control" name="arrivalDate" data-format="mm-dd-yyyy"
                                           aria-label="Дата прилёта"
                                           id="datepicker3" required="" pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                           value="${current_userDet.expirationDate}">
                                    <div class="invalid-feedback">
                                        Please enter your shipping address.
                                    </div>
                                </div>

                                <hr class="my-4">
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                        </form>
                    </div>
                </div>
                <div class="tab-pane fade pad" id="nav-balance" role="tabpanel" aria-labelledby="nav-balance-tab">
                    <div class="col-12">
                        <label for="address2" class="form-label">Your balance</label>
                        <h1>${current_wallet.balance}</h1>
                    </div>

                </div>
                <div class="tab-pane fade pad" id="nav-booking" role="tabpanel" aria-labelledby="nav-booking-tab">...</div>

            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2020–2021 Happy Tour :)</p>
    </footer>
</div>

<a href="controller?command=logout">logout</a>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>
