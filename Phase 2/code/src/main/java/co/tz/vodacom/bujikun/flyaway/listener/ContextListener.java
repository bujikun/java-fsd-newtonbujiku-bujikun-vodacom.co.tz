package co.tz.vodacom.bujikun.flyaway.listener;

import co.tz.vodacom.bujikun.flyaway.config.DataInit;
import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener("ContextListener")
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Create database tables
        DatabaseResource.getSessionFactory().openSession().close();
        DataInit.populateDatabase();
        new FlightService().findAll().forEach(System.out::println);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //ServletContextListener.super.contextDestroyed(sce);
        try {
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
