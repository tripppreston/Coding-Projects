<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Video Games</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1> <img src="https://d30y9cdsu7xlg0.cloudfront.net/png/14979-200.png" style="width:50px;height:45px;">    Video Games</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats">Stats</a></li>
                </ul>    
            </div>
            <div class="container">
                <div class=" col-md-6">
                    <h2>Video Games</h2>
                    <%@include file="videoGameTableFragment.jsp"%>
                </div>

                <div class=" col-md-6">

                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label for="search-game-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input id="search-game-title" name="title" type="text" class="form-control" placeholder="Title" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="search-game-publisher" class="col-md-4 control-label">Publisher:</label>
                            <div class="col-md-8">
                                <input id="search-game-publisher" name="publisher" type="text" class="form-control" placeholder="Publisher" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="search-game-genre" class="col-md-4 control-label">Genre:</label>
                            <div class="col-md-8">
                                <input id="search-game-genre" name="genre" type="text" class="form-control" placeholder="Genre" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="search-game-rating" class="col-md-4 control-label">ESRB Rating:
                                <div class="col-md-8">
                                    <div id="outer">
                                        <div id="inner">
                                            <select class="form-control" id="search-game-rating">
                                                <option>RP</option> 
                                                <option>EC</option> 
                                                <option>E</option> 
                                                <option>E10+</option> 
                                                <option>T</option> 
                                                <option>M</option> 
                                                <option>A</option> 
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </label>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button id="search-button" name="gameName" type="submit" class="btn btn-default">Search</button>
                            </div>
                        </div>
                    </form>
                    <div id="validationErrors" style="color: red"/></div>
            </div>
        </div>
    </div>
    <%@include file="detailModalFragment.jsp" %>
    <%@include file="editModalFragment.jsp" %>

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/videoGame.js"></script>

</body>
</html>

