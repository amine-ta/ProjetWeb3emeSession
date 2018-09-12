<%-- 
    Document   : panier
    Created on : 2018-09-07, 08:53:36
    Author     : Mohamed Amine Tarhouni et Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<head>
    <title>Ventes protéines</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" type="text/css" rel="stylesheet" />


</head>

<body>
    <jsp:include page="NavBarre.jsp"/>

    <div class="container"> 
        <c:choose>
            <c:when test="${shoppingcart != null  && shoppingcart.size() > 0 }">
                <div class="row">

                    <div class="col-lg-12">
                        <h3>Votre panier d'achat  <span class="glyphicon glyphicon-shopping-cart"></span> </h3>
                        <center>
                            <table border="0" class="table table-hover" width="100%" >
                                <tr>
                                    <td><b>Nom produit</b></td>
                                    <td><b>Marque produit</b></td>                               
                                    <td><b>Format</b></td>
                                    <td><b>Quantité</b></td>
                                    <td><b>Prix ($)</b></td>
                                    <td><b></b></td>
                                </tr>

                                <c:forEach  varStatus="loop"  var="prod" items="${shoppingcart}">
                                    <tr>
                                        <td><a href="detailProduit?id=${prod.produit.idproduit}&action=detail"><b>${prod.produit.nomproduit}</b></a></td>
                                        <td><b>${prod.produit.marque.nom}</b></td>
                                        <td><b>${prod.produit.formatpro}</b></td>
                                        <td><b>${prod.quantite}</b></td>
                                        <td><b>${prod.produit.prix * prod.quantite}</b></td>                        
                                        <td>
                                            <form name="deleteForm"
                                                  action="ControPanier"
                                                  method="POST">
                                                <input type="submit" class="btn btn-primary" value="Delete">
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
                    <form action="ControPanier" method="post">

                        <div class="col-lg-6">                       
                            <input type="hidden" name="action" value="CHECKOUT"/>
                            <span><input type="submit" name="action" class="btn btn-info" value="Checkout" /></span>
                        </div> 

                    </form>     
                    <form action="detailProduit" method="post">                          
                        <div class="col-lg-6"> 
                            <input type="hidden" name="action" value="SHOPPING"/>
                            <span><input type="submit" class="btn btn-info" value="Continue Shopping" /></span>
                        </div>  
                    </form> 
                </div> 
                <a href="Test" >pdf</a>
            </c:when>
            <c:otherwise>
                <h4>Votre Panier est Vide</h4>
                <div class="row">
                    <div class="col-lg-12"> 
                        <form action="detailProduit" method="post">                          
                           
                                <input type="hidden" name="action" value="SHOPPING"/>
                                <span><input type="submit" class="btn btn-info" value="Continue Shopping" /></span>
                             
                        </form> 
                    </div>  
                </div>
            </c:otherwise>
        </c:choose>           
</div>
</body>
