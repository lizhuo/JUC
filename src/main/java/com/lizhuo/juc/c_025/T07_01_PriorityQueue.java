/**
 * PriorityQueue 优先级队列
 *
 * 内部实现使用的是二叉树：最小堆
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_025;

import java.util.PriorityQueue;

public class T07_01_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<>();

		q.add("c");
		q.add("e");
		q.add("a");
		q.add("d");
		q.add("z");

		for (int i = 0; i < 5; i++) {
			System.out.println(q.poll());
		}

	}
}
