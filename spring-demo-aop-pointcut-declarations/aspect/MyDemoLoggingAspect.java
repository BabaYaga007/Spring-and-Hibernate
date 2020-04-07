package awesome.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging 
	
	//lets start with an @Before advice
	
	@Pointcut("execution(* awesome.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
		
//	@Before("execution(public void awesome.aopdemo.dao.AccountDAO.addAccount())") 		//Pointcut expression
//	@Before("execution(public void add*())") 
//	@Before("execution(* add*(awesome.aopdemo.Account))") 
	//	@Before("execution(* add*(..))")
	@Before("forDAOPackage()")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n---------> Executing @Before advice on AddAccount()");
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n --------> Performing API analytics");
	}
	
	
	
}
