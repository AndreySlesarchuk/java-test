package by.atmm.java.telegram_bot.telegram.configuration;

import by.atmm.java.telegram_bot.telegram.bot.MyTelegramBot;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotConfiguration {

//  @Bean
//  public TelegramBotsApi telegramBotsApi(MyTelegramBot telegramBot) throws TelegramApiException {
//    var api = new TelegramBotsApi(DefaultBotSession.class);
//    api.registerBot(telegramBot);
//    return api;
//  }

  @Bean
  public OkHttpClient okHttpClient() {
    return new OkHttpClient();
  }


}
