public class SemiCircle extends PlanarShape
{
	private Point point1, point2, point3, point4;
	private double radius;

	SemiCircle(Point a, Point b)
	{
		point1 = a;
		point2 = b;
		radius = Math.sqrt(Math.pow(point1.getX() - point2.getX(),2) + Math.pow(point1.getY() - point2.getY(),2))
		point3 = null;
		point4 = null;
	}

	public 
}