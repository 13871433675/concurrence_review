package com.art;

import javafx.concurrent.Worker;

/**
 * @Description: Join方法的使用
 * 1.join是线程类Thread的方法
 * 2.调用线程等待该线程完成之后才会执行
 * 3.join与sleep的区别：join会释放锁，sleep是不会释放锁
 * 4.使用：使线程顺序执行
 * @Author: qizhi.wang
 * @Date: 2019/7/1
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new com.art.Worker("Thread01"));

        t.start();
        t.join();
        System.out.println("main end");
    }
}

