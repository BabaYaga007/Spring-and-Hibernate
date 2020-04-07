package awesome.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration		//for Spring pure Java configuration
@EnableAspectJAutoProxy  		//to support Spring AOP proxy
@ComponentScan("awesome.aopdemo")
public class DemoConfig {

}
