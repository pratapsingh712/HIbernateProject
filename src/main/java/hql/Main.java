package hql;

import changing.ColumnName.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

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

        // select * from laptop where ram = 32; -> SQL
        //From laptop where ram = 32;

        Query query = session.createQuery("From Laptop");
        List<Laptop> laptops = query.getResultList();

        //Laptop l1 = session.find(Laptop.class,3);
        System.out.println(laptops);

        session.close();
        sf.close();
    }
}
