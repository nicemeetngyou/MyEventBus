/**
 * 
 */
package com.xlfx.myeventbus.my2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xlfx.myeventbus.my2.EventBus;
import com.xlfx.myeventbus.my2.Subscrible;
import com.xlfx.myeventbus.my2.ThreadMode;

/**
 * @author Administrator
 *
 */
public class MyEventBusTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		EventBus.getDefault().register(this);
		EventBus.getDefault().post(new EventBean("Jay", 45));
	}

	/**
	 * @Subscrible 用于标识添加到Eventbus中进行管理的方法
	 */
	@Subscrible(threadMode = ThreadMode.MAIN)
	public void getMessage(String messsage) {
		System.out.println("tets getMessage()");
	}

	// *多参数方法，使用对象封装，同样可以用单参数流程处理
	@Subscrible(threadMode = ThreadMode.MAIN)
	public void getMessage(EventBean eventbean) {
		System.out.println(eventbean.toString());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

}
