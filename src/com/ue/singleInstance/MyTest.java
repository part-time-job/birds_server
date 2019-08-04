package com.ue.singleInstance;

public class MyTest {

	private volatile static MyTest myTest;

	private MyTest() {

	}

	// 同步锁
	public static MyTest newInstance() {
		if (myTest == null) {
			synchronized (MyTest.class) {
				if (myTest == null) {

					myTest = new MyTest();
				}
			}

		}
		return myTest;
	}
}
