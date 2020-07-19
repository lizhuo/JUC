/**
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_016_LockOptimization;

import java.util.concurrent.TimeUnit;

/**
 * 锁优化
 * 细化 竞争不频繁 锁粒度越小越好
 * 粗化 锁太细碎 竞争太频繁 放粗
 */
public class FineCoarseLock {

	int count = 0;

	// fine lock
	synchronized void m1() {
		//do sth need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
		count++;

		//do sth need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void m2() {
		//do sth need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
		//采用细粒度的锁，可以使线程争用时间变短，从而提高效率
		synchronized (this) {
			count++;
		}
		//do sth need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
