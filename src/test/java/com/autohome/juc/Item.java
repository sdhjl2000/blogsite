package com.autohome.juc;

public class Item{
    private static  ThreadLocal<String> sname=new ThreadLocal<>();
    private static  String sname2;
    private final String name;
    public Item(String name){
        this.name=name;
    }
    public  void add() throws InterruptedException {
        synchronized(this){
        System.out.println("add start");
        Thread.sleep(5000);
        System.out.println("add end");}
    }
    public synchronized void sub() throws InterruptedException {
        synchronized(this){
        System.out.println("sub start");
        Thread.sleep(5000);
        System.out.println("sub end");}
    }

    public  void  putName(String str){
        //sname2=str;
        sname.set(str);
        }
    public String getName() {

        return sname.get();
    }

}
