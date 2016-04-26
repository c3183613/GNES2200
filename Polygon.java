/*
	Jeremy Law
	c3183613
	Polygon class
*/

public class Polygon extends PlanarShape
{	
	// array of Points
	private Point arrayPoint[];

	/*
		Preconditions: none
		Postconditions: Initializes array of points with size dimension
	*/
	Polygon(int dimension)
	{
		arrayPoint = new Point[dimension];
	}

	/*
		Precondition: Polygon initialized
		Postconditions: returns a string of the list of arrayPoint elements in the format
			[(x0, y0), (x1, y1), ... (xn, yn): area]
			[(x0, y0), (x1, y1), ... (xn, yn): area]
	*/
	// Sequence of Point objects representing the ordered vertices of the polygon
	public String toString()
	{
		String s = "POLY=[";
		// for each element in Point LinkedList, print area in form 5.2f
		for(int i=0; i<arrayPoint.length; i++)
		{
			s+= arrayPoint[i].toString()+", ";
		}
		s+=": " + String.format("%5.2f", area()) + "]";
		// [(point0), .... , pointn]:area
		return s;
	}	

	/*
		Preconditions: Polygon initialized
		Postconditions: returns the area of the Polygon
	*/
	public double area() 
	{
		double area = 0;
		// formula of calculating the area of a polygon
		for(int i=0; i< arrayPoint.length-1; i++)
		{
			area += ((arrayPoint[i+1].getX()+arrayPoint[i].getX())*(arrayPoint[i+1].getY()-arrayPoint[i].getY()));
		}
		area = Math.abs(area);
		return area/2;
	}

	/*
		Preconditions: Polygon initialized
		Postconditions: modify the array element at index 'index' of the array, to hold 'point'
	*/
	public void modifyArray(int index, Point point)
	{
		arrayPoint[index] = point;
	}

	/*
		Preconditions: Polygon initialized
		Postconditions: return arrayPoint
	*/
	public Point[] getArray()
	{
		return arrayPoint;
	}

	/*
		Preconditions: Polygon initialized
		Postconditions: if comparee is within 0.05% of this Polygon's area or
					this Polygon is within 0.05% of comparee's area, they are considered equal 
					and return true, otherwise return false
	*/
	public boolean equals(Polygon comparee)
	{
		if(area()*0.9995 <= comparee.area() && comparee.area() <= area()*1.0005)
			return true;
		else if(comparee.area()*0.9995 <= area() && area() <= comparee.area()*1.0005)
			return true;
		else
			return false;
	}

	/*
		Preconditions: Polygon initialized
		Postconditions: returns this Polygon's closest Point to the origin
	*/
	public Point closestPointToOrigin()
	{
		Point a = arrayPoint[0];
		for(int i=1; i<arrayPoint.length; i++)
		{
			if(arrayPoint[i].distance() < a.distance())
				a = arrayPoint[i];
		}
		return a;
	}
}