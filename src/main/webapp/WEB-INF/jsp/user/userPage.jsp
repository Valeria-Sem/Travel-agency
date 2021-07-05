<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header/header.jsp"/>

<jsp:useBean id="current_userDet" scope="session" type="com.epam.travelAgency.entity.UserDetailsEntity"/>
<jsp:useBean id="current_user" scope="session" type="com.epam.travelAgency.entity.UserEntity"/>
<jsp:useBean id="current_wallet" scope="session" type="com.epam.travelAgency.entity.WalletEntity"/>
<jsp:useBean id="current_sale" scope="session" type="com.epam.travelAgency.entity.SaleEntity"/>


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
<div class="alert alert-info" role="alert">
    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
        <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
    </svg>
    <h4 class="alert-heading">Добро пожаловать!</h4>
    <p>Вы на профильной странице. Если ваши паспортные данные ещё не внесены - заполните их пожалуйста. В дальнейшем это облегчит вам покупку туров.</p>
    <p class="mb-0">При регистрации вам был создан виртуальный кошелёк который вы можете пополнять и, в дальнейшем, за эти деньги покупать туры</p>
    <hr>
    <p class="mb-0" style="text-align: center">Приятного отыха :)</p>

</div>

<div class="container">
    <main>
        <div class="py-5">
            <nav>
                <div class="nav nav-tabs" id="nav-tab1" role="tablist">
                    <a class="nav-link active" id="nav-home-tab1" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Авторизационные данные</a>
                    <a class="nav-link" id="nav-profile-tab1" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Паспортные данные</a>
                    <a class="nav-link" id="nav-balance-tab" data-toggle="tab" href="#nav-balance" role="tab" aria-controls="nav-balance" aria-selected="false">Баланс & Скидки</a>
                    <a class="nav-link" id="nav-booking-tab" data-toggle="tab" href="#nav-booking" role="tab" aria-controls="nav-booking" aria-selected="false">Мои путёвки</a>
                </div>
            </nav>
<%--            <div class="tab-content" id="nav-tabContent1">--%>
<%--                <div class="tab-pane fade show active" id="nav-home1" role="tabpanel" aria-labelledby="nav-home-tab">...</div>--%>
<%--                <div class="tab-pane fade" id="nav-profile1" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>--%>
<%--                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">...</div>--%>
<%--            </div>--%>


<%--            <nav class="secNav">--%>
<%--                <div class="nav nav-tabs justify-content-md-center" id="nav-tab" role="tablist">--%>
<%--                    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home"--%>
<%--                            type="button" role="tab" aria-controls="nav-home" aria-selected="true"><c:out value="${chill}"/>Авторизационные данные</button>--%>
<%--                    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile"--%>
<%--                            type="button" role="tab" aria-controls="nav-profile" aria-selected="false"><c:out value="${excursions}"/>Основная информация</button>--%>
<%--                    <button class="nav-link" id="nav-balance-tab" data-bs-toggle="tab" data-bs-target="#nav-balance"--%>
<%--                            type="button" role="tab" aria-controls="nav-balance" aria-selected="false"><c:out value="${shopping}"/>Баланс и Скидки</button>--%>
<%--                    <button class="nav-link" id="nav-booking-tab" data-bs-toggle="tab" data-bs-target="#nav-booking"--%>
<%--                            type="button" role="tab" aria-controls="nav-booking" aria-selected="false"><c:out value="${shopping}"/>Мои путёвки</button>--%>
<%--                </div>--%>
<%--            </nav>--%>


        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active pad" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="col-md-7 col-lg-8 profile">
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

                        <button class="w-100 btn btn-primary btn-lg" type="submit"
                                style="margin-top: 30px; width: 200px !important">Изменить данные</button>
                    </form>
                </div>
            </div>

            <div class="tab-pane fade pad" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                <div class="col-md-7 col-lg-8 passp">
                    <h4 class="mb-3">Паспортные данные</h4>
                    <form class="needs-validation" novalidate="" method="post" action="controller?command=saveuserdetails">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="name" class="form-label">First name</label>
                                <input type="text" class="form-control caps" id="name" name="name" placeholder=""
                                       value="${current_userDet.name}" required="">
                                <div class="invalid-feedback">
                                    Valid first name is required.
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="surname" class="form-label">Last name</label>
                                <input type="text" class="form-control caps" id="surname" name="surname" placeholder=""
                                       value="${current_userDet.surname}" required="">
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="datepicker1" class="form-label">Дата рождения</label>
                                <input type="date" class="form-control" name="date_of_birth" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker1" required=""
                                       value="${current_userDet.dateOfBirth}"
                                       pattern="[0-9].[0-9].[0-9]{2,2,4}">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="citizenship" class="form-label">Гражданство</label>
                                <input type="text" class="form-control caps" id="citizenship" name="citizenship"
                                       value="${current_userDet.citizenship}"
                                       placeholder="Republic of Belarus" required="">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="address2" class="form-label"> Паспорт </label>
                                <input type="text" class="form-control caps" id="address2" name="passport"
                                       value="${current_userDet.passport}" placeholder="MP1234567">
                            </div>

                            <div class="col-12">
                                <label for="datepicker2" class="form-label">Дата выдачи</label>
                                <input type="date" class="form-control" name="date_of_issue" data-format="mm-dd-yyyy"
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
                                <input type="date" class="form-control" name="expiration_date" data-format="mm-dd-yyyy"
                                       aria-label="Дата прилёта"
                                       id="datepicker3" required="" pattern="[0-9].[0-9].[0-9]{2,2,4}"
                                value="${current_userDet.expirationDate}">
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>
                        </div>

                        <button class="w-100 btn btn-primary btn-lg" style="margin-top: 30px; width: 200px !important;"
                                type="submit">Update data</button>
                    </form>
                </div>
            </div>
            <div class="tab-pane fade pad" id="nav-balance" role="tabpanel" aria-labelledby="nav-balance-tab">
                <div class="container-fluid mt-3">
                    <div class="container">
                        <div class="row text-center">
                            <div class="row g-2">
                                <div class="col">
                                    <h2>Your balance</h2>
                                    <h1>${current_wallet.balance} $</h1>

                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#myModal" style="margin-top: 30px"> Пополнить баланс </button>
                                </div>
                                <div class="col">
                                    <h2>Your sale</h2>
                                    <h1>${current_sale.sale} %</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade pad" id="nav-booking" role="tabpanel" aria-labelledby="nav-booking-tab">...</div>

        </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">© 2020–2021 Happy Tour :) <img src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
                                                       width="40" height="40" alt="logo">
        </p>
    </footer>
</div>

<a href="controller?command=logout">logout</a>



<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Пополнение баланса</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="controller?command=updatebalance" method="post">
                <div class="modal-body">
                    <label for="bal" class="form-label"> Введите сумму $ </label>
                    <input type="text" class="form-control caps" id="bal" name="newBalance"
                           pattern="[0-9]{1,3}" title="Only digits" minlength="1" maxlength="3">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button class="btn btn-primary" type="submit">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>


<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
