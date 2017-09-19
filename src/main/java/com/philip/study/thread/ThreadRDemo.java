package com.philip.study.thread;

/**
 * Created by Philip on 2017/9/8.
 */
public class ThreadRDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //设计三个线程
        ThreadR mt = new ThreadR();
        Thread t1 = new Thread(mt,"一号窗口");
        Thread t2 = new Thread(mt,"二号窗口");
        Thread t3 = new Thread(mt,"三号窗口");
        Thread t4 = new Thread(mt,"四号窗口");
        Thread t5 = new Thread(mt,"五号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
