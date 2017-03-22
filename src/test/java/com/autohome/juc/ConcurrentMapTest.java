package com.autohome.juc;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder;

import org.junit.Test;

/**
 * Created by hujinliang on 2017/3/10.
 */
public class ConcurrentMapTest implements Serializable,Comparable<Integer> {
    ConcurrentHashMap<Integer,String> concurrentMap=new ConcurrentHashMap<Integer, String>();

    @Test
    public  void tt1(){
        Integer id=20563604;
        System.out.println(id);
    }
    @Test
    public void test1() throws InterruptedException {
        AddThread addThread=new AddThread();
//        Thread t1=new Thread(addThread);
//        Thread t2=new Thread(addThread);
//        Thread t3=new Thread(addThread);
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(100,100,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000));
        for (int i=0;i<1000;i++){
            threadPoolExecutor.submit(addThread);
    }
    Thread.sleep(5000);}

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
