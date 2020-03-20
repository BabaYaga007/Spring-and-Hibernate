package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Course;
import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;
import awesome.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//create a course 
			Course tempCourse = new Course ("Pacman - How to Score One Million Points ");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course .. Loved it !"));
			tempCourse.addReview(new Review("one hell of a course bro"));
			tempCourse.addReview(new Review("thats a badly illustrated course "));
			
			//save the course ... and leverage the cascade all
			System.out.println("Saving the course ");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
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
