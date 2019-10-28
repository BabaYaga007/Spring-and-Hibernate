package awesome.springdemo;

public class Baseballcoach implements Coach {
	
	//define a private field  for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency
	public Baseballcoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on the batting practice";
	}

	@Override
	public String getDailyFortune() {
		//use my fortuneService to get a fortune
		return fortuneService.getFortune() ;
	}
	
}
