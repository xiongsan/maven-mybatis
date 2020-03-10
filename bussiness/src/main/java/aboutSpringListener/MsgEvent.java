package aboutSpringListener;

import org.springframework.context.ApplicationEvent;

public class MsgEvent extends ApplicationEvent {
    public MsgEvent(Object source) {
        super(source);
    }
}
