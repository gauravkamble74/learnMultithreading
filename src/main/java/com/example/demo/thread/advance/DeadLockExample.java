package com.example.demo.thread.advance;

public class DeadLockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1){
                System.out.println("Thread 1: holding lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex){}
                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread 1 : Acquiring lock1");
                }
            }
        });
        Thread t2 = new Thread(() -> {
           synchronized (lock2){
               System.out.println("Thread 2: holding lock 2");
               try {
                   Thread.sleep(100);
               }catch (InterruptedException ex){}
           }
            System.out.println("Thread 2 : waiting for lock 1");
           synchronized (lock1){
               System.out.println("Thread 2 : Acquiring lock 1");
           }
        });

        t1.start();
        t2.start();

    }

}
