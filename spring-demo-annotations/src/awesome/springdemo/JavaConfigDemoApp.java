package awesome.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//SwimerCoach theCoach = context.getBean("swimerCoach", SwimCoach.class);
		//Coach aCoach = context.getBean("swimCoach",Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		//System.out.println(aCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		//theCoach.property();
		
		//close the context
		context.close();

	}

}
