package activemq.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

/**
 * Created by hairui on 2018/10/22.
 * main测试用，多个发布方
 */

public class Publisher1 {

    private Connection connection;
    private Session session;
    private MessageProducer producer;

    public void inti()throws JMSException{
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(null);
    }

    public void sendMessage(String topic, String msg) throws JMSException {
        Destination destination = session.createQueue(topic);
        Message message = session.createObjectMessage(msg);
        System.out.println("Sending message: " + ((ObjectMessage) message).getObject() + " on queue: " + destination);
        while (true){
            try {
                Thread.sleep(1);
                producer.send(destination, message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws JMSException {
        Publisher1 publisher = new Publisher1();
        publisher.inti();
        publisher.sendMessage("JOBS.","i am producer 1");
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

}
