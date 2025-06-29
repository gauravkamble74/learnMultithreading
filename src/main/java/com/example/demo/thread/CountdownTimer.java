package com.example.demo.thread;

public class CountdownTimer {
    public static void main(String[] args) throws InterruptedException {
        for (int i=5;i>0;i--){
            System.out.println("Countdown : "+i +" Thread Name : " + Thread.currentThread().getName());
            Thread.sleep(2000);
        }
        System.out.println("End");
    }
}
