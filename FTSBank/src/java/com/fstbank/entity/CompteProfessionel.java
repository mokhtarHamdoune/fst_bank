/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mokht
 */
@Entity
public class CompteProfessionel  extends Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int solde;
   /* @OneToOne
    private ClientProfessionel cpro;*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
   /* public void setClientProfessionel(ClientProfessionel cpro){
        this.cpro = cpro;
    }

     public ClientProfessionel getClientProfessionel(){
        return this.cpro;
    }*/
    
}
