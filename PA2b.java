/*
	Jeremy Law
	c3183613
	Main class for part b of PA2
*/
import java.util.Scanner;
import java.util.Iterator;

public class PA2b
{
	public static void main(String[] args)
	{
		// Intialize LinkedList which holds PlanarShapes
		LinkedList<PlanarShape> myList = new LinkedList<PlanarShape>();
		// New scanner
		Scanner in = new Scanner(System.in);
		// while in has input, append it into myList
		while(in.hasNext())
		{
			// pass Scanner into Planar.ShapeFactory (which returns a PlanarShape,
			// of either Polygon, Circle, or SemiCircle)
			myList.append(PlanarShape.shapeFactory(in));
		}
		// print original list
		System.out.println("Original list");
		Iterator<PlanarShape> iterate = myList.iterator();
		// iterate over  myList
		while(iterate.hasNext())
		{
			// PlanarShape o =(PlanarShape) iterate.next();
			// store each PlanarShape that we iterate over to use
			PlanarShape o = iterate.next();
			// print stored PlanarShape
			System.out.println(o.toString());
		}
		System.out.println();
		System.out.println("Sorted list");
		// Create new SortedList that holds type PlanarShapes using LinkedList constructor
		SortedList<PlanarShape> sortedList = new SortedList<PlanarShape>();
		// populate sortedList using listInOrder, pass myList
		// cast into SortedList<PlanarShape>
		sortedList =(SortedList<PlanarShape>) sortedList.listInOrder(myList);
		Iterator<PlanarShape> sortedIt = sortedList.iterator();
		// iterate over each element in the sortedList
		while(sortedIt.hasNext())
		{
			// store each element for use
			PlanarShape o = sortedIt.next();
			// print String representation of o
			System.out.println(o.toString());
		}
	}
}