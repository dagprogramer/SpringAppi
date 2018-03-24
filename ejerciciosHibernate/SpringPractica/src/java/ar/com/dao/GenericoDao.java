/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yo
 */
public class GenericoDao <E,PK extends Serializable>{
    private SessionFactory factory;

    public GenericoDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    public Class<E>getTipo(){
        ParameterizedType supper=(ParameterizedType)getClass().getGenericSuperclass();
        Type[]args=supper.getActualTypeArguments();
        return (Class<E>)args[0];
    }
    
    public E getById(PK id){
        Session session=factory.openSession();
        E e=(E)session.get(getTipo(), id);
        return e;
    }
    
    public PK save(E e){
        Session session=null;
        Transaction tx=null;
        try {
            session=factory.openSession();
            tx=session.beginTransaction();
            PK id=(PK)session.save(e);
            tx.commit();
            return id;
        } catch (HibernateException ex) {
            if(tx!=null){
                tx.rollback();
            }
            throw ex;
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    public void update(E e){
        Session session=null;
        Transaction tx=null;
        try {
            session=factory.openSession();
            tx=session.beginTransaction();
            session.update(e);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null){
                tx.rollback();
            }
            throw ex;
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    public void delete(E e){
        Session session=null;
        Transaction tx=null;
        try {
            session=factory.openSession();
            tx=session.beginTransaction();
            session.delete(e);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx!=null){
                tx.rollback();
            }
            throw ex;
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    public List<E>select(){
        Session session=factory.openSession();
        String query="from "+getTipo().getName();
        Query q=session.createQuery(query);
        List<E>lista=q.list();
        return lista;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
    
    
}
