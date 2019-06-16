package com.xlfx.myeventbus.my.test;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xlfx.myeventbus.my.FunctionHasParamHasResult;
import com.xlfx.myeventbus.my.FunctionManager;
import com.xlfx.myeventbus.my.FunctionNoParamNoResult;
import com.xlfx.myeventbus.my.moudle.User;

/**
 * 
 */

/**
 * @author xlfx
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
		
		FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult("NoParamNoResult") {

			@Override
			public void fuction() {
				System.out.println("FunctionNoParamNoResult add at test setUp()>>>");
			}
		});

		// FunctionHasParamHasResult
		FunctionManager.getInstance()
				.addFunction(new FunctionHasParamHasResult<User, User>("FunctionHasParamHasResult") {

					// @Override
					// public Object function(Object p) {
					//
					// System.out.println("FunctionHasParamHasResult add at test
					// setUp()>>>");
					// return null;
					// }

					@Override
					public User function(User param) {
						
						System.out.println("FunctionHasParamHasResult add at testsetUp()>>>");

						System.out.println("传递过来的参数为: "+ param.toString());
						User user = new User();
						user.setName("Leehom");
						user.setAge("45");

						return user;
					}
				});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		FunctionManager.getInstance().invokeFunction("NoParamNoResult");

		// FunctionHasParamHasResult
		User user = new User();
		user.setName("Jay");
		user.setAge("43");
		User result = FunctionManager.getInstance().invokeFunction("FunctionHasParamHasResult",user,User.class);
		System.out.println("返回的结果为："+result.toString());
		//fail("Not yet implemented");
	}

}
