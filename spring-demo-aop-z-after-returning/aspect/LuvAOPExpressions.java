package awesome.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpressions {

	//this is where we add all of our related advices for logging 
	
	//lets start with an @Before advice
	
	@Pointcut("execution(* awesome.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	//create pointcut for getter methods
	@Pointcut("execution(* awesome.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create pointcut for setter methods
	@Pointcut("execution(* awesome.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package ... exclude getter and setter 
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
	
	
}
