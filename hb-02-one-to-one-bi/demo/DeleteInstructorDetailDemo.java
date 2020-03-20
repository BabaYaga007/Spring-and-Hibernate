package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;
import awesome.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
				
			//start a transaction
			session.beginTransaction();
			
			//get instructor detail object
			int theId = 4;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the object
			System.out.println("Instructor detail object : "+tempInstructorDetail);
			//print the transaction
			System.out.println("tempInstructorDetail : "+tempInstructorDetail.getInstructor());
			
			//deleting the object 
			System.out.println("Deleting the object : "+tempInstructorDetail);
			
			// remove the bidirectional link
			//remove the associated object reference
			tempInstructorDetail.getInstructor().setInstructorDetail(null); // breaks the bidirectional link
			
			session.delete(tempInstructorDetail);
			
			//commit transaction	
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//handle the connection close leak
			session.close();
			
			factory.close();
		}		
		
	}

}
