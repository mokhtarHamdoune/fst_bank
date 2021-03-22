/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique;


import com.fstbank.entity.Client;
import com.fstbank.entity.ClientProfessionel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class FabriqueProfessionnel implements FabriqueClient {
    ClientProfessionel c = null;
    BufferedReader brConsoleReader;
    String nom,adresse,num_tel,domaine;
    @Override
    public Client creeClient() {
        try {
               c = new ClientProfessionel();
               brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
               System.out.print("Entrer le nom de l'entreprise: ");      
               nom = brConsoleReader.readLine();
               c.setNom(nom);
               System.out.print("Entrer l'adresse: ");
               adresse =brConsoleReader.readLine();
               c.setAdresse(adresse);
               System.out.print("Entrer num Tel: ");
               num_tel =brConsoleReader.readLine();
               c.setNumTel(num_tel);
               System.out.print("Entrer le domaine de l'entreprise: ");
               domaine =brConsoleReader.readLine();
               c.setDomaine(domaine);
        } catch (IOException ex) {
            Logger.getLogger(FabriqueParticulier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  c;
        
    }
    
}
