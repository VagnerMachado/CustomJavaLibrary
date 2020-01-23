
package avlANDbst;


/**<pre>
 * ********************************************************************************************************************
 *      									     LinkedMap.java       					                          
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class allows for the instantiation of a single Linked Map for generic types Entry
 * with generic key and values. The user is able to put, get, remove, check if a linked list contains an
 * element, the size of the map and if it is empty. A default constructor is defined which makes the head Entry null.
 * The key for the entry must extend the Comparable type.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     		             @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *********************************************************************************************************************
 *
 * @param K - a generic Comparable type 
 * @param V - the value associated with K
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class LinkedMap<K extends Comparable<K>,V> implements Map<K,V>
{

	//instance data
	private Entry<K,V> head;
	private int size;

	/**
	 * LinkedMap constructor - Starts a LinkedMap with a null Entry to be the head
	 */
	public LinkedMap()
	{
		head = null;
		size = 0;
	}

	/***
	 * clear - clears the LinkedMap
	 */
	public void clearLinkedMap()
	{
		head = null;
		size = 0;
		System.gc();
	}

	/**
	 * put - puts an Entry to the front of the linkedMap, insertion only occurs if key is not already in the Map
	 * @param data - key, value - the pair to be inserted
	 * @throws MapException - if the item to be put is null or already in the Map
	 */
	public void put(K key, V value) throws MapException 
	{
		if (key == null)
			throw new MapException("\n ***Exception: A null key cannot be inserted in the LinkedMap ***\n");              

		if(size == 0)
			head = new Entry<K,V>(key, value);
		else
		{
			if (get(key) != null)
				throw new MapException("\n*** Repeated item, cannot put pair to the LinkedMap ***\n");

			Entry<K,V> temp = new Entry<K,V>(key, value);
			temp.setNext(head);
			head = temp;
		}
		size++;
	}	

	/**
	 * remove - removes the item with the key passed as parameter
	 * @param <K> - the key
	 * @param <V> - the value
	 * @throws MapException - case the linkedMap is empty
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void remove(K key) throws MapException 
	{
		if ( size == 0)
			throw new MapException("\n*** The LinkedMap is empty, you cannot dequeue an item ***\n");

		Entry trav = head;
		Entry before = head;
		//V value  = null;
		for(int i = 0; i < size; i ++)
		{
			if(trav.getKey() == key)
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
	 * get - gets the value of Entry based on the key value
	 * @param key - the key for the entry being searched
	 * @return V - the value of Entry with key matching parameter passed
	 * @throws MapException -  if the list is empty
	 */
	public V get(K key) throws MapException 
	{
		if ( size == 0)
			throw new MapException("The LinkedMap is empty, you cannot get key " + key);

		Entry<K,V> trav = head;
		while(trav != null)
		{
			if (trav.getKey().compareTo(key) == 0)
				return trav.getValue();
			trav = trav.getNext();
		}	
		return null;
	}


	/**
	 * isEmpty - let's the user know if the linkedMap size is zero
	 * @return - true if the size is zero, false otherwise
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * getSize - accessor for the size of linkedMap
	 * @return - the size of the linkedMap
	 */
	public int size() 
	{
		return size;
	}


	/**
	 * contains - let's user know if the linkedMap contains certain key
	 * @param key - the key being looked for
	 * @return - true if list contains the key, false otherwise.
	 */
	public boolean contains(K key) 
	{
		Entry <K,V> trav = head;
		for(int i = 0; i < size; i++)
		{
			if(key.compareTo(trav.getKey()) == 0)
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
	 * get - accessor for a copy of an Entry needed to expand the HashMap
	 * @param index - the index for the Entry needed
	 * @return - a copy of an Entry at a valid index, avoid manipulation of original data
	 */
	public Entry<K, V> get(int index)  throws MapException
	{
		if (index < 0 || index > size - 1)
				throw new MapException("Exception: The index is in invalid range. "
						+ "Passed index" + index + " for size " + size);
		Entry <K,V> trav = head;
		int i = 0;
		
		while (i++ < index)
			trav = trav.getNext();
		
		return new Entry<K,V>(trav.getKey(), trav.getValue());
	}
}


