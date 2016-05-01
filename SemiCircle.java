/*
	Jeremy Law
	c3183613
	SemiCircle class
*/

public class SemiCircle extends PlanarShape
{
	private Point pointArray[]; // initialize array of Points 
	private double radius;		// initialize radius

	// Constructor for SemiCircle
	/*
		Preconditions: Point a is middle point, Point b is perpendicular to 'a' and equal distance from calculated
		pointArray[2] and pointArray[3] (this is really hard to articulate)
		Postconditions: SemiCircle initialized
	*/
	SemiCircle(Point a, Point b)
	{
		pointArray = new Point[4];	// Instantiation of pointArray, holds 4 Points
		pointArray[0] = a; 			// hold input in array
		pointArray[1] = b;
		// calculate radius
		radius = Math.sqrt(Math.pow(pointArray[0].getX() - pointArray[1].getX(),2) + Math.pow(pointArray[0].getY() - pointArray[1].getY(),2));
		// calculate other two points (perpendicular)
		Point retPoint = new Point();
		retPoint.setY(pointArray[1].getY() - pointArray[0].getY()); // point1.y - point2.y
		retPoint.setX(pointArray[1].getX() - pointArray[0].getX()); // point1.y - point2.y
		pointArray[2] = new Point(pointArray[0].getX()+retPoint.getX(), pointArray[0].getY()+retPoint.getY());
		pointArray[3] = new Point(pointArray[0].getX()-retPoint.getX(), pointArray[0].getY()-retPoint.getY());
	}

	// not used 
	private Point[] getPoints()
	{
		Point[] retPoints = new Point[3];
		retPoints[0].setY(pointArray[1].getY() - pointArray[0].getY()); // point1.y - point2.y
		retPoints[0].setX(pointArray[1].getX() - pointArray[0].getX()); // point1.y - point2.y
		retPoints[1] = new Point(pointArray[0].getX()+retPoints[0].getX(), pointArray[0].getY()+retPoints[0].getY());
		retPoints[1] = new Point(pointArray[0].getX()-retPoints[0].getX(), pointArray[0].getY()-retPoints[0].getY());
		return retPoints;
	}

	/*
		Precondition: SemiCircle initialized
		Postcondition: return string representation of semi circle
	*/
	public String toString()
	{
		// SEMI=[point 0 point 1 ]: area_value
		String s = "SEMI=[";
		s+=pointArray[0].toString()+", "+pointArray[1].toString() +"]: "+String.format("%5.2f", area());
		return s;
	}

	/*
		Precondition: SemiCircle initialized
		Postcondition: returns area of SemiCircle
	*/
	public double area()
	{
		return (Math.PI * Math.pow(radius,2))/2;
	}

	/*
		Precondition: SemiCircle initialized
		Postcondition: returns whichever Point of pointArray is closest to the origin
	*/
	public double originDistance()
	{
		Point smallest = pointArray[0];
		for(int i=1; i<4; i++)
		{
			if(pointArray[i].distance() < smallest.distance())
				smallest = pointArray[i];
		}
		return smallest.distance();
	}


	// Last 2 methods not implemented as they are not used, thus throw UnsupportedOperationException when called
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