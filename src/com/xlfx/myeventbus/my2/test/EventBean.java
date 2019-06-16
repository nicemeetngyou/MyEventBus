/**
 * 
 */
package com.xlfx.myeventbus.my2.test;

/**
 * @author Administrator
 *
 */
public class EventBean {

	private String mName;
	private int mAge;
	
	/**
	 * @param mName
	 * @param mAge
	 */
	public EventBean(String mName, int mAge) {
		this.mName = mName;
		this.mAge = mAge;
	}

	/**
	 * @return the mName
	 */
	public String getName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the mAge
	 */
	public int getAge() {
		return mAge;
	}

	/**
	 * @param mAge the mAge to set
	 */
	public void setAge(int mAge) {
		this.mAge = mAge;
	}

	/**
	 * 
	 */
	public EventBean() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventBean [mName=" + mName + ", mAge=" + mAge + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
