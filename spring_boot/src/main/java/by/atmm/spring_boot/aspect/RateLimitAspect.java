package by.atmm.spring_boot.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RateLimitAspect {
  @Autowired
  private RateLimitConfig rateLimitConfig;

  @Autowired
  private RateLimiterA rateLimiter;

  @Around("@annotation(RateLimited)")
  public Object enforceRateLimit(ProceedingJoinPoint joinPoint) throws Throwable {
    // Get the current request from the JoinPoint
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = requestAttributes.getRequest();

    String key = getKey(request);
    if (!rateLimiter.tryAcquire(key, rateLimitConfig.getRequests(), rateLimitConfig.getSeconds())) {
      throw new IllegalArgumentException("Rate limit exceeded");
    }
    return joinPoint.proceed();
  }

  private String getKey(HttpServletRequest request) {
    // Get the IP address of the client making the request
    String ipAddress = request.getRemoteAddr();
    return ipAddress; // Use IP address as the key
  }
}