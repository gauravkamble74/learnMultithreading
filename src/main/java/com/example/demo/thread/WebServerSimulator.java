package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//using ExecutorService interface
public class WebServerSimulator {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //for creating thread as needed
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=1;i<=5;i++){
            final int userId = i;
            executorService.submit(() -> {
                System.out.println("Processing request of request : "+userId + " thread name : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
