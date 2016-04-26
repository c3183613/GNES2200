import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>
{
	private Node sentNode;
	protected int modCount;
	// single sentinel node 
	LinkedList()
	{
		sentNode = new Node();
		sentNode.setNext(sentNode);
		sentNode.setPrev(sentNode);
	}
	LinkedList(T args)
	{
		sentNode = new Node();
		Node newNode = new Node(args);
		sentNode.setNext(newNode);
		sentNode.setPrev(newNode);
		newNode.setPrev(sentNode);
		newNode.setNext(sentNode);
		modCount++;
	}

	// prepend
	public void prepend(T args)
	{
		Node newNode = new Node(args);
		if(sentNode.getNext().equals(sentNode))
		{
			sentNode.setNext(newNode);
			sentNode.setPrev(newNode);
			newNode.setPrev(sentNode);
			newNode.setNext(sentNode);
		}
		else
		{
			newNode.setNext(sentNode.getNext());
			newNode.setPrev(sentNode);
			newNode.getNext().setPrev(newNode);
			sentNode.setNext(newNode);
		}
		modCount++;
	}

	// append
	public void append(T args)
	{
		Node newNode = new Node(args);
		if(sentNode.getNext().equals(sentNode))
		{
			sentNode.setNext(newNode);
			sentNode.setPrev(newNode);
			newNode.setPrev(sentNode);
			newNode.setNext(sentNode);	
		}
		else
		{
			newNode.setPrev(sentNode.getPrev());
			newNode.setNext(sentNode);
			newNode.getPrev().setNext(newNode);
			sentNode.setPrev(newNode);
		}
		modCount++;
	}

	// take items from the head
	// size >= 1
	public Node removeHead()
	{
		// assert(!sentNode.getNext().equals(sentNode));
		Node tempNode;
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

	public String toString()
	{
		Iterator<T> iterate = iterator();
		String s="";
		while(iterate.hasNext())
		{
			s+=iterate.next().toString();
		}
		return s;
	}

	public ListIterator iterator()
	{
		return new ListIterator(sentNode);
	}

	private class ListIterator implements Iterator<T>
	{
		private Node iteratorNode;
		private int expectedModCount;

		ListIterator(Node head)
		{
			iteratorNode = head;
			expectedModCount = modCount;
		}

		public boolean hasNext()
		{
			if(iteratorNode.getNext().equals(sentNode))
				return false;
			else
				return true;
		}

		// Returns the data within the next node
		public T next()
		{
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException("Cannot mutate in context of iterator");
			if(hasNext() == false)
				throw new NoSuchElementException("There are no more elements");
			iteratorNode = iteratorNode.getNext();
			return iteratorNode.getData();
		}

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

	private class Node
	{
		private T data;
		private Node next, prev;

		public Node()
		{
			data = null;
			prev = null;
			next = null;
		}
		public Node(T newData)
		{
			data = newData;
			prev = next = null;
		}
		// Mutator methods
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
		// Query methods
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