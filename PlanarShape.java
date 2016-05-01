import java.util.Scanner;

public abstract class PlanarShape implements Comparable<PlanarShape>
{
	public abstract String toString();

	public abstract double area();

	public abstract double originDistance();

	public abstract void modifyArray(int index, Point point);

	public abstract Point[] getArray();

	public boolean equals(PlanarShape comparee)
	{
		if(area()*0.9995 <= comparee.area() && comparee.area() <= area()*1.0005)
			return true;
		else if(comparee.area()*0.9995 <= area() && area() <= comparee.area()*1.0005)
			return true;
		else
			return false;
	}

	public static PlanarShape shapeFactory(Scanner scan)
	{
		String shapeType = scan.next();
		PlanarShape newShape = null; // if not = null, error, variable newShape might not have been initialized
		switch(shapeType)
		{
			case "S":
			{
				newShape = new SemiCircle(new Point(scan.nextDouble(), scan.nextDouble()), new Point(scan.nextDouble(), scan.nextDouble()));
				break;
			}

			case "C":
			{
				newShape = new Circle(new Point(scan.nextDouble(), scan.nextDouble()), scan.nextDouble());
				break;
			}

			case "P":
			{
				// System.out.println("next int: "+ scan.nextInt());
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

	// -1 if this comes before shape2, 0 if both equal, 1 if shape2 comes before this
	public int compareTo(PlanarShape shape2)
	{
		// If shape2 and this Polygon are considered equal by area
		// Check which Polygon has the point closest to the origin
		if(this.equals(shape2))
		{
			// if shape2's closest point to origin is bigger than this Polygon's 
			// closest point to origin, return true
			if(this.originDistance() < shape2.originDistance())
			{ // if comesBefore, true
				return -1;
			}
			// if the distance is the same, return true
			else if(this.originDistance() == shape2.originDistance())
			{
				return 0;
			}
			else
			{
				// otherwise, return false
				return 1;
			}
		}
		else
		{
			// if shape2 has a bigger area, it comes after this
			// hence this Polygon comes before, return true
			if(shape2.area() > this.area())
				return -1;
			// othwise, this Polygon's area is bigger, return false
			else
				return 1;
		}
	}
}