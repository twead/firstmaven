package hu.javadummy.repositories;

import hu.javadummy.db.DatabaseSessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public abstract class AbstractRepository {

    protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }

}