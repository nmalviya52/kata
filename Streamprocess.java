package com.company;


/**
 * Created by naresh.m on 16/05/17.
 */
public class Streamprocess implements MyEventListener {
    double[] a=new double[1000];
    static boolean[] b=new boolean[1000];
    {
        for(int i=0;i<1000;i++)
            a[i]=-10.0;
    }
    static{
        for(int i=0;i<1000;i++)
        {
            b[i]=false;
        }
    }
    public void myEventOccurred(int ClientID,int UUID,String Message) {
        long l = System.currentTimeMillis();
        double d = l / 1000000;
        if (d - a[UUID] > 10) {

//            System.out.println(ClientID + "  " + UUID);
            a[UUID] = d;
            Thread t1 = new Thread(new mythread("hello", Message), Message);
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
    public mythread(String threadName,String msg) {
        runner = new Thread(this, threadName);
        this.message=msg;
        runner.start();
    }
    @Override
    public void run() {
        System.out.println(""+message);
    }
}