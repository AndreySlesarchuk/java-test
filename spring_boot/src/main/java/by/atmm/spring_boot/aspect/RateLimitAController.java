package by.atmm.spring_boot.aspect;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitAController {
  @RateLimited
  @GetMapping("/api/testa")
  public ResponseEntity<String> getResource() {
    return ResponseEntity.ok("Hello World");
  }
}
