package org.eshop.mq;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspecJConfig {

    public AspecJConfig(ServiceTest serviceTest){
        System.err.println("This us -----------------");
    }


    public void ca(){

    }

    @Pointcut("execution(* *(..))")
    public void print(){

    }

    @Before("print()")
    public void getBefore(){
        System.err.println("this is before");
    }


}
