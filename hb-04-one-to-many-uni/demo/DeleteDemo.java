package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;
import awesome.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
				
			//start a transaction
			session.beginTransaction();
			
			//get transactions 
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId); //gives the instructor with the id
			
			System.out.println("Found the instructor : "+tempInstructor);
		
			//delete the instructor 
			if(tempInstructor != null ) {
				
				System.out.println("Deleting : "+tempInstructor);
				
				
				//This will also delete the object related to it because of CascadeType = ALL
				session.delete(tempInstructor);
				
			}
			
			//commit transaction		
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}		
		
	}

}
