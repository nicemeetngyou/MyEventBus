/**
 * 
 */
package com.xlfx.myeventbus.my2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class EventBus {

	private Map<Object, List<SubscribleMethod>> mMethodMap;
	// 单例模式
	private static volatile EventBus instance;

	/**
	 * @单例模式
	 * @私有构造函数
	 */
	private EventBus() {
		mMethodMap = new HashMap<>();
	}

	/**
	 * @单例获取函数
	 * @单例模式
	 *
	 */
	public static EventBus getDefault() {
		if (null == instance) {
			instance = new EventBus();
		}
		return instance;

	}

	// 查找和添加 方法到容器
	public void register(Object object) {
		List<SubscribleMethod> methodList = mMethodMap.get(object);
		if (methodList == null) {
			methodList = findSubscribleMethod(object);

		}
		mMethodMap.put(object, methodList);

	}

	private List<SubscribleMethod> findSubscribleMethod(Object object) {
		List<SubscribleMethod> list = new ArrayList<>();
		Class<?> clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();

		while (null != clazz) {
			// 找父类是要先判断一下是否是系统级别的类
			String className = clazz.getName();
			if (className.startsWith("java.") || className.startsWith("javax.") || className.startsWith("android.")) {
				// continue;
				break;
			}

			// 查找当前类包含Subscrible注解的方法
			for (Method method : methods) {
				// 得到带有Subscrible注解的方法
				Subscrible subscrible = method.getAnnotation(Subscrible.class);
				if (subscrible == null) {
					continue;
				} else {
					// 判断方法中参数的个数
					Class<?>[] types = method.getParameterTypes();
					if (types.length == 1) {
						ThreadMode threadMode = subscrible.threadMode();
						SubscribleMethod subscribleMethod = new SubscribleMethod(method, threadMode, types[0]);
						list.add(subscribleMethod);
					} else {
						System.out.println("错误！容器中只接收单个参数的方法");
					}
				}

			} // for
			clazz = clazz.getSuperclass();
		} // while

		return list;
	}

	public void post(Object type) {
		// 直接遍历Map中的对应方法进行回调
		Set<Object> set = mMethodMap.keySet();
		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next();
			List<SubscribleMethod> list = mMethodMap.get(object);
			for (SubscribleMethod subscribleMethod : list) {

				// a(if条件前面的对象) 所对应的类信息是不是b(if条件后面的对象)对象所对应的类信息的父类或接口
				if (subscribleMethod.getType().isAssignableFrom(type.getClass())) {
					invoke(subscribleMethod, object, type);
				}

			}

		}

	}

	private void invoke(SubscribleMethod subscribleMethod, Object object, Object type) {
		Method method = subscribleMethod.getMethod();
		try {
			method.invoke(object, type);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
