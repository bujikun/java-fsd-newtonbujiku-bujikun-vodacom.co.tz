package co.tz.vodacom.bujikun.flyaway.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseResource {
    private static SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void close(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

}
