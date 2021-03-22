/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mokht
 */
@Entity
public class ClientParticulier extends Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String prenom;
    private Date datenaissance;
    private String nom;
    private String adresse;
    private String numtel;
   /* @OneToMany(mappedBy="cp")
    private List <ComptePrive>  comptes_prive = new ArrayList<ComptePrive>();*/
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public void setDateNaissance(Date date_naissance){
        this.datenaissance = date_naissance;
    }
    
    
    public Date getDateNaissance(){
        return this.datenaissance;
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
        this.numtel = num_tel;
    }
    
    public String getNumTel(){
        return this.numtel;
    }
 
   /* public void setListComptesPrive(ComptePrive cp){
        comptes_prive.add(cp);
        cp.setClientParticulier(this);
    }
    
    public List<ComptePrive> getListComptesPrive(){
        return comptes_prive;
    }*/
    
    
}
