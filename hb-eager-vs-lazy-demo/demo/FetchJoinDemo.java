package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import awesome.hibernate.demo.entity.Course;
import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
//			Instructor tempInstructor =session.get(Instructor.class, theId); 
			
			//this query will load all the instructors at once 
			Query<Instructor> query =
					session.createQuery("select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId ", Instructor.class);
			//using the second method to load data after the session closes - using HQL (Hibernate Query language)
			
			//set parameter on query
			query.setParameter("theInstructorId",theId);
			
			//execute query and get instructor
			Instructor tempInstructor =query.getSingleResult();
			
			System.out.println("Aesomeness : Instructor :" + tempInstructor );
			
			//get courses for the Instructor
//			System.out.println("Awesomeness : Courses : " + tempInstructor.getCourses());
			
			
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
