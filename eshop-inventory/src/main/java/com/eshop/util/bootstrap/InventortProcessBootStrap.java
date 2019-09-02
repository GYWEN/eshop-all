package com.eshop.util.bootstrap;

import com.eshop.util.queue.TaskQueue;
import com.eshop.util.task.impl.MessageThreadTaskImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启动监听入口类
 */
public class InventortProcessBootStrap {

    /**
     * 线程池
     */
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);


    /**
     * 进行线程的匹配
     */
    public void init() throws Exception {

        TaskQueue taskQueue = TaskQueue.getInstance();
        for(int i=0;i<taskQueue.size();i++){
            MessageThreadTaskImpl messageThreadTask = new MessageThreadTaskImpl(taskQueue.getBlockingQueueByIndex(i));
            threadPool.submit(messageThreadTask);
        }
    }

}
