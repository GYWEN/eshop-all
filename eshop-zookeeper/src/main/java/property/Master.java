package property;

import org.apache.zookeeper.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.springframework.stereotype.Component;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;


@Component
public class Master implements Watcher {

    public ZooKeeper zk;

    private String zkConnection;

    private int zkSessionTimeout;

    private IStringCallBack iStringCallBack = new Master.IStringCallBack();

    String serverId = Integer.toHexString((int) Math.random());

    static final CountDownLatch connectedSemaphore = new CountDownLatch(1);


    public Master(ZkProperties zkProperties) throws IOException {

        this.zkConnection = zkProperties.getConnectString();

        this.zkSessionTimeout = zkProperties.getSessionTimeout();

        this.zk = new ZooKeeper(this.zkConnection,this.zkSessionTimeout,this);

    }

    @PostConstruct
    public void init() throws IOException, KeeperException, InterruptedException {

        System.err.println("THIs is zk ----------Init ----------");

        connectedSemaphore.await();

//        this.zk = new ZooKeeper(this.zkConnection,this.zkSessionTimeout,this);

        zk.create("/master",serverId.getBytes(),OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL,iStringCallBack,"this is callBack");
//        connectedSemaphore.await();
    }


    @Override
    public void process(WatchedEvent event) {
        //获取事件的状态
        KeeperState keeperState = event.getState();
        EventType eventType = event.getType();
        //如果是建立连接
        if (KeeperState.SyncConnected == keeperState) {
            connectedSemaphore.countDown();
            System.err.println("This is ZKKKKKKK");
        }
        if (event.getType() == EventType.NodeChildrenChanged){
            System.err.println("node data change");
        }
    }


    public static class IStringCallBack implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int i, String s, Object o, String s1) {
            System.err.println("test erroe");
        }
    }

}
