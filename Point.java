/*
	Created by: Jeremy Law
	Student number: c3183613
	Point class
*/
public class Point
{
	// class member variables for storing coordinates
	private double x,y;

	// Default constructor
	Point()
	{
		x = 0.0;
		y = 0.0;
	}

	// Constructor which takes two doubles when initialized for X and Y coordinates
	Point(double a, double b)
	{
		x = a;
		y = b;
	}

	// Precondition:	returns String representation of a Point
	// Postcondition: 	returns this point as a string in the format (XXXX.XX, YYYY.YY)
	public String toString()
	{
		String string = "(" + String.format("%4.2f", x) +"," + String.format("%4.2f", y) + ")";
		return string;
	}

	/*
	 Precondition: Point initialized
	 Postcondition: returns the distance from origin to this Point
	 */
	public double distance()
	{
		// use pythag's theorem? 
		return  Math.hypot(x, y);
	}

	// changes x coordinate
	public void setX(double a)
	{
		x = a;
	}
	// modifies Y coordinate
	public void setY(double a)
	{
		y = a;
	}
	// returns x coordinate of this Point
	public double getX()
	{
		return x;
	}
	// returns Y coordinate of this Point
	public double getY()
	{
		return y;
	}
}