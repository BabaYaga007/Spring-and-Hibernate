package awesome.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

		
//	@Before("execution(public void awesome.aopdemo.dao.AccountDAO.addAccount())") 		//Pointcut expression
//	@Before("execution(public void add*())") 
//	@Before("execution(* add*(awesome.aopdemo.Account))") 
//	@Before("execution(* add*(..))")
//	@Before("forDAOPackage()")
	@Before("awesome.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n---------> Executing @Before advice on AddAccount()");
	}
	


	
}
