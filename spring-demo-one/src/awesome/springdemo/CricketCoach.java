package awesome.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// add new fields for email address and team
	private String emailaddress;
	private String team;
	
	public void setEmailaddress(String emailaddress) {
		System.out.println("CricketCoach:inside setter method = setEmailAddress");
		this.emailaddress = emailaddress;
	}
	
	public String getEmailaddress() {
		return emailaddress;
	}


	public void setTeam(String team) {
		System.out.println("CricketCoach:inside setter method = setTeam");

		this.team = team;
	}
	
	public String getTeam() {
		return team;
	}


	//create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach:inside no=arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach:inside setter method = setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Bat five overs";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
		
	}

}
