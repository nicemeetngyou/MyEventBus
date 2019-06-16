/**
 * 
 */
package com.xlfx.myeventbus.my;

/**
 * @author xlfx
 * @param <T>
 *
 */
public abstract class FunctionNoParamHasResult<T> extends Function {

	/**
	 * 
	 */
	public FunctionNoParamHasResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fuctionname
	 */
	public FunctionNoParamHasResult(String fuctionname) {
		super(fuctionname);
		// TODO Auto-generated constructor stub
	}

	// 使用泛型参数
	public abstract T Fuction();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
