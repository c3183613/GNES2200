public class SemiCircle extends PlanarShape
{
	private Point pointArray[];// 
	private double radius;

	SemiCircle(Point a, Point b)
	{
		pointArray = new Point[4];
		pointArray[0] = a;
		pointArray[1] = b;
		radius = Math.sqrt(Math.pow(pointArray[0].getX() - pointArray[1].getX(),2) + Math.pow(pointArray[0].getY() - pointArray[1].getY(),2));
		Point retPoint = new Point();
		retPoint.setY(pointArray[1].getY() - pointArray[0].getY()); // point1.y - point2.y
		retPoint.setX(pointArray[1].getX() - pointArray[0].getX()); // point1.y - point2.y
		pointArray[2] = new Point(pointArray[0].getX()+retPoint.getX(), pointArray[0].getY()+retPoint.getY());
		pointArray[3] = new Point(pointArray[0].getX()-retPoint.getX(), pointArray[0].getY()-retPoint.getY());
	}

	private Point[] getPoints()
	{
		Point[] retPoints = new Point[3];
		retPoints[0].setY(pointArray[1].getY() - pointArray[0].getY()); // point1.y - point2.y
		retPoints[0].setX(pointArray[1].getX() - pointArray[0].getX()); // point1.y - point2.y
		retPoints[1] = new Point(pointArray[0].getX()+retPoints[0].getX(), pointArray[0].getY()+retPoints[0].getY());
		retPoints[1] = new Point(pointArray[0].getX()-retPoints[0].getX(), pointArray[0].getY()-retPoints[0].getY());
		return retPoints;
	}

	public String toString()
	{
		// SEMI=[point 0 point 1 ]: area_value
		String s = "SEMI=[";
		s+=pointArray[0].toString()+", "+pointArray[1].toString() +"]: "+String.format("%5.2f", area());
		return s;
	}

	public double area()
	{
		return (Math.PI * Math.pow(radius,2))/2;
	}

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