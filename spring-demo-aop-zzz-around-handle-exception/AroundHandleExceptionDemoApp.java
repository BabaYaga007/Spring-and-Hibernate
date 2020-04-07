package awesome.aopdemo;

import java.util.logging.Logger;

//import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import awesome.aopdemo.dao.AccountDAO;
import awesome.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName()); 
	

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from Spring controller 
		TrafficFortuneService theFortuneService =context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program : Around Demo App");
		
		myLogger.info("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is : "+ data) ;
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
		 
		
	}

}
