<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value = "${sessionScope.langueCourante}"/>
<fmt:setBundle basename="Langage"/>

<nav class="navbar navbar-inverse">

    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="font-family:Brush Script MT; color:red; font-size:30">Pro-Vita Tarh&Cia inc.</a>
    </div>
    <ul class="nav navbar-nav">
      
    
        <li class="active"><a href="init"><fmt:message key="barre.Accueil"/></a></li>
      
        <li><a href="ChangementLangue?language=fr_CA">Français</a></li>
        <li><a href="ChangementLangue?language=en_CA">English</a></li>
        <li><a href="ChangementLangue?language=it_IT">Italiano</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="ControPanier?action=cart"><span class="glyphicon glyphicon-shopping-cart"></span><fmt:message key="barre.panier"/>: ${count}</a></li>
    </ul>

</nav>