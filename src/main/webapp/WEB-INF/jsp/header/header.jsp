<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="nav.category" var="categ"/>
<fmt:message bundle="${loc}" key="nav.hot" var="hot"/>
<fmt:message bundle="${loc}" key="nav.tours" var="tours"/>
<fmt:message bundle="${loc}" key="nav.about" var="about"/>
<fmt:message bundle="${loc}" key="nav.help" var="help"/>
<fmt:message bundle="${loc}" key="nav.my-account" var="acc"/>


<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

    <style>
        <%@include file="/WEB-INF/jsp/header/header.css" %>
    </style>
    <title>Турагенство</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%--<script src="js/bootstrap.min.js"></script>--%>

<form action="controller?command=showcategories" method="get">
<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
    <div class="container-fluid">
        <a href="#" class="navbar-brand">
            <img src="https://www.nicepng.com/png/full/208-2082453_aphamok-travel-tours-and-travels-icon.png"
                 width="50" height="50" alt="logo">
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item dropdown">

                   <a class="nav-link dropdown-toggle"
                       role="button" id="navbarDropdown"
                       data-bs-toggle="dropdown" aria-expanded="false"
                       href="controller?command=showcategories">
                       <c:out value="${categ}"/>
                   </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach items="${categories}" var="category" >
                            <li><a class="dropdown-item" href="#">
                                ${category.name}</a></li>

                        </c:forEach>
                    </ul>

                </li>
<%--                <div class="vl"></div>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#"><c:out value="${hot}"/></a>
                </li>
<%--                <div class="vl"></div>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#"><c:out value="${tours}"/></a>
                </li>
<%--                <div class="vl"></div>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#"><c:out value="${about}"/></a>
                </li>
<%--                <div class="vl"></div>--%>
                <li class="nav-item">
                    <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">
                        <c:out value="${help}"/>
                    </a>
                </li>
            </ul>

            <div class="lang-buttons">
                <a class="btn btn-outline-warning translate" id="en" href="controller?command=gotomainpage&locale=en">
                    <img src="https://pngicon.ru/file/uploads/Flag-SShA.png" style="height: 20px; width: 30px">
                </a>
                <a class="btn btn-outline-warning" id="ru" href="controller?command=gotomainpage&locale=ru">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"
                         style="height: 20px; width: 30px">
                </a>
            </div>
                <div class="option-icon field-i">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                    <svg xmlns="http://www.w3.org/2000/svg" width="92px" height="92px" viewBox="0 0 92 92"
                         enable-background="new 0 0 92 92" class="app-icon">
                        <path d="M46,57.1c14.8,0,26.9-12.1,26.9-27C72.9,15.1,60.8,3,46,3S19.1,15.1,19.1,30C19.1,45,31.2,57.1,46,57.1zM46,11c10.4,0,18.9,8.5,18.9,19c0,10.5-8.5,19-18.9,19s-18.9-8.5-18.9-19C27.1,19.5,35.6,11,46,11z M58.5,59.7c-1.3-0.4-2.8-0.1-3.8,0.8L46,67.9l-8.7-7.4c-1.1-0.9-2.5-1.2-3.8-0.8C27.9,61.5,0,71.1,0,85c0,2.2,1.8,4,4,4h84c2.2,0,4-1.8,4-4C92,71.1,64.1,61.5,58.5,59.7z M10.1,81c4.4-4.7,15-9.9,23.8-12.9l9.5,8.1c1.5,1.3,3.7,1.3,5.2,0l9.5-8.1c8.8,3.1,19.4,8.3,23.8,12.9H10.1z"></path></svg>
                        </li>
                    </ul>
                </div>
                <div id="userInfo-place" class="field-i">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="controller?command=gotologinpage">
                            <c:out value="${acc}"/>
                        </a>
                        </li>
                    </ul>
     </div>

        </div>
    </div>
<%--    </div>--%>
</form>
</nav>

</body>
</html>
