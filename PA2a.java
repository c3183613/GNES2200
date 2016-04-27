import java.util.Scanner;
import java.util.Iterator;

public class PA2a
{
	public static void main(String[] args)
	{
		LinkedList<PlanarShape> myList = new LinkedList<PlanarShape>();
		// Delimits on P as P denotes a new Polygon
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			myList.append(PlanarShape.shapeFactory(in));
		}
		// print original list
		System.out.println("Original list");
		Iterator iterate = myList.iterator();
		while(iterate.hasNext())
		{
			PlanarShape o =(PlanarShape) iterate.next();
			System.out.println(o.toString());
		}
		System.out.println();
		System.out.println("Sorted list");
		SortedList<PlanarShape> sortedList = new SortedList<PlanarShape>();
		sortedList =(SortedList<PlanarShape>) sortedList.listInOrder(myList);
		Iterator sortedIt = sortedList.iterator();
		while(sortedIt.hasNext())
		{
			PlanarShape o =(PlanarShape) sortedIt.next();
			System.out.println(o.toString());
		}
	}
}