package com.blackpixel.threads;

import java.util.concurrent.TimeUnit;

public class ThreadStates extends Thread{
    Thread parent;

    public ThreadStates(Thread parent){
        this.parent = parent;
    }
    public void run(){
        for(int i = 1; i < 11; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i is currently : " + i);
            if(i==6){
                System.out.println("Parent thread status is: " + parent.getState());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread status is: " + Thread.currentThread().getState());
        ThreadStates threadStates = new ThreadStates(Thread.currentThread());
        System.out.println("threadDemo thread state is: " + threadStates.getState());
        //threadDemo.setDaemon(true);
        threadStates.start();
        System.out.println("threadDemo thread state is: " + threadStates.getState());
        try {
            TimeUnit.SECONDS.sleep(5);
            //thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
