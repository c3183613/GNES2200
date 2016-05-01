public class Circle extends PlanarShape
{
	private Point circCentre;
	private double radius;

	Circle(Point p, double r)
	{
		circCentre = p;
		radius = Math.abs(r);
	}

	public double area()
	{
		return Math.PI * Math.pow((radius),2);
	}

	public String toString()
	{
		String s="CIRC=[";
		s+= circCentre.toString() + " "+radius+"]:"+String.format("%5.2f", area());
		return s;
	}

	public double originDistance()
	{
		return Math.abs(circCentre.distance()-radius);
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