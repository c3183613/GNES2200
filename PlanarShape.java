import java.util.Scanner;

public abstract class PlanarShape implements Comparable<PlanarShape>
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

	/*
	Preconditions:
	Postconditions: If this Polygon comes before 'o', return true. Else, return false
					Returns true if: areas are 'equal' and this Polygon's closest Point to
					the origin is smaller or equal to o's closest Point
					Returns true if: this Polygon's area is less than o's area
					Returns false otherwise
	*/
	public static boolean compareTo(PlanarShape shape1, PlanarShape shape2)
	{
		// If shape2 and this Polygon are considered equal by area
		// Check which Polygon has the point closest to the origin
		if(shape1.equals(shape2))
		{
			// if shape2's closest point to origin is bigger than this Polygon's 
			// closest point to origin, return true
			if(shape1.originDistance() < shape2.originDistance())
			{
				return true;
			}
			// if the distance is the same, return true
			else if(shape1.originDistance() == shape2.originDistance())
			{
				return true;
			}
			else
			{
				// otherwise, return false
				return false;
			}
		}
		else
		{
			// if shape2 has a bigger area, it comes after this
			// hence this Polygon comes before, return true
			if(shape2.area() > shape1.area())
				return true;
			// othwise, this Polygon's area is bigger, return false
			else
				return false;
		}
	}
}