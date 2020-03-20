package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Course;
import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor
			int theId =1;
			Instructor tempInstructor =session.get(Instructor.class, theId); 
			
//			//create courses
//			Course tempCourse1 = new Course("Spring boot");
//			Course tempCourse2 = new Course("React + Redux");
//			
//			// add courses to the instructor
//			tempInstructor.add(tempCourse1);
//			tempInstructor.add(tempCourse2);
//			
//			//save the courses
//			session.save(tempCourse2);
//			session.save(tempCourse1);
			
			System.out.println("Aesomeness : Instructor :" + tempInstructor );
			
			//get courses for the Instructor
			System.out.println("Awesomeness : Courses : " + tempInstructor.getCourses());
			
			
			//commit transaction		
			session.getTransaction().commit();
			
			//close the session 
			session.close();  // this will fail because the courses are lazy loaded			
			
			System.out.println("\nSession is now closed\n\n");
			
			//get courses for the Instructor
			System.out.println("Awesomeness : Courses : " + tempInstructor.getCourses());
			// we have already loaded the data from the server , so this line will still work even after the session closes
			//this is the first way of dealing with the fetching data after the session closes, - call getter method wile session is open 
			
			
			System.out.println("Done");
			
		}
		finally {
			session.close();
			
			factory.close();
		}		
		
	}

}
