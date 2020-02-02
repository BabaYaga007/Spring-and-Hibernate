package awesome.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		//SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
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
