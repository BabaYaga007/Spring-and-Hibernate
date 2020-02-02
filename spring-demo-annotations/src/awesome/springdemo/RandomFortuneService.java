package awesome.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	public String[] array = {
		"Achint",
		"Arpana",
		"Ayushi",
		"Harsh",
		"Gaurang"
	};
	
	private Random ra = new Random();
	@Override
	public String getFortune() {
		
		int index = ra.nextInt(array.length);
		
		String fortune = array[index];
		return  fortune;
	}

}
