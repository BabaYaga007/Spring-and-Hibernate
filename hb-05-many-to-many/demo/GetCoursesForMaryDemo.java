package awesome.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Course;
import awesome.hibernate.demo.entity.Instructor;
import awesome.hibernate.demo.entity.InstructorDetail;
import awesome.hibernate.demo.entity.Review;
import awesome.hibernate.demo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get student Red John from the database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Loaded Student : " +tempStudent);
			
			System.out.println("Courses of Student : " + tempStudent.getCourses());
			
			//create more courses 
//			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
//			Course tempCourse2 = new Course("How to win the game CONTRA");
//			
//			
//			//add student to courses
//			tempCourse1.addStudent(tempStudent);
//			tempCourse2.addStudent(tempStudent);
//			
//			//save the courses 
//			System.out.println("Saving the cou rses");
//			session.save(tempCourse2);
//			session.save(tempCourse1);
			
			
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
