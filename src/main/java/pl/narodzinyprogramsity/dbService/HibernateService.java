package pl.narodzinyprogramsity.dbService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface HibernateService {
    boolean connect(String configFile);

    void disconnect();

    SessionFactory getConnection();

    void openSession();

    void closeSession();

    Session getSession();
}
