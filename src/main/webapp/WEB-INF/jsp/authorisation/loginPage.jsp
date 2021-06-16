<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="resources" var="loc"/>
<fmt:message bundle="${loc}" key="user.login.authorisation" var="authorisation"/>
<fmt:message bundle="${loc}" key="user.login.email-input" var="emailInput"/>
<fmt:message bundle="${loc}" key="user.login.password-input" var="passwordInput"/>
<fmt:message bundle="${loc}" key="user.login.login-button" var="loginButton"/>
<fmt:message bundle="${loc}" key="user.login.registered" var="registration"/>

<html lang="en">
<head>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Форма входа</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <!-- Custom styles for this template -->
  <style>
    <%@include file='/WEB-INF/jsp/authorisation/login.css' %>
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
    <button class="btn btn-outline-light translate" id="en">
        <img src="https://pngicon.ru/file/uploads/Flag-SShA.png" style="height: 30px; width: 40px">
    </button>
    <button class="btn btn-outline-light" id="ru">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"
             style="height: 30px; width: 40px">
    </button>

    <form  action="controller?command=authorisation" method="post">

    <a href="controller?command=gotomainpage"><img class="mb-4" src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
         alt="" width="200" height="200"></a>
    <h1 class="h3 mb-3 fw-normal">
        <c:out value="${authorisation}"/>
    </h1>

    <div class="form-floating">
      <input type="hidden", name="command", value="naming">
      <input type="email" name="email" class="form-control" id="floatingInput" placeholder="<c:out value="${emailInput}"/>">
      <label for="floatingInput">
          <c:out value="${emailInput}"/>
      </label>
    </div>
    <div class="form-floating">
      <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="<c:out value="${passwordInput}"/>">
      <label for="floatingPassword">
          <c:out value="${passwordInput}"/>
      </label>
    </div>

    <div class="checkbox mb-3">    <%--  ToDo регистрация--%>
      <a href="controller?command=gotoregistrationpage">
          <c:out value="${registration}"/>
      </a>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">
        <c:out value="${loginButton}"/>
    </button>

    <p class="mt-5 mb-3 text-muted">© 2020–2021</p>
  </form>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
