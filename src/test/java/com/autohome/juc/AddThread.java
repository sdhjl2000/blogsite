package com.autohome.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AddThread implements Runnable{
    ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    AtomicInteger inc=new AtomicInteger(0);
    @Override
    public void run() {
       System.out.println(Thread.currentThread().getId()+"-----"+inc.getAndIncrement());
       // System.out.println(Thread.currentThread().getId()+"---TL--"+threadLocal.get());
       // threadLocal.set(threadLocal.get()+1);
    }
}
