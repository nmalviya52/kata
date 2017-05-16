package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       Streamprocess a=new Streamprocess();
        try {
            a.begin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
