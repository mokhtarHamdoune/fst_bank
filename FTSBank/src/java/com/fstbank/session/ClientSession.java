/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.session;

import com.fstbank.entity.Compte;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mokht
 */
@Stateful
public class ClientSession implements ClientSessiosRemote {
    @PersistenceContext(unitName="FTSBankPU")
    private EntityManager em;
 
    public int consulter(int code ,int solde){   
     Compte c;
     c = em.find(Compte.class, code);
      if (c == null) {
            throw new RuntimeException("compte n'existe pas");
        }
      int s= c.getSolde();
      
      return s;
    }
    
    public void virement(int montant , int code){
        Compte s = em.find(Compte.class, code);
        s.setSolde(s.getSolde()+montant);
    }
    
    public void retrait(int montant , int code){
        Compte s = em.find(Compte.class, code);
        if(s.getSolde()<montant)throw new RuntimeException("solde inssufisant");
        else s.setSolde(s.getSolde()-montant);
    }
    
    public void imprimer(){}
    
}
