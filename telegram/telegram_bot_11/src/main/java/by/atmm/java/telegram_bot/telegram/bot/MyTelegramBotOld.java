package by.atmm.java.telegram_bot.telegram.bot;

import by.atmm.java.telegram_bot.exception.ServiceException;
import by.atmm.java.telegram_bot.mail.MailService;
import by.atmm.java.telegram_bot.ratelimiter.RateLimiter;
import by.atmm.java.telegram_bot.ratelimiter.impl.SlidingWindowRateLimiter;
import by.atmm.java.telegram_bot.ratelimiter.model.Request;
import by.atmm.java.telegram_bot.telegram.service.TelegramBotService;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@Component
public class MyTelegramBotOld extends TelegramLongPollingBot {

  private static final Logger LOG = LoggerFactory.getLogger(MyTelegramBotOld.class);

  private static final String START = "/start";

  private static final String USD = "/usd";

  private static final String EUR = "/eur";

  private static final String EMAIL = "/email";

  private static final String HELP = "/help";

  private final Environment env;

  private final TelegramBotService telegramBotService;

  private final MailService mailService;

  private final RateLimiter rateLimiter;

  public MyTelegramBotOld(@Value("${telegram.bot.token}") String botToken, Environment env, TelegramBotService telegramBotService, MailService mailService) {
    super(botToken);
    this.env = env;
    this.telegramBotService = telegramBotService;
    this.mailService = mailService;
    this.rateLimiter = new SlidingWindowRateLimiter();
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (!update.hasMessage() || !update.getMessage().hasText()) {
      return;
    }

    var request = new Request(LocalDateTime.now(), update.getMessage().getChatId().toString());
    var isLimitReached = !rateLimiter.hit(request);

    if (isLimitReached) {
      return;
    }

    String message = update.getMessage().getText();
    Long chatId = update.getMessage().getChatId();
    switch (message) {
      case START:
        String userName = update.getMessage().getChat().getUserName();
        startCommand(chatId, userName);
        break;
      case USD:
        usdCommand(chatId);
        break;
      case EUR:
        eurCommand(chatId);
        break;
      case EMAIL:
        emailCommand(chatId);
        break;
      case HELP:
        helpCommand(chatId);
        break;
      default:
        unknownCommand(chatId, message);
        break;
    }
  }

  @Override
  public String getBotUsername() {
    return env.getProperty("telegram.bot.name");
  }

  private void startCommand(Long chatId, String userName) {
    var text = "Добро пожаловать в бот, %s! \n" + "Здесь Вы сможете узнать официальные курсы валют на сегодня, установленные ЦБ РФ.\n"
        + "И подписаться на расслку новостей.\n" + "Для этого воспользуйтесь командами:\n" + "/usd - курс доллара\n" + "/eur - курс евро\n"
        + "/email - добавление почтового ящика в рассылку\n\n" + "/Дополнительные команды:\n" + "//help - получение справки\n";
    var formattedText = String.format(text, userName);
    sendMessage(chatId, formattedText);
  }

  private void usdCommand(Long chatId) {
    String formattedText;
    try {
      var usd = telegramBotService.getUSDExchangeRate();
      var text = "Курс доллара на %s составляет %s рублей";
      formattedText = String.format(text, LocalDate.now(), usd);
    }
    catch (ServiceException e) {
      LOG.error("Ошибка получения курса доллара", e);
      formattedText = "Не удалось получить текущий курс доллара. Попробуйте позже.";
    }
    sendMessage(chatId, formattedText);
  }

  private void eurCommand(Long chatId) {
    String formattedText;
    try {
      var usd = telegramBotService.getEURExchangeRate();
      var text = "Курс евро на %s составляет %s рублей";
      formattedText = String.format(text, LocalDate.now(), usd);
    }
    catch (ServiceException e) {
      LOG.error("Ошибка получения курса евро", e);
      formattedText = "Не удалось получить текущий курс евро. Попробуйте позже.";
    }
    sendMessage(chatId, formattedText);
  }

  private void emailCommand(Long chatId) {
    String formattedText;
    var text = "Введите пожалуйста ваш email:";
    formattedText = String.format(text, LocalDate.now(), "");
    sendMessage(chatId, formattedText);
  }

  private boolean isValidEmailAddress(String email) {
    return EmailValidator.getInstance().isValid(email);
  }

  private void helpCommand(Long chatId) {
    var text =
        "Справочная информация по боту\n" + "/Для получения текущих курсов валют воспользуйтесь командами:\n" + "//usd - курс доллара\n" + "//eur - курс евро";
    sendMessage(chatId, text);
  }

  private void unknownCommand(Long chatId, String message) {
    var text = "Не удалось распознать команду!";
    if (isValidEmailAddress(message)) {
      mailService.sendMail(message, "Test", "Ваш код: 2023");
      text = "Спасибо. Ваш емейл добавлен в рассылку и выслан код верификации";
    }
    sendMessage(chatId, text);
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
