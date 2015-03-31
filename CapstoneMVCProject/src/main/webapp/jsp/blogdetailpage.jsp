<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog Detail Page</title>
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
            <!--<h2>Home Page</h2>-->
            <%@include file="../WEB-INF/jspf/blogbodyfragment.jspf"%>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <%@include file="../WEB-INF/jspf/footerfragment.jspf"%>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/capstone.js"></script>
<!--        <script src="${pageContext.request.contextPath}/js/mvc.js"></script>
        <script src="${pageContext.request.contextPath}/js/tempJavaScriptFile.js"></script>
        <script src="${pageContext.request.contextPath}/js/inProgressJavascriptFile.js"></script>-->
    </body>
</html>

