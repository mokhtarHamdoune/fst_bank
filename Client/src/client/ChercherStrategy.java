package client;

import com.fstbank.entity.ClientParticulier;
import com.fstbank.session.BanquierSessionRemote;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mokht
 */
public interface ChercherStrategy {
    public ClientParticulier chercherClien(BanquierSessionRemote session);
}
