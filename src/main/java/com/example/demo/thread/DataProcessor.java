package com.example.demo.thread;

public class DataProcessor {
    public static void main(String[] args) throws InterruptedException {
        Thread dataLoader = new Thread(() -> {
            log("Starting data loading...");
            try {
                Thread.sleep(2000); //simulate data loading
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("Data Loaded");
        },"DataLoader");

        Thread dataValidator = new Thread(() -> {
            log("Waiting for validate data...");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            log("Data Validated");
        },"Data Validator");

        Thread dataProcessor = new Thread(() -> {
           log("Processing data...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log("Data processing complete");
        },"DataProcessor");

        dataLoader.start();
        dataLoader.join();

        dataValidator.start();
        dataValidator.join();

        dataProcessor.start();
        dataProcessor.join();

        log("All task finished. Exited main thread");
    }
    private static void log(String message){
        System.out.printf(" [%s] [%s] %s%n",
                java.time.LocalDateTime.now(),
                Thread.currentThread().getName(),
                message);
    }
}