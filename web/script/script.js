function startSearch(){
                      var url = "detailProduit?search=" + document.getElementById("search").value;
                    
                    var req=new XMLHttpRequest()

                    req.open("GET", url, true);

                    req.onreadystatechange = callback;//fonction utilisateur

                    req.send(null);
                }
                
                
                
function callback() {
    clearTable();

    if (req.readyState == 4) {
        if (req.status == 200) {
           
            parseMessages(req.responseXML);  // affichage
            
        }
    }
}
