<div>
    <nav class="navbar navbar-inverse" style="height:59px;">
        <div class="container-fluid">
            <ul id="nav-bar" class="nav nav-pills navbar-left">
                <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home"><h5>Home</h5></a></li>
                <!--<li role="presentation"><a href="${pageContext.request.contextPath}/blogpost"><h5>Blog Example Page</h5></a></li>-->
                <li id="d" class="dropdown">
                    <a id="a" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><h5>Dolphins  <span class="caret"></span></h5></a>
                    <ul id="dolphins-dropdown" class="dropdown-menu">
                        <!-- THIS IS WHERE WE CAN EITHER PUT SOME SORT OF JSTL <c forEach> or we
                              CAN USE JavaScript TO APPEND STATIC PAGES with their titles-->
<!--                        <li role="presentation"><a href="${pageContext.request.contextPath}/pages/Popinov"><h5>Popinov</h5></a></li>
                        <li role="separator" class="divider"></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/pages/Vladimir"><h5>Vladimir</h5></a></li>-->
                    </ul>
                </li>
                <!--this makes up a tab, this whole li section below-->
<!--                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><h5>Tab  <span class="caret"></span></h5></a>
                    <ul class="dropdown-menu">
                         THIS IS WHERE WE CAN EITHER PUT SOME SORT OF JSTL <c forEach> or we
                              CAN USE JavaScript TO APPEND STATIC PAGES with their titles
                        <li role="presentation"><a href="${pageContext.request.contextPath}/#"><h5>Static Page 1</h5></a></li>
                        <li role="separator" class="divider"></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/#"><h5>Static Page 2</h5></a></li>
                    </ul>
                </li>-->
            </ul>
            <ul id="nav-right" class="nav navbar-nav navbar-right"> 
                <!--<li role="presentation"><a href="${pageContext.request.contextPath}/search"><h5>Search (not a tab)</h5></a></li>-->
                <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin/pages"><h5>Manage Pages (admin)</h5></a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin/posts"><h5>Manage Posts (admin)</h5></a></li>
                </sec:authorize>

                <sec:authorize access="isAnonymous()">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/login"><h5>Log in</h5></a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout"><h5>Log Out</h5></a>
                    </li> 
                </sec:authorize>
            </ul>    
        </div>
    </nav>
</div>