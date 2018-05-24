package aboutKafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
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
 * Time :11:42
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Consumer {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.20.197:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("netflow"),new ConsumerRebalanceListener() {
//            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
//            }
//            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
//                //将偏移设置到最开始
//                Iterator<TopicPartition> it=collection.iterator();
//                while (it.hasNext()){
//                    consumer.seekToBeginning(collection);
//                }
//
//            }
//        });
        consumer.subscribe(Arrays.asList("netflow","test1","test2"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records){
                System.out.println(record.toString());
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//                JSONObject jsonObject = JSONObject.parseObject(record.value());
//                JSONObject netflow = jsonObject.getJSONObject("netflow");
//                String in_bytes = netflow.getString("in_bytes");
//
//                String ipv4_src_addr = netflow.getString("ipv4_src_addr");
//                String l4_src_port = netflow.getString("l4_src_port");
//
//                String ipv4_dst_addr = netflow.getString("ipv4_dst_addr");
//                String l4_dst_port = netflow.getString("l4_dst_port");
//                System.out.println("从"+ipv4_src_addr+":"+l4_src_port+"到"+ipv4_dst_addr+":"+l4_dst_port+"流量为"+":"+in_bytes+"字节");
            }
        }
    }
}
