package by.atmm.java.__early.behavioral.observer.newsagency;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class App {
  public static void main(String[] args) {
    NewsAgency observable = new NewsAgency();
    NewsChannel observer = new NewsChannel();
    NewsChannel a1 = new NewsChannel();

    observable.addObserver(observer);
    observable.addObserver(a1);
    observable.setNews("news");
  }

}
