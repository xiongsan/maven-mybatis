package aboutKafka.consumer;

/**
 * Created by Wanghairui on 2017/6/15.
 */
import java.io.UnsupportedEncodingException;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import org.apache.log4j.Logger;

public class Consumerwork implements Runnable {
//    private static Logger LOG = Logger.getLogger(Consumerwork.class);
    @SuppressWarnings("rawtypes")
    private KafkaStream m_stream;
    private int m_threadNumber;
    @SuppressWarnings("rawtypes")
    public Consumerwork(KafkaStream a_stream,int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext())
            try {
                MessageAndMetadata<byte[], byte[]> thisMetadata=it.next();
                String jsonStr = new String(thisMetadata.message(),"utf-8") ;
                // 应该就是消费者接受大
                System.out.println("Thread " + m_threadNumber + ": " +jsonStr);
                System.out.println("partion"+thisMetadata.partition()+",offset:"+thisMetadata.offset());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
    }
}