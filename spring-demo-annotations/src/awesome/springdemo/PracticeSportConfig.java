package awesome.springdemo;

import org.springframework.context.annotation.Bean;

public class PracticeSportConfig {

	// define bean for fortuneService
	@Bean 
	public FortuneService RESTFortuneService(){
		return new RESTFortuneService();
	}
	
	//define bean for pinball coach and inject fortune service dependency	
	@Bean 
	public Coach pinballCoach() {
		PinballCoach pincoach = new PinballCoach(RESTFortuneService());
		return pincoach;
	}
}
