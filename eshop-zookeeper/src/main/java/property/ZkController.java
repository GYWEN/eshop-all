package property;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

@RestController
public class ZkController {

    @Autowired
    public Master master;

    @Autowired
    public ZkProperties zkProperties;


    @GetMapping("/zktest")
    public String getZk() throws KeeperException, InterruptedException, IOException {

        //不能创建临时节点的子节点
        master.zk.create("/te","name".getBytes(),OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        master.zk.getChildren("/te",true);
        master.zk.create("/te/gyw","gyw".getBytes(),OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        return "123";
    }


    @GetMapping("/zkget")
    public List<String> getNode() throws KeeperException, InterruptedException {
        List<String> list = master.zk.getChildren("/name",true);
        return list;
    }
}
