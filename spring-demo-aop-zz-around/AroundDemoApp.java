package awesome.aopdemo;

//import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import awesome.aopdemo.dao.AccountDAO;
import awesome.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from Spring controller 
		TrafficFortuneService theFortuneService =context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n Main Program : Around Demo App");
		
		System.out.println("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is : "+ data) ;
		
		System.out.println("Finished");
		
		//close the context
		context.close();
		 
		
	}

}
