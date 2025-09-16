package impl.Ehcache.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(impl.Ehcache.Level.Laptop.class)
                .configure()
                .buildSessionFactory();


        Session session = sessionFactory.openSession();

        Laptop l1 = session.find(Laptop.class,2);
        System.out.println(l1);
        Laptop l2 = session.find(Laptop.class,2);
        System.out.println(l2);

        session.close();
        sessionFactory.close();
    }
}
