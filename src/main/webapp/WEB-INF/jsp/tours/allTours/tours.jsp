<%--
  Created by IntelliJ IDEA.
  User: leras
  Date: 29.06.2021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid mt-5" style="background-color: #eeeeee">
    <div class="container p-5">
        <div class="row justify-content-center">
            <c:forEach items="${tours}" var="tour" >

                <div class="col col-lg-4 description" >
                    <div class="card text-center mt-5 description-container param">
                        <img src="${tour.imgPath}" alt="" class="card-img-top img">
                        <div class="card-body" >
                            <h2 class="card-title pricing-card-title" >
                                    ${tour.name}
                            </h2>
                            <h4 class="card-title" style="margin-top: 10px">
                                <span class="badge rounded-pill bg-warning text-dark">${tour.price} $</span>
                            </h4>
                        </div>
                        <div class="card-footer">
                            <a class="btn btn-outline-primary" id="${tour.id}"
                               (click)="payAndSub(choice.monthPrise, template, choice.idProduct, choice.idOrganisation)">
                                Show details
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
