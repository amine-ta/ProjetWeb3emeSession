<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:set var="loc" value="fr_CA"/>
<c:if test="${!(empty sessionScope.langueCourante)}">
  <c:set var="loc" value="${sessionScope.langueCourante}"/>
</c:if>

<fmt:setLocale value = "${loc}"/>
<fmt:setBundle basename="Langage"/>

<nav class="navbar navbar-inverse">

    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="font-family:Brush Script MT; color:red; font-size:30">Pro-Vita Tarh&Cia inc.</a>
    </div>
    <ul class="nav navbar-nav">
 
        <ul class="nav navbar-nav navbar-right">
            <li><a href="Deconnexion?languecourr=${loc}"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="checkout.deconn"/></a></li>
    </ul>
  
</nav>