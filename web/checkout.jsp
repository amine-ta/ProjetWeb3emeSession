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

<body>
    <jsp:include page="NavBarre.jsp"/>

    <div class="container"> 
        <c:choose>
            <c:when test="${shoppingcart != null  && shoppingcart.size() > 0 }">
                <div class="row">

                    <div class="col-lg-12">
                        <h3><fmt:message key="checkout.panier"/>  <span class="glyphicon glyphicon-shopping-cart"></span> </h3>
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
                                    <td><b>Total :</b></td>
                                    <td><b>${amount}</b></td>
                                </tr>
                            </table>
                        </center>
                    </div>

                </div>            

            </c:when>
            <c:otherwise>
                <h4>Votre Panier est Vide</h4>
            </c:otherwise>
        </c:choose>      
        <form action="detailProduit" method="post">                          
            <div class="col-lg-12"> 
                <input type="hidden" name="action" value="SHOPPING"/>
                <input type="hidden" name="pageJSP" value="checkout.jsp"/>
                <span><input type="submit" class="btn btn-info" value="Continue Shopping" /></span>
            </div>  
        </form> 

    </div> 

</body>
