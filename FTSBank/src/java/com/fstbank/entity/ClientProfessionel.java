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

/**
 *
 * @author mokht
 */
@Entity
public class ClientProfessionel extends Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String domaine;
    private String nom;
    private String adresse;
    private String num_tel;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDomaine(String domaine){
        this.domaine = domaine;
    }
   
    public String getDomaine(){
        return this.domaine;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresse(){
        return this.adresse;
    }
   
    public void setNumTel(String num_tel){
        this.num_tel = num_tel;
    }
    
    public String getNumTel(){
        return this.num_tel;
    }

    @Override
    public String toString() {
        return "com.fstbank.entity.ClientProfessionel[ id=" + id + " ]";
    }
    
}
