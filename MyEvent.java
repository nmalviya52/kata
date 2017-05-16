package com.company;

/**
 * Created by naresh.m on 16/05/17.
 */
import java.util.EventListener;
import java.util.EventObject;
import java.util.*;
import java.lang.*;


interface MyEventListener extends EventListener {
    void myEventOccurred(int ClientID,int UUID,String Message);
}

public class MyEvent{
    private MyEventListener evntlis;
    public void SeteventListener(MyEventListener e)
    {
        evntlis=e;
    }
    public void start() throws InterruptedException {
        Random r=new Random();
        for(int i=0;i<50;i++)
        {
            int ClientID=r.nextInt(1000);
            int UUID=r.nextInt(1000);
            String Message="hello_"+i+"_"+ClientID+"_"+UUID;
            evntlis.myEventOccurred(ClientID,UUID,Message);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
