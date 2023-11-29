package by.atmm.java.telegram_bot.ratelimiter.impl;

import by.atmm.java.telegram_bot.ratelimiter.RateLimiter;
import by.atmm.java.telegram_bot.ratelimiter.model.Request;
import by.atmm.java.telegram_bot.ratelimiter.model.TimeFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SlidingWindowRateLimiterConcurrencyTest {

  public static final String USER_ID = "1";

  private RateLimiter rateLimiter;

  @BeforeEach
  void setUp() {

  }

  @RepeatedTest(1000)
  void should_works_concurrently_as_sequentially() {
    // given
    var threadsCount = 10;
    var limit = 5;
    var requestResults = makeParallelRequests(threadsCount, limit);

    // then
    assertThat(requestResults).containsExactly(entry(false, 5L), entry(true, 5L));
  }

  private Map<Boolean, Long> makeParallelRequests(int threadsCount, int limit) {
    var executor = Executors.newFixedThreadPool(threadsCount);
    var timeFrame = new TimeFrame(1L, ChronoUnit.MINUTES);
    var time = of(2000, 1, 1, 1, 1);
    var request = new Request(time, USER_ID);
    rateLimiter = new SlidingWindowRateLimiter(limit, timeFrame, () -> time);
    var list = new ArrayList<Future<Boolean>>();
    var barrier = new CyclicBarrier(threadsCount);

    // when
    for (int i = 0; i < threadsCount; i++) {
      var requestResult = executor.submit(() -> {
        barrier.await();
        return rateLimiter.hit(request);
      });
      list.add(requestResult);
    }

    executor.shutdown();
    try {
      executor.awaitTermination(1L, TimeUnit.MINUTES);
    }
    catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    var requestResults = groupRequestsBySuccess(list);
    return requestResults;
  }

  private static Map<Boolean, Long> groupRequestsBySuccess(ArrayList<Future<Boolean>> list) {
    return list.stream().map(booleanFuture -> {
      try {
        return booleanFuture.get();
      }
      catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
      return null;
    }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

}