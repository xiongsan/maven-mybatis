package aboutZookeeper.distribute_lock.dis_test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hairui on 2018/10/22.
 * 经测试：多个consumer消费同一个主题，
 * 会按照顺序消费，应该是consumer端启动顺序，并且平均消费
 * 一条消息只会被消费一次。
 */
public class ShortMessageConsumer {

    private Connection connection;
    private Session session;

    public ShortMessageConsumer() throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public static void main(String[] args) throws JMSException {

        ShortMessageConsumer consumer = new ShortMessageConsumer();
        Destination destination = consumer.getSession().createQueue("short_message");
        MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
        messageConsumer.setMessageListener(consumer.new Listener());

    }

    public Session getSession() {
        return session;
    }

    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }

    public class Listener implements MessageListener {

        public void onMessage(Message message) {
            try {
                //do something here
                System.out.println("收到发短信的任务，短信内容为" + ((ObjectMessage) message).getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
