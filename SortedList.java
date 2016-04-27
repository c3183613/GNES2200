import java.util.Iterator;
public class SortedList<T extends PlanarShape> extends LinkedList<T>
{	
	public LinkedList<T> listInOrder(LinkedList<T> list) 
	{
		Iterator<T> iterate;
		SortedList<T> sortedList = new SortedList<T>();
		T smallest; T next;
		// while there are elements in list
		while(list.size()!=0)
		{
			iterate = list.iterator();
			// take first element as the smallest element we have encountered so far
			smallest= iterate.next();
			// for all other elements, search for smallest element
			while(iterate.hasNext())
			{
				next = iterate.next();
				if(PlanarShape.compareTo(next, smallest)) // if next comes before smallest
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
				T removeNext = iterate.next();	// store next element
				if(removeNext.equals(smallest))		// if the next element is what we want to remove
				{
					iterate.remove();				// remove it
					break;
				}
			}
		}
		return sortedList;
	}
}