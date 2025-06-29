package com.example.demo.thread;

//extending thread Class
public class BackgroundMusic extends Thread{
    public static void main(String[] args) {
//        new BackgroundMusic().start();
        BackgroundMusic b1 = new BackgroundMusic();
//        b1.run();
        b1.start();
        System.out.println("Game started");
    }
    public void run(){
        while(true){
            System.out.println("Playing background music");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex){
                System.out.println("Music thread Interuppted");
            }
        }
    }
}
