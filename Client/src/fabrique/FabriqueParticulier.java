/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrique;


import com.fstbank.entity.Client;
import com.fstbank.entity.ClientParticulier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class FabriqueParticulier implements FabriqueClient{
    BufferedReader brConsoleReader;
    String nom,prenom,adresse,num_tel;
    Date date_naissance;
    ClientParticulier c=null;
    @Override
    public Client creeClient() {
        
        try {
               c = new ClientParticulier();
               brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
               System.out.print("Entrer le nom de client: ");      
               nom = brConsoleReader.readLine();
               c.setNom(nom);
               System.out.print("Entrer le prenom de client: ");
               prenom = brConsoleReader.readLine();
               c.setPrenom(prenom);
               System.out.print("Entrer la date de naissance (yyyy-mm-dd): ");
               date_naissance = Date.valueOf(brConsoleReader.readLine());
               c.setDateNaissance(date_naissance);
               System.out.print("Entrer l'adresse: ");
               adresse =brConsoleReader.readLine();
               c.setAdresse(adresse);
               System.out.print("Entrer num Tel: ");
               num_tel =brConsoleReader.readLine();
               c.setNumTel(num_tel);
        } catch (IOException ex) {
            Logger.getLogger(FabriqueParticulier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  c;
    }
    
}
