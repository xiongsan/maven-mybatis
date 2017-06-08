package util;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2017/2/5
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏汇鑫融智软件科技有限公司 </p>
 */
@Component("Sender")
public class Sender {

    private  CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<Session>();

    public CopyOnWriteArraySet<Session> getSessions() {
        return sessions;
    }

    public void sendData(String message){
        for (Session session:sessions){
            try {
                if(session!=null)
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
