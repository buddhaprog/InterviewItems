<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title class="pagetitle">Home Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <!--        TEAM 3 CSS-->
        <link href="${pageContext.request.contextPath}/css/team3-template.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <%@include file="../WEB-INF/jspf/navbarfragment.jspf"%>
            <div class="container">
                <div class="blog-header">
                    <h1 class="blog-title" style="text-align: center">${pageTitle}</h1>
                    <!--        <p class="lead blog-description">Blogs in detail</p>-->
                    <hr>
                </div>
                <div class="row">
                    <div class="col-sm-8 blog-main">

                        <div class="blog-post">

                            <div>${pageContent}</div>
                            <h1>Welcome</h1>
                            <hr>
                            <h2>Thank you for deciding to visit our <strong>"Create your own blog and page site"</strong>.</h2>
                            <hr>
                            <p>Here on this site you can:</p>
                            <ul>
                                <li>Manage Users</li>
                                <li>Create Blogs
                                <li>Create Static Pages</li> 
                                <!--<li>Leave comments</li>-->
                                <li>Post and Unpost items</li>
                            </ul>
                            <p>Putting it simply, this is an example of a basic site using the following technologies:</p>
                            <ul> 
                                <li> HTML</li>
                               <li>  CSS</li>
                               <li>  Java</li>
                               <li>  ajax</li>
                               <li>  jQuery</li>
                               <li>  php</li>
                               <li>  SQL</li>
                               <li>  MySql</li>
                               <li>  phpadmin</li>
                               <li>  Spring MVC</li>
                               <li>  JDBC templates</li>
                               <li>  Bootstrap</li>
                               <li>  Spring security</li>
                               <li>  netbeans</li>
                                <li> tinymce</li>
                               <li>  tomcat</li>
                               <li>  maven</li>
                            </ul>
                            <p><em>Keep in mind, This is still a work in progress.</em></p>
                            <hr>

                            <%--<%@include file="commentboxfragment.jspf"%>--%>
                        </div><!-- /.blog-post -->
                    </div><!-- /.blog-main -->
                    <!--                    sidebar-->
                    <%@include file="../WEB-INF/jspf/sidebarfragment.jspf"%>
                </div><!-- /.row -->
            </div><!-- /.container -->



        </div>

        <%@include file="../WEB-INF/jspf/footerfragment.jspf"%>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/capstone.js"></script>
<!--        <script src="${pageContext.request.contextPath}/js/mvc.js"></script>
        <script src="${pageContext.request.contextPath}/js/tempJavaScriptFile.js"></script>
        <script src="${pageContext.request.contextPath}/js/inProgressJavascriptFile.js"></script>-->
    </body>
</html>


