package by.atmm.java.activemq.queues;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin"
                , "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            TextMessage textMessage = session.createTextMessage("Second message");

            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            System.out.println("Message Published");

            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}

