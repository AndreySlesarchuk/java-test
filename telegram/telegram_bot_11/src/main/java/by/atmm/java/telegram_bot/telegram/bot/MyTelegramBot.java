package by.atmm.java.telegram_bot.telegram.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {
  @Value("${telegram.bot.token}")
  private String botToken;

  private static final Logger LOG = LoggerFactory.getLogger(MyTelegramBot.class);

  @Autowired
  private Environment env;

  @PostConstruct
  private void init() {
    System.out.println("1 start");
    try {
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
      telegramBotsApi.registerBot(this); // Регистрируем бота
    }
    catch (TelegramApiException e) {
      System.out.println("Regiser bot 1 Error");

    }
  }

  public MyTelegramBot() {
    System.out.println("Error 1");
  }

  @Override
  public void onUpdateReceived(Update update) {
    //Проверим, работает ли наш бот.
    System.out.println(update.getMessage().getText());
  }


  @Override
  public String getBotUsername() {
    return env.getProperty("telegram.bot.name");
  }

  @Override
  public String getBotToken() {
    return botToken;
  }

  private void sendMessage(Long chatId, String text) {
    var chatIdStr = String.valueOf(chatId);
    var sendMessage = new SendMessage(chatIdStr, text);
    try {
      execute(sendMessage);
    }
    catch (TelegramApiException e) {
      LOG.error("Ошибка отправки сообщения", e);
    }
  }

}
