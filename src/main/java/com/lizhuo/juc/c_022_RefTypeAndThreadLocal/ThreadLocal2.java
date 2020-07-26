/**
 * ThreadLocal 线程局部变量
 * <p>
 * ThreadLocal 是使用空间换时间，synchronized 是使用时间换空间
 * 比如在 hibernate 中 session 就存在与 ThreadLocal 中，避免synchronized的使用
 * <p>
 * 运行下面的程序，理解 ThreadLocal
 *
 * @author lizhuo
 */
package com.lizhuo.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {
	//volatile static Person p = new Person();
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	static ThreadLocal<Person> threadLocal = new ThreadLocal<>();

	public static void main(String[] args) {

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(tl.get());
		}).start();

		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tl.set(new Person());
			threadLocal.set(new Person("lizhuo"));
			threadLocal.set(new Person("lizhuo-new"));

			System.out.println("tl: " + tl.get().name);
			System.out.println("tl: " + threadLocal.get().name);
		}).start();
	}

	static class Person {
		public Person() {
		}

		public Person(String name) {
			this.name = name;
		}

		String name = "zhangsan";
	}
}


