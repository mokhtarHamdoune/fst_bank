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
public class ChercherById implements ChercherStrategy{
    public ClientParticulier chercherClien(BanquierSessionRemote session){
         BufferedReader brConsoleReader;
         ClientParticulier c=null;
         int id=0;
        try {
            brConsoleReader= new BufferedReader(new InputStreamReader(System.in)); 
            System.out.print("Entrer l'id de client : ");
            id = Integer.parseInt(brConsoleReader.readLine());
            System.out.println(id);
            c = session.chercherById(id);
        } catch (IOException ex) {
            Logger.getLogger(ChercherById.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
