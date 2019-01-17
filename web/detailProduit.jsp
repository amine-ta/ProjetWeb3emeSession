<%-- 
    Document   : detailProduit
    Created on : 3 sept. 2018, 00:05:07
    Author     : Mohamed Amine Tarhouni et Gian Gabriele Ciampa
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
        <link href="css/style.css" type="text/css" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>JSP Page</title>
    </head>
    <body >
      
        <jsp:include  page="NavBarre.jsp"/>
<div class="container">
        <div> 
            <div class="row">
                <div class="col-sm-6">
                    <div class="detail" >
                        <img src="./images/${detailProduit.image}" alt="Cinque Terre"> 
                    </div>
                </div> 

                <div class="col-sm-6">

                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.marque"/></h2>
                            <p>${detailProduit.marque.nom}</p>
                            <hr>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.nom"/></h2>
                            <p>${detailProduit.nomproduit}</p>
                            <hr>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.categorie"/></h2>
                            <p>${detailProduit.categorie.nomcategorie}</p>
                            <hr>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.qtestk"/></h2>
                            <p>${detailProduit.quantiteenstock}</p>
                            <hr>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.format"/></h2>
                            <p>${detailProduit.formatpro}</p>   
                            <br>
                            <hr>
                        </div>  
                    </div>    
                    <div class="row">
                        <div class="col-lg-12">
                            <h2><fmt:message key="detail.prix"/></h2>
                            <p>${detailProduit.prix} $</p>   
                            <br>
                            <hr>
                        </div>  
                    </div>          
                    <div class="row">
                        <div class="col-lg-12">
                            <form name="ADDFORM" action="ControPanier" method="POST">
                                <div class="col-sm-6">
                                    <label id="qte"><fmt:message key="detail.qte"/>:  </label>
                                    <input type="${(detailProduit.quantiteenstock <=0)? "hidden" :"text"}"  name="qteSaisie" value="1"  />                                 
                                </div>
                                <div class="col-sm-6">
                                    <input type="hidden"  name="idItem" value="${detailProduit.idproduit}"/>
                                    <input type="hidden"  name="action" value="ADD" />
                                    <input type="${(detailProduit.quantiteenstock <=0)? "HIDDEN" :"SUBMIT"}" class="btn btn-info " value=<fmt:message key="detail.bouton"/> />
                                     <h4 style="color:red"> ${MessageErreurQteEnStockProd}</h4>
                                </div>
                                <hr>    

                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">                           
                            <div class="col-lg-12">
                                <h2><fmt:message key="detail.desc"/></h2>
                                <p>${detailProduit.descriptionFr}</p>                              
                            </div>                                                      
                        </div>
                    </div>                
                </div> 
            </div>
        </div> 
     </div>                       
    </body>
</html>
