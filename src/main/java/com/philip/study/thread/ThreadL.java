package com.philip.study.thread;

/**
 * 线程学习归纳
 * Created by Philip on 2017/9/8.
 */
public class ThreadL extends Thread {

    private int ticket = 100;
    private String name;

    public ThreadL(String name){
        this.name =name;
    }

    public void run(){
        for(int i = 0 ; i < 500 ; i++){
            if(this.ticket > 0){
                System.out.println(this.name + "卖票---->" + (this.ticket--));
            }
        }
    }

}
