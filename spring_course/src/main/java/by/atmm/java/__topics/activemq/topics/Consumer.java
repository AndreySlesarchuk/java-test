package by.atmm.java.__topics.activemq.topics;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

  public static void main(String[] args) {

    ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

    try {
      Connection connection = factory.createConnection();
      connection.setClientID("1");
      connection.start();

      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      Topic topic = session.createTopic("Demo-topic");

      MessageConsumer consumer = session.createDurableSubscriber(topic, "Consumer-1");
      consumer.setMessageListener(new MessageListener() {
        @Override
        public void onMessage(Message message) {
          TextMessage textMessage = (TextMessage) message;
          try {
            System.out.println(textMessage.getText());
          }
          catch (JMSException e) {
            e.printStackTrace();
          }
        }
      });
    }
    catch (JMSException e) {
      e.printStackTrace();
    }
  }

}

