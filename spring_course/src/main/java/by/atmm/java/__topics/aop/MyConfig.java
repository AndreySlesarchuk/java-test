package by.atmm.java.__topics.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.atmm.java.aop")
@EnableAspectJAutoProxy
public class MyConfig {

}
