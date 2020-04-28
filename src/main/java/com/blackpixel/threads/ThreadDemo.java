package com.blackpixel.threads;

import java.util.concurrent.TimeUnit;

public class ThreadDemo extends Thread{
    Thread parent;

    public ThreadDemo(Thread parent){
        this.parent = parent;
    }
    public void run(){
        for(int i = 0; i < 10; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==6){
                System.out.println("Parent thread status is: " + parent.getState());
            }
            System.out.println("i is currently : " + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo(Thread.currentThread());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
