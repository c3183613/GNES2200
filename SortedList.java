/*
	Jeremy Law
	c3183613
	SortedList class
*/
import java.util.Iterator;
public class SortedList<T extends Comparable<T>> extends LinkedList<T>
{
	/*
		Precondition: SortedList is initialized 
		Postcondition: Returns a SortedList<T> list of elements in sorted order but parameter ends up empty
	*/
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
				if(next.compareTo(smallest) == -1) // if next comes before smallest
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