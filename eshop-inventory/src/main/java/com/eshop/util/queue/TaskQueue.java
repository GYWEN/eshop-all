package com.eshop.util.queue;

import com.eshop.util.message.RequestMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 队列的管理
 */
public class TaskQueue {

    private static final int init_capaticy = 8;

    private List<BlockingQueue<RequestMessage>> messageQueue;

    private TaskQueue(){
        this.messageQueue = new ArrayList<>(init_capaticy);
        for (int index =0;index<init_capaticy;index++){
            messageQueue.add(new ArrayBlockingQueue<RequestMessage>(128));
        }
    }


    public int size(){
        return messageQueue.size();
    }

    public static TaskQueue getInstance(){
        return subTaskQueue.getInstance();
    }

    public BlockingQueue<RequestMessage> getBlockingQueueByIndex(int index) throws Exception {
        if(index > size()){
            throw new Exception("请求序列超过当前限制");
        }
        return messageQueue.get(index);
    }


    private static class subTaskQueue{

        private static TaskQueue defaultTaskQueue = new TaskQueue();

        public static TaskQueue getInstance(){
            return defaultTaskQueue;
        }

    }
}
