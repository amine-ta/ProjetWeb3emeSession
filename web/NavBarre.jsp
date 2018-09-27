<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="script/script.js" type="text/javascript"></script>

<c:set var="loc" value="fr_CA"/>
<c:if test="${!(empty sessionScope.langueCourante)}">
    <c:set var="loc" value="${sessionScope.langueCourante}"/>
</c:if>

<fmt:setLocale value = "${loc}"/>
<fmt:setBundle basename="Langage"/>

<nav class="navbar navbar-inverse">
    <div class="row">
        <div class="col-lg-6"> 
            <span>
                 <a class="navbar-brand" href="#" style="font-family:Brush Script MT; color:red; font-size:30">Pro-Vita Tarh&Cia inc.</a>
            </span>
            
             <span>
                <ul class="nav navbar-nav"> 
                <li class="active"><a href="init"><fmt:message key="barre.Accueil"/></a></li>
                <li><a href="ChangementLangue?language=fr_CA">Français</a></li>
                <li><a href="ChangementLangue?language=en_CA">English</a></li>      
                <li><a href="ChangementLangue?language=it_IT">Italiano</a></li>
            </ul>
            </span>
               
           

        </div>
        <div class="col-lg-6">

            <div class="search-container">
             
                    <input type="text" placeholder="Search.." name="search" id="search" onkeyup="startSearch()">
                    <button type="submit"><i class="fa fa-search"></i></button>
             
            </div> 

            <ul class="nav navbar-nav navbar-center">
                <li><a href="ControPanier?action=cart"><span class="glyphicon glyphicon-shopping-cart"></span><fmt:message key="barre.panier"/>: ${count}</a></li>
            </ul>

        </div>
    </div>
</nav>
            
        