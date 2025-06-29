package com.example.demo.thread;

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producer = new Thread(() -> {
            try {
                sharedQueue.produce(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer1 = new Thread(() -> {
            try {
                sharedQueue.produce(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producer2 = new Thread(() -> {
            try {
                sharedQueue.produce(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                sharedQueue.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        producer1.start();
        producer2.start();
        consumer.start();
    }
}
class SharedQueue{
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException{
        while (hasData) wait();

        data = value;
        hasData = true;
        System.out.println("Produced: "+value);
        notify();
    }

    public synchronized void consume() throws InterruptedException{
        while (!hasData) wait();

        System.out.println("Consumed: "+data);
        hasData = false;
        notify();
    }
}