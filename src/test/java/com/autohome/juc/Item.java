package com.autohome.juc;

public class Item{
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
