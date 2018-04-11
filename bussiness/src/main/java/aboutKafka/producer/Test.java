package aboutKafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/11
 * Time :13:16
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.20.197:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<>("netflow", Integer.toString(i), Integer.toString(i))
                    , new Callback() {
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            // TODO Auto-generated method stub 发送成功失败回调
                            if (e != null)
                                System.out.println("the producer has a error:" + e.getMessage());
                            else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset());
                                System.out.println("The partition of the record we just sent is: " + metadata.partition());
                            }

                        }
                    }
                    );
        producer.close();
    }
}
