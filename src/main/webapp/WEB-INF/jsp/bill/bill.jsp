<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle scope="session" basename="lang" var="loc"/>
<fmt:message bundle="${loc}" key="bill.header" var="headerS"/>
<fmt:message bundle="${loc}" key="bill.text.coast" var="coastText"/>
<fmt:message bundle="${loc}" key="bill.text.email" var="emailText"/>
<fmt:message bundle="${loc}" key="bill.close.btn" var="closeBtn"/>

<jsp:include page="../main/mainPage.jsp"/>
<html lang="ru"><head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Bill</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

  <style>
    <%@include file='/WEB-INF/jsp/bill/bill.css' %>
  </style>


</head>
<body class="modal-open">

<script type="text/javascript">
  let myModal = document.getElementById('myModal')
  myModal.addEventListener('show.bs.modal', function () {
    myModal.modal('show');
  })

</script>

  <div class="modal" id="myModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
       aria-labelledby="myModal"
       aria-hidden="true" style="display: block">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5><c:out value="${headerS}"/></h5>
          <a type="button" href="controller?command=gotomainpage" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></a>
        </div>
        <div class="modal-body">
          <p><c:out value="${coastText}"/> - ${discountPrice} $ </p>
          <p><c:out value="${emailText}"/></p>
        </div>
        <div class="modal-footer">
          <a type="button" href="controller?command=gotomainpage" class="btn btn-secondary" data-bs-dismiss="modal">
            <c:out value="${closeBtn}"/>
          </a>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>


