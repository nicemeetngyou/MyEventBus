/**
 * 注解类
 */
package com.xlfx.myeventbus.my2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import org.greenrobot.eventbus.ThreadMode;

/**
 * @author xlfx
 * @注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscrible {
	ThreadMode threadMode() default ThreadMode.MAIN;
}
