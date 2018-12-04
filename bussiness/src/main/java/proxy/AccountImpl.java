package proxy;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Wanghairui on 2017/6/1.
 */
public class AccountImpl implements Account {
    public void query(String id) {
        System.out.println(id+"AccountImpl.query");
    }
}
