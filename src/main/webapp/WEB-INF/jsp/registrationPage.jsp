<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="jquery.datetimepicker.min.css">


    <style>
        <%@include file="/WEB-INF/css/registration.css" %>
    </style>
<%--    <%@ include file="/WEB-INF/jsp/js/registration.js" %>--%>


    <title>Registration</title>

</head>
<body>


<h1>Регистрация</h1>
    <form class="row g-3 form-registration">
    <div class="needs-validation" novalidate>
        <div class="my">
            <div class="col-md-13">
                <label for="validationCustomUsername" class="form-label">Email</label>
                <div class="input-group has-validation">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                    <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend"
                           required="" style="text-transform: none;">
                    <div class="invalid-feedback">
                        Пожалуйста, введите свой email.
                    </div>
                </div>
            </div>

            <div class="col-md-13">
                <label for="validationCustom02" class="form-label">Пароль</label>
                <input type="password" class="form-control" id="validationCustom0" value="" required=""
                style="text-transform: none;">
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
            <input type="text" class="form-control" id="validationCustom01" value="Иван" required>
            <div class="valid-feedback">
                Все хорошо!
            </div>
        </div>
        <div class="col-md-13">
            <label for="validationCustom02" class="form-label">Фамилия</label>
            <input type="text" class="form-control" id="validationCustom02" value="Петров" required>
            <div class="valid-feedback">
                Все хорошо!
            </div>
        </div>

        <div class="col-md-13">
            <div class="form-group">
                <div class="input-group">
                    <label for="datepicker" class="form-label">Дата рождения</label>

                    <div class="input-group date" data-provide="datepicker">
                        <button type="button" id="toggle" class="input-group-text">
                            <i class="bi bi-calendar-date">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-date" viewBox="0 0 16 16">
                                    <path d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z"/>
                                    <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                                </svg>
                            </i>
                        </button>
                        <script type="text/javascript">
                            // $('#datepicker').datepicker({
                            //     timepicker: false,
                            //     datepicker: true,
                            //     format: 'mm.dd.yyyy',
                            //     value: '06.15.2021',
                            //     weeks : true
                            // });
                            $('#toggle').on('click', function (){
                                $('#datepicker').datepicker('toggle')
                            })

                            $('#datepicker').datepicker('show');
                            // $('#datepicker').datepicker("setDate", new Date());
                        </script>
                        <input class="form-control" id="datepicker" data-date-format="mm.dd.yyyy" data-provide="datepicker"
                           >
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="invalid-feedback">
                Укажите действующий город.
            </div>
        </div>
    </div>
        <div class="vl" style="
        border-left: 3px solid grey;
        height: 250px;
    "></div>
    <div class="my">
        <div class="col-md-13">
            <label for="validationCustom04" class="form-label">Область</label>
            <select class="form-control" id="validationCustom04" required>
                <option selected disabled value="">Выберите...</option>
                <option>...</option>
            </select>
            <div class="invalid-feedback">
                Пожалуйста, выберите корректный город.
            </div>
        </div>
        <div class="col-md-13">
            <label for="validationCustom05" class="form-label">Индекс</label>
            <input type="text" class="form-control" id="validationCustom05" required>
            <div class="invalid-feedback">
                Пожалуйста, предоставьте действующий почтовый индекс.
            </div>
        </div>
    </div>

        <div class="col-12">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                <label class="form-check-label" for="invalidCheck">
                    Примите условия и соглашения
                </label>
                <div class="invalid-feedback">
                    Вы должны принять перед отправкой.
                </div>
            </div>
        </div>
        <div class="col-13">
            <button class="btn btn-primary" type="submit">Отправить форму</button>
        </div>
    </form>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<script src="jquery.datetimepicker.full.min.js"></script>



</body>
</html>
