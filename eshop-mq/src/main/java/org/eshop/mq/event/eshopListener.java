package org.eshop.mq.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class eshopListener  {

    @EventListener({CacheEvent.class,eshopEvent.class})
    public void processListener(ApplicationEvent event){
        if(event instanceof CacheEvent){
            System.err.println("this is cache Event");
        }else{
            if (event instanceof eshopEvent){
                eshopEvent eshopEvent = (eshopEvent)event;
                System.err.println("this is +++" + eshopEvent.getTarget());
            }
        }
    }
}
