package org.eshop.mq.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class eshopEvent extends ApplicationEvent {

    private String target;

    public eshopEvent(Object source) {
        super(source);
    }

    public eshopEvent(Object source,String target){
        super(source);
        this.target = target;
    }

    public String getTarget(){
        return target;
    }

}
