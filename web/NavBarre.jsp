
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="ControlPortail">VentePro</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="ControlPortail"><fmt:message key="barre.Accueil">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Langue<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ChangementLangue?language=en_CA">English</a></li>
          <li><a href="ChangementLangue?language=it_IT">Italiano</a></li>
          <li><a href="ChangementLangue?language=fr_CA">Français</a></li>       
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">       
        <li>         
                 <form class="navbar-form navbar-left" action="/action_page.php">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Search" name="search">
                      <div class="input-group-btn">
                      </div>
                    </div> 
                </form>
        </li>
       <li><a href="ControPanier?action=cart"><span class="glyphicon glyphicon-shopping-cart"></span><fmt:message key="barre.panier"/> (${count})</a></li>  
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>   
</nav>
     

