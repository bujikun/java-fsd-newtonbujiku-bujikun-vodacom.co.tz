package co.tz.vodacom.bujikun.flyaway.listener;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener("ContextListener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Create database tables
        DatabaseResource.getSessionFactory().openSession().close();
        System.out.println("CONTEXT ON");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //ServletContextListener.super.contextDestroyed(sce);
    }
}
