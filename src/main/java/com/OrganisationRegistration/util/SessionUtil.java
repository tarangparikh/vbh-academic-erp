package com.OrganisationRegistration.util;

import com.OrganisationRegistration.bean.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SessionUtil {
    private static final SessionFactory sessionFactory;

    static {
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        try 
        {
            Configuration configuration = new Configuration();

            //Uncomment the line below to use hibernate.cfg.xml
            configuration.configure();

            configuration.addAnnotatedClass(Organisation.class).addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).addAnnotatedClass(Department.class);

            sessionFactory = configuration.buildSessionFactory();
        } 
        catch (HibernateException ex) 
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
