package springRmiClient.service;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by 张少昆 on 2017/8/23.
 */
public interface IRmiService {
    void recovery();

    CopyOnWriteArraySet<String> backup();

    void upgrade();

    void restore(String time);


}