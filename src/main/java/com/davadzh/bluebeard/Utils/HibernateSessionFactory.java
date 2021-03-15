package com.davadzh.bluebeard.Utils;

import com.davadzh.bluebeard.DAL.Master;
import com.davadzh.bluebeard.DAL.MasterWorkType;
import com.davadzh.bluebeard.DAL.WorkType;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory(){}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Master.class);
                configuration.addAnnotatedClass(WorkType.class);
                configuration.addAnnotatedClass(MasterWorkType.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;

    }
}
