
package priorityQueueThreeWays;
import java.util.NoSuchElementException;

/**<pre>
 * ********************************************************************************************************************
 *      									     LinkedListPQ.java       					                          *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class implements the PriorityQueue interface and its methods. It also uses the
 * methods and constructors defined in the Node class in order to build a doubly linked list with the functionalities
 * of a priority queue. 
 *  
 * For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                  *           
 *********************************************************************************************************************
 *
 * @param T - a generic type that extends the Comparable interface
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class LinkedListPQ<T extends Comparable<T>> implements PriorityQueue<T>
{

	//instance data
	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * PriorityQueue constructor - Starts a priority queue with a null node with 
	 * a head and tail pointing to it
	 */
	public LinkedListPQ()
	{
		head = tail = null;
		size = 0;
	}

	public void clear()
	{
		head = tail = null;
		size = 0;
		System.gc();
	}
	
	/**
	 * enqueue - adds a Comparable item to the list in the proper position. This implementation checks
	 *  if item to be added is larger than tail. If so, it uses the addToRear auxiliary method. If it is less than the 
	 *  head, it uses the addToFront auxiliary method to accomplish that. Otherwise, it iterates through the linked
	 *  list and adds the item in the proper position
	 * @param data - the data to be inserted
	 * @throws NoSuchElementException - if the item to be added is null
	 */
	public void enqueue(T data) throws NoSuchElementException 
	{
		if (data == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority");

		if(size == 0)
			head = tail = new Node<T> (data);

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
			Node <T> trav = head;
			while(trav.getData().compareTo(data) < 0)
				trav = trav.getNext();
			Node <T> n = new Node <T>(data, trav, trav.getPrevious());
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
	public T dequeue() throws NoSuchElementException 
	{
		if ( size == 0)
			throw new NoSuchElementException("The priority queue is empty, you cannot dequeue an item");
		T item = head.getData();
		head = head.getNext();
		if(head != null)
			head.setPrevious(null); 
		size--;
		return item;
	}

	/**
	 * isEmpty - let's the user know if the size of priority queue is zero
	 * @return - true if the size is zero, false otherwise
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * getSize - accessor for the size of the priority queue
	 * @return - the size of the priority queue
	 */
	public int getSize() 
	{
		return size;
	}

	/**
	 * peek - accessor for the item with highest priority in the priority queue
	 * @return - the item with highest priority in the priority queue
	 * @throws NoSuchElementException - case the priority queue is empty
	 */
	public T peek() throws NoSuchElementException
	{
		if(size == 0)
			throw new NoSuchElementException("The priority queue is empty, you cannot peek.");
		
		return head.getData();
	}

	/**
	 * incrementSize - increments the size of the priority queue
	 */
	public void incrementSize() 
	{
		size++;	
	}

	/**
	 * decrememntSize - decrements the size of the priority queue
	 */
	public void decrememntSize() 
	{
		size--;			
	}

	/**
	 * addToRear method - adds the item to the rear of list
	 * @param d - item to be added
	 * @throws NoSuchElementException - if the item in parameter is null
	 */
	private void addToRear(T d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority queue");
		else
		{
			Node<T> n = new Node<T>(d, null, tail);
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
	private void addToFront(T d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the priority queue");
		else
		{
			Node<T> n = new Node<T>(d, head, null);
			head.setPrevious(n);
			head = n;
		}
		size++;
	}

}
