import java.util.Iterator;
public class SortedList<T> extends LinkedList<T>
{	
	public LinkedList<T> listInOrder(LinkedList<T> list) 
	{
		Iterator iterate;
		SortedList<T> sortedList = new SortedList();
		T smallest,next;
		// while there are elements in list
		while(list.size()!=0)
		{
			iterate = list.iterator();
			// take first element as the smallest element we have encountered so far
			smallest=(T) iterate.next();
			// for all other elements, search for smallest element
			while(iterate.hasNext())
			{
				next =(T) iterate.next();
				if(comesBefore((PlanarShape) next,(PlanarShape) smallest)) // if next comes before smallest
				{
					smallest = next;
				}
			}
			// add smallest element to sortedList
			sortedList.append(smallest);
			// find smallest element again and remove from LinkedList
			iterate = list.iterator(); 	// reset to beginning to list
			while(iterate.hasNext())	// while there are things to iterate over
			{
				T removeNext = (T) iterate.next();	// store next element
				if(removeNext.equals(smallest))		// if the next element is what we want to remove
				{
					iterate.remove();				// remove it
					break;
				}
			}
		}
		return sortedList;
	}

	/*
	Preconditions:
	Postconditions: If this Polygon comes before 'o', return true. Else, return false
					Returns true if: areas are 'equal' and this Polygon's closest Point to
					the origin is smaller or equal to o's closest Point
					Returns true if: this Polygon's area is less than o's area
					Returns false otherwise
	*/
	private static boolean comesBefore(PlanarShape shape1, PlanarShape shape2)
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