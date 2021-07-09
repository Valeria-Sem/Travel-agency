<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../user/userPage.jsp"/>

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
          <h5>BILL</h5>
          <a type="button" href="controller?command=gotouserpage" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></a>
        </div>
        <div class="modal-body">
          <p>Оплата прошла успешно. Цена со скидкой составила - ${discountPrice} $ </p>
          <p>Подтверждение оплаты было васлано вам на почту</p>
        </div>
        <div class="modal-footer">
          <a type="button" href="controller?command=gotouserpage" class="btn btn-secondary" data-bs-dismiss="modal">
            Close
          </a>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>


