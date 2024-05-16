package by.atmm.java.__topics.threads;

import by.atmm.java.__topics.utils.MyLog;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

  public static void main(String[] args) {
    MyLog.log(test());
  }

  private static String test() {
    CompletableFuture.supplyAsync(() -> {
      // Имитация длительной операции
      try {
        TimeUnit.SECONDS.sleep(1);
      }
      catch (InterruptedException e) {
        throw new IllegalStateException(e);
      }
      return "Result of an asynchronous operation";
    }).thenApply(result -> result.toUpperCase()).thenAccept(result -> {
      System.out.println(result);
    }).exceptionally(ex -> {
      System.out.println("Произошла ошибка: " + ex.getMessage());
      return null;
    });
    return "The end.";
  }

}
