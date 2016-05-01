/*
	Jeremy Law
	c3183613
	LinkedList class
	private inner Node class
	private inner Iterator class for Linked List
*/
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>
{
	// sentinel node
	private Node sentNode;
	// modification count for Iterator
	protected int modCount;	// each time LinkedList is modified, modCount is incremented

	// Constructor for empty LinkedList class
	LinkedList()
	{
		sentNode = new Node();
		sentNode.setNext(sentNode);
		sentNode.setPrev(sentNode);
	}

	// Constructor to instantiate with one item
	LinkedList(T args)
	{
		sentNode = new Node();
		Node newNode = new Node(args);
		sentNode.setNext(newNode);
		sentNode.setPrev(newNode);
		newNode.setPrev(sentNode);
		newNode.setNext(sentNode);
		modCount++
;	}

	/*
		Precondition: LinkedList instantiated
		Postcondition: put args at front of linked list
	*/
	public void prepend(T args)
	{
		Node newNode = new Node(args);
		// if there are no elements in the linked list
		if(sentNode.getNext().equals(sentNode))
		{
			sentNode.setNext(newNode);
			sentNode.setPrev(newNode);
			newNode.setPrev(sentNode);
			newNode.setNext(sentNode);
		}
		// at least one element in the linked list
		else
		{
			newNode.setNext(sentNode.getNext());
			newNode.setPrev(sentNode);
			newNode.getNext().setPrev(newNode);
			sentNode.setNext(newNode);
		}
		// increment mod count
		modCount++;
	}

	/*
		Precondition: LinkedList instantiated
		Postcondition: Add to the end of the list
	*/
	public void append(T args)
	{
		Node newNode = new Node(args);
		// if no elements other than sentinel node
		if(sentNode.getNext().equals(sentNode))
		{
			sentNode.setNext(newNode);
			sentNode.setPrev(newNode);
			newNode.setPrev(sentNode);
			newNode.setNext(sentNode);	
		}
		// at least one element
		else
		{
			newNode.setPrev(sentNode.getPrev());
			newNode.setNext(sentNode);
			newNode.getPrev().setNext(newNode);
			sentNode.setPrev(newNode);
		}
		// increment mod counter
		modCount++;
	}

	/*
		Precondition: LinkedList instantiated and at least 1 element in the list
		Postcondition: Remove element at the head of the list
	*/
	public Node removeHead()
	{
		Node tempNode;
		// if else statement to control pointers depending on how many elements in the list
		// if only one element in the list, sentinel node points back to itself after element removal
		if(sentNode.getNext().getNext().equals(sentNode))
		{
			tempNode = sentNode.getNext();
			sentNode.setNext(sentNode);
			sentNode.setPrev(sentNode);
		}
		else
		{
			tempNode = sentNode.getNext();
			sentNode.setNext(tempNode.getNext());
			tempNode.getNext().setPrev(sentNode);
		}
		modCount++;
		return tempNode;
	}

	/*
		Precondition: LinkedList instantiated 
		Postcondition: Returns how many elements in list (not including sentinel node)
	*/
	public int size()
	{
		int i=0;
		Iterator iterate = iterator();
		while(iterate.hasNext())
		{
			iterate.next();
			i++;
		}
		return i;
	}

	/*
		Precondition: LinkedList instantiated
		Postcondition: return iterator of type ListIterator
	*/
	public ListIterator iterator()
	{
		return new ListIterator(sentNode);
	}

	/*
		Private inner class, iterator for LinkedList of type T
	*/
	private class ListIterator implements Iterator<T>
	{
		private Node iteratorNode;
		private int expectedModCount;

		/*
			Precondition: LinkedList has a sentinel node before first element in list
			Postcondition: ListIterator initialized
		*/
		ListIterator(Node head)
		{
			iteratorNode = head;
			expectedModCount = modCount;
		}

		/*
			Precondition: ListIterator initialized
			Postcondition: returns true if iteratorNode points to another element that is not sentNode
							returns false otherwise
		*/
		public boolean hasNext()
		{
			if(iteratorNode.getNext().equals(sentNode))
				return false;
			else
				return true;
		}

		/*
			Precondition: ListIterator has been initialized, hasNext has returned true
			Postcondition: 	If LinkedList has been modified independent to the iterator, throw ConcurrentModificationException
							If hasNext() would return false immediately before this function is called, throw NoSuchElementException
							If no Exceptions thrown, return data in next element (of type T)
		*/
		public T next()
		{
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException("Cannot mutate in context of iterator");
			if(hasNext() == false)
				throw new NoSuchElementException("There are no more elements");
			iteratorNode = iteratorNode.getNext();
			return iteratorNode.getData();
		}

		/*
			Precondition:	ListIterator has been initialized, LinkedList has not been modified independently of the Iterator
			Postcondition: 	If LinkedList has been modified independent of the Iterator, throw ConcurrentModificationException
							if no exception thrown, remove element most recently visited and set pointers appropriately
		*/
		public void remove()
		{
			Node tempNode;
			modCount++;
			if(modCount != ++expectedModCount)
				throw new ConcurrentModificationException("Cannot mutate in context of iterator");
			tempNode = iteratorNode;
			iteratorNode = iteratorNode.getNext();
			tempNode.getNext().setPrev(tempNode.getPrev());
			tempNode.getPrev().setNext(tempNode.getNext());
		}

	}

	/*
		Private inner Node class that holds type T
	*/
	private class Node
	{
		// private member variables
		private T data;
		private Node next, prev;

		/*
			Precondition: none
			Postcondition: Node instantiated with no data. Member variables set to null
		*/
		public Node()
		{
			data = null;
			prev = null;
			next = null;
		}

		/*
			Precondition: none
			Postcondition: Node instantiated with newData
		*/
		public Node(T newData)
		{
			data = newData;
			prev = next = null;
		}
		// Mutator methods (self explanatory)
		public void setData(T newData)
		{
			data = newData;
		}

		public void setNext(Node newNext)
		{
			next = newNext;
		}

		public void setPrev(Node newPrev)
		{
			prev = newPrev;
		}
		// Query methods (self explanatory)
		public T getData()
		{
			return data;
		}

		public Node getNext()
		{
			return next;
		}

		public Node getPrev()
		{
			return prev;
		}
	}
}