/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dao;

import ar.com.modelo.Persona;
import org.hibernate.SessionFactory;

/**
 *
 * @author yo
 */
public class PersonaDao extends GenericoDao<Persona, Integer>{

    public PersonaDao(SessionFactory factory) {
        super(factory);
    }
    
}
