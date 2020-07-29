/**
 * TransferQueue 放入任务后 等待此任务已经处理才解除阻塞
 * 确保任务已经投递到了
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T09_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.transfer("aaa");

		//strs.put("aaa");

		// TransferQueue 会一直阻塞
		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/

	}
}
