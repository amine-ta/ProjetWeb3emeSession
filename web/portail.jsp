<%-- 
    Document   : portail
    Created on : 2018-08-30, 18:20:25
    Author     : Mohamed Amine Tarhouni et Gian Gabriele Ciampa
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Ventes protein</title>
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
            <div class="row">
                <div class="col-lg-12">
                    <div id="main" class="cellule grand">
                        <div id="myCarousel" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                <li data-target="#myCarousel" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img  src="images/2017-08-ban-p28.jpg" alt="Los Angeles" >
                                </div>

                                <div class="item">
                                    <img src="images/2017-08-ban-get-performance.jpg" alt="Chicago">
                                </div>

                                <div class="item">
                                    <img src="images/2017-08-ban-beyond.jpg" alt="New york" style="width:100%;">
                                </div>
                            </div>

                            <!-- Left and right controls -->
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>            

            </div>                
            <div class="row">

                <div class="col-sm-6">
                    <div class="form-group">
                        <form action="detailProduit" methode="POST">   
                            <select class="form-control" name ="marque" onchange="this.form.submit();">
                                <option>Magasiner Par Marque</option>
                                <c:forEach var = "marque" items="${ListMarque}">
                                    <option>${marque.nom}</option>
                                </c:forEach>

                            </select>
                        </form>    
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <form action="detailProduit" methode="POST">  
                            <select class="form-control" name="categorie" onchange="this.form.submit();">
                                <option>Magasiner Par Catégorie</option>
                                <c:forEach var = "categorie" items="${ListCategorie}">
                                    <option>${categorie.nomcategorie}</option>
                                </c:forEach>
                            </select>
                        </form> 
                    </div>
                </div>

            </div>
            <div class="row">
                <c:forEach var = "produit" items="${ListPoduit}">
                    <div class="col-lg-3"> 
                        <div class="cellule grand">  
                            <a href="detailProduit?id=${produit.idproduit}&action=detail"> 
                                <div class="image">
                                    <img src="./images/${produit.image}" alt="Cinque Terre"/>
                                </div>   
                            </a>    
                            <hr>                                     
                            <div class="description">                                

                                <b id="prix">Prix :${produit.prix} $</b><br>                                 
                                <b style="color:${(produit.quantiteenstock <=0)?"RED" :"GREEN"}">État :${(produit.quantiteenstock <=0)?"Épuisé" :"Disponible"}</b>

                                <hr>
                                <form  action="ControPanier" method="post">  
                                    <input type="hidden"  name="qteSaisie" value="1"  />  
                                    <input type="hidden"  name="idItem" value="${produit.idproduit}"/>
                                    <input type="hidden"  name="action" value="portail" />
                                    <input type="${(produit.quantiteenstock <=0)?"HIDDEN" :"SUBMIT"}"  class="btn btn-info " value="Ajouter au panier" />
                                </form>                                     
                            </div>
                        </div>     
                    </div>  
                </c:forEach>
            </div>
        </div>
    </body>
</html>
