/**
 * 
 */
package com.xlfx.myeventbus.my.moudle;

/**
 * @author Administrator
 *
 */
public class User {

	

	private String mName;
	private String mAge;
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
	public String getAge() {
		return mAge;
	}

	/**
	 * @param mAge the mAge to set
	 */
	public void setAge(String mAge) {
		this.mAge = mAge;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [mName=" + mName + ", mAge=" + mAge + "]";
	}

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
