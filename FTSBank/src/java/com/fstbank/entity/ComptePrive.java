/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mokht
 */
@Entity
public class ComptePrive extends Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int solde;
    /*@ManyToOne
    private ClientParticulier cp;*/
    
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
    
    /*public void setClientParticulier(ClientParticulier cp){
        this.cp = cp;
    }

     public ClientParticulier getClientParticulier(){
        return this.cp;
    }
*/
    
    @Override
    public String toString(){
        return "Compte prive : id :"+this.getId()+" sold : "+this.getSolde();
    }
    
}
