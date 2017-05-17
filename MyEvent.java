package com.company;

/**
 * Created by naresh.m on 16/05/17.
 */
import java.util.EventListener;
import java.util.*;
import java.lang.*;


interface MyEventListener extends EventListener {
    void myEventOccurred(int ClientID,int UUID,String Message);
}

public class MyEvent{
    private MyEventListener eventlistener;
    public void SeteventListener(MyEventListener e)
    {
        eventlistener=e;
    }
    public void start() throws InterruptedException {
        Random r=new Random();
        int i=0;
        while(true)
        {
            int ClientID=r.nextInt(100);
            int UUID=r.nextInt(100);
            String Message="hello_"+i+"_"+ClientID+"_"+UUID;
            eventlistener.myEventOccurred(ClientID,UUID,Message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
