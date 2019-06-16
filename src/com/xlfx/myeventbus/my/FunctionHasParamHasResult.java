/**
 * 
 */
package com.xlfx.myeventbus.my;

/**
 * @author xlfx
 * @param <P>
 * @param <T>
 *
 */
public abstract class FunctionHasParamHasResult<P, T> extends Function {

	/**
	 * 
	 */
	public FunctionHasParamHasResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fuctionname
	 */
	public FunctionHasParamHasResult(String fuctionname) {
		super(fuctionname);
		// TODO Auto-generated constructor stub
	}

	public abstract T function(P p);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
