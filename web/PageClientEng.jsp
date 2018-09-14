<%-- 
    Document   : PageClientEng
    Created on : 2018-09-14, 08:21:00
    Author     : Mohamed Amine Tarhouni, Gian Gabriele Ciampa
     ---
                 English version for the Client Page Login/Inscription
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
         <title>Proteins Sale - Client Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page="NavBarreEng.jsp"/>
         
        <div class="container">
            <div class="row">
                
                <div class="col-sm-6 " >
                    <div class="cellule gauche">
                        
                    
                    <form  class="well form-horizontal" name="ExistantClient" action="ControlClient" method="post">
  
                     <center><h2><b>I am an Existing Client</b></h2></center><br>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Email</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                             <input  value="${logincourrielv}" name="logincourriel" size="20" type="email">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Password</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${loginmdpv}" name="loginmdp" size="20"  type="password">
                        </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4"><br>
                        <input type="hidden" name="action" value="CLIENTEXISIT"/>    
                        <button type="submit" class="btn btn-warning" >OPEN SESSION<span class="glyphicon glyphicon-send"></span></button>
                        </div>
                    </div> 
                     
                    <h3>${MessageErreurLogin}</h3>
                    <input name ="langue" value="english" type="hidden"> 
                     
                    </form>    
                    </div>    
                </div>
                
                <div class="col-sm-6">
                 <div class="cellule droite">
                <form  class="well form-horizontal" name="CreationClient" action="CreationClient" method="post">
  
                     <center><h2><b>I am a new Client</b></h2></center><br>
                    <div class="form-group">
                        <label class="col-md-4 control-label">Firstname</label>  
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                             <input  value="${prenomv}" name="prenom" placeholder="Firstname - required" size="25" type="text" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Lastname</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${nomv}" name="nom" placeholder="LastName - required " size="25"  type="text" required>
                        </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Phone Number</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input value="${telephonev}" name="telephone" placeholder="Phone Number" size="25"  >
                            </div>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Street Number</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${nociviquev}" name="nocivique" placeholder="Street Number" size="25"  type="text">
                        </div>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Apartment #</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${noappv}" name="noapp" placeholder="Apartment #" size="25"  type="text">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Street Name</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${ruev}" name="rue" placeholder="Street Name" size="25"  type="text">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                         <label class="col-md-4 control-label" >City</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${villev}" name="ville" placeholder="City" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Province</label> 
                        <div class="col-md-4 inputGroupContainer">
                             <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${provincev}" name="province" placeholder="Province" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Country</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${paysv}" name="pays" placeholder="Country" size="25"  type="text">
                            </div>
                        </div>
                    </div>            
            
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Email</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input value="${courrielv}" name="courriel" placeholder="Email - required" size="25"  type="email" required >
                            </div>
                        </div>  
                    </div>            
    
                    <div class="form-group">
                         <label class="col-md-4 control-label" >Password</label> 
                         <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input value="${motdepassev}" name="motdepasse" placeholder="Password - required" size="25"  type="password" required>
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

