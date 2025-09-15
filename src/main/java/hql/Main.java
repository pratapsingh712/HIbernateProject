package hql;

import changing.ColumnName.Alien;
import changing.ColumnName.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        changing.ColumnName.Laptop l1 = new changing.ColumnName.Laptop();
        l1.setLid(4);
        l1.setBrand("Asus");
        l1.setModel("Strix");
        l1.setRam(32);


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(changing.ColumnName.Laptop.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();



        transaction.commit();

        session.close();
        sf.close();
    }
}
