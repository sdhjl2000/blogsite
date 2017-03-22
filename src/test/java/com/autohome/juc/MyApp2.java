package com.autohome.juc;

import java.util.Random;

public class MyApp2 implements Runnable{
    private static ThreadLocal<String> sname=new ThreadLocal<>();
    public MyApp2(String str){
        sname.set(str);
    }
    public void run() {

        for (int i = 0; i <100 ; i++) {
            sname.set(String.valueOf(i));
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--"+String.valueOf(i)+"-"+sname.get());
        }
    }
}
