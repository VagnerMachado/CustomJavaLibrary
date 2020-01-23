package undirectedGraphANDdijkstra;


//import java.util.NoSuchElementException;

/**<pre>
 * ********************************************************************************************************************
 *      									     HeapPQ.java       					                                  *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class implements the PriorityQueue and its methods. In addition, this 
 * class has its own methods: bubbleUp, bubbleDown, and swap. This class allows the user to instantiate generic
 * priority queues that contain the characteristics of a heap at all times.
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

public class HeapPQ<K,V>
{
	//instance data
	private Data<K,V> [] array;          
	private int size;                      


	@SuppressWarnings("hiding")
	/**
	 * Data - protected class that allows for saving weight and node in the PQ
	 * 
	 * @author Vagner Machado
	 * @param <K> the weight
	 * @param <V> the vertex
	 */
	protected class Data <K,V>
	{
		//instance data
		private double weight;
		private int vertex;
		
		/**
		 * Data Constructor
		 * @param w - the weight
		 * @param v - the vertex
		 */
		private Data(double w, int v)
		{
			vertex = v;
			weight = w;
		}
		
		/**
		 * getWeight - accessor for the weight
		 * @return
		 */
		public double getWeight()
		{
			return weight;
		}

		/**
		 * getVertex - accessor for the vertex data
		 * @return
		 */
		public int getVertex()
		{
			return vertex;
		}
	}

	/**
	 * HeapPQ Constructor - Initializes an empty priority queue with default capacity 100
	 * + 1 to account for index zero not being used. 
	 */

	@SuppressWarnings("unchecked")
	public HeapPQ() 
	{
		array =  new Data [101];
		size = 0;
	}

	/**
	 * HeapPQ Constructor - Initializes an empty priority queue with the given initial 
	 * capacity + 1 to account for index zero not being used
	 * Case the parameter is negative, the user is warned that Heap was started to default size 100.
	 * @param  cap -  the initial capacity of this priority queue
	 */

	@SuppressWarnings("unchecked")
	public HeapPQ(int cap) 
	{
		if (cap < 0)
		{
			System.out.println("The size of the heap cannot be negarive. Heap instatinated with default size 100");
			cap = 100;
		}
		array =  new Data[cap + 1];
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public void clear()
	{
		array =   new Data [array.length];
		size = 0;
		System.gc();
	}

	/**
	 *  enqueue - adds an item to the priority queue
	 */
	public void enqueue(double d, int f)
	{
		//expand if needed
		if (size == array.length - 1)
			resize(2 * array.length);

		//add, increment and bubbleUp inserted value
		array[++size] = new Data<K,V>(d,f);
		bubbleUp(size);				
	}

	/**
	 * bubbleUp - auxiliary function that moves newly inserted value up the 'tree' to preserve the heap and priority 
	 * characteristics
	 * @param index - the index of the item to be bubbled up
	 */
	private void bubbleUp(int index) 
	{
		//stop clause
		if(index <= 1)
			return;

		//find parent, swap if necessary and bubbleUp
		int parent = index / 2;
		if (array[index].getWeight() <(array[parent].getWeight()))
			swap(index, parent);
		bubbleUp(parent);	// maybe do this only if there was a swap?
	}

	/**
	 * swap - auxiliary function that allows for swapping of two values in the generic array
	 * @param index1 - index of item to be swapped with item at index2
	 * @param index2 - index of item to be swapped with item at index1
	 */
	private void swap(int index1, int index2) 
	{
		Data<K,V> temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;	
	}

	/**
	 * resize - auxiliary function that allows for the resizing of the array of items
	 * @param cap - the new capacity for the array of items
	 */
	private void resize(int cap)
	{
		@SuppressWarnings("unchecked")
		Data<K,V> [] temp = new Data[cap];
		for (int i = 1; i <= size; i++) 
		{
			temp[i] = array[i];
		}
		array = temp;
	}

	/**
	 * dequeue - removes and returns the item with highest priority from the priority queue
	 * @throws GeneralException - case the priority queue is empty
	 * @return item - the item with highest priority in the priority queue
	 */
	public Data<K,V> dequeue() throws GeneralException
	{
		if (size == 0)
			throw new GeneralException("Exception: The priority queue is empty, you cannot dequeue");
		Data<K,V> item = array[1];
		array[1] = array[size--];
		bubbleDown(1);
		return item;
	}

	/**
	 * bubbleDown - auxiliary function that allows an item at certain position to be moved down the 'three'
	 * to preserve the characteristics of a heap priority queue 
	 * @param parent
	 */
	private void bubbleDown(int parent) 
	{
		//find left child and validate
		int left = parent * 2;
		if (left > size)
			return;
		//case right child does not exist
		if(left + 1 > size)
		{   
			//compare left and parent, and swap if necessary
			if(array[left].getWeight() < (array[parent].getWeight()))
				swap(left, parent);
		}
		//the right child exists
		else
		{
			//case left child has higher priority than right child
			if(array[left].getWeight() < (array[left + 1].getWeight()))
			{
				//swap with parent if child has higher priority
				if(array[left].getWeight() < (array[parent].getWeight()))
				{
					swap(left, parent);
					bubbleDown(left);
				}

			}
			//case right child has higher priority that left child
			else
			{
				//swap with parent if child has higher priority
				if(array[left + 1].getWeight() < (array[parent].getWeight()))
				{
					swap(left + 1, parent);
					bubbleDown(left + 1);
				}
			}
		}
	}

	/**
	 * isEmpty - used to identify if the heap priority queue is empty
	 * @return - true if empty, false otherwise
	 */
	public boolean isEmpty()
	{

		return size == 0;
	}

	/**
	 * getSize - accessor for the size of the priority queue
	 * @return size - the size of the priority queue
	 */
	public int getSize() 
	{

		return size;
	}

	/**
	 * peek - accessor for the item with highest priority. It does not remove the item from the queue
	 * @throws GeneralException - case the priority queue empty
	 * @returns - the item with highest priority in the array
	 */
	public Data<K,V> peek() throws GeneralException
	{
		if (size == 0)
			throw new GeneralException("Exception: The priority queue is empty, you cannot peek.");
		return array[1];
	}

	/**
	 * toString - used to visualize the priority queue items at different stages during testing
	 * @return s - a string reference to a string with all items in the priority queue
	 */
	public String toString()
	{
		String s = "";
		int i = 0;
		while(i++ < size)
			s += array[i] + " ";
		return s;
	}


}




