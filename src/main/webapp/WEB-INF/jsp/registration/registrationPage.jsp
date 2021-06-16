<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/jsp/registration/registration.css" %>
    </style>

    <title>Registration</title>

</head>
<body>


<h1>Регистрация</h1>
    <form class="row g-3 form-registration">
        <div class="needs-validation" novalidate>
            <div class="my">
                <div class="col-md-13">
                    <label for="email" class="form-label">Email</label>
                    <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="email" class="form-control" name="email" id="email" aria-describedby="inputGroupPrepend"
                               required style="text-transform: none;"
                               placeholder="example@gmail.com"
                               pattern="[a-zA-Z_.0-9]+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}"
                               minlength="5" maxlength="30">
                    </div>
                </div>

                <div class="col-md-13">
                    <label for="validationCustom02" class="form-label">Пароль</label>
                    <input type="password" class="form-control" id="validationCustom0" required=""
                    style="text-transform: none;" minlength="6">
                    <div class="valid-feedback">
                        Все хорошо!
                    </div>
                </div>
            </div>
        </div>

        <div class="vl"></div>

        <div class="my">
            <div class="col-md-13">
                <label for="validationCustom01" class="form-label">Имя</label>
                <input type="text" class="form-control" id="validationCustom01" placeholder="IVAN" required
                       pattern="[a-zA-Z]{2,}" minlength="2" maxlength="30">
            </div>

            <div class="col-md-13">
                <label for="validationCustom02" class="form-label">Фамилия</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="PETROV" required
                       pattern="[a-zA-Z]{2,}" minlength="2" maxlength="30">
            </div>

            <div class="col-md-13">
                <label for="datepicker" class="form-label">Дата рождения</label>
                    <div class="input-group date">
                        <input type="date" class="form-control" data-format="mm-dd-yyyy" id="datepicker" required>
                    </div>
            </div>
        </div>

        <div class="vl"></div>

        <div class="my">
            <div class="col-md-13">
                <label for="validationCustom7" class="form-label">№ Паспорта</label>
                <input type="text" class="form-control" id="validationCustom7" placeholder="MP5678789" required
                       pattern="[a-zA-Z]+[0-9]{2,7}">
            </div>

            <div class="col-md-13">
                <label for="validationCustom8" class="form-label">Национальность</label>
                <input type="text" class="form-control" id="validationCustom8" placeholder="REPUBLIC OF BELARUS" required>
            </div>

            <div class="col-md-13">
                <label for="datepicker2" class="form-label">Дата выдачи паспорта</label>
                <div class="input-group date">
                    <input type="date" class="form-control" data-format="mm-dd-yyyy" placeholder="" id="datepicker2" required>
                </div>
            </div>

            <div class="col-md-13">
                <label for="datepicker3" class="form-label">Паспорт годен до</label>
                <div class="input-group date">
                    <input type="date" class="form-control" data-format="mm-dd-yyyy"  placeholder="" id="datepicker3" required>
                </div>
            </div>
        </div>

            <div class="col-12 ">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck" >
                        Примите условия и соглашения
                    </label>
                    <div class="invalid-feedback">
                        Вы должны принять перед отправкой.
                    </div>
                </div>
            </div>
            <div class="col-13">
                <form method="post" onsubmit="register()">
                    <button class="btn btn-primary" type="submit" >
                       Отправить форму
                        </button>
                </form>
            </div>
    </form>

<script src=" ${pageContext.request.contextPath}/registration.js"  type="text/javascript"></script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<%--<script src="jquery.datetimepicker.full.min.js"></script>--%>
</body>
</html>
