package activemq.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hairui on 2018/10/22.
 */
public class Consumer2 {

    private Connection connection;
    private Session session;

    public Consumer2() throws JMSException {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public static void main(String[] args) throws JMSException {


        Consumer2 consumer = new Consumer2();
        Destination destination = consumer.getSession().createQueue("JOBS.");
        MessageConsumer messageConsumer = consumer.getSession().createConsumer(destination);
        messageConsumer.setMessageListener(consumer.new Listener("JOBS."));

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

        private String job;

        int i=0;

        public Listener(String job) {
            this.job = job;
        }

        public void onMessage(Message message) {
            try {
                //do something here
                System.out.println("2222收到队列" + job + "的消息：" + ((ObjectMessage) message).getObject());
                i++;
                System.out.println(String.format("消费个数 %d",i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
