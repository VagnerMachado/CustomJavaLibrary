package graphANDdijkstra;

import java.util.Iterator;


/**<pre>
 * ********************************************************************************************************************
 *      									     LinkedList.java       					                          
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class allows for the instantiation of a single Linked List of generic type.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     		             @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *********************************************************************************************************************
 *
 * @param K - a generic type
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class LinkedList<K> implements Iterable<K>
{

	//instance data
	private Entry<K> head;
	private int size;

	/**
	 * LinkedMap constructor - Starts a LinkedMap with a null Entry to be the head
	 */
	public LinkedList()
	{
		head = null;
		size = 0;
	}

	/***
	 * clear - clears the LinkedMap
	 */
	public void clear()
	{
		head = null;
		size = 0;
		System.gc();
	}

	/**
	 * put - puts an Entry to the front of the linked list
	 * @param data - key to be inserted
	 * @throws GeneralException - if the item to be put is null
	 */
	public void put(K k) 
	{
		if (k == null)
			throw new GeneralException("\n *** Linked List Exception: "
					+ "A null key cannot be inserted in the Linked list ***\n");              

		if(size == 0)
			head = new Entry<K>(k);
		else
		{
			Entry<K> temp = new Entry<K>(k);
			temp.setNext(head);
			head = temp;
		}
		size++;
	}	

	/**
	 * remove - removes the item with the key passed as parameter
	 * @param <K> - the key
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void remove(K key)
	{
		if ( size == 0) 
		{
			System.out.println("\n*** The Linked list is empty, you cannot remove an item ***\n");
			return;
		}

		Entry trav = head;
		Entry before = head;
		//V value  = null;
		for(int i = 0; i < size; i ++)
		{
			if(trav.getData() == key)
			{
				if (i == 0) // first
					head = head.getNext();
				else if (i == size - 1) //last
					before.setNext(null);
				else // middle
					before.setNext(trav.getNext());
				size--;	
				return;
			}
			else
			{
				before = trav;
				trav = trav.getNext();
			}
		}
	}
	

	/**
	 * isEmpty - let's the user know if the linked list size is zero
	 * @return - true if the size is zero, false otherwise
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * getSize - accessor for the size of linked list
	 * @return - the size of the linked list
	 */
	public int size() 
	{
		return size;
	}


	/**
	 * contains - let's user know if the linked list contains certain key
	 * @param key - the key being looked for
	 * @return - true if list contains the key, false otherwise.
	 */
	public boolean contains(K k) 
	{
		Entry <K> trav = head;
		for(int i = 0; i < size; i++)
		{
			if(k == (trav.getData()))
				return true;
			else
				trav = trav.getNext();
		}

		return false;
	}

	@SuppressWarnings("rawtypes")
	/**
	 * toString - gives a string to the user containing all the data in it
	 */
	public String toString()
	{
		String result = "";
		Entry trav = head;
		for(int i = 0; i < size; i++)
		{
			result += trav.toString();
			trav = trav.getNext();
		}

		return result;
	}

	/**
	 * get - accessor for a copy of an Entry needed to expand the Hash list
	 * @param index - the index for the Entry needed
	 * @return - a copy of an Entry at a valid index, avoid manipulation of original data
	 */
	public K get(int index)
	{
		if (index < 0 || index > size - 1)
		{
			System.out.println("Invalid call to get");
		}
		Entry <K> trav = head;
		int i = 0;

		while (i++ < index)
			trav = trav.getNext();

		return (K)trav.getData();
	}

	/**
	 * iterator - returns an instance of ListIterator
	 */
	public Iterator<K> iterator()
	{
		
		return new ListIterator<K>();
	}
	
	@SuppressWarnings("hiding")
	/**
	 * ListIterator - allows for the iteration of a Linked List
	 * @author Vagner Machado
	 * @param <K> - a generic type
	 */
	private class ListIterator<K> implements Iterator<K> 
	{

		@SuppressWarnings("unchecked")
		//instance data
		private Entry<K> trav = (Entry<K>) head;
		
		/**
		 * hasNext - condition to stop iteration is checked
		 */
		public boolean hasNext()
		{
			return trav != null;
		}

		@Override
		/**
		 * next - saves the data in a variable, moves the pointer to next and returns data
		 */
		public K next() {
			K data = trav.getData();
			trav = trav.getNext();
			return data;
		}
		
	}

	/**<pre>**************************************************************************************************************
	 *                                                    Entry.java  						 							 
	 *********************************************************************************************************************
	 *                                                    
	 * Description: Allows user to create Entry Objects that take generic parameters K. 
	 * The class provides getters and setters for the field data in addition to a to String method, these objects
	 * are meant to be used on the Linked list for Project 3. Each Entry object contains a key and a pointer to 
	 * the next Entry
	 * 
	 *           For information about the other classes created for this project, please see their javadocs.
	 *
	 *********************************************************************************************************************
	 *                       @author VagnerMachado - ID 23651127 -  Queens College - Spring 2018              
	 *********************************************************************************************************************
	 *
	 * @param <K> - generic for the key for the object
	 *<pre>
	 ***/
	@SuppressWarnings("hiding")
	public class Entry<K> 
	{
		//instance data
		private K data;
		private Entry<K> next;

		/**
		 * Entry constructor
		 * @param key - the Entry's key
		 * @param value - the Entry's value
		 */
		public Entry(K k) 
		{
			data = k;
			next = null;
		}
		/**
		 * getNext - accessor for the next Entry
		 * @return next - the next Entry
		 */
		public Entry<K> getNext() 
		{
			return next;
		}

		/**
		 * setNext r- mutator for the next Entry
		 * @param n - the new next Entry
		 */
		public void setNext(Entry<K> n) 
		{
			next = n;
		}

		/**
		 * getKey method - accessor to Entry's key
		 * @return key - the Entry's key
		 */
		public K getData()
		{
			return data;
		}

		/**
		 * setKey method - setter for Entry's Key
		 * @return key - the Entry's key
		 */
		public void setData(K k) 
		{
			data = k;
		}

		@Override
		/**
		 * toString method - prints the key and value for the entry
		 */
		public String toString() 
		{
			return  data + " -> ";
		}  

	}
}


