/**
 * VarHandle：
 * 1. 普通属性也可以执行原子性操作
 * 2. 比反射快，相当于直接操作二进制码 反射每次都要做检查，VarHandle 不需要做检查 效率高
 * <p>
 * AQS：
 * 释放锁 比较简单 自己看 unlock
 */
package com.lizhuo.juc.c_021_03_VarHandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * since jdk 1.9
 */
public class T01_HelloVarHandle {

	int x = 8;

	private static VarHandle handle;

	static {
		try {
			handle = MethodHandles.lookup().findVarHandle(T01_HelloVarHandle.class, "x", int.class);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		T01_HelloVarHandle t = new T01_HelloVarHandle();

		//plain read / write
		System.out.println((int) handle.get(t));
		handle.set(t, 9);
		System.out.println(t.x);

		handle.compareAndSet(t, 9, 10); // 保证原子性
		System.out.println(t.x);

		handle.getAndAdd(t, 10);  // 保证原子性
		System.out.println(t.x);

	}
}
