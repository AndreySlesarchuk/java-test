package by.atmm.gof.behavioral.observer.newsagency;

import java.util.logging.Logger;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class NewsChannel implements Channel {
  private static final Logger LOGGER = Logger.getLogger(NewsChannel.class.getName());

  private String news;

  @Override
  public void update(Object news) {
    this.setNews((String) news);
    LOGGER.info(String.format("%s get news: %s", this.getClass().getName(), news));
  }

  public String getNews() {
    return news;
  }

  public void setNews(String news) {
    this.news = news;
  }

}