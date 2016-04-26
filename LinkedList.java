import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>
{
	private Node<T> sentNode;
	// single sentinel node 
	LinkedList()
	{
		sentNode.setNext(sentNode);
		sentNode.setPrev(sentNode);
	}
	LinkedList(Node<T> newNode)
	{
		sentNode.setNext(newNode);
		sentNode.setPrev(newNode);
		newNode.setPrev(sentNode);
		newNode.setNext(sentNode);
	}

	// prepend
	public void prepend(Node<T> newNode)
	{
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
	}
	// append
	public void append(Node<T> newNode)
	{
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
	}

	// take items from the head
	// size >= 1
	public Node<T> removeHead()
	{
		// assert(!sentNode.getNext().equals(sentNode));
		Node<T> tempNode;
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
		return tempNode;
	}

	public ListIterator<T> iterator()
	{
		return new ListIterator<T>(sentNode.getNext());
	}

	private class ListIterator<T> implements Iterator<T>
	{
		private Node<T> iteratorNode;

		ListIterator(Node<T> head)
		{
			iteratorNode = head;
		}

		public boolean hasNext()
		{
			// throw new ConcurrentModificationException();
			if(sentNode.getNext().equals(sentNode))
				return false;
			else
				return true;
		}

		// Returns the data within the next node
		public T next()
		{
			if(hasNext() == false)
				throw new NoSuchElementException();
			iteratorNode = iteratorNode.getNext();
			return iteratorNode.getData();
		}

	}

	private class Node<T>
	{
		private T data;
		private Node<T> next, prev;

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

		public void setNext(Node<T> newNext)
		{
			next = newNext;
		}

		public void setPrev(Node<T> newPrev)
		{
			prev = newPrev;
		}
		// Query methods
		public T getData()
		{
			return data;
		}

		public Node<T> getNext()
		{
			return next;
		}

		public Node<T> getPrev()
		{
			return prev;
		}
	}
}