/**
 * 弱引用只要遭遇到GC就会回收
 * <p>
 * 场景：
 * 1. 容器 一般使用再容器中，Tomcat 中有使用
 *  一旦某对象的强引用实效，即可回收此对象
 * 2. ThreadLocal
 *  注意内存泄露
 */
package com.lizhuo.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;

public class T03_WeakReference {
	public static void main(String[] args) {
		WeakReference<M> m = new WeakReference<>(new M());

		System.out.println(m.get());
		System.gc();
		System.out.println(m.get());


		// 应用案例
		ThreadLocal<M> tl = new ThreadLocal<>();
		tl.set(new M()); // key: tl value: new M()
		tl.remove(); // 不用则必须 remove 掉，否则会引起内存泄露

	}
}
