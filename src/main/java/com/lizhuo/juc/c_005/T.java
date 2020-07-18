/**
 * 分析一下这个程序的输出
 *
 * @author lizhuo
 */

package com.lizhuo.juc.c_005;

import java.util.ArrayList;
import java.util.List;

public class T implements Runnable {


	private /*volatile*/ int count = 10;

	public /*synchronized*/ void run() {
		count--;
		//Thread.yield();
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}

	public static void main(String[] args) throws InterruptedException {
		T t = new T();
//		for (int i = 0; i < 100000; i++) {
//			new Thread(t, "THREAD" + i).start();
//		}

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(t, "thread_" + i));
			//threads.get(i).join();
		}

		for (Thread thread : threads) {
			thread.start();
		}

		System.out.println("---- main thread: " + t.count);
		//? ---- main thread: 1

	}

}
