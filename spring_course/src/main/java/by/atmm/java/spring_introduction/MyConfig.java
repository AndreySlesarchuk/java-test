package by.atmm.java.spring_introduction;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("MyApp.properties")
// @ComponentScan("by.atmm.java.spring_introduction")
public class MyConfig {

  @Bean
  @Scope("singleton")
  public Pet catBean() {
    return new Cat();
  }

  @Bean
  @Scope("prototype")
  public Person personBean() {
    return new Person(catBean());
  }

}
