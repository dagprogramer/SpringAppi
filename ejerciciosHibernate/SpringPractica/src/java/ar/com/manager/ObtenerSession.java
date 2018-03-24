/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.manager;

import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
public class ObtenerSession {
    private SessionFactory factory;
    
    public SessionFactory getSessionFactory(){
        factory=SessionManager.getSession();
        return factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
    
    
}
