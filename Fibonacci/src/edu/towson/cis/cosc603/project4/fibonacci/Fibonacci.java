
package edu.towson.cis.cosc603.project4.fibonacci;

/**
 * The Class Fibonacci to simply calculates the nth Fibonacci number given the input n.
 */
public class Fibonacci {
	
	/**
	 * Calculates and returns the nth Fibonacci number.
	 *
	 * @param n the index
	 * @return the nth Fibonacci number
	 */
	public int fibonacci(int n) {
		switch (n) {
			case 0: return 0;
			//change the return 1 to return 0 in the case 0 so that when n=0, in case 0, the return value is 0 and not 1.
			case 1: return 1;
			default: return (fibonacci(n - 1) + fibonacci(n - 2));
		}
	}
}
