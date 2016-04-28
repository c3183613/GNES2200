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
		return (Math.PI * radius) * (Math.Pi * radius);
	}

	public String toString()
	{
		String s="CIRC=[";
		s+= circCentre.toString + " "+radius+"]:"+area();
		return s;
	}

	public double originDistance()
	{
		return (circCentre.distance()-radius);
	}
}