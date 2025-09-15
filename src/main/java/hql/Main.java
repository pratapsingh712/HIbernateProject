package hql;

import changing.ColumnName.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Laptop l1 = new changing.ColumnName.Laptop();
//        l1.setLid(4);
//        l1.setBrand("Asus");
//        l1.setModel("Strix");
//        l1.setRam(32);


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(changing.ColumnName.Laptop.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Laptop l1 = session.find(Laptop.class,3);
        System.out.println(l1);

        session.close();
        sf.close();
    }
}
