package com.example;

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
        l1.setModel("Inspiron");
    
        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Priyanka");
        a1.setTech("Java");
        a1.setLaptop(l1);
        
        SessionFactory sf = new Configuration()
                                .configure()
                                .addAnnotatedClass(Alien.class)
                                .addAnnotatedClass(Laptop.class)
                                .buildSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.persist(l1);
        s.persist(a1);
        tx.commit();
        Alien a2 = s.find(Alien.class, 1);
        System.out.println(a2);
        s.close();
        sf.close();
    }
}
