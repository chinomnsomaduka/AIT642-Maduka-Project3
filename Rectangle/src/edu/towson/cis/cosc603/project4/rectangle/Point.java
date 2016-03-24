package edu.towson.cis.cosc603.project4.rectangle;

/**
 * The Point Class.
 */
public class Point {
	
	/** x and y coordinates. */
	public Double x, y;
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	Point(Double x, Double y) {
		//the test case failed because the value of y coordinate was given to x and y at the same time.
		this.x = x;
		//changed this.x = y to this.x = x
		this.y = y;
	}
}
