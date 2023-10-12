// Q.2)Create Car Entity class with different annotation.

package com.Swapnil.Car;

// importing all necessary library
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	//creating object of POJO class
    	Car car = new Car();
    	// setting all fields
    	car.setId(20);
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear(2022);
        
        
        
        // application to specify properties and mapping documents to be used when creating a SessionFactory
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Car.class);
        // for  creation of Session instances
        
		SessionFactory sf = cfg.buildSessionFactory();
		
		// offer create, read and delete operations for instances of mapped entity classes.
        Session ses = sf.openSession();
        // used for commit and transaction management
        Transaction txn = ses.beginTransaction();
        // saving object into database
        ses.save(car);
        txn.commit();
        
        
        
    }
}
