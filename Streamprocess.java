package com.company;

import java.util.*;
/**
 * Created by naresh.m on 16/05/17.
 */
public class Streamprocess implements MyEventListener {
    public static double[] a=new double[100];
    public static Object[] b=new Object[100];
    static{
        for(int i=0;i<100;i++)
            a[i]=-10.0;
        for(int i=0;i<100;i++)
            b[i]=new Object();
    }
    public void myEventOccurred(int ClientID,int UUID,String Message) {
        long l = System.currentTimeMillis();
        double d = l / 1000;
        if (d - a[UUID] >=10.000000) {
            a[UUID] = d;
            Thread t1 = new Thread(new mythread("hello", Message,b[ClientID]), Message);
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void begin() throws InterruptedException {
        MyEvent a=new MyEvent();
        a.SeteventListener(this);
        try {
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class mythread implements Runnable{
    Thread runner;
    String message;
    Object client;
    public mythread(String threadName,String msg,Object o) {
        runner = new Thread(this, threadName);
        this.message=msg;
        this.client=o;
        runner.start();
    }
    @Override
    public void run() {
        System.out.println(""+message+" waiting");
        synchronized (client)
        {
            System.out.println(""+message+" executing");
            Random r=new Random();
            try {
                int val=r.nextInt(5);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(""+message+"terminated ");
        }
    }
}