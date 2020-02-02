package awesome.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		//SwimerCoach theCoach = context.getBean("swimerCoach", SwimCoach.class);
		//Coach aCoach = context.getBean("swimCoach",Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(aCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		//theCoach.property();
		
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());

		
		//close the context
		context.close();

	}

}
