package priorityQueueThreeWays;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

/**<pre>
 * ********************************************************************************************************************
 *      									     ArrayPQ.java       					                              *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class implements the PriorityQueue interface and its methods. Enqueuing happens
 * at the end of the array and dequeuing is done after reverse sorting the array. We use a 'dirtyBit' boolean 
 * called 'sorted'to keep the array from being sorted multiple times for consecutive dequeuing calls  
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
public class ArrayPQ<T extends Comparable<T>> implements PriorityQueue<T>
{

	private T [] array;
	private int size;
	private boolean sorted;

	@SuppressWarnings("unchecked")
	/**
	 * ArrayPQ constructor - allows for the instantiation of an ArrayPQ object with default length 100.
	 * @param cap - the initial capacity for the array implemented priority queue
	 */

	public ArrayPQ()
	{
		array = (T[]) new Comparable[100];
		size = 0;
		sorted = false;
	}
	@SuppressWarnings("unchecked")
	/**
	 * ArrayPQ constructor - allows for the instantiation of an ArrayPQ object with specific capacity.
	 * If capacity passed is negative, the user is warned and array is initialized with size 100.
	 * @param cap - the initial capacity for the array implemented priority queue
	 */
	public ArrayPQ(int cap)
	{
		if (cap < 0)
		{
			System.out.println("Warning: Array length cannot be negative. "
					+ "Initializing array with default length 100.");
			cap = 100;
		}
		array = (T[]) new Comparable[cap];
		size = 0;
		sorted = false;
	}

	@SuppressWarnings("unchecked")
	/**
	 * clear - clears up the priority queue and forces return memory to the heap with gc() call
	 */
	public void clear()
	{
		array =  (T[]) new Comparable[array.length];
		size = 0;
		sorted = false;
		System.gc();
	}
	/**
	 *  enqueue - adds an item to the array priority queue
	 *  @throws - NoSuchElementException  - case the item to be added is null
	 */
	public void enqueue(T item) throws NoSuchElementException
	{
		//validate
		if (item  == null)
			throw new NoSuchElementException("Exception: You cannot enqueue a null item.");

		//expand if needed
		if (size == array.length)
			resize(2 * array.length);

		array[size++] = item;

		//set false only if and only if added item violates the reverse sorted order
		if(size >= 2 && sorted && array[size - 1].compareTo(array[size - 2]) > 0)
			sorted = false;		
	}

	/**
	 * dequeue - removes from array and returns the item with the highest priority
	 * @throws - NoSuchElementException - case the array is empty
	 * @return - the last item on the array, which has the highest priority due to reverse sort
	 */
	public T dequeue() throws NoSuchElementException
	{
		//validate
		if (size == 0)
			throw new NoSuchElementException("Exception: The priority queue is empty, you cannot dequeue");

		//sort and reverse if necessary	
		if(!sorted)
		{
			reverseSort();
			sorted = true;
		}
		return array[--size];
	}

	/**
	 * reverseSort - sorts in reverse order the array of items. I was not able to, initially to get the
	 * reverse sort to work due to an integer overflow when subtracting an extremely large integer from an
	 * extremely low integer in the Task compareTo i.e case compare to returns 
	 * Integer.MIN_VALUE - Integer.MAX_VALUE. This results in an overflow and gives a runtime error.
	 * After editing the Task compareTo, this problem seems to disappear. The 
	 * Collections.reverse sort is commented out because it did not work and always generated a null pointer
	 */
	private void reverseSort() 
	{
		//Arrays.sort(array, Collections.reverseOrder());
		
		//System.out.println("in reverse sort");
		Arrays.sort(array, 0, size);
		int i = 0;
		int j = size - 1;
		while(i < j)
		{
			T temp = array[i];
			array[i++] = array[j];
			array[j--] = temp;	
		}
	}

	@Override
	/**
	 * isEmpty - used to identify if the array priority queue is empty
	 * @return - true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	/**
	 * getSize - accessor for the size of the priority queue
	 * @return size - the size of the priority queue
	 */
	public int getSize() 
	{
		return size;
	}

	@Override
	/**
	 * peek - accessor for the item with highest priority. It does not remove the item from the queue
	 * @throws NoSuchElementException - case the priority queue empty
	 * @returns - the item with highest priority in the array
	 */
	public T peek() throws NoSuchElementException
	{
		if (size == 0)
			throw new NoSuchElementException("Exception: The priority queue is empty, you cannot peek.");
		if(!sorted)
		{
			reverseSort();
			sorted = true;
		}
		return array[size - 1];
	}

	/**
	 * resize - auxiliary function that allows for the resizing of the array of items
	 * @param cap - the new capacity for the array of items
	 */
	private void resize(int cap)
	{
		@SuppressWarnings("unchecked")
		T [] temp = (T[]) new Comparable[cap];
		for (int i = 0; i < size; i++) 
		{
			temp[i] = array[i];
		}
		array = temp;
	}
	
	/**
	 *  heapSort - sorts the array using the heap property
	 */
	public void heapSort()
	{
		int s = size;
		if(size == 0 || size == 1)
			return;
		for(int i = 0; i < s; i++)
		{
			array[size - 1] = dequeue();
		}
		size = s;
	}

	/**
	 * toString - helps visualize the status of the heap
	 */
	public String toString()
	{
		String result = "";
		for(int i = 0; i < size; i++)
			result += array[i] + " ";
		return result;
	}
	

public static void main(String [] args)
{
	ArrayPQ <Integer> a = new ArrayPQ<Integer>();
	a.enqueue(7);
	a.enqueue(6);
	a.enqueue(12);
	a.enqueue(0);
	a.enqueue(-1);
	a.enqueue(30);
	
	System.out.println(a);
	a.heapSort();
	System.out.println(a);
	
}

}