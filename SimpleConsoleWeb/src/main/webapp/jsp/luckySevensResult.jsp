
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
        <title>Lucky Sevens Results!</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/whitetest.jpg">

    </head>
    <body>
        <div class="container">
            <h1>Lucky Sevens Results!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLuckySevensForm">Lucky Sevens</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFactorizorForm">Factorizor</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayInterestCalculatorForm">Interest Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFlooringCalculatorForm">Flooring Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayTipCalculatorForm">Tip Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayRomanConverterForm">Roman Converter</a></li>

                </ul>       
            </div>
            <h2>${resultMessage}</h2>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>


