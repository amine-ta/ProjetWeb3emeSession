<%-- 
    Document   : panier
    Created on : 2018-09-07, 08:53:36
    Author     : Mohamed Amine Tarhouni et Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value = "${sessionScope.langueCourante}"/>
<fmt:setBundle basename="Langage"/>

<head>
    <title>VentesPro</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body >
    <jsp:include page="NavBarre.jsp"/>
    <div class="container">
    <div> 
        <c:choose>
            <c:when test="${shoppingcart != null  && shoppingcart.size() > 0 }">
                <div class="row">

                    <div class="col-lg-12">
                        <h3><fmt:message key="panier.panier"/>  <span class="glyphicon glyphicon-shopping-cart"></span> </h3>
                        <br>
                        <center>
                            <table border="0" class="table table-hover" width="100%" >
                                <thead class="thead-light">
                                    <tr>
                                        <td><b><fmt:message key="panier.nom"/></b></td>
                                        <td><b><fmt:message key="panier.images"/></b></td>
                                        <td><b><fmt:message key="panier.marque"/></b></td>                               
                                        <td><b><fmt:message key="panier.format"/></b></td>
                                        <td><b><fmt:message key="panier.qte"/></b></td>
                                        <td><b><fmt:message key="panier.prix"/> ($)</b></td>
                                        <td><b></b></td>
                                    </tr>
                                </thead>

                                <c:forEach  varStatus="loop"  var="prod" items="${shoppingcart}">
                                    <tr>
                                        <td><a style="width:100%;color:#B22222;" href="detailProduit?id=${prod.produit.idproduit}&action=detail"><b>${prod.produit.nomproduit}</b></a></td>
                                        <td><b><img style="width:50px; height:50px; " src="./images/${prod.produit.image}" alt="Cinque Terre"></b></td>                                                               
                                        <td><b>${prod.produit.marque.nom}</b></td>
                                        <td><b>${prod.produit.formatpro}</b></td>
                                        <td><b>${prod.quantite}</b></td>
                                        <td><b>${prod.produit.prix * prod.quantite}</b></td>                  
                                        <td>
                                            <form name="deleteForm"
                                                  action="ControPanier"
                                                  method="POST">
                                                <input type="submit" class="btn btn-btn" value=<fmt:message key="panier.btnsupp"/>>
                                                <input type="hidden" name= "delindex" value="${loop.index}">
                                                <input type="hidden" name="action" value="DELETE">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </center>
                    </div>
                </div>  
                     <div class="row">
                   
                        <div class="col-lg-6">  
                             <form action="ControPanier" method="post">
                            <input type="hidden" name="action" value="CHECKOUT"/>
                            <span><input style="width:100%;" type="submit" name="action" class="btn btn-dark" value=<fmt:message key="panier.btnpayer"/> /></span>
                             </form>     
                        </div>                      
                                              
                        <div class="col-lg-6"> 
                            <form action="init" method="post">
                            <input type="hidden" name="action" value="SHOPPING"/>
                            <span><input style="width:100%" type="submit" class="btn btn-dark" value=<fmt:message key="panier.btncontinuer"/> /></span>
                            </form> 
                        </div>                
                </div> 
                
            </c:when>
            <c:otherwise>
                <h4><fmt:message key="panier.vide"/></h4>
                <div class="row">
                    <div class="col-lg-12"> 
                        <form action="init" method="post">                          
                           
                                <input type="hidden" name="action" value="SHOPPING"/>
                                 <span><input style="width:100%" type="submit" class="btn btn-dark" value=<fmt:message key="panier.btncontinuer"/> /></span>
                             
                        </form> 
                    </div>  
                </div>
            </c:otherwise>
        </c:choose>        
   </div>
</div>
</body>
