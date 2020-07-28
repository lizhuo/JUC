/**
 * 有界 BlockingQueue
 */
package com.lizhuo.juc.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

	static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

	static Random r = new Random();

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strs.put("a" + i);
		}

		//strs.put("aaa"); // 满了就会等待，程序阻塞
		//strs.add("aaa"); // 会跑出异常
		//strs.offer("aaa"); // 通过返回值判断结果 可以加 Timeout
		strs.offer("aaa", 1, TimeUnit.SECONDS);

		System.out.println(strs);
	}
}
