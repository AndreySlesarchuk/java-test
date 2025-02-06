package by.atmm.spring_boot.aspect;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class RateLimitConfig {
//  @Value("${rate.limit.requests}")
  private int requests = 5;

//  @Value("${rate.limit.seconds}")
  private int seconds = 60;
}