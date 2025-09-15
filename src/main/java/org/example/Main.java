package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
//        s.setRoll_No(6);
//        s.setS_Name("Parvati");
//        s.setS_Age(18); commenting this part so that I can perform the delete operation

//        Student s1 = new Student();

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

        Transaction transaction = session.beginTransaction(); //we need transaction when we are performing insert, update or delete not when fetching the data

//        s1 = session.find(Student.class,1);

        //session.persist(s); // instead of this earlier session.save(object); was used but to match the JPA standard naming convention it was changed to persist

//        session.merge(s);

        s = session.find(Student.class,5);

        session.remove(s);
        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s); // if you want to perform something like s1.getName or s1.getAge then it's good idea to use try catch because it can throw null pointer exception

    }
}