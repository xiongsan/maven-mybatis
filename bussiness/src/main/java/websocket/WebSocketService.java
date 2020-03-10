package websocket;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2016/11/17
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocketService {

    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<>();
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        Runtime runtime = Runtime.getRuntime();
        // 声明处理类对象
        Process process = null;
        // 返回行信息
        // 输入流
        InputStream is = null;
        // 字节流
        InputStreamReader isr = null;
        // 缓冲流
        BufferedReader br = null;

        // 结果
        try {
            // 运行PING命令
            String command = "";
            if (!System.getProperties().getProperty("os.name").contains("Windows")) {
                command = "ping -c 20 192.168.20.197";
            }else {
                command = "ping -n 20 192.168.20.197";
            }
            process = runtime.exec(command);
            // 实例化输入流
            is = process.getInputStream();
            // 把输入流转换成字节流
            isr = new InputStreamReader(is);
            // 从字节中读取文本
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                if(!"".equals(line))
                    sendMessage(line);
            }
            sendMessage("1");
            this.session.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != isr) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    //收到客户端端消息时触发
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息："+message);
        for(WebSocketService item: webSocketSet){
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.onlineCount--;
    }

}