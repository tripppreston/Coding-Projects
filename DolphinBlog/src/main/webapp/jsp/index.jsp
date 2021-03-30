<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <!-- Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <style>

/*            @import url('https://fonts.googleapis.com/css?family=Oswald');

            body{
                background: url('http://wallpapercave.com/wp/RB16JiE.jpg');
                background-repeat: no-repeat;
                background-position: center center;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Oswald', sans-serif;
                font-weight:bold;
                color:white;
            }

            #left,
            #right,
            #nav-div,
            .pop,
            .content-div-sm,
            .pic-div-md,
            .text-div-custom,
            .right-min,
            #search-div,
            #search-input-div,
            #search-button-div,
            #comments1,
            #icons{
                border: solid 1px white;
                padding: 0px;
            }

            *******************************
                START Custom Classes for JS
            ********************************
         
            .content-div-sm{
                height:148px;
                width:210px;
                margin-top:10px;
            }
            
            .date-md{
                margin-top:33px;
            }
            
            .date-sm{

            }

            .pic-div-md{
                height:200px;
                margin-top:20px;
            }
            
            .pic-md{
                height:198px;width:425px;
            }

            .pic-sm{
                height:148px;width:210px;
            }
            
            .recent{
                height:500px;
            }

            .right-min{
                height:300px;
            }

            .text-div-md{
                height:120px;
                margin-top:20px;
            }
           
            .title-md{

            }
             
            .title-sm{

            }

            *****************************
                END Custom Classes for JS
            ******************************

            #search-div{
                height:310px;
            }
            #search-input-div{
            }
            #search-button-div{
            }

            #comments1{
                height:50px;
            }
            #icons{
                height:40px;
            }*/

            
        </style>
    </head>
    <body>
        <%@include file="navbarFragment.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div id="left" class="col-xs-6">
                    <div style="margin-bottom:50px" class="title-text col-md-10 col-md-offset-2"><h1>Anastasia's Dolphin Blog</h1></div>
                    <div id="divToFill" class="pop col-md-12">
                        
                    </div>
                    
                </div>  <!-- END OF LEFT COLUMN -->  

                <!--begin RIGHT COLUMN-->
                <div id="right" class="container-fluid col-xs-4 col-xs-offset-2">
                    <div id="search-div" class="col-xs-12">
                        <div  id="search-input-div" class="col-xs-6 col-xs-offset-2">
                            <input type="text" class="form-control" id="search-field" placeholder="Search by Titles">
                        </div>
                        <div id="search-button-div" class="col-xs-4">
                            <button id="search-button" type="button" class="btn btn-success">Search</button>
                        </div>
<!--                        <div style="margin-bottom:20px;" id="search-input-div" class="col-xs-6 col-xs-offset-2">
                            <input type="text" class="form-control" id="hashtag-search" placeholder="Search by #">
                        </div>
                        <div style="margin-bottom:20px;" id="search-button-div" class="col-xs-4">
                            <button type="button" class="btn btn-success">Search</button>
                        </div>-->
                        <div style="padding-left:0px" class="col-xs-4">
                            <h3 style="margin-top:30px;">Categories</h3>
                            <a id="training-link"><h4>Training</h4></a>
                            <a id="travels-link"><h4>Travels</h4></a>
                            <a id="style-link"><h4>Style</h4></a>
                            <a id="mission-link"><h4>Mission</h4></a>
                            <a id="other-link"><h4>Other</h4></a>
                        </div>
                        <div  class="col-xs-8">
                            <div style="padding:0px;" class="col-xs-12">
                                <h3 style="margin-top:30px;padding:0px;">Popular #</h3>
                            </div>
                            <div style="padding-left:0px;" class="col-xs-6">
                                <a id="hash-link-1" ><h5 id="hash-text-1"></h5></a>
                                <a id="hash-link-2" ><h5 id="hash-text-2"></h5></a>
                                <a id="hash-link-3" ><h5 id="hash-text-3"></h5></a>
                                <a id="hash-link-4" ><h5 id="hash-text-4"></h5></a>
                                <a id="hash-link-5" ><h5 id="hash-text-5"></h5></a>
                            </div>
                            <div style="padding-left:0px;" class="col-xs-6">
                                <a id="hash-link-6" ><h5 id="hash-text-6"></h5></a>
                                <a id="hash-link-7" ><h5 id="hash-text-7"></h5></a>
                                <a id="hash-link-8" ><h5 id="hash-text-8"></h5></a>
                                <a id="hash-link-9" ><h5 id="hash-text-9"></h5></a>
                                <a id="hash-link-10" ><h5 id="hash-text-10"></h5></a>
                            </div>
                        </div>
                    </div>

                    <div id="popDivToFill" >
                        <h3 style="padding-left:0px;" class="col-md-12">POPULAR POSTS </h3>
                      


                    </div> <!--GENERATED CONTENT FOR SMALL POPULAR BLOGS--> 
                </div>  <!-- END OF RIGHT COLUMN -->
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>
        <script src="${pageContext.request.contextPath}/js/NavBar.js"></script>

    </body>
</html>

