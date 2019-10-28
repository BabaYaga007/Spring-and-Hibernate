package awesome.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class practice2 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext(Practice).xml");
		
		//retrieve bean from spring container 
		Coach theCoach = context.getBean("myBasketballCoach",Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}

}
