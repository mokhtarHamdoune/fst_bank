/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.entity;

/**
 *
 * @author mokht
 */
public class Compte {
    protected int id;
    protected int solde;
    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
         this.id=id;
    }
    public int getSolde() {
        return this.solde;
    }
    
    public void setSolde(int solde){
        this.solde = solde;
    }

    
}
