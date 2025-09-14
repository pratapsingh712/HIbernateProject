package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        s.setRoll_No(7);
        s.setS_Name("Ram");
        s.setS_Age(18);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
//
//        SessionFactory sf = cfg.buildSessionFactory();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class).
                configure().
                buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s); // instead of this earlier session.save(object); was used but to match the JPA standard naming convention it was changed to persist

        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s);
    }
}
