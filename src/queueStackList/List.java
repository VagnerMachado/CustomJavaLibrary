package queueStackList;
import java.util.NoSuchElementException;

/*
 * modified from DoublyLinkedQueue and DoublyLinkedStack to make an Unordered/Ordered Doubly Linked List - CSC 230
 */

/**********************************************************************************************************************
 *           										List.java    							                          *
 * ********************************************************************************************************************
 * 
 * Description: The List class contains a default constructor for a list for a generic list object with initial
 * size 0 and front and rear nodes with null value. The methods implemented for this lab include:
 * 	- addToFront
 *  - removeFromFront
 *  - addToRear
 *  - removeFromRear
 *  - addAtPosition
 *  - get
 *  - toString
 *  - reverseString
 *  
 * I decided to include some additional methods:
 *  - search
 *  - removeAtPoistion
 *  - emptyList
 *  - size
 *  - sortList
 *  - sortedInsert
 * 
 * For information about the other classes and methods created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	                 *           
 *********************************************************************************************************************
 *
 */


public class List<T extends Comparable<T>> { 


	private Node<T> front, rear;
	private int size;

	/**
	 * List default constructor - instantiates a list object
	 */

	public List()
	{
		front = rear = null;
		size = 0;
	}

	/**
	 * addToRear method - adds the item to the rear of list
	 * @param d - item to be added
	  * @throws NoSuchElementException - if the item in parameter is null
	 */
	public void addToRear(T d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the list");
		else
			if (size == 0)
				rear = front = new Node<T>(d, null, null);
			else
			{
				Node<T> n = new Node<T>(d, null, rear);
				rear.setNext(n);
				rear = rear.getNext();
			}
		size++;
	}	
	/**
	 * addToFront method - adds the item to front of the list
	 * @param d - the data to be inserted
	  * @throws NoSuchElementException - if the item in parameter is null
	 */
	public void addToFront(T d) throws NoSuchElementException
	{
		if (d == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the list");
		else
			if (size == 0)
				rear = front = new Node<T>(d, null, null);
			else{
				Node<T> n = new Node<T>(d, front, null);
				front.setPrevious(n);
				front = n;
			}
		size++;
	}

	/**
	 * removeFromRear method - removes the item in the rear of the list
	 * @return - the last item in the list
	 * @throws NoSuchElementException - if list is empty
	 */
	public T removeFromRear() throws NoSuchElementException
	{
		if (size == 0)
			throw new NoSuchElementException("Exception: The list is empty, there is not an item to be removed from rear.");
		T item = rear.getData();
		rear = rear.getPrevious();
		if (rear != null)
			rear.setNext(null);
		else
			front = rear = null;
		size--;
		//System.out.println("Size in remove from rear: " + size);

		return item;

	}

	/**
	 * dequeue method - removes the object in the front of the queue
	 * @throws QueueEmptyException - in case the queue is empty
	 * @return - the item dequeued
	 * @throws NoSuchElementException if the list is empty
	 */
	public T removeFromFront() throws NoSuchElementException
	{
		if (size == 0) 
			throw new NoSuchElementException("Exception: The list is empty, there is not an item to be removed from front.");
		T item = front.getData();
		front = front.getNext();
		if( front == null)
			rear = null;
		else
			front.setPrevious(null);
		size--;
		//System.out.println("Size in remove from front: " + size);
		return item;
	}

	/**
	 * getSize method - gives access to the size of the queue
	 * @return - the size of the array as an integer
	 */
	public int size() {
		return size;
	}

	/**
	 * addAtPosition method - adds item to the list at the specific position
	 * @param data - the data to be inserted
	 * @param position - the position for the new item
	 * @throws NoSuchElementException if position is greater than list size or if item passed is null
	 */
	public void addAtPosition(T data, int position) throws NoSuchElementException
	{
		if (data == null)
			throw new NoSuchElementException("Exception: A null item cannot be inserted in the list");
		else
			if (position > size)
				throw new NoSuchElementException("Exception: Cannot add item, position is greater than list size.");
			else
				if (position == 0)
				{
					addToFront(data);
					return; //prevents size from being incremented twice: once in addToFront and once at size ++
				}
				else
					if (position == size)
					{
						addToRear(data);
						return; //prevents size from being incremented twice: once in addToRear and once at size ++
					}
					else
					{
						Node<T> c = front;
						for (int i = 0; i < position; i++)
						{
							c = c.getNext();
						}
						Node <T> n = new Node<T>(data, c, c.getPrevious());
						c.setPrevious(n);
						n.getPrevious().setNext(n);
					}
		size ++;
	}

	/**
	 * toString method - prints a String with all Nodes' data
	 * return - a reference to a String with all Nodes' data
	 */
	public String toString()
	{
		if (size == 0)
			return "Empty List";
		Node <T> trav = front;
		StringBuilder sb = new StringBuilder("Front  ");
		while (trav != null)
		{  
			sb.append(trav.getData() + " <-> ");
			trav = trav.getNext();
		}
		return sb.toString().substring(0,sb.length()-4).concat(" Rear	--	List size: " + size() + " items.");
	}

	/**
	 * reverseString - print the reverse list starting at the rear
	 * @return - the list printed reverse
	 */
	public String reverseString()
	{
		if (size == 0)
			return "Empty List";
		Node <T> trav = rear;
		StringBuilder sb = new StringBuilder("Rear  ");
		while (trav != null)
		{   
			sb.append(trav.getData() + " <-> ");
			trav = trav.getPrevious();
		}
		return sb.toString().substring(0,sb.length()-4).concat(" Front	--	List size: " + size() + " items.");
	}

	/**
	 * getItem method - returns the data at a specific position in a list starting at position 0
	 * @param position - the position in the list
	 * @return - the data at the specific position
	 * @throws NoSuchElementException - if the list is empty or if position is in invalid range
	 */
	public T get(int position) throws NoSuchElementException
	{
		if (size == 0)
			throw new NoSuchElementException("Exception: The List is empty.");
		else
			if (position > size - 1 || position < 0) // a negative node does not exist nor one greater than size
				throw new NoSuchElementException("Exception: The position passed is out of valid range.");

		Node<T> n = front;
		int i = 0;
		while(i++ < position)
			n = n.getNext();
		return n.getData();
	}
	/**
	 * removeAtPositon method - removes the item at the specified position
	 * @param position - the position at which the item will be removed
	 * @throws NoSuchElementException - if the list is empty or if position is in invalid range
	 */
	public void removeAtPosition(int position) throws NoSuchElementException 
	{
		if (size == 0)
			throw new NoSuchElementException ("Exception: The list is empty, there is not an item to remove");
		else 
			if (position > size || position < 0)
				throw new NoSuchElementException ("Exception: The position is in invalid range");
		Node<T> temp = front;
		int i = 0;
		if (position == 0)
		{
			removeFromFront();
			return;
		}else
			if (position == (size - 1)) 
			{
				removeFromRear();
				return;
			}
			else
			{
				while( i++ < (position - 1))
					temp = temp.getNext();
				temp.setNext(temp.getNext().getNext());
				temp.getNext().setPrevious(temp);
			}
		size--;
	}

	/**
	 * search method - searches for an item in a list passed as a parameter
	 * @param item - the item to be searched in the list
	 * @return -  negative if non existing or an integer position if found
	 */
	public int search(T item)
	{
		if (size == 0)
			return -1;
		int i = 0;
		Node <T> n = front;
		while(n != null)
		{
			if(n.getData().equals(item)){
				//System.out.println("This is item: " + item + "   this is n.getData(): " + n.getData());
				return i;
				
			}
			n = n.getNext();
			i++;
		}
		return -1;
	}

	/**
	 * sortedInsert method - adds an item to a list in a ordered manner (alphabetically or by integer/double value
	 * @param item - the item to be inserted
	 * @throws NoSuchElementException - if the item in parameter is null
	 */
	public void sortedInsert(T item) throws NoSuchElementException
	{
		if (item == null)
			throw new NoSuchElementException("Cannot insert a null item ot the list");
		else
			/*if (search(item) >= 0) //is this useful? i guess depends on the list type
				throw new NoSuchElementException("The item was not added, it is already in the list");
			else*/
				if (size == 0)
				{
					rear = front = new Node<T>(item, null, null);
					size++;
					return;
				}

				else
					if(item.compareTo(front.getData()) <= 0)
					{
						addToFront(item);
						return;
					}
					else
						if(item.compareTo(rear.getData()) >= 0)
						{
							addToRear(item);
							return;
						}
		//inserting in the middle somewhere
		Node <T> temp = front;
		while(temp != null) 
		{
			if(item.compareTo(temp.getNext().getData()) > 0)
			{
				temp = temp.getNext();
			}
			else
			{
				Node<T> newNode = new Node <T>(item, null, temp); //adds and links a new node
				newNode.setNext(temp.getNext());
				temp.getNext().setPrevious(newNode);
				temp.setNext(newNode);
				size++;
				return;
			}
		}
	}

	/**
	 * sortList method - sorts an unordered list
	 * @return - a list containing all items in a sorted manner
	 */
	public List sortList()
	{
		List <T> sortedList = new List <T>();
		Node <T> temp = this.front;
		while(temp != null)
		{
			sortedList.sortedInsert(temp.getData());
			temp = temp.getNext();
		}
		return sortedList;
	}
	

	/**
	 * emptyList method - resets the list
	 */
	public void emptyList()
	{
		front = rear = null;
		size = 0;
	}

}

