import java.util.Scanner;
import java.util.Iterator;

public class PA1
{
	public static void main(String[] args)
	{
		LinkedList<PlanarShape> myList = new LinkedList<PlanarShape>();
		// Delimits on P as P denotes a new Polygon
		Scanner in = new Scanner(System.in).useDelimiter("\\s*P\\s*");
		while(in.hasNext())
		{
			// Store the String in variable to be used
			Scanner line = new Scanner(in.next());
			// Create a Polygon to be used, use next int as array size
			PlanarShape tempPoly = new Polygon(line.nextInt()+1);
			// variable used to keep track of which index of array to modify
			int i =0;
			// while there are inputs to take
			while(line.hasNextDouble())
			{
				tempPoly.modifyArray(i, new Point(line.nextDouble(), line.nextDouble()));
				// System.out.println(line);
				i++;
			}
			// Deep copy the first point of the polygon as the last
			tempPoly.modifyArray(i, new Point(tempPoly.getArray()[0].getX(), tempPoly.getArray()[0].getY()));
			// add Polygon into linked list as a new node
			myList.append(tempPoly);
		}
		// print original list
		Iterator iterate = myList.iterator();
		while(iterate.hasNext())
		{
			PlanarShape o =(PlanarShape) iterate.next();
			System.out.println(o.toString());
		}
		System.out.println("SORTED");
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