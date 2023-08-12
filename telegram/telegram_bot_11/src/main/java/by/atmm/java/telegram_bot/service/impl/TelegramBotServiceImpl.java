package by.atmm.java.telegram_bot.service.impl;

import by.atmm.java.telegram_bot.client.CbrClient;
import by.atmm.java.telegram_bot.exception.ServiceException;
import by.atmm.java.telegram_bot.service.TelegramBotService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

@Service
public class TelegramBotServiceImpl implements TelegramBotService {

  private static final String USD_XPATH = "/ValCurs//Valute[@ID='R01235']/Value";

  private static final String EUR_XPATH = "/ValCurs//Valute[@ID='R01239']/Value";

  private final CbrClient client;

  public TelegramBotServiceImpl(CbrClient client) {
    this.client = client;
  }

  @Override
  public String getUSDExchangeRate() throws ServiceException {
    var xmlOptional = client.getCurrencyRatesXML();
    String xml = xmlOptional.orElseThrow(() -> new ServiceException("Не удалось получить XML"));
    return extractCurrencyValueFromXML(xml, USD_XPATH);
  }

  @Override
  public String getEURExchangeRate() throws ServiceException {
    var xmlOptional = client.getCurrencyRatesXML();
    String xml = xmlOptional.orElseThrow(() -> new ServiceException("Не удалось получить XML"));
    return extractCurrencyValueFromXML(xml, EUR_XPATH);
  }

  private static String extractCurrencyValueFromXML(String xml, String xpathExpression) throws ServiceException {
    var source = new InputSource(new StringReader(xml));
    try {
      var xpath = XPathFactory.newInstance().newXPath();
      var document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);

      return xpath.evaluate(xpathExpression, document);
    }
    catch (XPathExpressionException e) {
      throw new ServiceException("Не удалось распарсить XML", e);
    }
  }
}