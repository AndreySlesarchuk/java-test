package by.atmm.javaspringtestproject.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("by.atmm.javaspringtestproject.aop")
@EnableAspectJAutoProxy
public class MyConfig {

}
