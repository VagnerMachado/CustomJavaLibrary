package doublyLinkedQueue;

import java.util.Iterator;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxx<br>
 *<b>Filename:</b>	Queue.java<br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This class implements the abstract methods contained in the QueueADT interface. The class instantiates a new Node
 *object every time an item is enqueued, and this way the queue is never full and does not throw that Exception. The methods 
 *available enable the user to determine if a queue is empty, add or remove an item, see the front or rear item, and the 
 *size of the queue. The description for each method can be found above each method's signature, in its javadoc.
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 */

/**
 * Queue Class - implement the methods defined in the QueueADT Class
 * @param <T> - a generic data type
 */

public class Queue <T> implements QueueADT<T>, Iterable<T>
{
	/**
	 * private class Node - defines three constructors for Node objects to assist the Queue class
	 * @param <E> - a generic data type
	 */
	private class Node <E> 
	{
		//Node instance data
		private E data;
		private Node <E> next;
		private Node<E> previous;

		/**
		 * Node default constructor - sets data and next field as null for the instantiated Node object
		 */
		public Node()
		{
			data = null;
			next = null;
			previous = null;
		}

		/**
		 * Node parameterized constructor - Instantiates a Node object with data d.
		 * @param d  - the data for instantiated Node object
		 */
		public Node(E d)
		{
			data = d;
			next = null;
		}
		/**
		 * Node parameterized constructor - isntantiates a Niode object with data d and next n
		 * @param d - the data for the instantiated Node object
		 * @param n - the Node next to this Node
		 */
		public Node (E d, Node<E> n)
		{
			data = d;
			next = n;
		}

		/**
		 * Node parameterized constructor - instantiates Node object with data d with next n
		 * @param d - data to be assigned to this node
		 * @param n - this node's next
		 * @param p - previous node
		 */
		public Node (E d, Node<E> n, Node<E> p)
		{
			data = d;
			next = n;
			previous = p;
		}
		/**
		 * getData method - accessor to the data field
		 * @return - object stored in this node's data field
		 */
		public E getData() {
			return data;
		}

		/**
		 * setData method - modifier for the data field
		 * @param d - object to be stored in data field
		 */
		public void setData(E d) {
			data = d;
		}

		/**
		 * getNext method - accessor to the next field
		 * @return next - the Node object next to this Node object
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * getPrevious method - accessor to the previus field
		 * @return previous - the Node object previous to this Node object
		 */
		public Node<E> getPrevious() {
			return previous;
		}

		/**
		 * setNext method - modifier to the nexxt field
		 * @param n - the Node object next to this Node object
		 */
		public void setNext(Node<E> n) {
			next = n;
		}

		/**
		 * setPrevious method - modifier to the previous field
		 * @param n - the Node object previous to this Node object
		 */
		public void setPrevious(Node<E> n) {
			previous = n;
		}
	}
	//////////////////////////////////
	private class MyIterator<T> implements Iterator<T>
	{
		private Node<T> trav; 

		public MyIterator(Node<T> front)
		{
			trav = front;
		}
		public boolean hasNext() {

			return trav != rear.getNext();
		}

		@Override 
		public T next() {
			T item = trav.getData();
			trav = trav.getNext();
			return item;
		}

	}

	private Node<T> front, rear;
	public final int CAPACITY =100;
	private int size;


	/**
	 * Queue default constructor - instantiates a queue object
	 */
	@SuppressWarnings("unchecked")
	public Queue()
	{
		front = rear = null;
		size = 0;
		// calls the parent class Object constructor
	}

	/**
	 * enqueue method - adds an object to the end of the queue
	 * @param d - object to be added to the end of the queue
	 */
	public void enqueue(T d)
	{
		if (size == 0)
			rear = front = new Node<T>(d, null, null);
		else
		{
			Node<T> n = new Node<T>(d, null, rear);
			rear.next = n;
			rear = rear.next;
		}
		size++;
	}

	//the enqueue method below is for a circular queue implemented by a LinkedList
	//if this enqueue method is used, comment out the one above

	/*
	public void enqueue(T d)
	{
		if (rear == null)
		{
			rear = front = new Node<T>(d);
			rear.next = front;
		}
		else
			rear.next = new Node<T>(d, front);
		size++;
	}*/


	/**
	 * dequeue method - removes the object in the front of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 * @return - the item dequeued
	 */
	public T dequeue() throws QueueEmptyException 
	{
		if (isEmpty()) 
			throw new QueueEmptyException("Empty Queue Exception, there is no entry to dequeue");
		T item = front.data;
		front = front.next;
		if( front == null)
			rear = null;
		else
			front.previous = null;
		size--;
		return item;
	}


	//the dequeue method below is for a circular queue implemented by a LinkedList
	//if this dequeue method is used, comment out the one above

	/*
	 public T dequeue() throws QueueEmptyException 
	{
		if (isEmpty()) 
			throw new QueueEmptyException("Empty Queue Exception, there is no entry to dequeue");
		T item = front.data;
		if(front == rear)
		front = rear = null;
		else
		{
		front = front.next;
		rear.next = front;
		}

		size--;
		return item;
	}
	 */ 

	/**
	 * front method - shows the data in the front of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 * @return - the item in front of the queue
	 */
	public T front() throws QueueEmptyException 
	{
		if (isEmpty()) 
			throw new QueueEmptyException ("Empty Queue, there is no item in front of the queue");
		T value = front.data;
		return value;
	}

	/**
	 * isEmpty method - keeps track if the queue is empty or not
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * rear method - gives access the the object in the end of the queue
	 * @return - the object in the rear of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 */
	public T rear() throws QueueEmptyException 
	{
		if(isEmpty())
			throw new QueueEmptyException("Empty Queue Exception, there is no item in the rear of the queue");
		T item = rear.data;
		return item;
	}

	/**
	 * getSize method - gives access to the size of the queue
	 * @return - the size of the array as an integer
	 */
	public int getSize() {
		return size;
	}

	/**
	 * toString method - traverses through the queue and prints a reference to a String containing 
	 * the items currently in the queue
	 */
	public String toString()
	{
		String result = "";
		Node<T> trav = front;
		while(trav != null)
		{
			result += trav.data + " ";
			trav = trav.next;
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {

		return new MyIterator<T>(front);
	}


	//Test area
/*
	public static void main (String [] Vagner) throws QueueEmptyException
	{
		Queue <Integer> q = new Queue <Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);

		//Iterator for each
		System.out.println("\n** For each iterator **");
		for(int x : q)
		{
			System.out.print(x + " ");
		}
		//Other way to check the iterator
		System.out.println("\n\n** Getting the iterator **");
		Iterator<Integer> it = q.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");

		System.out.println("\n\n** Dequeue all **");
		while(!q.isEmpty())
			System.out.print(q.dequeue() + " ");
	}
*/




}	



