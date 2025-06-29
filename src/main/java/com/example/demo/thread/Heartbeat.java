package com.example.demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Heartbeat {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable heartbeat = () -> {
            System.out.println("Heartbeat at : "+System.currentTimeMillis());
        };

        scheduledExecutorService.scheduleAtFixedRate(heartbeat,0,2, TimeUnit.SECONDS);
    }
}
