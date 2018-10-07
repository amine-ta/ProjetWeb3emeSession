/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMethodes;

import DAO.FactureDAO;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gcia_
 */
public class GestionnaireFacture {
    
    
    
    public static BigDecimal recupererDernierIDCommande() {
        BigDecimal increment;
        BigDecimal incrementor = new BigDecimal("1");

        Object obj = FactureDAO.recupererDernierIDFacture();

        // S'il n'y a aucun client dans la BDD, on démarre les ID à 1001, sinon
        // on incrémente de 1 le dernier ID récupéré.
        if (obj != null) {
            increment = (BigDecimal) obj;
            increment = increment.add(incrementor);
        } else {
            increment = (new BigDecimal(10001));
        }

        return increment;
    }
    
}
