package com.example.demo.thread.advance;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AdvancedProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> logQueue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            int logCount=1;
            try {
                while (true) {
                    String log = "Log Entry " + logCount++;
                    logQueue.put(log);
                    System.out.println("Produced: "+log);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){}
        };

        Runnable consumer = () -> {
            try {
                while (true){
                    String log = logQueue.take();
                    System.out.println("Consumed: "+log);
                    Thread.sleep(2000);
                }
            }catch (InterruptedException ex){}
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
