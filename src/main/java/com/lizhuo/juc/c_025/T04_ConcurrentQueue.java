/**
 * Queue 基本用法
 * Method: 非阻塞
 *  add/offer
 *  poll/peek
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < 10; i++) {
			/**
			 * add throw exception
			 * offer  return true/false
			 */
			strs.offer("a" + i);  //add
		}

		System.out.println(strs);

		System.out.println(strs.size());

		System.out.println(strs.poll());
		System.out.println(strs.size());

		System.out.println(strs.peek());
		System.out.println(strs.size());

		// 双端 Deque
	}
}
