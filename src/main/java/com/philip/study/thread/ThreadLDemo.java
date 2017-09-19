package com.philip.study.thread;

/**
 * Created by Philip on 2017/9/8.
 */
public class ThreadLDemo {

    public static void main(String[] args) {
        ThreadL tl1 = new ThreadL("一号窗口");
        ThreadL tl2 = new ThreadL("二号窗口");
        ThreadL tl3 = new ThreadL("三号窗口");
        ThreadL tl4 = new ThreadL("四号窗口");
        ThreadL tl5 = new ThreadL("五号窗口");
        tl1.start();
        tl2.start();
        tl3.start();
        tl4.start();
        tl5.start();
    }
}
