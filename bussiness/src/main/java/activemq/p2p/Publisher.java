package activemq.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

/**
 * Created by hairui on 2018/10/22.
 */
@Component
public class Publisher {

    private Connection connection;
    private Session session;
    private MessageProducer producer;

//    @PostConstruct
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
        producer.send(destination, message);
    }

    public static void main(String[] args) throws JMSException {
        Publisher publisher = new Publisher();
        publisher.inti();
        publisher.sendMessage("JOBS.","i am producer 1");
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

}
