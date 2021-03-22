/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.session;

import com.fstbank.entity.Client;
import com.fstbank.entity.ClientParticulier;
import com.fstbank.entity.Compte;
import com.fstbank.entity.ComptePartage;
import com.fstbank.entity.ComptePrive;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author mokht
 */
@Remote
public interface BanquierSessionRemote {
   public void creeClien(Client c);
   public void creeCompte(Compte cp);
   public ClientParticulier chercherByCoord(String name,String prenom);
   public ClientParticulier chercherById(int id);
   public ArrayList<ClientParticulier> getListClient();
   public ComptePrive getComptePrive(int id);
   public ComptePartage getComptePartager(int id);
}
