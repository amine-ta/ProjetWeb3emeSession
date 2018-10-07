<%-- 
    Document   : DeconnClient
    Created on : 2018-09-23, 21:51:24
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page:Deconnexion</title>
    </head>
    <body>
      <h3><fmt:message key="messageDeconnexion"/></h3>
    </body>
</html>
