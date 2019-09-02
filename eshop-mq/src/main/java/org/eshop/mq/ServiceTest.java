package org.eshop.mq;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Service;

@Service
//@AutoConfigureAfter(AspecJConfig.class)
public class ServiceTest  {

//    public ServiceTest(AspecJConfig key){
//        System.err.println("this is ServiceTest key--------------");
//    }

//    public ServiceTest(String key,String test) {
//        System.err.println("This is Tsest Key");
//    }

//    public ServiceTest(){
//        System.err.println("this is ServiceTest");
//    }
    public void get(){
        System.err.println("THhis is Service");
    }

}
