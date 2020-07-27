/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * <p>
 * 使用Vector或者Collections.synchronizedXXX
 * 分析一下，这样能解决问题吗？
 *
 * 结论：仍旧发生超卖 size 与 remove 不是原子性操作
 */
package com.lizhuo.juc.c_024_FromVectorToQueue;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TicketSeller2 {
	static Vector<String> tickets = new Vector<>();


	static {
		for (int i = 0; i < 1000; i++) tickets.add("ticket no:" + i);
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				// size() remove() 整体并非原子
				while (tickets.size() > 0) {

					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println("sale--" + tickets.remove(0));
				}
			}).start();
		}
	}
}
