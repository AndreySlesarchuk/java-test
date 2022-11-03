package by.atmm.java.activemq.topics;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin"
                , "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("Demo-Topic");

            TextMessage textMessage = session.createTextMessage("Message for topic 2");

            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            System.out.println("Message published");

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}

