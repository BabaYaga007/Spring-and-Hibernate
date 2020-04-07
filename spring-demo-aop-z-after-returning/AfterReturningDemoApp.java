package awesome.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import awesome.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from Spring controller 
		AccountDAO theAccountDAO =context.getBean("accountDAO",AccountDAO.class);
		
		//call the methods to find all the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//display the accounts
		System.out.println("In Main Program : AfterRetruningDemoApp");
		System.out.println("--------------------");
		
		System.out.println(theAccounts + "\n");
		

		
		//close the context
		context.close();
		
		
	}

}
