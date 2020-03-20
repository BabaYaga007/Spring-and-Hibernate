package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Course;
import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
			
			//create the objects
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code !!!");
			
			Instructor tempInstructor = new Instructor("Susan ", "Sexy", "sexy.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com", " being a bitch");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);			
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			session.save(tempInstructor); // this will also save the details object because cascaade type ALL
			System.out.println("Saving instructor: "+tempInstructor);
			
			//commit transaction		
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
			
			factory.close();
		}		
		
	}

}
