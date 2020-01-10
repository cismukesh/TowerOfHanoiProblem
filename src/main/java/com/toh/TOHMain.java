package com.toh;

import java.math.BigDecimal;
/**
 * Main class to start program execution by running main method
 * @author cis (MS)
 * 
 *
 */
public class TOHMain {

	//static instance of class TowerOfHanoi to execute TOH methods
	static TowerOfHanoi towerOfHanoi = new TowerOfHanoi();

	/**
	 * This method is used to get expected value
	 * @return BigDecimal value
	 */
	private static BigDecimal getExpectedValue() {

		double mod = Math.pow(10, 9);
		double totalExpValue = 0, prevG = 0, currG = 1, k = 10, a = 3, b = 6, c = 9;

		for (int n = 1; n < (10000 + 1); n++) {

			double expValue = (2 * currG * (c - a) * (k - 1) - (2 * k - b - c) * (c - b)) % mod;
			totalExpValue = (totalExpValue + expValue) % mod;
			prevG = currG;
			currG = (currG + 2 * prevG + 1) % mod;
			k = (k * 10) % mod;
			a = (a * 3) % mod;
			b = (b * 6) % mod;
			c = (c * 9) % mod;
		}
		return BigDecimal.valueOf(totalExpValue);
	}

	public static void main(String[] args) {
		for (int n = 1; n < (10 + 1); n++) {
			System.out.println(n + "=> " + towerOfHanoi.startProcess(n));
		}
		System.out.println(getExpectedValue());
	}
}
