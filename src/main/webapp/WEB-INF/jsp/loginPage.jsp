<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru"><head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<%--  <meta name="description" content="Пример на bootstrap 5: Форма входа - макет и дизайн формы.">--%>

  <title>Форма входа</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <!-- Custom styles for this template -->
  <style>
    <%@include file='/WEB-INF/css/login.css' %>
  </style>

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>

</head>
<body class="text-center">

<main class="form-signin">
    <form  action="controller?command=authorisation" method="post">

    <a href="controller?command=gotomainpage"><img class="mb-4" src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
         alt="" width="200" height="200"></a>
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="hidden", name="command", value="naming">
      <input type="email" name="email" class="form-control" id="floatingInput" placeholder="Email">
      <label for="floatingInput">Email</label>
    </div>
    <div class="form-floating">
      <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Пароль">
      <label for="floatingPassword">Пароль</label>
    </div>

    <div class="checkbox mb-3">    <%--  ToDo регистрация--%>
      <a href="controller?command=gotoregistrationpage">Регистрация</a>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>

    <p class="mt-5 mb-3 text-muted">© 2020–2021</p>
  </form>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>