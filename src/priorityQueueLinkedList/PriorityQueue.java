package priorityQueueLinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**<pre>
 * ********************************************************************************************************************
 *      									  PriorityQueue.java 								                      *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> In this class I defined the methods used for a priority queue: enqueue, dequeue and getSize.
 * This priority queue accepts any type of generic data type that implements the Comparable interface to facilitate 
 * enqueuing items in proper order. Both enqueue and dequeue methods @throws NoSuchElementException. The first case the 
 * item to be enqueued is null and the second if the priority queue is empty.
 * 
 * For information about the other classes created for this program, please see their javadocs. 
 * 
 *
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                  *           
 *********************************************************************************************************************
 *
 * @param E - a generic type that extends the Comparable interface
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class PriorityQueue<E extends Comparable <E>> implements Iterable<E>
{
	//instance data
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * PriorityQueue constructor - Starts a priority queue with a null node with 
	 * a head and tail pointing to it
	 */
	public PriorityQueue()
	{
		head = tail = null;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	/**
	 * enqueue - adds a Comparable item to the list in the proper position. This implementation checks
	 *  if item to be added is larger than tail. If so, it uses the addToRear auxiliary method. If it is less than the 
	 *  head, it uses the addToFront auxiliary method to accomplish that. Otherwise, it iterates through the linked
	 *  list and adds the item in the proper position
	 * @param data - the data to be inserted
	 * @throws NoSuchElementException - if the item to be added is null
	 */
	public void enqueue(E data) throws NoSuchElementException
	{
		if (data == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority");

		if(size == 0)
			head = tail = new Node<E> (data, null, null);

		else if (head.getData().compareTo(data) >= 0) //less than first
		{
			addToFront(data);
			return;
		}
		else if(tail.getData().compareTo(data) <= 0) // greater than last
		{
			addToRear(data);
			return;
		}
		else //iterate and add somewhere in the middle
		{
			Node <E> trav = head;
			while(trav.getData().compareTo(data) < 0)
				trav = trav.getNext();
			Node <E> n = new Node <E>(data, trav, trav.getPrevious());
			trav.getPrevious().setNext(n);
			trav.setPrevious(n);	
		}
		size++;
	}

	/**
	 * dequeue - removes the item with the highest priority from the priority queue
	 * @return - the item with the highest priority
	 * @throws NoSuchElementException - case the priority queue is empty
	 */
	public E dequeue() throws NoSuchElementException
	{
		if ( size == 0)
			throw new NoSuchElementException("The priority queue is empty, you cannot dequeue an item");
		E item = head.getData();
		head = head.getNext();
		if(head != null)
			head.setPrevious(null); 
		size--;
		return item;
	}

	/**
	 * toString - forms a string containing all items in the priority queue
	 * @return - the string will all items in the priority queue
	 */
	public String toString()
	{
		String a = "";
		Node<E> trav = head;
		while(trav != null)
		{
			a += trav.getData() + " ";
			trav = trav.getNext();
		}
		return a;
	}

	/**
	 * reverseString - forms a string containing all items in the priority queue in reverse, 
	 * mostly used to test the double link
	 * @return - the string will all items in the priority queue in reverse
	 */
	public String reverseString()
	{
		String a = "";
		Node<E> trav = tail;
		while(trav != null)
		{
			a += trav.getData() + " ";
			trav = trav.getPrevious();
		}
		return a;
	}

	/**
	 * addToRear method - adds the item to the rear of list
	 * @param d - item to be added
	 * @throws NoSuchElementException - if the item in parameter is null
	 */
	private void addToRear(E d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority queue");
		else
		{
			Node<E> n = new Node<E>(d, null, tail);
			tail.setNext(n);
			tail = tail.getNext();
		}
		size++;
	}	
	/**
	 * addToFront method - adds the item to front of the list
	 * @param d - the data to be inserted
	 * @throws NoSuchElementException - if the item in parameter is null
	 */
	private void addToFront(E d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority queue");
		else
		{
			Node<E> n = new Node<E>(d, head, null);
			head.setPrevious(n);
			head = n;
		}
		size++;
	}

	/**
	 * getSize - accessor for the size of the priority queue
	 * @return size - the size of the queue
	 */
	public int getSize()
	{
		return size;
	}

	@Override
	/**
	 * iterator - returns an iterator for this PriorityQueue
	 */
	public Iterator<E> iterator() {
		return new PQiterator<E>(head);

	}

	@SuppressWarnings("hiding")
	/**
	 * PQ Iterator Class - this class implements Iterator and its methods.
	 * It is used to provide the PriorityQueue with an iterator.
	 * @author Vagner_Machado QCID 23651127
	 * @param <E> - a Comparable generic type
	 */
	private class PQiterator<E extends Comparable <E>> implements Iterator <E>
	{
		//instance data
		private Node<E> trav;

		/**
		 * PQiterator constructor - initializes the instance data to 
		 * parameter passed to constructor
		 * @param x - a Node <E> reference
		 */
		public PQiterator(Node <E> x)
		{
			trav = x;
		}

		/**
		 * hasNext - accessor used to know if there are more items in the priority queue
		 * @returns -  true if there are more items, false otherwise
		 */
		public boolean hasNext() {

			return trav != null;
		}

		@Override
		/**
		 * next - accessor for the current item in the iterator. Before returning such item, iterator is moved to
		 * the next item
		 * @return data - the data in the node where iterator currently points to
		 */
		public E next() {
			E data = trav.getData();
			trav = trav.getNext();
			return data;
		}

	}

	/**
	 * main method - two data types are used to test the priority queue:
	 * Integer and Store. Both of them are successfully ordered, enqueued and dequeued 
	 * @param args - an array of string passes at command line
	 */
	public static void main (String [] args)
	{
		PriorityQueue<Integer> a = new PriorityQueue<Integer>();
		a.enqueue(4);
		a.enqueue(5);
		a.enqueue(9);
		a.enqueue(6);
		a.enqueue(3);
		a.enqueue(10);

		System.out.println("\nPrinting all integers\n");
		for (Integer x : a)
			System.out.print(x + " ");

		System.out.println("\n\nPrinting reverse integers\n\n" + a.reverseString());
		System.out.println("\n\nDequeue all integers\n");
		while(a.getSize() != 0)
			System.out.println(a.dequeue());


		PriorityQueue<Store> d = new PriorityQueue<Store>();
		d.enqueue(new Store("Target" , "8am", "11pm"));
		d.enqueue(new Store("Five Guys" , "8am", "11pm"));
		d.enqueue(new Store("Minado Sushi" , "11am", "9pm"));
		d.enqueue(new Store("Good Year" , "8am", "6pm"));

		System.out.println("\nPrinting all Stores\n");
		for (Store x : d)
			System.out.println(x);

		System.out.println("\nDequeue all Stores\n");
		while(d.getSize() != 0)
			System.out.println(d.dequeue());
	}
}
