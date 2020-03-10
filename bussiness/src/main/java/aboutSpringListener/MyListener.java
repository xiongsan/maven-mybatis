package aboutSpringListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener  implements ApplicationListener<MsgEvent> {

    @Override
    public void onApplicationEvent(MsgEvent msgEvent) {
        System.out.println(msgEvent.getSource());
    }
}
