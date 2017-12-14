package aboutKafka.producer;

/**
 * Created by Wanghairui on 2017/6/15.
 */
import java.util.Properties;
import org.apache.kafka.clients.producer.*;
public class PartitionTest{

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.20.175:9092");
        props.put("retries", 0);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("partitioner.class", "aboutKafka.producer.MyPartion");
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>("producer_test", "2223132132",
                "test23_60");
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                // TODO Auto-generated method stub
                if (e != null)
                    System.out.println("the producer has a error:" + e.getMessage());
                else {
                    System.out.println("The offset of the record we just sent is: " + metadata.offset());
                    System.out.println("The partition of the record we just sent is: " + metadata.partition());
                }

            }
        });
        try {
            Thread.sleep(1000);
            producer.close();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
