<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            #outer {
                width: 100%;
                text-align: center;
            }

            #inner {
                display: inline-block;
            }
            #outerRight {
                width: 100%;
                text-align: right;
            }

            #innerRight {
                display: inline-block;
            }

            #cssTable  
            {
                text-align:center; 
                vertical-align:middle;
            }
            #textBox {
                width: 350px;
                border-radius: 5px;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                </ul>    
            </div>
            <div class="container">
                <div class=" col-md-6">
                    <h2>Items</h2>
                    <%@include file="itemTableFragment.jsp"%>
                </div>

                <div class=" col-md-6">

                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label for="currentMoney" class="col-md-4 control-label">Current Money</label>
                            <div class="col-md-8">


                                <input type="number" id="currentMoney" class="form-control" value="0.00" readonly/>



                            </div>
                        </div>

                        <div class="form-group">
                            <label for="insertButton" class="col-md-4 control-label">Insert Money</label>
                            <div class="col-md-8">
                                <input type="number" value="0.00" id="insertedMoney" class="form-control"/>
                                <input type="submit" value="Insert Money" id="insertButton" class="form-control btn btn-primary"/>
                                <br>
                                <br>
                            </div>

                            <label for="change" class="col-md-4 control-label">Change</label>
                            <div class="col-md-8">
                                <input type="number" value="0.00" id="change" class="form-control"/>
                                <input type="submit" value="Get Change" id="getChangeButton" class="form-control btn btn-primary"/>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingMachine.js"></script>

    </body>
</html>

