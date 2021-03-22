/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.fstbank.entity.ClientParticulier;
import com.fstbank.session.BanquierSessionRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mokht
 */
public class ChercherByCoord implements ChercherStrategy{
    
    public ClientParticulier chercherClien(BanquierSessionRemote session){
        BufferedReader brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
        String nom,prenom;
        ClientParticulier c=null;
        try{
            
            brConsoleReader= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Entrer le nom de client: ");
            nom = brConsoleReader.readLine();
            System.out.print("Entrer le prenom de client: ");
            prenom = brConsoleReader.readLine();
            System.out.println("9bal mawaslak walo a si mohammed");
            c= (ClientParticulier) session.chercherByCoord(nom, prenom);
            System.out.println("mor mawaslak walo a si mohammed");
            if(c==null){
                System.out.println("mawaslak walo a si mohammed");
            }
        }catch(IOException ex){
             Logger.getLogger(ChercherById.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
