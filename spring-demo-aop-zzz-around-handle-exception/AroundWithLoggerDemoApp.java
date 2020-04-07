package awesome.aopdemo;

import java.util.logging.Logger;

//import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import awesome.aopdemo.dao.AccountDAO;
import awesome.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName()); 
	

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from Spring controller 
		TrafficFortuneService theFortuneService =context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program : Around Demo App");
		
		myLogger.info("Calling getFortune()");
		
		boolean tripWire= true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy fortune is : "+ data) ;
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
		 
		
	}

}
