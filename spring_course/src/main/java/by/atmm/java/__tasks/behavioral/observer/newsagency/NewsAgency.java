package by.atmm.java.__tasks.behavioral.observer.newsagency;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Andrey Slesarchuk on 07/26/2020.
 */
public class NewsAgency {
  private static final Logger LOGGER = Logger.getLogger(NewsAgency.class.getName());

  private String news;

  private List<Channel> channels = new ArrayList<>();

  public void addObserver(Channel channel) {
    this.channels.add(channel);
  }

  public void removeObserver(Channel channel) {
    this.channels.remove(channel);
  }

  public void setNews(String news) {
    this.news = news;
    LOGGER.info(String.format("NewsAgency set news: %s", news));
    for (Channel channel : this.channels) {
      channel.update(this.news);
    }
  }

}