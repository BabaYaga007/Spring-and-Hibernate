package awesome.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		//get the bean from spring container
		Coach theCoach = context.getBean("pinballCoach", Coach.class);
		
		//call the two methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();

	}

}
