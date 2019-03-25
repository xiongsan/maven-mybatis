package aboutZookeeper.distribute_lock.dis_test;

import java.util.Map;

/**
 * Created by hairui on 2019/3/10.
 */
public class SecondKill {

    public synchronized void reduce(int userId){
        if(SimulationDatabase.sum>9998){
            System.out.println(userId);
            SimulationDatabase.sum--;
            SimulationDatabase.killA.add(userId);
        }
    }

}
