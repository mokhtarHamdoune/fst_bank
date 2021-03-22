/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstbank.session;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author mokht
 */
@Remote
public interface ClientSessiosRemote {
 
    public int consulter( int code ,int solde);
    public void virement(int montant , int code);
    public void retrait(int montant , int code);
    public void imprimer();
}
