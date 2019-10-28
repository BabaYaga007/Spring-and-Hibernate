package awesome.springdemo;

public class ChessCoach implements FortuneService {

	@Override
	public String getFortune() {
		String[] arr = new String[3];
		arr[0]="Achint";
		arr[1]="is";
		arr[2]="awesome";
		
		return arr[2] ;
	}

}
