/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique;

import com.fstbank.entity.Compte;
import com.fstbank.entity.CompteProfessionel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokht
 */
public class FabriqueCompteProfessionnel implements FabriqueCompte{
    CompteProfessionel cpro = null;
    BufferedReader brConsoleReader;
    int solde;
    @Override
    public Compte creeCompte() {
        try {
            cpro = new CompteProfessionel();
            brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entre le sold de compte:");
            solde = Integer.parseInt(brConsoleReader.readLine());
            cpro.setSolde(solde);
        } catch (IOException ex) {
            Logger.getLogger(FabriqueComptePrive.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cpro;
    }
    
}
