package awesome.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import awesome.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session =factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();	
			
			//display the students
			displayStudents(theStudents);
			
			//query students : lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display the Students 
			System.out.println("\nAll the students with last Name 'Doe' ");
			displayStudents(theStudents);
			
			//query students : lastName ='Doe' or firstname ="james"
			theStudents = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='James'").getResultList();
			
			//display the Students 
			System.out.println("\nAll the students with last Name 'Doe' or first Name = James ");
			displayStudents(theStudents);
			
			//query students where email LIKE '%awesome.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display the Students 
			System.out.println("\nAll the students with email LIKE '%awesome.com' ");
			displayStudents(theStudents);

			//commit transaction		
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
		}
		finally {
			factory.close();
		}		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
