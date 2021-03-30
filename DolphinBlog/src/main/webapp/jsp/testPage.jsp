<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <!-- Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <title><c:out value="${title}" default="Didn't work"/></title>
        <style>

            @import url('https://fonts.googleapis.com/css?family=Oswald');

            body{


                background: url('https://i.imgsafe.org/b713dd40eb.jpg');
                background-repeat: no-repeat;
                background-position: center center;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Oswald', sans-serif;
                font-weight:bold;

            }

            #nav-div{
                height:100px;
                margin:0px;
                padding:0px;

            }
            #left{
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #right{
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #pop1{
                height:800px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #pop2{
                height:500px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #pop3{
                height:500px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #pic-div1{
                height:400px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
            }
            #pic-div2{
                height:200px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
            }
            #pic-div3{
                height:200px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
            }
            #pic-div4{
                height:150px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:10px;
            }
            #pic-div5{
                height:150px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:10px;
            }
            #pic-div6{
                height:150px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:10px;
            }
            #text-div1{
                /*                height:120px;*/
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
                color:white;
            }
            #text-div2{
                height:120px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
            }
            #text-div3{
                height:120px;
                /*                border: solid 1px white;*/
                padding:0px;
                margin-top:20px;
            }
            #right-min1{
                height:300px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #right-min2{
                height:300px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #right-min3{
                height:300px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #search-div{
                height:310px;
                /*                border: solid 1px white;*/
                padding:0px;
            }
            #search-input-div{

                padding:0px;
            }
            #search-button-div{

                padding:0px;
            }
            #comments1{
                /*                border: solid 1px white;*/
                color:white;
                padding:0px;
                height:50px;
            }
            #icons{
                /*                border: solid 1px white;*/
                color:white;
                padding:0px;
                height:40px;
            }
            #table-image{
                border: solid 1px white;
                color:white;
                padding:0px;
                height:80px;
                width:80px;
            }
        </style>
    </head>
    <body>

<!--        <h2>  <c:out value="${post}" default="Didn't work"/> </h2>
<h2>  <c:out value="${postID}" default="Didn't work"/> </h2>
<h2>  <c:out value="${title}" default="Didn't work"/> </h2>
<h2>  <c:out value="${pub_date}" default="Didn't work"/> </h2>
<h2>  <c:out value="${post}" default="Didn't work"/> </h2>
<h2>  <c:out value="${postID}" default="Didn't work"/> </h2>
<h2>  <c:out value="${title}" default="Didn't work"/> </h2>
<h2>  <c:out value="${pub_date}" default="Didn't work"/> </h2>-->



        <%@include file="navbarFragment.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div id="left" class="col-xs-8">
                    <div id="pop1" class="col-md-12">
                        <!--                        <div style="padding:0px;" class="col-md-6 col-md-offset-1">
                                                    <h2 style="color:white;">${title} </h2>
                                                </div>
                                                <div class="col-md-4">
                                                    <h4 style="color:white;margin-top:33px;">${pub_date}</h4>
                                                </div>-->
                        <!--                        <div id="pic-div1" class="col-md-6 col-md-offset-1">
                                                    <img src="https://www.extremetech.com/wp-content/uploads/2015/12/DolphinJump-640x353.jpg" class="image-responsive img-rounded" style="height:400px;width:600px"/>
                                                </div>-->
                        <div id="text-div1" class="col-md-10 col-md-offset-1">
                            ${content}

                        </div>
                        <div class="col-md-12">
                            <div class="col-md-5 col-md-offset-1">
                                <h3 style="color:white">Comment <span class="glyphicon glyphicon-comment"></span></h3>
                            </div>
                            <div class="col-md-6">
                                <h3 id="like-text-test-page" style="color:white">Likes(${likes}) <a id="like-button-test-page"><span class="glyphicon glyphicon-thumbs-up"></span></a></h3>
                            </div>
                            <div class="col-md-12" style="color:white;">
                                <table class="table">
                                    <thead class="thead-inverse">
                                        <tr>
                                            <th>Comments</th>


                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${comments}" var="person">
                                            <tr>
                                                <th scope="row"><div id="table-image"></div></th>
                                                <td><p>${person}</p></td>

                                            </tr>
                                        </c:forEach>
                                        <!--                                        <tr>
                                                                                    <th scope="row"><div id="table-image"></div></th>
                                                                                    <td><p>Wow who would have guessed someone who works around so many blowholes would become one themselves. Get a job you fucking hippy!</p><br><p>-xxxTrUmP4PrEZ2016xxx</p></td>
                                        
                                                                                </tr>-->
                                        <!--                                        <tr>
                                                                                    <th scope="row"><div id="table-image"></div></th>
                                                                                    <td><p>So true! I guess you need more than thumbs to seize the means of production </p><br><p>-BernieBabe442</p></td>
                                        
                                                                                </tr>
                                                                                <tr>
                                                                                    <th scope="row"><div id="table-image"></div></th>
                                                                                    <td><p>Coins sink in water, but if you give enough to a dolphin he will just float there. Can't explain that! </p><br><p>-KenM</p></td>
                                        
                                                                                </tr>-->
                                    </tbody>
                                </table>

                            </div>
                        </div>

                    </div>


                </div>
                <div id="right" class="col-xs-4">
                    <div id="search-div" class="col-xs-12">
                        <div id="search-input-div" class="col-xs-6 col-xs-offset-2">
                            <input type="text" class="form-control" id="extampleField" placeholder="Search by Titles">
                        </div>
                        <div id="search-button-div" class="col-xs-4">
                            <button type="button" class="btn btn-success">Search</button>
                        </div>
                        <div style="margin-bottom:20px;" id="search-input-div" class="col-xs-6 col-xs-offset-2">
                            <input type="text" class="form-control" id="hashtag-search" placeholder="Search by #">
                        </div>
                        <div style="margin-bottom:20px;" id="search-button-div" class="col-xs-4">
                            <button type="button" class="btn btn-success">Search</button>
                        </div>
                        <div  class="col-xs-4">

                            <h3 style="color:white;margin-top:0px;">Categories</h3>
                            <a><h4 style="color:white;">Training(3)</h4></a>
                            <a><h4 style="color:white;">Travels(6)</h4></a>
                            <a><h4 style="color:white;">Style(10)</h4></a>
                            <a><h4 style="color:white;">Mission(3)</h4></a>
                            <a><h4 style="color:white;">Other(8)</h4></a>


                        </div>
                        <div class="col-xs-8">
                            <div style="padding:0px;" class="col-xs-12">
                                <h3 style="color:white;margin-top:0px;padding:0px;">Popular #</h3>
                            </div>
                            <div style="padding-left:0px;" class="col-xs-6">


                                <a id="finning"><h5 style="color:white;">#Finning</h5></a>
                                <a id="training"><h5 style="color:white;">#Training</h5></a>
                                <a id="cute"><h5 style="color:white;">#Cute</h5></a>
                                <a id="echolocation"><h5 style="color:white;">#Echolocation</h5></a>
                                <a id="fuck-sharks"><h5 style="color:white;">#FuckSharks</h5></a>
                            </div>
                            <div style="padding-left:0px;" class="col-xs-6">

                                <a id="stalin-did-nothing-wrong"><h5 style="color:white;">#StalinDidNothingWrong</h5></a>
                                <a id="reject-capitalism"><h5 style="color:white;">#RejectCapitalism</h5></a>
                                <a id="rescue"><h5 style="color:white;">#Rescue</h5></a>
                                <a id="comrades-for-life"><h5 style="color:white;">#ComradesForLife</h5></a>
                                <a id="enemy-sub-locations"><h5 style="color:white;">#EnemySubLocations</h5></a>
                            </div>

                        </div>

                    </div>
                    <div id="right-min1" class="col-xs-12">
                        <div class="col-xs-6">
                            <h4 style="color:white;">POPULAR BLOG </h4>
                        </div>
                        <div class="col-xs-6">
                            <h4 style="color:white;">dd/mm/yy</h4>
                        </div>
                        <div id="pic-div4" class="col-xs-6">
                            <img src="http://www.defenders.org/sites/default/files/styles/large/public/dolphin-kristian-sekulic-isp.jpg" class="image-responsive img-rounded" style="height:148px;width:210px"/>
                        </div>
                        <div id="pic-div5" class="col-lg-6">
                            <div class="col-xs-12" style="">
                                <p style="color:white">DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS</p>
                            </div>
                            <div class="col-xs-12">
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-comment"></span></h4>
                                </div>
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-thumbs-up"></span></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="right-min2" class="col-xs-12">
                        <div class="col-xs-6">
                            <h4 style="color:white;">POPULAR BLOG </h4>
                        </div>
                        <div class="col-xs-6">
                            <h4 style="color:white;">dd/mm/yy</h4>
                        </div>
                        <div id="pic-div5" class="col-xs-6">
                            <img src="http://media.salon.com/2013/08/shutterstock_133313075.jpg" class="image-responsive img-rounded" style="height:148px;width:210px"/>
                        </div>
                        <div id="pic-div5" class="col-lg-6">
                            <div class="col-xs-12" style="">
                                <p style="color:white">DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS</p>
                            </div>
                            <div class="col-xs-12">
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-comment"></span></h4>
                                </div>
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-thumbs-up"></span></h4>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div id="right-min3" class="col-md-12">
                        <div class="col-md-6">
                            <h4 style="color:white;">POPULAR BLOG </h4>
                        </div>
                        <div class="col-md-6">
                            <h4 style="color:white;">dd/mm/yy</h4>
                        </div>
                        <div id="pic-div6" class="col-md-6">
                            <img src="https://www.czs.org/custom.czs/files/e3/e3649ee2-8a64-4cf3-a5a0-1d1d38123967.jpg" class="image-responsive img-rounded" style="height:148px;width:210px"/>
                        </div>
                        <div id="pic-div6" class="col-md-6">
                            <div class="col-xs-12" style="">
                                <p style="color:white">DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS DOLPHINS</p>
                            </div>
                            <div class="col-xs-12">
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-comment"></span></h4>
                                </div>
                                <div id="icons" class="col-xs-6">
                                    <h4>(4)<span class="glyphicon glyphicon-thumbs-up"></span></h4>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
                            <div id="secret-post-id-div">${postIdentifier}</div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>
    </body>
</html>
