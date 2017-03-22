package com.autohome.juc;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        //ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*512);
        synnew();

    }

    private static void TestFinal() {
        Item item=new Item("dasdas");

        String  str=item.getName();
        str="aaa";
        System.out.println(item.getName());
    }
    private static void synnew() throws InterruptedException {
    Runnable t1=new MyApp2("AAAA");
        Runnable t2=new MyApp2("BBB");
       Thread tt1= new Thread(t1);
        Thread tt2= new Thread(t2);
        tt1.start();
        tt2.start();
        tt1.join();
        tt2.join();
    }
    private static void syn() throws InterruptedException {
        Item item=new Item("sss");
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    item.putName("AAAA");
                    Thread.sleep(150);
                    System.out.println(Thread.currentThread().getName()+"---"+item.getName());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    item.putName("DDDDD");
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"---"+item.getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1=new Thread(task1);
        Thread thread2=new Thread(task2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void compStr() {
        String arr[] = {"choice_city_id","sv.factory_id","platform","business","app_soft_type"};
        for (int r = 0; r < 6; r++) {
            int n = arr.length;
            printCombination(arr, n, r);
        }
    }

    static void combinationUtil(String arr[], String data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+",");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(String arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        String data[]=new String[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    private static void TLAB() throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("my-sad-thread-%d").build();
        ExecutorService executorService= Executors.newFixedThreadPool(10,namedThreadFactory);

        for (int i=0;i<10000;i++) {
            executorService.submit(new MyApp());
        }
        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }
}
