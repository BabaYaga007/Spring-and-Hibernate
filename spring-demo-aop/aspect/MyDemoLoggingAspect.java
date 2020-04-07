package awesome.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging 
	
	//lets start with an @Before advice
	
	
//	@Before("execution(public void awesome.aopdemo.dao.AccountDAO.addAccount())") 		//Pointcut expression
//	@Before("execution(public void add*())") 
//	@Before("execution(* add*(awesome.aopdemo.Account))") 
	//	@Before("execution(* add*(..))")
	@Before("execution(* awesome.aopdemo.dao.*.*(..))")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n---------> Executing @Before advice on AddAccount()");
	}
	
	
	
	
	
}
