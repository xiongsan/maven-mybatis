package aboutKafka.consumer;

/**
 * Created by Wanghairui on 2017/6/15.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerGroup {
    private final ConsumerConnector consumer;
    private final String topic;
    private ExecutorService executor;

    public ConsumerGroup(String a_zookeeper, String a_groupId, String a_topic) {
        consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(a_zookeeper, a_groupId));
        this.topic = a_topic;
    }

    public static void main(String[] args) {
        String zooKeeper = "192.168.20.175:2181";
        String groupId = "test_group";
        String topic = "netflow";
        int threads = 1;
        ConsumerGroup example = new ConsumerGroup(zooKeeper, groupId, topic);
        System.out.println("Starting consumer kafka messages with zk:" + zooKeeper + " and the topic is " + topic);
        example.run(threads);
        // example.shutdown();
    }

    private void shutdown() {
        if (consumer != null)
            consumer.shutdown();
        if (executor != null)
            executor.shutdown();
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }

    private void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, a_numThreads);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        // now launch all the threads
        //
        executor = Executors.newFixedThreadPool(a_numThreads);

        // now create an object to consume the messages
        int threadNumber = 0;
        System.out.println("the streams size is " + streams.size());
        for (final KafkaStream stream : streams) {
            executor.submit(new Consumerwork(stream, threadNumber));
            //      consumer.commitOffsets();
            threadNumber++;
        }

    }

    private ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);
        props.put("group.id", a_groupId);
//        props.put("zookeeper.session.timeout.ms", "10000");
        props.put("zookeeper.connection.timeout.ms", "10000");
        props.put("zookeeper.sync.time.ms", "10000");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
//        props.put("rebalance.max.retries", "10");
//        props.put("rebalance.backoff.ms", "2000");
        return new ConsumerConfig(props);
    }

}