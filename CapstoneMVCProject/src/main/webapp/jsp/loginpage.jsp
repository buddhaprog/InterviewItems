<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <!--        TEAM 3 CSS-->
        <link href="${pageContext.request.contextPath}/css/team3-template.css" rel="stylesheet">
        <script src='https://www.google.com/recaptcha/api.js'></script>
    </head>
    <body>
        <div>
            <%@include file="../WEB-INF/jspf/navbarfragment.jspf"%>
            <h2 style="text-align: center">Login Page</h2>
<!--            SECURITY!! ITEM!!!-->
             <c:if test="${param.login_error == 1}">
                <h3>Wrong id or password!</h3>
            </c:if>
            <%@include file="../WEB-INF/jspf/loginpagefragment.jspf"%>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <div>
            <%@include file="../WEB-INF/jspf/footerfragment.jspf"%>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/js/inProgressJavascriptFile.js"></script>-->
        <script src="${pageContext.request.contextPath}/js/capstone.js"></script>
        <!--<script src="${pageContext.request.contextPath}/js/tempJavaScriptFile.js"></script>-->
    </body>
</html>

