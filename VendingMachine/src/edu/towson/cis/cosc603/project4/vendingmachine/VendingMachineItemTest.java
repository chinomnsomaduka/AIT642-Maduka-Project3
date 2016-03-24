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
public class VendingMachineItemTest {

	String invalidCode = "ABCD";
	VendingMachine myVendingMachine = new VendingMachine();
	VendingMachineItem snickers = new VendingMachineItem("snickers", 1.25);
	VendingMachineItem cookie = new VendingMachineItem("Cookie", 1.55);
	VendingMachineItem voidItem = new VendingMachineItem("voidItem", 0.00);
	VendingMachineItem defaultVendingMachineItem = new VendingMachineItem("defaultItem", 10.00);

	@Test
	public void testVendingMachineItem_Case1() {
		VendingMachineItem myVendingMachineItem1 = new VendingMachineItem("item1", 5.00);
		assertEquals("item1", myVendingMachineItem1.getName());
	}
	
	@Test
	public void testVendingMachineItem_Case2(){
		VendingMachineItem myVendingMachineItem2 = new VendingMachineItem("item2", 3.00);
		assertEquals("item2", myVendingMachineItem2.getName());
		
	}
	
	@Test (expected = VendingMachineException.class)
	public void testVendingMachineItem_Case3() throws Exception {
		VendingMachineItem myVendingMachineItem3 = new VendingMachineItem("item3", -5.00);
		assertEquals("item3", myVendingMachineItem3.getName());
	}
	
	@Test
	public void testGetName() {	
		defaultVendingMachineItem.getName();
		assertEquals("defaultItem", defaultVendingMachineItem.getName());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(10, defaultVendingMachineItem.getPrice(),0.01);
		
	}
	
	
		
}
