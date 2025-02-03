package by.atmm.spring_boot.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RateLimitingFilter implements Filter {
  // Map to store request counts per IP address
  private final Map<String, AtomicInteger> requestCountsPerIpAddress = new ConcurrentHashMap<>();

  // Maximum requests allowed per minute
  private static final int MAX_REQUESTS_PER_MINUTE = 5;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    String ipAddress = httpServletRequest.getRemoteAddr();

    // Initialize request count for the client IP address
    requestCountsPerIpAddress.putIfAbsent(ipAddress, new AtomicInteger(0));
    AtomicInteger requestCount = requestCountsPerIpAddress.get(ipAddress);
    requestCount.incrementAndGet();

    // Increment the request count
    int requests = requestCount.incrementAndGet();

    // Check if the request limit has been exceeded
    if (requests > MAX_REQUESTS_PER_MINUTE) {
      httpServletResponse.setStatus(HttpServletResponse.SC_REQUEST_URI_TOO_LONG);
      httpServletResponse.getWriter().write("Too many requests. Please try again later.");
      return;
    }

    // Allow the request to proceed
    chain.doFilter(request, response);

    // Optional: Reset request counts periodically (not implemented in this simple example)

  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
