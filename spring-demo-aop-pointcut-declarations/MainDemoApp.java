package awesome.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import awesome.aopdemo.dao.AccountDAO;
import awesome.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from Spring controller 
		AccountDAO theAccountDAO =context.getBean("accountDAO",AccountDAO.class);
		
		//get membership bean from spring container
		MembershipDAO theMembershipDAO =context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		Account myAccount =new  Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		//call the membership method
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
		//do it again 
//		System.out.println("\n Call the method one more time");
//		theAccountDAO.addAccount();
		
		//close the context
		context.close();
		
		
	}

}
