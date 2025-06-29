package com.example.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TicketBooking {
    private final ReentrantLock lock = new ReentrantLock();

    void ticketBooking(String user){
        lock.lock();
        try {
            System.out.println(user + " is booking ticket...");
            Thread.sleep(1000);
            System.out.println(user + " booked ticket");
        }catch (InterruptedException e){
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        new Thread(() -> booking.ticketBooking("Alice")).start();
        new Thread(() -> booking.ticketBooking("Bob")).start();
    }
}
