package com.company;

import java.util.*;
/**
 * Created by naresh.m on 16/05/17.
 */
public class StreamProcess implements MyEventListener {
    public static double[] lastrequesttime=new double[100];
    public static Object[] mutex=new Object[100];
    static{
        for(int i=0;i<100;i++)
            lastrequesttime[i]=-10.0;
        for(int i=0;i<100;i++)
            mutex[i]=new Object();
    }
    public void myEventOccurred(int ClientID,int UUID,String Message) {
        long curtime = System.currentTimeMillis();
        double curtimesec = curtime / 1000;
        if (curtimesec - lastrequesttime[UUID] >=10.000000) {
            lastrequesttime[UUID] = curtimesec;
            Thread t1 = new Thread(new mythread("hello", Message,mutex[ClientID]), Message);
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void begin() throws InterruptedException {
        MyEvent anew=new MyEvent();
        anew.SeteventListener(this);
        try {
            anew.start();
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