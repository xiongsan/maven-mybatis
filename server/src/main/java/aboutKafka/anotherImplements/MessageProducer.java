package aboutKafka.anotherImplements;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

import kafka.producer.ProducerConfig;


import java.util.Properties;
import java.util.concurrent.Executors;

/**
 * Created by Wanghairui on 2017/6/16.
 */
public class MessageProducer {

    private Producer<String,String> producer;

    public static void main(String[] args) {
        new MessageProducer().start();
    }

    public void init(){
        Properties props = new Properties();
        /**
         * 用于自举（bootstrapping ），producer只是用它来获得元数据（topic, partition, replicas）
         * 实际用户发送消息的socket会根据返回的元数据来确定
         */
        props.put("metadata.broker.list", "192.168.20.175:9092");
        /**
         * 消息的序列化类
         * 默认是 kafka.serializer.DefaultEncoder， 输入时 byte[] 返回是同样的字节数组
         */
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        /**
         * producer发送消息后是否等待broker的ACK，默认是0
         * 1 表示等待ACK，保证消息的可靠性
         */
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);
        // 泛型参数分别表示 The 0first is the type of the Partition key, the second the type of the message
        producer = new Producer<>(config);
    }

    public void produceMsg(){
        // 构建发送的消息
        long timestamp = System.currentTimeMillis();
        String msg = "Msg" + timestamp;
        String topic = "producer_test";  // 确保有这个topic
        System.out.println("发送消息" + msg);
        String key = "Msg-Key" + timestamp;

        /**
         * topic: 消息的主题
         * key：消息的key，同时也会作为partition的key
         * message:发送的消息
         */
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, key, msg);

        producer.send(data);
    }

    public void start() {
        System.out.println("开始发送消息 ...");
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                init();
                while (true) {
                    try {
                        Thread.sleep(2000);
                        produceMsg();
                    } catch (Throwable e) {
                        if (producer != null) {
                            try {
                                producer.close();
                            } catch (Throwable e1) {
                                System.out.println("Turn off Kafka producer error! " + e);
                            }
                        }
                    }

                }

            }
        });
    }
}
