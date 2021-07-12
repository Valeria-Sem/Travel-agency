<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="error.oops" var="oops"/>
<fmt:message bundle="${loc}" key="error.server" var="server"/>

<html>
<head>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


  <style>
    <%@include file="/WEB-INF/jsp/error/errorPage.css" %>
  </style>

  <title>Title</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div class="error-template">
        <h1><c:out value="${oops}"/></h1>

        <div class="error-details">
          <c:if test="${requestScope.errorMsg != null}">

            <div class="alert alert-danger" role="alert">
                ${requestScope.errorMsg}
            </div>
          </c:if>
          <c:if test="${requestScope.errorMsg == null}">

            <div class="alert alert-danger" role="alert">
              <c:out value="${server}"/>
            </div>
          </c:if>

        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
