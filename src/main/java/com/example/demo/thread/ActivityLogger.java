package com.example.demo.thread;

//implementing Runnable interface
public class ActivityLogger implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Logging activity");
    }

    public static void main(String[] args) {
//        ActivityLogger activityLogger1 = new ActivityLogger();
//        Thread logger = new Thread(activityLogger1);
        Thread logger = new Thread(new ActivityLogger());
        logger.start();
        System.out.println("calling thread via runnable interface");
    }
}
