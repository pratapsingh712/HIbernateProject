package changing.ColumnName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a = new Alien();
        a.setAid(101);
        a.setAname("Navin");
        a.setTech("Java");


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(changing.ColumnName.Alien.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a);
        transaction.commit();

        session.close();
        sf.close();
    }
}
