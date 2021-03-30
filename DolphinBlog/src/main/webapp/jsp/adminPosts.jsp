<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Posts (Admin)</title>
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

            .adminButton{
                width:50px !important;                
            }
            th{
                font-size: 30px;
            }

            #add-post-modal,
            #edit-post-modal {
                color: darkslateblue;
            }

            .modal-header .close {
                font-size: 50px; 
            }


        </style>
    </head>
    <body>
        <%@include file="navbarFragment.jsp" %>
        <div class="container-fluid">
            <div>
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="row">
                        <form>
                            <div style="margin-bottom:20px;" class="row">
                                <div class="col-sm-2">
                                    <button data-toggle="modal" data-target="#add-post-modal" class="btn btn-lg btn-default" type="button">
                                        Add New Post
                                    </button>
                                </div>
                                <div class="input-group input-group-lg col-sm-6 col-sm-offset-3">
                                    <input id="post-search" type="text" class="form-control" placeholder="Search posts">
                                    <div class="input-group-btn">
                                        <button id="post-search-button" class="btn btn-default" type="submit">
                                            <i class="glyphicon glyphicon-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>

                    </div>

                    <div class="row">
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                            <table id="ApproveListTable" class="table" border="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Active Posts</th>
                                    </tr>
                                <thead/>
                                <tbody id="approvedRows" style="font-size: 24px"></tbody>
                            </table>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                            <table id="WaitApproveListTable" class="table" border="0" width="100%">
                                <thead
                                    <tr>
                                        <th>#</th>
                                        <th>Awaiting Approval</th>
                                    </tr>
                                </thead>
                                <tbody id="waitRows" style="font-size: 24px"></tbody>
                            </table>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_USER')">
                            <table id="employeeWaitApproveListTable" class="table" border="0" width="100%">
                                <thead
                                    <tr>
                                        <th>#</th>
                                        <th>Awaiting Approval</th>
                                    </tr>
                                </thead>
                                <tbody id="waitRowsEmployee" style="font-size: 24px"></tbody>
                            </table>
                        </sec:authorize>
                        
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                            <table id="EditListTable" class="table" border="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Edit Mode(Employee Queue)</th>
                                    </tr>
                                </thead>
                                <tbody id="editRows" style="font-size: 24px"></tbody>
                            </table>
                        </sec:authorize>
                    </div>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
<!--                    <div class="row">
                        <table class="table" style="color:white;">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Notice the full-width hr line below</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row"><h3 style="margin:0px;">3</h3></th>
                                    <td><h3 style="margin:0px;">Do yous know to write post how? I no England speak</h3></td>

                                    <td class = "adminButton"><button type="button" class="btn btn-primary" >Edit</button></td>
                                    <td class = "adminButton"><button type="button" class="btn btn-warning">Reject</button></td>
                                    <td class = "adminButton"><button type="button" class="btn btn-success" >Post</button></td>
                                    <td class = "adminButton"><button type="button" class="btn btn-danger" >Delete</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>-->

                    <br>
                    <br>
                    <br>
                    <br>

                </div>  

            </div> <!-- end container div -->

            <%@include file="addPostModalFragment.jsp" %>
            <%@include file="editPostModalFragment.jsp" %>

            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
            <script src="${pageContext.request.contextPath}/js/adminPosts.js"></script>
            <script src="${pageContext.request.contextPath}/js/tinymce.js"></script>
            <script src="${pageContext.request.contextPath}/js/NavBarAdminPost.js"></script>
    </body>
</html>
