package aboutZookeeper.distribute_lock.dis_test;

import aboutZookeeper.distribute_lock.ZookeeperDisLock;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hairui on 2019/3/9.
 */
public class HardTestDis {
    private Connection connection;
    private Session session;
    private MessageProducer messageProducer;
    public HardTestDis(){
           try{
               ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
               connection = factory.createConnection();
               connection.start();
               session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
               messageProducer = session.createProducer(null);
           }
           catch (Exception e){
               e.printStackTrace();
           }


    }
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(()->{
            while (true){
                new HardTestDis().function(Thread.currentThread().toString(),"{我是参数1}");
            }
        }).start();

        new Thread(()->{
            while (true){
                new HardTestDis().function(Thread.currentThread().toString(),"{我是参数2}");
            }
        }).start();

        new Thread(()->{
            while (true){
                new HardTestDis().function(Thread.currentThread().toString(),"{我是参数3}");
            }
        }).start();
    }

    public void sendMessage(String topic, String msg)  {
        Destination destination = null;
        try {
            destination = session.createQueue(topic);
            Message message = session.createObjectMessage(msg);
            System.out.println("Sending message: " + ((ObjectMessage) message).getObject() + " on queue: " + destination);
            messageProducer.send(destination, message);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public void function(String  thread,String param){
//        ZookeeperDisLock.getZookeeperDisLock().getLock(thread,Lock_Path.CERTAIN_BUSINESS);
        sendMessage("certainBusiness_1test",param);
    }

}
