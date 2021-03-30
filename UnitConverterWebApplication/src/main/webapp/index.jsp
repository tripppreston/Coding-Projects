<%-- 
    Document   : Index
    Created on : Oct 25, 2016, 11:27:52 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script language="javascript" type="text/javascript">
            function call() {
                var name = "xyz";
                window.location.replace("a.jsp?name=" + name);
            }
        </script>

        <style>
            #inner {
                display: inline-block;
            }
            #outer {
                width: 100%;
                text-align: center;
            }
            #innerTextbox {
                display: inline-block;
            }
            #outerTextbox {
                width: 100%;
                text-align: right;
            }
            .buttonStuff {
                width: 150px;
                height: 50px;
                color: white;
                background-color: red; 
                border: black;
                border-radius: 10px;
            }
            .smallButtons {
                width: 100px;
                height: 25px;
                color: white;
                background-color: green;
                border-radius: 20px;
                border: green;
            }
            .closeButtons {
                width: 100px;
                height: 25px;
                color: white;
                background-color: red;
                border-radius: 20px;
                border: red;
            }
            .modal {
                background-color: lightseagreen;

            }
            .modal-body, .modal-content, .modal-footer {
                background-color: lightgray;
            }
            .borderModal{
                border: black;
            }
        </style>
    </head>
    <body>
        <c:out value="${modal}" ></c:out> 


            <div class="container">
                <div class="col-sm-3">
                </div>
                <div class="col-sm-6">
                    <div id="outer">
                        <div id="inner">
                            <h1>Unit Converter</h1>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <button id="temperature" type="button" class="buttonStuff" style="width:150px" data-toggle="modal" data-target="#temperatureModal">Temperature</button>
                            <br>
                            <br>
                            <button id="currency" type="button" class="buttonStuff" style="width:150px" data-toggle="modal" data-target="#currencyModal">Currency</button>
                            <br>
                            <br>
                            <button id="length" type="button" class="buttonStuff" style="width:150px" data-toggle="modal" data-target="#lengthModal">Length</button> 
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">

                </div>

            </div>
            <form name="form" action="Converter" method="POST">
                <div class="modal fade" id="temperatureModal" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title" style="text-align: center">Convert Temperature</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="col-sm-1" style="text-align: right; width: 50px;">
                                        <input type="number" name="startTemp" value="0" style="width: 50px;"><!--first temperature variable-->
                                    </div>
                                    <div class="col-sm-1">
                                        <select class="smallButtons" name="tempTypeStart" >
                                            <option name="celsius" value="celsius">Celsius</option>
                                            <option name="fahrenheit" value="fahrenheit">Fahrenheit</option>
                                            <option name="kelvin" value="kelvin">Kelvin</option>
                                        </select>

                                    </div>
                                    <div class="col-sm-1" style="text-align: right; width: 50px;">


                                        <input type="number" name="endTemp" value="<c:out value="${temperature}" ></c:out>" style="width: 50px;"><!--first temperature variable-->
                                    </div>

                                    <div class="col-sm-1">
                                        <select class="smallButtons" name="tempTypeDesired">
                                            <option name="celsius" value="celsius">Celsius</option>
                                            <option name="fahrenheit" value="fahrenheit">Fahrenheit</option>
                                            <option name="kelvin" value="kelvin">Kelvin</option>
                                        </select>
                                    </div>

                                    <div class="col-sm-2">
                                        <div id="outer">
                                            <div id="inner">
                                                <input type="submit" name="tempSubmitButton" value="Convert" class="smallButtons">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="closeButtons" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal fade" id="currencyModal" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" style="color: black" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title" style="text-align: center">Convert Currency</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="col-sm-1" style="text-align: right; width: 50px;">
                                        <input type="number" value="0" name="startCurrency" style="width: 50px;"><!--first temperature variable-->
                                    </div>
                                    <div class="col-sm-1">
                                        <select class="smallButtons" name="currencyTypeStart">
                                            <option name="USD" value="USD">USD</option>
                                            <option name="EUR" value="EUR">EUR</option>
                                            <option name="GBP" value="GBP">GBP</option>
                                            <option name="CAD" value="CAD">CAD</option>
                                        </select>

                                    </div>
                                    <div class="col-sm-1" style="text-align: right;width: 50px;">
                                        <input type="number" value="<c:out value="${currency}"></c:out>" name="endCurrency" style="width: 50px;"><!--first temperature variable-->
                                    </div>
                                    <div class="col-sm-1">
                                        <select class="smallButtons" name="currencyTypeDesired">
                                            <option name="USD" value="USD">USD</option>
                                            <option name="EUR" value="EUR">EUR</option>
                                            <option name="GBP" value="GBP">GBP</option>
                                            <option name="CAD" value="CAD">CAD</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <div id="outer">
                                            <div id="inner">
                                                <input type="submit" id="1" onclick="reply_click(this.id)" name="currencySubmitButton" value="Convert" class="smallButtons" style="border: green">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="closeButtons" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="modal fade" id="lengthModal" role="dialog">
                    <div class="modal-dialog">


                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title" style="text-align: center">Convert Length</h4>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="col-sm-1" style="text-align: right;width: 50px;">
                                        <input type="number" name="startLength" value="0" style="width: 50px;"><!--first temperature variable-->
                                    </div>
                                    <div class="col-sm-1">
                                        <select class="smallButtons" name="lengthTypeStart">
                                            <option name="millimeter" value="millimeter">Millimeters</option>
                                            <option name="centimeter" value="centimeter">Centimeters</option>
                                            <option name="meter" value="meter">Meters</option>
                                            <option name="kilometer" value="kilometer">Kilometers</option>
                                        </select>

                                    </div>
                                    <div class="col-sm-1" style="text-align: right; width: 50px;">
                                        <input type="number" value="<c:out value="${length}"></c:out>" name="endLength" style="width: 50px;"><!--first temperature variable-->
                                </div>
                                <div class="col-sm-1">
                                    <select class="smallButtons" name="lengthTypeDesired">
                                        <option name="inch" value="inch">Inches</option>
                                        <option name="foot" value="foot">Feet</option>
                                        <option name="yard" value="yard">Yards</option>
                                        <option name="mile" value="mile">Miles</option>
                                    </select>
                                </div>
                                <div class="col-sm-2">
                                    <div id="outer">
                                        <div id="inner">
                                            <input type="submit" name="lengthSubmitButton"  value="Convert" class="smallButtons" style="border: green">
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">

                            <button type="button" class="closeButtons" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            <script type="text/javascript">
                function reply_click(clicked_id)
                {
                    var button = document.getElementById(clicked_id);
                }
            </script>
        </form>
        <script>
            $(document).ready(function () {
                $(window).load(function () {
                    $('#temperatureModal').modal('show');
                });


                $("form input[type=submit]").click(function () {
                    $("input[type=submit]", $(this).parents("form")).removeAttr("clicked");
                    $(this).attr("clicked", "true");
                });

            });

        </script>

    </body>
</html>

