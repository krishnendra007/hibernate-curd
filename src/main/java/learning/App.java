package learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Setting data in database
        // OLD Method 
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        //Transaction tx = session.beginTransaction();

        //Using Service Registory
        // Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        // ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceResgistry();
        // SessionFactory sf = con.buildSessionFactory(reg);
        // Session session = sf.openSession();
        // Transaction tx = session.beginTransaction();
        // Alien test = new Alien();
        // test.setAid(1018);
        // test.setAname("k");
        // test.setColor("green");
        // //session.save(test);
        // session.persist(test);
        // tx.commit();


        //Getting data from database
        // Alien test2;
        // test2 = (Alien)session.get(Alien.class, 1012);
        // tx.commit();
        // System.out.println(test2);
        
        
        //Embeeded objects

        AlienName an = new AlienName();
        an.setFname("Krish");
        an.setLname("Sharma");
        an.setMname("Kumar");
        Alien test = new Alien();
        test.setAid(1018);
        test.setColor("green");
        test.setAname(an);
        Transaction tx = session.beginTransaction();
        session.persist(test);
        tx.commit();

    }
}
