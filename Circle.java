/*
	Jeremy Law
	c3183613
	Circle class
*/
public class Circle extends PlanarShape
{
	// private member variables
	private Point circCentre;
	private double radius;

	/*
		Precondition: none
		Postcondition: Circle instantiated with member variables
	*/
	Circle(Point p, double r)
	{
		circCentre = p;
		radius = Math.abs(r);
	}

	/*
		Precondition: Circle instantiated
		Postcondition: returns area
	*/
	public double area()
	{
		return Math.PI * Math.pow((radius),2);
	}

	/*
		Precondition: Circle instantiated
		Postcondition: returns String representation of Circle
	*/
	public String toString()
	{
		String s="CIRC=[";
		s+= circCentre.toString() + " "+radius+"]:"+String.format("%5.2f", area());
		return s;
	}

	/*
		Precondition: Circle instantiated
		Postcondition: returns distance from closest point of circumference to the origin
	*/
	public double originDistance()
	{
		return Math.abs(circCentre.distance()-radius);
	}

	// These member variables are not used so if called, they throw UnsupportedOperationException
	@Override
	public void modifyArray(int index, Point point)
	{
		throw new UnsupportedOperationException("This feature is not supported in this class");
	}

	@Override
	public Point[] getArray()
	{
		throw new UnsupportedOperationException("This feature is not supported in this class");
	}
}