
package avlANDbst;
import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.Set;


/**<pre>*************************************************************************************************************
 *                                                 HashMap.java  						 						    
 ********************************************************************************************************************
 * 																													
 * Description: Enables user to instantiate HashMap Objects, which contain a LinkedMap array with initial size   
 * passed as parameter to constructor. As items are added to the HashMap Object, the load factor increases and    
 * once it becomes greater than the threshold also passed as parameter, the array is expanded and LinkedMaps are         
 * placed in new array according to the new array size.     													    
 *                                                                                                                  
 *  I added an instance LinkedHashSet <K> called allKeys. As entries are added to the list, their keys               
 *  are added to the allKeys variable. I imported the java.util.Set and added the method Set<K> keySet() which      
 *  returns to the user a reference to allKeys.                                                                        
 ********************************************************************************************************************
 * 
 *         For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     		                @author VagnerMachado  - ID 23651127 - Spring  2018 - Queens College           	                            
 *********************************************************************************************************************
 *
 * @param <K> - a generic for the key 
 * @param <V> - a generic for the value
 </pre>*/
public class HashMap<K extends Comparable<K>, V> implements Map<K,V>
{

	//instance data
	private int numOfBucketsUsed;
	private int size;
	private double loadfactor;
	private double  MAX_LOAD_FACTOR;
	private LinkedMap<K,V> [] table;
	private LinkedHashSet <K> allKeys;
	private int collisions;
	private int items;
	private int firstArraySize;
	private double firstLoadFactor;

	/**
	 * HashMap Constructor - instantiates a empty HashMap object; array size,
	 * and threshold passed as parameter
	 */
	@SuppressWarnings("unchecked")
	public HashMap(int arraySize, double loadThreshHold) 
	{
		size = firstArraySize = arraySize;
		numOfBucketsUsed = collisions = 0;
		loadfactor = 0;
		firstLoadFactor = MAX_LOAD_FACTOR = loadThreshHold;
		table = new LinkedMap [size];
		allKeys = new LinkedHashSet <K>();
		//function = f;
	}

	@SuppressWarnings("unchecked")
	/**
	 * clear - clears a HashMap object to the initial values
	 */
	public void clear()
	{
		size  = firstArraySize;
		numOfBucketsUsed = collisions = 0;
		loadfactor = 0;
		MAX_LOAD_FACTOR = firstLoadFactor;
		table = new LinkedMap [size];
		allKeys = new LinkedHashSet <K>();
	}

	/**
	 * keySet method - accessor to a Linked Hash Set Object containing a 
	 * list of all keys entered in the HashMap Object
	 * @return - a set containing all keys
	 */
	public Set<K> keySet()
	{
		return allKeys;
	}

	/**
	 * put method - adds a Key-Value pair to the LinkedMap Array.
	 * repeated keys are not added to the hash table
	 * @param key - the key used to generate the hashcode
	 * @param value - the value store in the bucket location determined by hashcode
	 */
	public void put(K key, V value) throws MapException
	{
		int hashCode = Math.abs(key.hashCode()); //uses key to generate an int hashcode
		int bucketIndex = hashCode % size; //determined the bucketIndex
		if(table[bucketIndex] == null)
		{
			table[bucketIndex] = new LinkedMap<K,V>(); //instantiates a list at bucket Index
			table[bucketIndex].put(key, value); //adds the Entry to that list                          
			numOfBucketsUsed ++; //increment the number of buckets used
			items++; //keeps track of number of items added
			allKeys.add(key); //this calls the hashCode function as well, adds key to Linked Hash Set
		}
		else 
		{
			boolean repeat = false;
			if(table[bucketIndex].contains(key))
			{
				repeat = true;
			}
			if(!repeat) //does not allow repeated keys
			{
				collisions++; //increment the collisions
				table[bucketIndex].put(key, value); //Add entry to the linkedMap at that spot
				items++; //keeps track of number of items added
				allKeys.add(key); //this calls adds key to Linked Hash Set
			}
			else
			{
				throw new MapException("\n ** Found a repeated key: " + key + ", cannot add it to HashMap **\n");
			}
		}
		loadfactor = ((double)items / numOfBucketsUsed); // recalculates load factor

		//checking if the Hash Table needs to be resized
		if(loadfactor >= MAX_LOAD_FACTOR )
			resizeTable();
		
	}

	/**
	 * get method - gets the Value stored based on Key passed as parameter
	 * @param key - the Key used to locate item's value
	 * @return the items value or a runtime exception if
	 *  item is not found in the list
	 */
	//@SuppressWarnings("unchecked")
	public V get(K key) throws MapException
	{
		int hashCode =  Math.abs(key.hashCode()); //generates the hash code based on the key passed as parameter                                                    
		int bucketIndex = hashCode % size; // calculates the bucket index

		// if there is nothing at the bucketIndex element then throw MapException
		if(table[bucketIndex] == null) 
			throw new MapException("\n** Bad Hash? The key " + key + " is not in the bucketindex " + bucketIndex + "**\n");
		else
		{   
			V value = table[bucketIndex].get(key); //gets the value associated with key

			if (value != null)
				return value;
			else 
				throw new MapException("\n** Key " + key + " is not found in the HashMap at " + bucketIndex + "**\n");
		}
	}

	/**
	 * resizeTable private method - Once the load factor is greater than the defined threshold
	 * this method gets called to resize and relocated the LinkedLists in an expanded array
	 * The Console displays the relocation process
	 */
	@SuppressWarnings({ "unchecked" })
	private void resizeTable() throws MapException
	{
		size = size * 2 + 3;
		collisions = 0;
		numOfBucketsUsed = 0;
		loadfactor = 0; 

		//new LinkedList Array is instantiated to new size
		LinkedMap<K,V> [] temp = new LinkedMap[size] ;

		//iterates through the old Array
		for (int i = 0; i < table.length; i++)
		{
			//if there is a list at that spot
			if(table[i] != null)
			{
				int j = 0; // the item to be relocated in each individual bucket
				while( j < table[i].size())
				{
					Entry <K,V> tempEntry = table[i].get(j); //get a reference the that Entry Object
					int newHashCode = Math.abs(tempEntry.getKey().hashCode());                             
					int newBuckIndex = newHashCode % size; // calculates the new bucket index
					if(temp[newBuckIndex] == null)
					{
						temp[newBuckIndex] = new LinkedMap <K,V>(); // then add a new Linked List to that spot
						temp[newBuckIndex].put(tempEntry.getKey(),tempEntry.getValue()); //add the entry to the that Linked List
						numOfBucketsUsed ++; //increments the number of buckets used
					}

					// else add entry to the linked list already at that spot
					else 
					{
						temp[newBuckIndex].put(tempEntry.getKey(),tempEntry.getValue()); //add entry to the linked list already at that spot
						collisions++; //increments collisions
					}
					j++;
				}
			}
		}
		loadfactor = ((double)items / numOfBucketsUsed); // recalculates load factor
		
		table = temp;
	}

	/**
	 * toString method - prints the current contents in the HashMap
	 * @return a String with the objects in the LinkedMap Array
	 */
	public String toString()
	{
		if(items == 0)
		{
			System.out.println("\n	** The HashMap is empty **");
		}
		//append and return string with all items.
		StringBuilder sb = new StringBuilder();
		sb.append("	  Max Load:    " + new DecimalFormat("###.##").format(MAX_LOAD_FACTOR) + "\n");
		sb.append("	  Load Factor:  " + new DecimalFormat("###.##").format(loadfactor) + "\n");
		sb.append("	  Collisions:   " + collisions +  "\n");
		sb.append("	  Buckets Used: " + (numOfBucketsUsed) + "\n");
		sb.append("	  Items added:  " + (items) + "\n");
		sb.append("   Array Size:   " + (size) + "\n");
		sb.append("   Distribution: " + ((items == 0) ? 
				" 0%\n" : new DecimalFormat("###.###").format(numOfBucketsUsed * 100.0 /items) + "%\n"));
		sb.append("	  Longest List: " + (longestList()) + "\n");

		for(int i = 0; i < table.length; i++)
			sb.append("Array [" + i + "] = " + table[i] + "\n");
		return sb.toString();
	}

	/**
	 * printStats - prints the values for the instance data without the hash table
	 */
	public void printStats()
	{
		if(items == 0)
		{
			System.out.println("\n	** The HashMap is empty **");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("	  	Max Load:    " + new DecimalFormat("###.##").format(MAX_LOAD_FACTOR) + "\n");
		sb.append("	  	Load Factor:  " + new DecimalFormat("###.##").format(loadfactor) + "\n");
		sb.append("	  	Collisions:   " + collisions +  "\n");
		sb.append("	 	Buckets Used: " + (numOfBucketsUsed) + "\n");
		sb.append("	 	Items added:  " + (items) + "\n");
		sb.append("	  	Array Size:   " + (size) + "\n");
		sb.append("		Distribution: " + ((items == 0) ? 
				" 0%\n" : new DecimalFormat("###.###").format(numOfBucketsUsed * 100.0 /items) + "%" + "\n"));
		sb.append("		Longest List:   " + (longestList()) + "\n");
		System.out.println(sb);

	}

	/**
	 * longestList - made this just to test. Accessor to the longest list in the Hash Table
	 * @return - an int corresponding to the longest list in the table
	 */
	public int longestList()
	{
		int x = 0;
		for (int i = 0; i < table.length; i++)
		{
			if (table[i] != null && table[i].size() > x)
				x = table[i].size();
		}
		return x;
	}

	/**
	 * printHashMap - prints the contents of the HashMap
	 */
	public void printHashMap()
	{
		if(items == 0)
			System.out.println("\n	** The hash table is empty **");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < table.length; i++)
			sb.append("Array [" + i + "] = " + table[i] + "\n");
		System.out.println(sb);
	}

	/**
	 * remove - removes an Entry from the hash table based on the key passed as parameter
	 * @param key - the key for the Entry to be deleted
	 * @return - true if a deletion happened, false otherwise
	 */
	public void remove(K key) throws MapException
	{
		int bucket = Math.abs(key.hashCode()) % size;
		if(table[bucket].size() != 0)
		{
			if(table[bucket].contains(key))
			{
				table[bucket].remove(key);
				items--;
				allKeys.remove(key);
				if(table[bucket].size() == 0)
				{
					//System.out.println("Size zero");
					table[bucket] = null;
					numOfBucketsUsed --; //increment the number of buckets used
					if(items == 0)
						loadfactor = 0;
					else
						loadfactor = ((double)items / numOfBucketsUsed); // recalculates load factor
				}
				else
				{
					collisions--;
				}
			}
			else
				throw new MapException ("\n** Cannot remove key " + key +", it is not in bucket " + bucket + "** \n" );
		}
		else
			throw new MapException ("\n** Cannot remove key " + key +". LinkedMap size is zero.** \n" );
	}

	@Override
	/**
	 * size - accessor for the size of the LinkedMap
	 * @return - size
	 */
	public int size() 
	{
		return items;
	}

	/**
	 * getMaxLoad - accessor for the max load of the HashMap
	 * @return
	 */
	public double getMaxLoad()
	{
		return MAX_LOAD_FACTOR;
	}

	/**
	 * getFirstArraySize - accessor for the size passed as parameter
	 * @return
	 */
	public int getFirstArraySize()
	{
		return firstArraySize;
	}

	@Override
	/**
	 * isEmpty - let's program know if the HashMap is Empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() 
	{
		return items == 0;
	}

}
