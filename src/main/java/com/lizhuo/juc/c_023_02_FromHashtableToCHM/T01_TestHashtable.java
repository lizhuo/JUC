/**
 * HashTable 线程安全
 * <p>
 * Performance:
 * write cost: 569
 * 1000000
 * read cost:55096
 */
package com.lizhuo.juc.c_023_02_FromHashtableToCHM;

import java.util.Hashtable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class T01_TestHashtable extends TestThreadBase {

	static Hashtable<UUID, UUID> m = new Hashtable<>();

	static int count = Constants.COUNT;
	static UUID[] keys = new UUID[count];
	static UUID[] values = new UUID[count];
	static final int THREAD_COUNT = Constants.THREAD_COUNT;

	static {
		for (int i = 0; i < count; i++) {
			keys[i] = UUID.randomUUID();
			values[i] = UUID.randomUUID();
		}
	}

	static class MyThread extends Thread {
		int start;
		int gap = count / THREAD_COUNT;

		public MyThread(int start) {
			this.start = start;
		}

		@Override
		public void run() {
			for (int i = start; i < start + gap; i++) {
				m.put(keys[i], values[i]);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThread(i * (count / THREAD_COUNT));
		}
		startAndJoin(threads);

		long end = System.currentTimeMillis();
		System.out.println("write cost: " + (end - start));
		System.out.println(m.size());


		// 读取性能  --------------
		start = System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 10000000; j++) {
					m.get(keys[10]);
				}
			});
		}

		startAndJoin(threads);

		end = System.currentTimeMillis();
		System.out.println("read cost:" + (end - start));

		TimeUnit.SECONDS.sleep(2);
	}

}
