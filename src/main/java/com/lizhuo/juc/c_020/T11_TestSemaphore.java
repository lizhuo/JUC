/**
 * 信号灯
 *
 * 场景：限流 限制线程数 燕贤
 *
 */
package com.lizhuo.juc.c_020;

import java.util.concurrent.Semaphore;

public class T11_TestSemaphore {
	public static void main(String[] args) {
		//Semaphore s = new Semaphore(2);
		Semaphore s = new Semaphore(2, true); // 公平指用队列等待 -- 内部有队列AQS
		//允许一个线程同时执行
		//Semaphore s = new Semaphore(1);

		new Thread(() -> {
			try {
				s.acquire(); // 获取锁 阻塞 (得到取得)

				System.out.println("T1 running...");
				Thread.sleep(200);
				System.out.println("T1 running...");

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s.release(); // 恢复数量 1？
			}
		}).start();

		new Thread(() -> {
			try {
				s.acquire(); // 获取锁 阻塞 (得到取得)

				System.out.println("T2 running...");
				Thread.sleep(200);
				System.out.println("T2 running...");

				s.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
