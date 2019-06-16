/**
 * 
 */
package com.xlfx.myeventbus.my;

/**
 * @author xlfx
 * @param <T>
 *
 */
public abstract class FunctionHasParamNoResult<T> extends Function {

	/**
	 * 
	 */
	public FunctionHasParamNoResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fuctionname
	 */
	public FunctionHasParamNoResult(String fuctionname) {
		super(fuctionname);
		// TODO Auto-generated constructor stub
	}

	public abstract void fuction(T t);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
