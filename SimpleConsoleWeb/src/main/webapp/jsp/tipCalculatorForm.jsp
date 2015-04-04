
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

        <title>Tip Calculator</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Tip Calculator</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayLuckySevensForm">Lucky Sevens</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFactorizorForm">Factorizor</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayInterestCalculatorForm">Interest Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayFlooringCalculatorForm">Flooring Calculator</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayTipCalculatorForm">Tip Calculator</a></li>
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/displayUnitConverterForm">Unit Converter</a></li>



                </ul>    
            </div>
        </div>
        <div class="container">

            <h2>How much was the Bill? (Controller)</h2>
            <form action="calculateTip" method="POST">
                <input type="text" name="billAmount">
                <h2>What is the % you would like to tip?(Controller)</h2>
                <input type="text" name="tipRate">
                <input type="submit" value="Calculate Tip!!">
                <h2> </h2>

            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>


