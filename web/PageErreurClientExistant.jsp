<%-- 
    Document   : PageErreurClientExistant
    Created on : 2018-09-08, 16:55:09
    Author     : Mohamed Amine Tarhouni et Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet" />
        <title>JSP Page - Erreur Client Existant</title>
    </head>
    <body>
         <%@include file="/NavBarre.jsp" %>
         <div align="center">
         <h1>ERREUR!!!</h1>
         <h2>Un client avec le courriel ${nouveauclient} existe déjà dans notre Base de donnée!</h2><br/>
         <a href="PageClient.jsp">Cliquez ce lien pour revenir à l'authentification</a>
         </div>
    </body>
</html>
