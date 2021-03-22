/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique;

import com.fstbank.entity.Compte;
import com.fstbank.entity.ComptePrive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokht
 */
public class FabriqueComptePrive implements FabriqueCompte{
    ComptePrive cpri = null;
    BufferedReader brConsoleReader;
    int solde;
    @Override
    public Compte creeCompte() {
        try {
            cpri = new ComptePrive();
            brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entre le sold de compte:");
            solde = Integer.parseInt(brConsoleReader.readLine());
            cpri.setSolde(solde);
        } catch (IOException ex) {
            Logger.getLogger(FabriqueComptePrive.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpri;
    }
    
}
