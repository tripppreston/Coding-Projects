<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Search</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            body{
                background: url('https://static.pexels.com/photos/656/sea-water-ocean-dark.jpg');
                background-repeat: no-repeat;
                background-position: center center;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Oswald', sans-serif;
                color:white;
            }

            /* Styles specific to this page*/



        </style>
    </head>
    <body>
        <%@include file="navbarFragment.jsp" %>
        <div class="container-fluid">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="row">
                    <form class="form-horizontal">
                        <div style="margin-bottom:20px;" class="row">
                            <div class="input-group input-group-lg col-sm-6 col-sm-offset-3">
                                <input id="search-field2" type="text" class="form-control" placeholder="Search posts">
                                <div class="input-group-btn">
                                    <button id="search-button2" class="btn btn-default" type="submit">
                                        <i class="glyphicon glyphicon-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div> <!-- end container div -->

               <div id="divToFillSearch" class="pop col-md-12"></div>

            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
            <script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>
    </body>
</html>
