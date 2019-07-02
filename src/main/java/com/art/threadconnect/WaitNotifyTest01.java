package com.art.threadconnect;

import javax.management.ObjectName;

/**
 * @Description: wait/notify实现线程之间的通信:等待/通知机制
 * 1.wait/notify都是object的对象，synchronized与等待/通知机制实现线程之间的通信，
 * 那么这个wait/notify方法的调用是发生在同一个对象的，在不同线程下调用，借助这个锁对象来实现线程之间的通信
 * 2.wait方法被执行后，当前线程所持有的锁释放，notify方法不释放锁，必须执行同步块代码后才会释放锁
 * 3.当线程在等待状态，也就是带调用完wait方法后，调用interrupt()会出现线程终端异常
 * @Author: qizhi.wang
 * @Date: 2019/7/1
 */
public class WaitNotifyTest01 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Integer i = new Integer(1);
        MyThread01 t1 = new MyThread01(lock, i);
        t1.start();
        Thread.sleep(2000);
        MyThread02 t2 = new MyThread02(lock, i);
        t2.start();
        Thread.sleep(5000);

    }
}


class MyThread01 extends Thread {
    private Object  lock;
    private Integer i;

    public MyThread01(Object lock, Integer i) {
        super();
        this.i = i;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始wait的时间点：" + System.currentTimeMillis());
                i++;
                lock.wait();
                System.out.println("结束wait的时间点：" + System.currentTimeMillis());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

class MyThread02 extends Thread {
    private Object  lock;
    private Integer i;

    public MyThread02(Object lock, Integer i) {
        super();
        this.i = i;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始notify的时间点：" + System.currentTimeMillis());
            i += 2;
            lock.notify();
            System.out.println("结束notify的时间点：" + System.currentTimeMillis());
        }
    }
}