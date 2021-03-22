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
import javax.ejb.Stateful;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mokht
 */
@Stateful
public class BanquierSession implements BanquierSessionRemote {
    
    @PersistenceContext(unitName="FTSBankPU")
    private EntityManager entityManager;

    public void creeClien(Client c) {
        entityManager.persist(c);
    }

    
    public void creeCompte (Compte cp) {
        entityManager.persist(cp);
    }
    
    public ArrayList<ClientParticulier> getListClient() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   

    public ClientParticulier chercherByCoord(String nom, String prenom) {
        Query q =  entityManager.createNativeQuery("SELECT * From clientparticulier c where c.nom= ? and c.prenom = ?", ClientParticulier.class);
        q.setParameter(1, nom);
        q.setParameter(2, prenom);
        ClientParticulier c = (ClientParticulier) q.getResultList().get(0);
        if(c!=null){
            System.out.println(c);
            return c;
        }else{
            return null;
        }
    }

    public ClientParticulier chercherById(int id) {
        ClientParticulier c = entityManager.find(ClientParticulier.class,id);
        System.out.println(c.getClass());
        if(c!=null){
            return c;
        }else{
            return null;
        }
    }
    public ComptePrive getComptePrive(int id){
        ComptePrive cp = entityManager.find(ComptePrive.class,id);
        System.out.println("from session "+cp.getId()+" "+cp.getSolde());
        if(cp!=null){
            return cp;
        }else{
            return null;
        }
    }
    public ComptePartage getComptePartager(int id){
        ComptePartage cp = entityManager.find(ComptePartage.class,id);
        System.out.println("from session "+cp.getId()+" "+cp.getSolde());
        if(cp!=null){
            return cp;
        }else{
            return null;
        }
    }
    
}
