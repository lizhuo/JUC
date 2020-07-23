/**
 * LockSupport -- 控制线程暂停
 * 原有方式 需要 wait/await & notify
 *
 * unpark 可以先于 park 调用
 *
 * 实现：
 *  park & unpark is native method
 *
 */
package com.lizhuo.juc.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				if (i == 5) {
					LockSupport.park();  // 指定当前线程停车
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t.start();

		//LockSupport.unpark(t);  // 唤醒指定线程t  -- 可以先于park执行

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);   // 唤醒指定线程t

	}
}
