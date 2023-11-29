package by.atmm.java.telegram_bot.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

//@Component
public class BotComponentOld extends TelegramLongPollingBot {

  Environment env;
  // Создаём их объект для регистрации
  private final TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

  @Value("${telegram.bot.token}")
  private String botToken;

  @PostConstruct
  private void init() throws TelegramApiException, InterruptedException {
    telegramBotsApi.registerBot(this); // Регистрируем бота
    System.out.println("Start bot 2");
    TimeUnit.SECONDS.sleep(5);
    clearWebhook();
    onClosing();
  }

  public BotComponentOld() throws TelegramApiException, InterruptedException {
    System.out.println("Error bot 2");
//    this.botToken = "6270658660:AAGvMn1Ux_YLdbDKMqj8dnPxLmr3Ip37KG8";
//    init();
    this.onClosing();
  }

  @Override
  public void onClosing() {
    //Проверим, работает ли наш бот.
    this.exe.shutdown();
    System.out.println("Bot shutdown");
  }

  @Override
  public void onUpdateReceived(Update update) {
    //Проверим, работает ли наш бот.
//    System.out.println(update.getMessage().getText());
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