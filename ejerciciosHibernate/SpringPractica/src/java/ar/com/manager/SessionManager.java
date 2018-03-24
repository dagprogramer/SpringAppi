/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.manager;

import ar.com.modelo.Persona;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author yo
 */
public class SessionManager {
    
    public static SessionFactory getSession()throws HibernateException{
        Configuration configuration=new Configuration();
        mapeoClases(configuration);
        configuration.setProperties(getHibernateProperties());
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory factory=configuration.buildSessionFactory(builder.build());
        return factory;
    }

    private static void mapeoClases(Configuration configuration) throws MappingException{
        configuration.addAnnotatedClass(Persona.class);
    }

    private static Properties getHibernateProperties() {
        Properties properties=new Properties();
        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/abm");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    
    
}
