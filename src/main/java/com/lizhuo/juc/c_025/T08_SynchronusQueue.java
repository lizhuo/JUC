/**
 * SynchronousQueue 两个线程用于交换东西 容器容量为零
 * 类似 Exchanger
 * 可用于线程间互相交换任务
 * <p>
 * 如果没有消费者 take 则 生产者不能 put
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.put("aaa"); //阻塞等待消费者消费
		//strs.put("bbb");
		//strs.add("aaa");
		System.out.println(strs.size());
	}
}
