<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Pages(Admin)</title>
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
                color: white;
            }

            /* Styles specific to this page*/

            .adminButton{
                min-width:50px !important;                
            }
            th{
                font-size: 30px;
            }

            .modal-header .close {
                font-size: 50px; 
            }

            #add-page-modal,
            #edit-page-modal {
                color: darkslateblue;
            }


        </style>
    </head>
    <body>
        <%@include file="navbarFragment.jsp" %>
        <div class="container-fluid">
            <div>
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="row">
                        <div style="margin-bottom:20px;" class="row">
                            <div class="col-sm-2">
                                <button data-toggle="modal" data-target="#add-page-modal" class="btn btn-lg btn-default" type="button">
                                    Add New Page
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <table id= "activePagesTable" class="table table-responsive" border="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Active Pages</th>
                                </tr>
                            <thead/>
                            <tbody id="activePagesRows" style="font-size: 24px"></tbody>
                        </table>



                        <table id="editModePagesTable" class="table" border="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Pages In Edit Mode</th>
                                </tr>
                            </thead>
                            <tbody id="editModePagesRows" style="font-size: 24px"></tbody>
                        </table>
<!--                        <table id="unpostedPagesTable" class="table" border="0" width="100%">
                            <thead>
                                <tr>
                                    <th>Unposted Pages</th>
                                </tr>
                            </thead>
                            <tbody id="unpostedPagesRows" style="font-size: 24px"></tbody>
                        </table>-->
                    </div>

                </div>
            </div>
        </div>  
    </div>  <!-- end container div -->
    <br>
    <br>
    <br>
    <br>
</div>

<%@include file="addPageModalFragment.jsp" %>
<%@include file="editPageModalFragment.jsp" %>

<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
<script src="${pageContext.request.contextPath}/js/adminPages.js"></script>
<!--<script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>-->
<script src="${pageContext.request.contextPath}/js/tinymce.js"></script>
<script src="${pageContext.request.contextPath}/js/NavBarAdminPage.js"></script>
</body>
</html>
