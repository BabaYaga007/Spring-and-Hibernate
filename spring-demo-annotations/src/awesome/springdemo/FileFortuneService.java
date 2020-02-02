package awesome.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "C:/My Space/Fortunes.txt";
	private List<String> theFortunes;
	
	//create a random number generator
	private Random rand = new Random();
	
	public FileFortuneService() {
		
		File theFile = new File(fileName);
		
		//System.out.println("Reading fortunes from file: " + theFile);
		//System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from file
		try (BufferedReader br = new BufferedReader(
				new FileReader(theFile))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	@Override
	public String getFortune() {
		
		int index = rand.nextInt(theFortunes.size());
		
		String fortune = theFortunes.get(index);
		return  fortune;
	}

}
