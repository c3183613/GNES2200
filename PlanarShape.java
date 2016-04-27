import java.util.Scanner;

public abstract class PlanarShape
{
	public abstract String toString();

	public abstract double area();

	public abstract double originDistance();

	public abstract void modifyArray(int index, Point point);

	public abstract Point[] getArray();

	public static PlanarShape shapeFactory(Scanner scan)
	{
		String shapeType = scan.next();
		PlanarShape newShape = null; // if not = null, error, variable newShape might not have been initialized
		switch(shapeType)
		{
			case "P":
			{
				newShape = new Polygon(scan.nextInt()+1);
							// variable used to keep track of which index of array to modify
				int i =0;
				// while there are inputs to take
				while(scan.hasNextDouble())
				{
					newShape.modifyArray(i, new Point(scan.nextDouble(), scan.nextDouble()));
					i++;
				}
				// Deep copy the first point of the polygon as the last
				newShape.modifyArray(i, new Point(newShape.getArray()[0].getX(), newShape.getArray()[0].getY()));
				break;
			}

			default:
			{
				System.out.println("This is not valid input");
				break;
			}
		}
		return newShape;
	}
}