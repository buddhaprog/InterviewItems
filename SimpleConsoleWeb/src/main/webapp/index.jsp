
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Web Apps</title>
        <link rel="styleSheet" type="text/css" href="css/bootstrap.css">

        <link rel="styleSheet" type="type/css" href="css/bootstrap-theme.css">	
        <link rel="styleSheet" type="type/css" href="css/starter-template.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/whitetest.jpg">

    </head>

    <body>
        <!--        took this out of the line after #navbar   aria-expanded="false" aria-controls="navbar-->
        <nav class="navbar navbar-inverse navbar-fixed-top">

            <div class="navbar-header">

                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Web Apps</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div>

        </nav>

        <div class="container">

            <div class="starter-template">
                <h1>Simple Web Applications</h1>
            </div>
        </div>
        <!--nav bar to web apps here-->
        <div class="container">
            <section>
                <div class="navbar" data-example-id="simple-nav-tabs">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayLuckySevensForm">Lucky Sevens</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFactorizorForm">Factorizor</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayInterestCalculatorForm">Interest Calculator</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFlooringCalculatorForm">Flooring Calculator</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayTipCalculatorForm">Tip Calculator</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayRomanConverterForm">Roman Converter</a></li>

                    </ul>
                </div>
            </section>
        </div>
        <br>
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

