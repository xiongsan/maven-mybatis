package aboutZookeeper;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * Title :
 * </p>
 *
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/13
 * Time :16:03
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class ServiceRegistryImpl implements ServiceRegistry,Watcher {

    private static Logger logger = LoggerFactory.getLogger(ServiceRegistryImpl.class);
    private static CountDownLatch latch = new CountDownLatch(1);
    private ZooKeeper zk;
    private static final int SESSION_TIMEOUT = 5000;
    public ServiceRegistryImpl() {

    }

    public ServiceRegistryImpl(String zkServers) {
        try {
            zk = new ZooKeeper(zkServers, SESSION_TIMEOUT, this);
            latch.await();
            logger.debug("connected to zookeeper");
        } catch (Exception ex) {
            logger.error("create zookeeper client failure", ex);
        }
    }

    private static final String REGISTRY_PATH = "/registry";

    @Override
    public void register(String serviceName, String serviceAddress) {
        try {
            String registryPath = REGISTRY_PATH;
            if (zk.exists(registryPath, this) == null) {
                zk.create(registryPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                logger.debug("create registry node:{}", registryPath);
            }
            //创建服务节点（持久节点）
            String servicePath = registryPath + "/" + serviceName;
            if (zk.exists(servicePath, this) == null) {
                zk.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                logger.debug("create service node:{}", servicePath);
            }
            //创建地址节点
            String addressPath = servicePath + "/address-";
            String addressNode = zk.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.debug("create address node:{} => {}", addressNode, serviceAddress);
            System.out.println("create address node:"+addressNode+"         "+ serviceAddress);
        } catch (Exception e) {
            logger.error("create node failure", e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        latch.countDown();
        if(watchedEvent.getType() == Event.EventType.NodeCreated){
            System.out.println("创建节点");
        }
        if(watchedEvent.getType() == Event.EventType.NodeDataChanged){
            System.out.println("节点改变");
        }
        if(watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
            System.out.println("子节点节点改变");
        }
        if(watchedEvent.getType() == Event.EventType.NodeDeleted){
            System.out.println("节点删除");
        }
    }
}