<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="errorMsg" scope="request" type="java.lang.String"/>--%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
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

<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/jsp/registration/registration.css" %>
    </style>

    <title><c:out value="${regTitle}"/></title>

</head>
<body>
<c:if test="${errorMsg != null}">

        <div class="alert alert-danger" role="alert">
                ${errorMsg}
        </div>
</c:if>

<div class="lang-buttons">
    <p><c:out value="${changeLang}" /></p>
    <a class="btn btn-outline-warning translate" id="en" href="controller?command=gotoregistrationpage&locale=en">
        <img src="https://pngicon.ru/file/uploads/Flag-SShA.png" style="height: 30px; width: 40px">
    </a>
    <a class="btn btn-outline-warning" id="ru" href="controller?command=gotoregistrationpage&locale=ru">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"
             style="height: 30px; width: 40px">
    </a>
</div>

<h1><c:out value="${regTitle}"/></h1>
    <form class="form-registration" action="controller?command=registration" method="post">
<%--        <form >--%>

        <div class="needs-validation" novalidate>
            <div class="my">
                <div class="col-md-13">
                    <label class ="myLabel" for="email" class="form-label">
                        <c:out value="${emailInput}"/>
                    </label>
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
                    <label class ="myLabel" for="password" class="form-label">
                        <c:out value="${passwordInput}"/>
                    </label>
                    <input type="password" name="password" class="form-control" id="password" required=""
                    style="text-transform: none;" minlength="6">
                </div>
            </div>
        </div>

<%--        <div class="vl"></div>--%>

<%--        <div class="my">--%>
<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="name" class="form-label">--%>
<%--                    <c:out value="${nameInput}"/>--%>
<%--                </label>--%>
<%--                <input type="text" class="form-control" name="name" id="name" placeholder="IVAN" required--%>
<%--                       pattern="[a-zA-Z]{2,}" minlength="2" maxlength="30">--%>
<%--            </div>--%>

<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="surname" class="form-label">--%>
<%--                    <c:out value="${surnameInput}"/>--%>
<%--                </label>--%>
<%--                <input type="text" class="form-control" name="surname" id="surname" placeholder="PETROV" required--%>
<%--                       pattern="[a-zA-Z]{2,}" minlength="2" maxlength="30">--%>
<%--            </div>--%>

<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="datepicker" class="form-label">--%>
<%--                    <c:out value="${dateBInput}"/>--%>
<%--                </label>--%>
<%--                    <div class="input-group date">--%>
<%--                        <input type="date" class="form-control" name="dateOfBirth" data-format="mm-dd-yyyy" id="datepicker" required>--%>
<%--                    </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="vl"></div>--%>

<%--        <div class="my">--%>
<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="passport"  class="form-label">--%>
<%--                    <c:out value="${passportInput}"/>--%>
<%--                </label>--%>
<%--                <input type="text" class="form-control" name="passport" id="passport" placeholder="MP5678789" required--%>
<%--                       pattern="[a-zA-Z]+[0-9]{2,7}">--%>
<%--            </div>--%>

<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="nationality" class="form-label">--%>
<%--                    <c:out value="${nationalityInput}"/>--%>
<%--                </label>--%>
<%--                <input type="text" class="form-control" name="citizenship" id="nationality" placeholder="REPUBLIC OF BELARUS" required>--%>
<%--            </div>--%>

<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="datepicker2"  class="form-label">--%>
<%--                    <c:out value="${dateIInput}"/>--%>
<%--                </label>--%>
<%--                <div class="input-group date">--%>
<%--                    <input type="date" class="form-control" name="dateOfIssue" data-format="mm-dd-yyyy" placeholder="" id="datepicker2" required>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="col-md-13">--%>
<%--                <label class ="myLabel" for="datepicker3" class="form-label">--%>
<%--                    <c:out value="${dateEInput}"/>--%>
<%--                </label>--%>
<%--                <div class="input-group date">--%>
<%--                    <input type="date" class="form-control" name="expirationDate" data-format="mm-dd-yyyy"  placeholder="" id="datepicker3" required>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

            <div class="col-12 ">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck" >
                        <c:out value="${checkBox}"/>
                    </label>
                </div>
            </div>
            <div class="col-13">

                    <button id="regBtn" class="btn btn-primary" type="submit" >
                        <c:out value="${regButton}"/>
                    </button>

            </div>
    </form>
<%--</form>--%>
<script src=" ${pageContext.request.contextPath}/registration.js"  type="text/javascript"></script>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

<%--<script src="jquery.datetimepicker.full.min.js"></script>--%>
</body>
</html>
