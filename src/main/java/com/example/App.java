package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Dell");
        l1.setModel("XPS 13");
        
        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Apple");
        l2.setModel("MacBook Pro");

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Priyanka");
        a1.setTech("Java");
        a1.setLaptops(List.of(l1, l2));
        
        // Alien a2 = new Alien();
        // a2.setAid(2);
        // a2.setAname("someone");
        // a2.setTech("Python");
        // a2.setLaptops(List.of(l2));

        SessionFactory sf = new Configuration()
                                .configure()
                                .addAnnotatedClass(Alien.class)
                                .addAnnotatedClass(Laptop.class)
                                .buildSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        s.persist(l1);
        s.persist(l2);
        s.persist(a1);
        //s.persist(a2);

        tx.commit();
        s.close();
        sf.close();
    }
}
