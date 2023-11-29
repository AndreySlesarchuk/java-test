package by.atmm.java.telegram_bot.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class BotComponent extends TelegramLongPollingBot {

  @Value("${telegram.bot.token}")
  private String botToken;

  @PostConstruct
  private void init() {
    //    TimeUnit.SECONDS.sleep(5);
    System.out.println("2 start");
    try {
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
      telegramBotsApi.registerBot(this); // Регистрируем бота
    }
    catch (TelegramApiException e) {
      System.out.println("Regiser bot 2 Error");
    }
  }

  public BotComponent() throws TelegramApiException {
    System.out.println("Error 2");
  }

  @Override
  public void onUpdateReceived(Update update) {
    //Проверим, работает ли наш бот.
    System.out.println(update.getMessage().getText());
  }

  @Override
  public String getBotUsername() {
    return "bot";
  }

  @Override
  public String getBotToken() {
    return botToken;
  }
}