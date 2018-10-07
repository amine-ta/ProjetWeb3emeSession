<%-- 
    Document   : FinAchat
    Created on : 2018-10-07, 12:21:22
    Author     : Mohamed Amine Tarhouni, Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value = "${sessionScope.langueCourante}"/>
<fmt:setBundle basename="Langage"/>
<!DOCTYPE html>
<html>
    <head>
      
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" type="text/css" rel="stylesheet" />
        <title>JSP Page:MerciAchat</title>
    </head>
    <body class="container">
        <jsp:include page="NavBarreCheckout.jsp"/>
      <h3><fmt:message key="messageMerciAchat"/></h3>
    </body>
</html>