package by.atmm.java.telegram_bot.telegram.service;

import by.atmm.java.telegram_bot.exception.ServiceException;

public interface TelegramBotService {

  String getUSDExchangeRate() throws ServiceException;

  String getEURExchangeRate() throws ServiceException;

}
