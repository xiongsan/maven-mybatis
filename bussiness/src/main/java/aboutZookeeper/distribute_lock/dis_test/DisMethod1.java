package aboutZookeeper.distribute_lock.dis_test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hairui on 2019/3/9.
 */
public class DisMethod1 implements MessageListener{

    private Connection connection;

    private Session session;

    private MessageProducer producer;

    private DisMethod1(){
        try{
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("certainBusiness_1");
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(this);
            producer = session.createProducer(null);
        }
        catch (Exception e){

        }
    }

    private void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }
    public static void main(String[] args) {
        new DisMethod1();
    }
    private int _int = 0;
    public void function(String param){
        _int += param.length();
        System.out.println("DisMethod1.function start -----");
        System.out.println("param = [" + param + "]");
        try {
            System.out.println("DisMethod1.function 入库业务开始");
            Thread.sleep(50);
            System.out.println("DisMethod1.function 入库业务结束");
            System.out.println("----通知某个业务系统异步完成某个事情----");
            sendMessage("short_message", "DisMethod1:你好，此处省略一万字");
            //通知业务方法2做事
            sendMessage("certainBusiness_2",param);
            System.out.println("param = [" + param + "]");
            _int -= param.length();
            System.out.println("检测并发，_int值应该为零"+_int);
            System.out.println("DisMethod1.function end -----");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String topic, String msg) throws JMSException {
        Destination destination = session.createQueue(topic);
        Message message = session.createObjectMessage(msg);
        System.out.println("Sending message: " + ((ObjectMessage) message).getObject() + " on queue: " + destination);
        producer.send(destination, message);
    }

    @Override
    public void onMessage(Message message) {
        try {
            function((((ObjectMessage) message).getObject()).toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
