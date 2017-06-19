package aboutKafka.consumer;

/**
 * Created by Wanghairui on 2017/6/15.
 */
import java.io.UnsupportedEncodingException;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.message.source.ProtocolSourceMessage;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

public class Consumerwork implements Runnable {
    @SuppressWarnings("rawtypes")
    private KafkaStream m_stream;
    private int m_threadNumber;
    private final Set ports = new HashSet();
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
                JSONObject jsonObject = JSONObject.parseObject(jsonStr);
                JSONObject netflow = jsonObject.getJSONObject("netflow");
                //host
                String in_bytes = netflow.getString("in_bytes");

                String ipv4_src_addr = netflow.getString("ipv4_src_addr");
                String l4_src_port = netflow.getString("l4_src_port");

                String ipv4_dst_addr = netflow.getString("ipv4_dst_addr");
                String l4_dst_port = netflow.getString("l4_dst_port");
//                ports.add(l4_src_port);
//                ports.add(l4_dst_port);
                System.out.println("从"+ipv4_src_addr+":"+l4_src_port+"到"+ipv4_dst_addr+":"+l4_dst_port+"流量为"+":"+in_bytes+"字节");
//                System.out.println(ports.size());
                System.out.println("Thread " + m_threadNumber + ": " +jsonStr);
                //System.out.println("partion"+thisMetadata.partition()+",offset:"+thisMetadata.offset());
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