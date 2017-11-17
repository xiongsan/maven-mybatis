package proxy;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Wanghairui on 2017/6/1.
 */
public class AccountImpl2 implements Account {
    public void query(String id) {
        System.out.println(id+"AccountImpl2.query");
    }
}
