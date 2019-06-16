/**
 * 
 */
package com.xlfx.myeventbus.my2;

import java.lang.reflect.Method;

/**
 * @author Administrator
 *
 */
public class SubscribleMethod {

	private Method mMethod;
	private ThreadMode mThreadMode;
	private Class<?> mType;
	
	
	/**
	 * 
	 */
	public SubscribleMethod() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param mMethod
	 * @param mThreadMode
	 * @param mType
	 */
	public SubscribleMethod(Method mMethod, ThreadMode mThreadMode, Class<?> mType) {
		this.mMethod = mMethod;
		this.mThreadMode = mThreadMode;
		this.mType = mType;
	}
	/**
	 * @return the mMethod
	 */
	public Method getMethod() {
		return mMethod;
	}

	/**
	 * @param mMethod the mMethod to set
	 */
	public void setMethod(Method mMethod) {
		this.mMethod = mMethod;
	}

	/**
	 * @return the mThreadMode
	 */
	public ThreadMode getThreadMode() {
		return mThreadMode;
	}

	/**
	 * @param mThreadMode the mThreadMode to set
	 */
	public void setThreadMode(ThreadMode mThreadMode) {
		this.mThreadMode = mThreadMode;
	}

	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return mType;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(Class<?> type) {
		mType = type;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
