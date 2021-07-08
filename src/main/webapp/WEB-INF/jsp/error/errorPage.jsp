<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
        <h1>
          Oops!</h1>

        <div class="error-details">
          <c:if test="${requestScope.errorMsg != null}">

            <div class="alert alert-danger" role="alert">
                ${requestScope.errorMsg}
            </div>
          </c:if>
            SERWER ERROR :(
        </div>
<%--        <div class="error-actions">--%>
<%--          <a href="controller?command=gotomainpage" class="btn btn-primary btn-lg">--%>
<%--            Take Me Home </a>--%>
<%--        </div>--%>
      </div>
    </div>
  </div>
</div>
</body>
</html>
