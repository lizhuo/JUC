/**
 * 交换器
 * 两个线程 阻塞到能交换
 *
 * 实战高并发编程
 *
 * 乐观锁 CAS
 * 悲观锁 Synchronized
 * 自旋锁 CAS
 * 读写锁
 * 分段锁 LongAdder
 *
 */
package com.lizhuo.juc.c_020;

import java.util.concurrent.Exchanger;

public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                s = exchanger.exchange(s);  // 阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            try {
                s = exchanger.exchange(s);  // 阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }
}
