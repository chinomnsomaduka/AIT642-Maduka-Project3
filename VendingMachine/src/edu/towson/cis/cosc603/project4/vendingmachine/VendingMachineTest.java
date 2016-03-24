/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

/**
 * @author Chin
 *
 */
public class VendingMachineTest {
	
	String invalidCode = "ABCD";
	VendingMachine myVendingMachine = new VendingMachine();
	VendingMachineItem snickers = new VendingMachineItem("snickers", 1.25);
	VendingMachineItem cookie = new VendingMachineItem("Cookie", 1.55);
	VendingMachineItem voidItem = new VendingMachineItem("voidItem", 0.00);
	
	
	@Test
	public void testAddItem_Case1() {
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);  
		assertEquals(snickers, myVendingMachine.getItem(VendingMachine.A_CODE)); 
	}
	@Test
	public void testAddItem_Case2() {
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);
		assertEquals(snickers,myVendingMachine.getItem(VendingMachine.A_CODE)); 
	}
	
	@Test
	(expected = VendingMachineException.class)
	public void testAddItem_Case3() throws Exception{
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);  
		assertEquals(snickers, myVendingMachine.getItem(VendingMachine.A_CODE));
		myVendingMachine.addItem(cookie, VendingMachine.A_CODE); 
		assertEquals(cookie, myVendingMachine.getItem(VendingMachine.A_CODE));
	}	
	
	@Test
	(expected = VendingMachineException.class)
	public void testAddItem_Case4() throws Exception {
		myVendingMachine.addItem(voidItem, invalidCode);  
	}

	@Test (expected = VendingMachineException.class)
	public void testRemoveItem_Case1() throws Exception{
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);  
		myVendingMachine.removeItem(VendingMachine.A_CODE);
		assertEquals(snickers, myVendingMachine.removeItem(VendingMachine.A_CODE));
	}
		
	@Test (expected = VendingMachineException.class)
	public void testRemoveItem_Case2() throws Exception {
		String temp= ""; 
		myVendingMachine.removeItem(VendingMachine.A_CODE);
		assertEquals(true, myVendingMachine.removeItem(temp));
	}

	@Test (expected = VendingMachineException.class)
	public void testRemoveItem_Case3() throws Exception {
		myVendingMachine.removeItem(invalidCode);
		assertEquals(true, myVendingMachine.removeItem(invalidCode));
	}
	
	@Test
	public void testInsertMoney_Case1() {
		myVendingMachine.insertMoney(20);
		assertEquals(20, myVendingMachine.getBalance(),0.01);
	}
	
	@Test
	public void testInsertMoney_Case2() {
		myVendingMachine.insertMoney(0);
		assertEquals(0, myVendingMachine.getBalance(),0.01);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testInsertMoney_Case3() throws Exception{
		myVendingMachine.insertMoney(-20.0);
		assertEquals(-20, myVendingMachine.getBalance(),0.01);
	}
	
	@Test 
	public void testGetBalance()  {
		myVendingMachine.insertMoney(5);
		myVendingMachine.getBalance();
		assertEquals(5 ,myVendingMachine.getBalance(),0.1);
	}
	
	@Test 
	public void testMakePurchase_Case1()  {
		myVendingMachine.insertMoney(5);
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);  
		myVendingMachine.makePurchase(VendingMachine.A_CODE);
		// balance is 5.00-1.25 = 3.75. Purchase is made, and balance is 3.75
		assertEquals(3.75,myVendingMachine.getBalance(),.01);		
	}
	
	@Test (expected = VendingMachineException.class)
	public void testMakePurchase_Case2() throws Exception {
		myVendingMachine.removeItem(VendingMachine.A_CODE);
		myVendingMachine.makePurchase(VendingMachine.A_CODE);
		assertEquals(false, myVendingMachine.makePurchase(VendingMachine.A_CODE));
	}
	
	@Test (expected = VendingMachineException.class)
	public void testMakePurchase_Case3() throws Exception {
		myVendingMachine.makePurchase(invalidCode);
		assertEquals(false, myVendingMachine.makePurchase(invalidCode));
	}
	
	@Test 
	public void testReturnChange() {
		myVendingMachine.insertMoney(5);
		myVendingMachine.addItem(snickers, VendingMachine.A_CODE);  
		myVendingMachine.makePurchase(VendingMachine.A_CODE);
		assertEquals(3.75, myVendingMachine.returnChange(),0.01);
	}

	
	
	}
