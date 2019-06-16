/**
 * @参考EventBus
 * @目前只包含添加方法到容器的逻辑
 * @没有包含移除容器中方法放入逻辑
 * @需要参照EventBus继续学习
 */
package com.xlfx.myeventbus.my;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @param <FuctionNoParamNoResult>
 *
 */
public class FunctionManager {
	// 单例
	private static FunctionManager instance;

	// 方法容器
	private Map<String, FunctionNoParamNoResult> mNoParamNoResultMap;
	private Map<String, FunctionNoParamHasResult> mNoParamHasResultMap;
	private Map<String, FunctionHasParamNoResult> mHasParamNoResultMap;
	private Map<String, FunctionHasParamHasResult> mHasParamHasResultMap;

	/**
	 * @private Constructor
	 * @单例
	 */
	private FunctionManager() {
		mNoParamHasResultMap = new HashMap<>();
		mNoParamNoResultMap = new HashMap<>();
		mHasParamHasResultMap = new HashMap<>();
		mHasParamNoResultMap = new HashMap<>();
	}

	public static FunctionManager getInstance() {

		if (null == instance) {
			instance = new FunctionManager();
		}
		return instance;

	}

	// 添加方法到方法容器中
	public void addFunction(FunctionNoParamNoResult function) {
		mNoParamNoResultMap.put(function.mFunctionName, function);

	}

	// TextUtils.isEmpty() is Android API？
	// 调用方法容器中的方法
	public void invokeFunction(String functionName) {

		if (null == functionName || functionName.length() == 0) {

			// Log @ Android Project
			System.out.println("方法名为空终止流程 ！");
			return;
		}

		if (null != mNoParamNoResultMap && !mNoParamNoResultMap.isEmpty()) {

			FunctionNoParamNoResult functionNoParamNoResult = mNoParamNoResultMap.get(functionName);
			if (null != functionNoParamNoResult) {
				functionNoParamNoResult.fuction();
			} else {
				// Log @ Android Project
				System.out.println("方法容器中找不到对应的方法 ！");
				return;
			}
		} else {
			// Log @ Android Project
			System.out.println("方法容器为空终止流程 ！");
			return;
		}
	}

	// 4
	// 4.1添加有参数有返回值的方法到方法容器、
	public void addFunction(FunctionHasParamHasResult function) {
		mHasParamHasResultMap.put(function.mFunctionName, function);
	}

	// 4.2 从方法容器调用有参数有返回值的方法、
	public <P, T> T invokeFunction(String functionName, P p, Class<T> t) {
		if (null == functionName || functionName.length() == 0) {

			// Log @ Android Project
			System.out.println("方法名为空终止流程 ！");
			return null;
		}

		if (null != mHasParamHasResultMap && !mHasParamHasResultMap.isEmpty()) {

			FunctionHasParamHasResult functionHasParamHasResult = mHasParamHasResultMap.get(functionName);
			if (null != functionHasParamHasResult) {
				if (null != t) {
					// ???
					// 将functionHasParamHasResult.function(p)的返回值
					// 转换成泛型T
					return t.cast(functionHasParamHasResult.function(p));
				}
			} else {
				// Log @ Android Project
				System.out.println("方法容器中找不到对应的方法 ！");
				return null;
			}
		} else {
			// Log @ Android Project
			System.out.println("方法容器为空终止流程 ！");
			return null;
		}
		return null;

	}

	public static boolean strIsEmpty(String str) {
		// 先判空防止空指针异常
		// str.isEmpty()就是判断str.length()是否等于0
		if (str == null || str.isEmpty()) {
			// 可能报空指针的写法if (str.isEmpty() ||str == null) {
			return true;
		}
		return false;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strIsEmpty(""));
		System.out.println(strIsEmpty(null));
		// System.out.println("".isEmpty());
	}

}
