<%-- 
    Document   : PageClient
    Created on : 2018-09-07, 09:02:37
    Author     : Mohamed Amine Tarhouni, Gian Gabriele Ciampa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
   
   <head>
        <title><fmt:message key="titre.pageclient"/></title>
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
                
                <div class="col-sm-6 " >
                    <div class="cellule gauche">
                        
                    
                    <form  class="well form-horizontal" name="ExistantClient" action="ControlClient" method="post">
  
                     <center><h2><b><fmt:message key="connexion.titre"/></b></h2></center><br>
                    <div class="form-group">
                        <label class="col-md-4 control-label"><fmt:message key ="connexion.Courriel"/></label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                             <input  value="${logincourrielv}" name="logincourriel" size="23" type="email">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" ><fmt:message key="connexion.mdp"/></label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${loginmdpv}" name="loginmdp" size="23"  type="password">
                        </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>
                        <input type="hidden" name="action" value="CLIENTEXISIT"/>    
                        <button type="submit" class="btn btn-warning" ><fmt:message key="connexion.bouton"/><span class="glyphicon glyphicon-send"></span></button>
                        </div>
                    </div> 
                     
                    <h3>${MessageErreurLogin}</h3>
                     
                  
                    </form>    
                    </div>    
                </div>
                
                <div class="col-sm-6">
                 <div class="cellule droite">
                <form  class="well form-horizontal" name="CreationClient" action="CreationClient" method="post">
  
                    <center><h2><b><fmt:message key="client.titre" /></b></h2></center><br>
                    <div class="form-group">
                        <label class="col-md-4 control-label"><fmt:message key="client.prenom"/></label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                             <input  value="${prenomv}" name="prenom" size="25" type="text" required placeholder=<fmt:message key="client.requis"/>>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Nom</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${nomv}" name="nom" size="25"  type="text" required placeholder=<fmt:message key="client.requis"/>>
                        </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Téléphone</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input value="${telephonev}" name="telephone" size="25"  >
                            </div>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Numéro civique</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${nociviquev}" name="nocivique" size="25"  type="text">
                        </div>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Appartement</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${noappv}" name="noapp" size="25"  type="text">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Rue</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${ruev}" name="rue"  size="25"  type="text">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                         <label class="col-md-4 control-label" >Ville</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${villev}" name="ville" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Province</label> 
                        <div class="col-md-4 inputGroupContainer">
                             <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${provincev}" name="province" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Pays</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${paysv}" name="pays" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Courriel</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input value="${courrielv}" name="courriel" size="25"  type="email" required placeholder=<fmt:message key="client.requis"/>>
                            </div>
                        </div>  
                    </div>            
    
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Mot de passe</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${motdepassev}" name="motdepasse" size="25"  type="password" required placeholder=<fmt:message key="client.requis"/>>
                            </div>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>
                        <button type="submit" class="btn btn-warning" >INSCRIPTION<span class="glyphicon glyphicon-send"></span></button>
                        </div>
                    </div>
                    <h3>${MessageErreurCourriel}</h3> 
                </form> 
                </div>
                </div>     
            </div>        
            
    </body>
</html>
