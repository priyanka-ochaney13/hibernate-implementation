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

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Lenovo");
        l3.setModel("ThinkPad X1");

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Priyanka");
        a1.setTech("Java");
        
        Alien a2 = new Alien();
        a2.setAid(2);
        a2.setAname("Mitesh");
        a2.setTech("Python");

        Alien a3 = new Alien();
        a3.setAid(3);
        a3.setAname("Ankush");
        a3.setTech("JavaScript");
        
        // Setting up Many-to-Many relationships
        a1.setLaptops(List.of(l1, l2));
        a2.setLaptops(List.of(l2, l3));
        a3.setLaptops(List.of(l1, l3));

        l1.setAliens(List.of(a1, a3));
        l2.setAliens(List.of(a1, a2));
        l3.setAliens(List.of(a2, a3));

        SessionFactory sf = new Configuration()
                                .configure()
                                .addAnnotatedClass(Alien.class)
                                .addAnnotatedClass(Laptop.class)
                                .buildSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        s.persist(l1);
        s.persist(l2);
        s.persist(l3);
        s.persist(a1);
        s.persist(a2);
        s.persist(a3);

        tx.commit();
        s.close();
        sf.close();
    }
}
