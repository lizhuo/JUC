/**
 * 强引用
 *
 * m = null 回收
 */
package com.lizhuo.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

public class T01_NormalReference {
	public static void main(String[] args) throws IOException {
		M m = new M();
		m = null;
		System.gc(); //DisableExplicitGC

		System.in.read();
	}
}
