package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       StreamProcess a=new StreamProcess();
        try {
            a.begin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
