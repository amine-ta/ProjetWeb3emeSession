<%-- 
    Document   : checkout.jsp
    Created on : 2018-09-07, 09:02:37
    Author     : Mohamed Amine Tarhouni, Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value = "${sessionScope.langueCourante}"/>
<fmt:setBundle basename="Langage"/>


<head>
    <title>Vente/Sale</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" type="text/css" rel="stylesheet" />


</head>

<body class="container">
    <jsp:include page="NavBarreCheckout.jsp"/>

    <div> 
        <c:choose>
            <c:when test="${shoppingcart != null  && shoppingcart.size() > 0 }">
                <div class="row">
                    <div>
                                    <td><b><fmt:message key="checkout.nofacture"/>${nofacture}</b></td>
                                    <td><b><fmt:message key="checkout.nocommande"/>${nocommandeF}</b></td>
                                    <td><b><fmt:message key="checkout.courriel"/>${boncourriel}</b></td>
                                    </div>
                                    <br/>
                    <div class="col-lg-12">
                        <h3><fmt:message key="checkout.panier"/>  <span class="glyphicon glyphicon-shopping-cart"></span> </h3>
                        <center>
                            <table border="0" class="table table-hover" width="100%" >
                                <tr>
                                
                                    <td><b><fmt:message key="checkout.nom"/></b></td>
                                    <td><b><fmt:message key="checkout.marque"/></b></td>                               
                                    <td><b><fmt:message key="checkout.format"/></b></td>
                                    <td><b><fmt:message key="checkout.qte"/></b></td>
                                    <td><b><fmt:message key="checkout.prix"/>($)</b></td>
                                    <td><b></b></td>
                                </tr>


                                <c:forEach  varStatus="loop"  var="prod" items="${shoppingcart}">
                                    <tr>
                                        <td><b>${prod.produit.nomproduit}</b></a></td>
                                        <td><b>${prod.produit.marque.nom}</b></td>
                                        <td><b>${prod.produit.formatpro}</b></td>
                                        <td><b>${prod.quantite}</b></td>
                                        <td><b>${prod.produit.prix * prod.quantite}</b></td>                        

                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>                                    
                                    <td><b><fmt:message key="checkout.sstotal"/> :</b></td>
                                    <td><b>${soustotal}</b></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>                                    
                                    <td><b>TPS (${TPSval}) :</b></td>
                                    <td><b>${TPS}</b></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>                                    
                                    <td><b>TVQ (${TVQval}) :</b></td>
                                    <td><b>${TVQ}</b></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>                                    
                                    <td><b><fmt:message key="checkout.total"/> :</b></td>
                                    <td><b>${amount}$</b></td>
                                </tr>
                            </table>
                        </center>
                    </div>

                </div>            

            </c:when>
            <c:otherwise>
                <h4><fmt:message key="checkout.message"/></h4>
            </c:otherwise>
        </c:choose> 
        <div class="row">
            <div class="col-lg-6">      
                <form action="init" method="post">                          
                    
                        <input type="hidden" name="action" value="SHOPPING"/>
                        <span><input type="submit" class="btn btn-info" value=<fmt:message key="checkout.bouton"/> /></span>
                   
                </form> 
            </div>  
            <div class="col-lg-6"> 
                <form action="ControlPaiement" method="post">                          
                
                        <input type="hidden" name="action" value="PayerCommande"/>
                        <span><input type="submit" class="btn btn-info" value=<fmt:message key="checkout.PayerCommande"/> /></span>
               
                </form> 
            </div>
        </div>   
    </div> 

</body>
