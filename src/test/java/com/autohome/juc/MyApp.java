package com.autohome.juc;

import java.util.Random;

public class MyApp implements Runnable{
    ThreadLocal<Byte[]> threadLocal=new ThreadLocal<Byte[]>();
    public void run() {
        try {
            Random rand=new Random(1);
            threadLocal.set(new Byte[1024*1024]);
            double sum=0d;
           while (sum<10000){
               sum=sum+ rand.nextDouble();
           }
            System.out.println(sum);
            threadLocal.get();
        }
        catch (Throwable throwable){
            System.out.println("===");
        }

    }
}
