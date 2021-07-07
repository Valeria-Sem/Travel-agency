<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <style>
        <%@include file="/404.css" %>
    </style>

    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
<%--                <h1>--%>
<%--                    Oops!</h1>--%>
<%--                <h2>--%>
<%--                    404 Not Found</h2>--%>
<%--                <div class="error-details">--%>
<%--                    Sorry, an error has occured, Requested page not found!--%>
<%--                </div>--%>
    <h1>
        Oops!</h1>
    <h2>
        <c:out value="${requestScope.errorMsg}" />
    </h2>
                <div class="error-actions">
                    <a href="controller?command=gotomainpage" class="btn btn-primary btn-lg">
                        Take Me Home </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
