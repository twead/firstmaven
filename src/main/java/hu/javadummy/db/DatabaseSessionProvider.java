package hu.javadummy.db;

import hu.javadummy.entities.Aircraft;
import hu.javadummy.entities.Tank;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseSessionProvider {

    private static DatabaseSessionProvider instance = null;
    private Session sessionObj;


    private DatabaseSessionProvider() {
        configDatabase();
    }

    public static DatabaseSessionProvider getInstance() {
        if (instance == null) {
            instance = new DatabaseSessionProvider();
        }
        return instance;
    }

    public Session getSessionObj() {
        return sessionObj;
    }

    private void configDatabase() {
        Configuration configObj = new Configuration();

        configObj.addAnnotatedClass(Tank.class);
        configObj.addAnnotatedClass(Aircraft.class);

        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "Admin123");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionObj = configObj.buildSessionFactory(serviceRegistryObj).openSession();
    }
}