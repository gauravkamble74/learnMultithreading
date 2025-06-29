package com.example.demo.thread;

public class ATM {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw("Alice",700));
        Thread t2 = new Thread(() -> account.withdraw("Bob",500));

        t1.start();
        t2.start();
    }
}

class BankAccount{
    private int balance = 1000;
    synchronized void withdraw(String name, int amount){
        if(balance >= amount){
            System.out.println(name + " is withdrawing Rs. "+amount);
            balance -= amount;
        }else {
            System.out.println(name + " cannot withdraw, insufficient balance");
        }
    }
}
