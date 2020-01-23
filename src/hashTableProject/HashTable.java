
/* 			@author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017   */

package hashTableProject;
import java.text.DecimalFormat;
//the steveo.us
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*********************************************************************************************************************
 *                                                 HashTable.java  						 							 *
 *********************************************************************************************************************
 * 
 * Description: Enables user to instantiate HashTable Objects, which contain a LinkedList array with initial size
 * of 5. As items are added to the HashTable Object, the load factor increases and once it becomes greater than the 
 * defined threshold, the array is expanded and lists are placed in new array according to the new array size.
 * 
 *         For information about the other classes created for this project, please see their javadocs.
 *
 *  
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	                 *           
 *********************************************************************************************************************
 *
 * @param <K> - a generic for the key 
 * @param <V> - a generic for the value
 */
public class HashTable<K, V> {

	private int numOfBucketsUsed; //
	private int size;
	private double loadfactor;
	private double threshold;
	private LinkedList<Entry<K,V>> [] table;
	// make a ref to a LinkedList of entries called table

	@SuppressWarnings("unchecked")
	/**
	 * HashTable Constructor - instantiates a empty Hash Table object array of size 5
	 * with initial threshold value 0.5
	 */
	public HashTable() {
		size = 31;
		numOfBucketsUsed = 0;
		loadfactor = numOfBucketsUsed / size;
		threshold = 0.5;
		table = new LinkedList [size];
		// instantiate table to size
	}

	/**
	 * add method - adds a Key - Value pair to the Linked List Array
	 * @param key - the key used ot generate the bucket location
	 * @param value - the value store in the bucket location
	 */
	public void add(K key, V value)
	{
		// make a new Entry object with the key and value
		Entry <K,V> entry = new Entry <K,V>(key, value);

		int hashCode = entry.genHashCode(key);

		System.out.println(hashCode + " : " + value);

		// bucketIndex should be hashcode mod size
		int bucketIndex = hashCode % size;	

		// if table[bucketIndex] is null then make a new linkedlist at that spot
		if(table[bucketIndex] == null)
		{
			// then add the entry to that list
			table[bucketIndex] = new LinkedList <Entry<K,V>>();
			table[bucketIndex].add(entry);
			numOfBucketsUsed ++;
			loadfactor = ((double)numOfBucketsUsed) / size; // recalculates loadfactor
			System.out.println("List in if: " + table[bucketIndex]);
		}
		// else
		// add entry to the linked list at that spot
		else 
		{
			table[bucketIndex].add(entry);
			System.out.println("List in else: " + table[bucketIndex]);
		}

		/**** THE CODE BLOCK BELOW EXPANDS THE ARRAY WHEN NECESSARY  ****/

		//I am resizing the array once the load factor is greater than threshold.
		//To see the resizing output, please uncomment the block below and two 
		//lines commented out in the MainTest.java file		-Vagner

		System.out.println("Buckets Used: " + numOfBucketsUsed);
		System.out.println("Load Factor: " + new DecimalFormat("#.###").format(loadfactor));
		if(loadfactor > threshold )
		{
			System.out.println(this);
			resizeTable();
		}

		/*********************** END OF ARRAY RESIZING  ****************************/
	}

	/**
	 * get method - gets the Value stored based on Key passed as parameter
	 * @param key - the Key used to locate item's value
	 * @return the items value or a runtime exception if
	 *  item is not found in the list
	 */
	public V get(K key)
	{
		Entry <K,V> temp = new Entry<K,V>(key, null); /////////////////////////////////////////////////////////////////////////seee
		int hashCode = temp.genHashCode(key);	///////////if gen hash is in entry class, gotta crate a temp entry
		System.out.println("in get " + hashCode);
		int pos = -1;
		//System.out.println("Size: " + size);
		int bucketIndex = hashCode % size;
		//System.out.println("Located in index " + bucketIndex);

		// if there is nothing at the bucketIndex element then throw NoSuchElementException
		if(table[bucketIndex] == null)
			throw new NoSuchElementException("No item at bucketindex " + bucketIndex);
		// else
		// get ref to linked list at the bucketIndex element
		else
		{
			LinkedList <Entry<K,V>> list = table[bucketIndex];
			for(int i = 0; i < list.size(); i++)
				if (list.get(i).getKey().equals(key))
					pos = i;

			// use for loop to go through items in that list checking to see if the item's
			// key matches the key you're looking for.
			// if you find it record the position, otherwise pos is -1

			System.out.println("pos of key is " + pos);
			V result;
			// if you found position 
			// get entry from that position and return it's value
			if (pos != -1)
				result = list.get(pos).getValue();
			else 
				throw new NoSuchElementException("Not found in List");
			return result;
		}
	}

	/**
	 * resizeTable method - Once the load factor is greater than the defined threshold
	 * this method gets called to resize and relocated the LinkedLists in an expanded array
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void resizeTable()
	{
		System.out.println("\n  ** Expanding the Linked List Array **");
		//new size for the LInkedList array 
		size = size * 2 + 3; //i added 3 because times two alone would cause spots to remain unchanged
		numOfBucketsUsed = 0; //true for the new Table
		//recalculate load factor
		loadfactor = ((double)numOfBucketsUsed) / size;

		//new LinkedList
		LinkedList<Entry<K,V>> [] temp = new LinkedList[size] ;

		//iterates through table
		for (int i = 0; i < table.length; i++)
		{
			//if there is a list at that spot
			if(table[i] != null)
			{
				int j = 0; // the items in each individual bucket
				System.out.println("This is the i value " + i );
				while(table[i].size() > j)
				{

					//System.out.println("This is the j value " + j );
					//System.out.println("The table size at (see below) is: " + table[i].size());
					//get the key for the first Entry in the list - all Entries in the list have the same hash code
					System.out.println("Relocating list in spot [" + i +  "] [" + j + "]");
					K newKey = table[i].get(j).getKey(); //--> if complex hashing, iterate through each list and relocate all Entries
					//V newValue = table[i].get(j++).getValue();
					Entry <K,V> tempEntry = table[i].get(j++);//new Entry <K,V> (newKey, newValue);
					//System.out.println("new key: " + newKey + "  -  newValue: " );//+ newValue);
					//produce the hash code and bucketIndex based on retrieved key
					int newHashCode = tempEntry.genHashCode(newKey);
					int newBucketIndex = newHashCode % size;
					System.out.println("New bucket: " + newBucketIndex + "  -  Size: " + size + "   -  New Hash: " + newHashCode);

					/* ***************************************************************************************************/
					if(temp[newBucketIndex] == null)
					{
						// then add the entry to that list
						temp[newBucketIndex] = new LinkedList <Entry<K,V>>();
						temp[newBucketIndex].add(tempEntry);
						numOfBucketsUsed ++;
						loadfactor = ((double)numOfBucketsUsed) / size; // recalculates loadfactor
						System.out.println("List in if: " + temp[newBucketIndex]);
					}
					// else
					// add entry to the linked list at that spot
					else 
					{
						temp[newBucketIndex].add(tempEntry);
						System.out.println("List in else: " + temp[newBucketIndex]);
					}

					/* **************************************************************************************************************/
				}
			}else
				System.out.println("Skipping the spot " + i);
		}

		//prints the old and new arrays, can be commented out
		System.out.println("\n	****  Old Array   ****");
		System.out.println(this);
		table = temp;
		System.out.println("	****  New Array   ****");
		System.out.println(this);
	}

	/**
	 * toString method - prints the current contents in the HashTable
	 * @return a String with the objects in the Linked List Array
	 */
	public String toString()
	{
		//append and return string with all items.
		StringBuilder sb = new StringBuilder();
		sb.append("	  Buckets Used: " + new DecimalFormat("#.##").format(numOfBucketsUsed) + "\n");
		sb.append("	  Threshold:    " + new DecimalFormat("#.##").format(threshold) + "\n");
		sb.append("	  Load Factor:  " + new DecimalFormat("#.##").format(loadfactor) + "\n");
		sb.append("	  Array Size:   " + new DecimalFormat("#.##").format(size) + "\n");
		for(int i = 0; i < table.length; i++)
			sb.append("Array [" + i + "] = " +table[i] + "\n");
		return sb.toString();
	}
}
