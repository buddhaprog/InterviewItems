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
        <%@include file="../WEB-INF/jspf/navbarfragment.jspf" %>
        <div class="container">
            <h1 style="text-align: center">User Control</h1>
            <h4 id="num-contacts"> </h4>
            <hr/>
            <div class="row">
                <!--this div holds the summary table of contacts-->
                <div class="col-md-12">
                    <h2>Users</h2>  
                    <!---table table-hover is the class that highlights the row when you hover over it-->
                    <!--since its in the same folder we can just use the name, if in another folder we would need to-->
                    <!--enter the path-->
                    <%@include file="../WEB-INF/jspf/userSummaryTable.jspf" %>
                    <%@include file="../WEB-INF/jspf/userDetailsEditModalFragment.jspf" %>
                </div>
                <!--this holds the new contact form-->
                <!--forms act like containers so they aren't placed inside a container-->
                <!--<div class="col-md-6">-->
<!--                    <h2>Search Users</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-first-name" class="col-md-4 control-label">
                                First Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-first-name" placeholder="First Name"> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-last-name" class="col-md-4 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-last-name" placeholder="Last Name">
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="search-user-name" class="col-md-4 control-label">
                                User Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-user-name" placeholder="Company">
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="search-email" class="col-md-4 control-label">
                                Email:
                            </label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-email" placeholder="Email">
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="search-button" class="btn btn-default">
                                    Search Users
                                </button>
                            </div>
                        </div>
                    </form>-->
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/capstone.js"></script>
<!--        <script src="${pageContext.request.contextPath}/js/tempJavaScriptFile.js"></script>
        <script src="${pageContext.request.contextPath}/js/inProgressJavascriptFile.js"></script>-->
    </body>
</html>

