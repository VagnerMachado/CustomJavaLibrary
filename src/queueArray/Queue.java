package queueArray;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project 3: Airport Simulation<br>
 *<b>Filename:</b>	Queue.java<br>
 *<b>Date Written:</b>	April, 2016<br>
 *<b>Due Date:</b> April 25th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This class implements the abstract methods contained in the QueueADT interface. The methods available enable the 
 *user to determine if a queue is empty, add or remove an item, see the front or rear item, and the size of the queue.
 *The description for each method can be found above each method's signature, in its javadoc.
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

public class Queue <T> implements QueueADT<T>
{
	// instance data
	public final int CAPACITY =100;
	private T [] data;
	private int size = 0;
	private int front = 0;

/**
 * Queue default constructor - instantiates a queue implemented by an array of size 100
 */
	@SuppressWarnings("unchecked")
	public Queue()
	{
		data = (T[]) new Object[CAPACITY];
	}

	/**
	 * Queue parameterized  constructor - instantiates a Queue implemented by an array 
	 * @param x - the size of the queue's array.
	 */
	@SuppressWarnings("unchecked")
	public Queue( int x)
	{
		data = (T[]) new Object[x];
	}

	/**
	 * enqueue method - adds an object to the end of the queue
	 * @param d - object to be added to the end of the queue
	 * @throws QueueFullException -- in case the queue is full
	 */
	public void enqueue(T d) throws QueueFullException 
	{
		if (isFull()) 
			throw new QueueFullException("Full Queue Exception, the entry was not enqueued");
		int location = (front+size)%data.length;
		data[location] = d;
		size++;
	}

/**
 * dequeue method - removes the object in the front of the queue
 * @throws QueueEmptyException - in case the queue is empty
 * @return - the item dequeued
 */
	public T dequeue() throws QueueEmptyException 
	{
		if (isEmpty()) 
			throw new QueueEmptyException("Empty Queue Exception, there is no entry to dequeue");
		T item = data[front];
		data[front] = null;
		front = (front + 1)%data.length;
		size--;
		return item;
	}

	/**
	 * front method - shows the data in the front of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 * @return - the item in front of the queue
	 */
	public T front() throws QueueEmptyException 
	{
		if (isEmpty()) 
			throw new QueueEmptyException ("Empty Queue, there is no item in front of the queue");
		return data[front];
	}

/**
 * isFull method - keeps track if the queue is full
 * @return true if queue is full, false otherwise.
 */
	public boolean isFull() 
	{
		return data.length == size;
	}

/**
 * isEmpty method - keeps track if the queue is empty
 * @return true if empty, false otherwise
 */
	public boolean isEmpty() {

		return size == 0;
	}

	/**
	 * rear method - fives access the the object in the end of the queue
	 * @return - the object in the rear of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 */
	public T rear() throws QueueEmptyException 
	{
		if(isEmpty())
			throw new QueueEmptyException();
		return data[(front + size - 1) % data.length];
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
	 * the queue lenght and size, and the items currently in the queue
	 */
	public String toString()
	{
		System.out.println("Length: " + data.length + " Size: " + size);
		String result = "";
		for (int i = front; i < data.length; i++)
			if (data[i] != null)
				result += data[i] + " ";
		for (int i = 0; i < front; i++)
			if (data[i] != null)
				result += data[i] + " ";
		return result + "\n";

	}
}



