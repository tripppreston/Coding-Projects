<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <title>JSP Page</title>
        <style>

            @import url('https://fonts.googleapis.com/css?family=Oswald');

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
            }
/*http://i.imgur.com/YuCTY0n.jpg?fb*/
        </style>
    </head>
    <body>
        <%@include file="navbarFragment.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                
                <div style="max-width:80%; margin: auto;" class="text-center">
                    <h1 style="color:white;">Popinov</h1> <br>
                    <img class="img-responsive" style="margin:auto;" src="http://i.imgur.com/YuCTY0n.jpg?fb"/>
                    <h2 style="color:white;">Dolphin 119c3B-2r: Activated 2011</h2>
                    <p style="color:white;">
                        Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент
                        классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney,
                        штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе.
                        В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), 
                        написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..',
                        происходит от одной из строк в разделе 1.10.32
                        Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент
                        классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney,
                        штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе.
                        В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), 
                        написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..',
                        происходит от одной из строк в разделе 1.10.32

                    </p>
                </div>

            </div>

        </div>  
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>

    </body>
</html>
