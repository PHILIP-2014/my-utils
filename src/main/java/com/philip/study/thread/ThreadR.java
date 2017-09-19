package com.philip.study.thread;

/**
 * Created by Philip on 2017/9/8.
 */
public class ThreadR implements Runnable {

    private int ticket = 100;
    private String name;

    public void run(){
        for(int i =0 ; i<500 ; i++){
            if(this.ticket > 0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }
}
