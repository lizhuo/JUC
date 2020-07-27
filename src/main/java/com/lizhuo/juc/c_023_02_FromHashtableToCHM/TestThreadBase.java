package com.lizhuo.juc.c_023_02_FromHashtableToCHM;

public abstract class TestThreadBase {

	protected static void startAndJoin(Thread[] threads) {
		if (threads == null || threads.length <= 0) {
			return;
		}

		for (Thread t : threads) {
			t.start();
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
