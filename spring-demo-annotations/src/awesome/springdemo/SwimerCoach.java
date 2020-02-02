package awesome.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Swim 50 lenghts and 100 breadths";
	}

	@Override
	public String getDailyFortune() {
		
		return null;
	}
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public void property() {
		System.out.println(team);
		System.out.println(email);
	}
}
