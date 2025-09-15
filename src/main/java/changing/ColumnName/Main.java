package changing.ColumnName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Alien a = new Alien();
        a.setAid(101);
        a.setAname("Navin");
        a.setTech("Java");
        a.setLaptop(l1);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(changing.ColumnName.Alien.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a);
        transaction.commit();

        Alien a2 = session.find(Alien.class,101);
        System.out.println(a2);
        session.close();
        sf.close();
    }
}
