public class SortedList<T> extends LinkedList<T>, implements ComparePoly<T>
{
	public static void listInOrder(LinkedList<T> list) 
	{
		LinkedList<PlanarShape> sortedList = new LinkedList<PlanarShape>();
		Iterator iter = list.iterator();
		if(iter.hasNext())
			sortedList.append(iter.next())
		while(iter.hasNext())
		{
			PlanarShape shape = inter.next();
			if(shape.comesBefore(sortedList.))
		}
	}

	/*
	Preconditions:
	Postconditions: If this Polygon comes before 'o', return true. Else, return false
					Returns true if: areas are 'equal' and this Polygon's closest Point to
					the origin is smaller or equal to o's closest Point
					Returns true if: this Polygon's area is less than o's area
					Returns false otherwise
	*/
	private static boolean ComesBefore(PlanarShape shape1, PlanarShape shape2)
	{
		// If shape2 and this Polygon are considered equal by area
		// Check which Polygon has the point closest to the origin
		if(shape1.equals(shape2))
		{
			// if shape2's closest point to origin is bigger than this Polygon's 
			// closest point to origin, return true
			if(shape1.closestPointToOrigin().distance() < shape2.closestPointToOrigin().distance())
			{
				return true;
			}
			// if the distance is the same, return true
			else if(shape1.closestPointToOrigin().distance() == shape2.closestPointToOrigin().distance())
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
			if(shape2.area() > area())
				return true;
			// othwise, this Polygon's area is bigger, return false
			else
				return false;
		}
	}
}