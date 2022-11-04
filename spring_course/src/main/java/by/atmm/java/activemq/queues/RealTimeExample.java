package by.atmm.java.activemq.queues;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

import javax.jms.*;

public class RealTimeExample {

    public static void main(String[] args) {

        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin"
                , "tcp://localhost:61616");

        try {
            Connection connection = factory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("demo");

            JSONObject json = new JSONObject();
            json.put("from date", "2022-11-02");
            json.put("from date", "2022-11-02");
            json.put("email", "abc@gmail.com");
            json.put("query", "select * from data");

            TextMessage textMessage = session.createTextMessage(json.toString());

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

