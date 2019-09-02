package com.eshop.util.task.impl;

import com.eshop.util.message.RequestMessage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class MessageThreadTaskImpl implements Callable {

    private BlockingQueue<RequestMessage> messagesQueue ;

    public MessageThreadTaskImpl(BlockingQueue<RequestMessage> messagesQueue ){

        this.messagesQueue = messagesQueue;
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
