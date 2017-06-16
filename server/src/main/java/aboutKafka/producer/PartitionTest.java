package aboutKafka.producer;

/**
 * Created by Wanghairui on 2017/6/15.
 */
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

public class PartitionTest implements Partitioner {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.20.175:9092");
        props.put("retries", 0);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("partitioner.class", "aboutKafka.producer.PartitionTest");
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<>("producer_test", "2223132132",
                "test23_60");
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        System.out.println("发送消息");
                        producer.send(record);
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

    @Override
    public int partition(String topic, Object key, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        int partitionNum = 0;
        try {
            partitionNum = Integer.parseInt((String) key);
        } catch (Exception e) {
            partitionNum = key.hashCode() ;
        }
        System.out.println("the message sendTo topic:"+ topic+" and the partitionNum:"+ partitionNum);
        return Math.abs(partitionNum  % numPartitions);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
