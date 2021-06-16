<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../authorisation/loginPage.jsp"/>
<html lang="ru"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--  <meta name="description" content="Пример на bootstrap 5: Форма входа - макет и дизайн формы.">--%>

    <title>Форма входа</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <style>
        <%@include file='/WEB-INF/jsp/authorisation/login.css' %>
        <%@include file='/WEB-INF/jsp/wrongModal/wrongModal.css' %>
    </style>


</head>
<body class="modal-open">

<script type="text/javascript">
    let myModal = document.getElementById('myModal')
    myModal.addEventListener('show.bs.modal', function () {
        myModal.modal('show');
    })

</script>

<form  action="controller?command=gotologinpage" method="post">
<div class="modal" id="myModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="myModal"
     aria-hidden="true" style="display: block">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="alert alert-danger" id="staticBackdropLabel">Ошибка авторизации</h5>
                <a type="button" href="controller?command=gotologinpage" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></a>
            </div>
            <div class="modal-body">
                <p>Пожалуйста, проверте правильность вашего email или пароля.
                    Если у вас ещё нет аккаунта - <a href="controller?command=gotoregistrstionpage">зарегистрируйтесь</a> </p>
            </div>
            <div class="modal-footer">
                <a type="button" href="controller?command=gotologinpage" class="btn btn-secondary" data-bs-dismiss="modal"
                 >Close</a>
            </div>
        </div>
    </div>
</div>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>


