/**
 * 
 */
package com.toh.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.toh.TowerOfHanoi;

/**
 * @author cis
 *
 */
public class TestTowerOfHanoi {

	TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTOH1() {
		System.out.println("test-case 1 " + towerOfHanoi.startProcess(1));
	}
	
	@Test
	public void testTOH2() {
		System.out.println("test-case 2 " + towerOfHanoi.startProcess(5));
	}
	
	@Test
	public void testTOH3() {
		System.out.println("test-case 3 " + towerOfHanoi.startProcess(11));
	}
	
	@Test
	public void testTOH4() {
		System.out.println("test-case 4 " + towerOfHanoi.startProcess(6));
	}
	
	@Test
	public void testTOH5() {
		System.out.println("test-case 5 " + towerOfHanoi.startProcess(12));
	}

}
