package com.art;

/** 
 * @Description: Join Test02
 * @Author: qizhi.wang
 * @Date: 2019/7/1
 */ 
public class JoinTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Worker("Thread01"));
        Thread t2 = new Thread(new Worker("Thread02"));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main end");
    }
}

//出现这种结果的原因是：join只能保证调用线程等待线程执行完成后执行，不能保证调用的多个线程的执行顺序
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        Thread02 i   runed !
//        Thread01 i   runed !
//        Thread01 i   runed !
//        Thread02 i   runed !
//        main end