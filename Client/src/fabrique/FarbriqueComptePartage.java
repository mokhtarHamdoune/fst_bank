/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique;

import com.fstbank.entity.Compte;
import com.fstbank.entity.ComptePartage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokht
 */
public class FarbriqueComptePartage implements FabriqueCompte {
    ComptePartage cpar = null;
    BufferedReader brConsoleReader;
    int solde;
    @Override
    public Compte creeCompte() {
        try {
            cpar = new ComptePartage();
            brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entre le sold de compte:");
            solde = Integer.parseInt(brConsoleReader.readLine());
            cpar.setSolde(solde);
        } catch (IOException ex) {
            Logger.getLogger(FabriqueComptePrive.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpar;
    }
    
}
