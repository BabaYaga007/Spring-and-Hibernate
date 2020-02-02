package awesome.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component           //thatSillyCoach is the bean-id
//@Scope("prototype")                  
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach () {
		System.out.println("TennisCoach : Inside Default Constructor");
	}
	
	//define my init method
	@PostConstruct
	public void StartupStuff() {
		System.out.println("tennisCoach -> inside MyStartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void CleanupStuff() {
		System.out.println("tennisCoach -> inside CleanupStuff");
	}
	
	
	/*
	//define a setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) { 
		System.out.println("TennisCoach : Inside setFortuneService() setter method");
		this.fortuneService=fortuneService;
	}
	*/

	/*
	@Autowired
	public TennisCoach (FortuneService thefortuneService) {
		
		fortuneService=thefortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {

		return "Practice backhand volley shot";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
	

}
