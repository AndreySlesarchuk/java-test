package by.atmm.java.telegram_bot.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value="MailService")
public class MailService {
  private final Environment env;

  private final JavaMailSender javaMailSender;

  @Autowired
  public MailService(Environment env, JavaMailSender javaMailSender) {
    this.env = env;
    this.javaMailSender = javaMailSender;
  }

  public void sendMail(String mailAddress, String title, String mailMessage) {
    log.info(this.getClass().getName() + ".SendMail Start!");

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(env.getProperty("spring.mail.from"));
    message.setTo(mailAddress);
    message.setSubject(title);
    message.setText(mailMessage);

    javaMailSender.send(message);

    log.info(this.getClass().getName() + ".SendMail End!");

  }

}
