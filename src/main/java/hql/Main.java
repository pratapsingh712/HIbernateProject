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
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        changing.ColumnName.Laptop l2 = new changing.ColumnName.Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(16);

        changing.ColumnName.Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(8);

        changing.ColumnName.Alien a = new changing.ColumnName.Alien();
        a.setAid(101);
        a.setAname("Navin");
        a.setTech("Java");

        changing.ColumnName.Alien a1 = new changing.ColumnName.Alien();
        a1.setAid(102);
        a1.setAname("Harsh");
        a1.setTech("Python");

//        Alien a2 = new Alien();
//        a2.setAid(103);
//        a2.setAname("Kiran");
//        a2.setTech("AI");

        a.setLaptop(Arrays.asList(l1,l2));
        a1.setLaptop(Arrays.asList(l3));
//        a1.setLaptop(Arrays.asList(l1));

//        l1.setAlien(Arrays.asList(a,a2));
//        l2.setAlien(Arrays.asList(a,a1));
//        l3.setAlien(Arrays.asList(a2));

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(changing.ColumnName.Alien.class);
        cfg.addAnnotatedClass(changing.ColumnName.Laptop.class); // for creating a new table in the DB -> laptop
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);


        session.persist(a);
        session.persist(a1);
//        session.persist(a2); I have commented this part for eager and lazy fetch

        transaction.commit();

        session.close();

        Session session1 = sf.openSession();

        changing.ColumnName.Alien a5 = session1.find(Alien.class,101);
        System.out.println(a5);

        session1.close();
        sf.close();

    }
}
