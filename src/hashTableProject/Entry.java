
/*		 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017   */

package hashTableProject;

import java.lang.reflect.Array;

/*********************************************************************************************************************
 *                                                    Entry.java  						 							 *
 *********************************************************************************************************************
 *                                                    
 * Description: Allows user to create Entry Objects that take two generic parameters K and V. 
 * The class provides getters and setters for the field data in addition to a to String method
 * 
 *           For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	                 *           
 *********************************************************************************************************************
 *
 * @param <K> - generic for the key for the object
 * @param <V> - generic for the value of the object
 */
public class Entry<K, V> {
	//instance data
	private K key;
	private V value;

	/**
	 * Entry constructor
	 * @param key - the Entry's key
	 * @param value - the Entry's value
	 */
	public Entry(K key, V value) 
	{
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * getKey method - accessor to Entry's key
	 * @return key - the Entry's key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * setKey method - setter for Entry's Key
	 * @return key - the Entry's key
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * getValue method - accessor to Entry's value
	 * @return key - the Entry's key
	 */
	public V getValue() {
		return value;
	}

	/**
	 * setValue method - setter for Entry's Value
	 * @return value - the Entry's value
	 */
	public void setValue(V value) {
		this.value = value;
	}
	
	/** 16 buckets, 65 array, 22 items
	 * jenkins hash, god and sofa in the same bucket
	 *
	*/
	/*public int genHashCode(K key) { 
		String string = (String) key;
		byte[] b = string.getBytes();
		    int hash = 0;
		    int i = 0;
		    while (i < b.length) {
		        hash += (b[i++] & 0xFF); //masks by getting only significant bits
		        hash += (hash << 10);
		        hash ^= (hash >>> 6); //unsigned shift 6 bits right, keeps sign bit unchanged
		    }
		    hash += (hash << 3);
		    hash ^= (hash >>> 11); // >>> unsigned shift right 11 bits, keeps the sign bit unchanged
		    hash += (hash << 15);
		    return hash & 0x7FFFFFFF;
		}*/


	/**
	 * Rotating hash - Places one item per bucket on tested Entries  //see the return statement for efficiency
	 * @param key - the key to get hashed
	 * @return hash - an integer as result of the hash
	 */
	/*public int genHashCode(K key)
		{
			String str = (String) key;
			
			int hash, i; 
		    for (hash = str.length(), i = 0; i < str.length(); ++i) 
		      hash = (hash << 4) ^ (hash >> 28) ^ str.charAt(i); 
		    //return ((hash * str.length())& 0x7FFFFFFF);   //18 buckets, 65 array, 22 items
		    return ((hash ^ (hash>>10) ^ (hash>>20)) & 0x7FFFFFFF); ////17 buckets, 65 array, 22 items
		}*/

	/**
	 *  
	 * JSHash  - placed an Entry per bucket for tested entries 15 buckets, 31 array, 22 items
	 * @param key - the key used to generate the hash
	 * @return hash - an integer as result of the hash
	 */
	/*public int genHashCode(K key) { 
	    int hash = 1315423911; 
	 String str = (String)key;
	    for (int i = 0; i < str.length(); i++) { 
	      hash ^= ((hash << 5) + (int)str.charAt(i) + (hash >> 2)); 
	    } 

	    return (hash & 0x7FFFFFFF); 
	  }*/ 
	
	/**
	 * FNV hash 18 buckets in 65 array
	 * @param key
	 * @return
	 */
	 /*public int genHashCode(K key) 
	  { 
		  String data = (String) key;
		    final int p = 16777619; 
		    int hash = (int) 2166136261L; 
		    for (int i = 0; i < data.length(); i++) 
		      hash = (hash ^ data.charAt(i)) * p; 
		    hash += hash << 13; 
		    hash ^= hash >> 7; 
		    hash += hash << 3; 
		    hash ^= hash >> 17; 
		    hash += hash << 5; 
		    return hash  & 0x7FFFFFFF; 
		  } */

	/**
	 * murmur hash 19 of 65 buckets 22 items best  them
	 * @param key
	 * @return
	 */
	public int genHashCode(K key) { 
	    // 'm' and 'r' are mixing constants generated offline. 
	    // They're not really 'magic', they just happen to work well. 
		String str = (String) key;
		byte [] data = str.getBytes();
	    final int m = 0x5bd1e995; 
	    final int r = 24; 
	    final int seed = 31;
	    final int length = str.length();
	 
	    // Initialize the hash to a random value 
	    int h = seed ^ length; 
	    int length4 = length / 4; 
	 
	    for (int i = 0; i < length4; i++) { 
	      final int i4 = i * 4; 
	      int k = 
	          (data[i4 + 0] & 0xff) + ((data[i4 + 1] & 0xff) << 8) + ((data[i4 + 2] & 0xff) << 16) 
	              + ((data[i4 + 3] & 0xff) << 24); 
	      k *= m; 
	      k ^= k >>> r; 
	      k *= m; 
	      h *= m; 
	      h ^= k; 
	    } 
	 
	    // Handle the last few bytes of the input array 
	    switch (length % 4) { 
	      case 3: 
	        h ^= (data[(length & ~3) + 2] & 0xff) << 16; 
	      case 2: 
	        h ^= (data[(length & ~3) + 1] & 0xff) << 8; 
	      case 1: 
	        h ^= (data[length & ~3] & 0xff); 
	        h *= m; 
	    } 
	 
	    h ^= h >>> 13; 
	    h *= m; 
	    h ^= h >>> 15; 
	 
	    return h & 0x7FFFFFFF; 
	  } 

	
	@Override
	/**
	 * toString method - prints the key and value for the entry
	 */
	public String toString() 
	{
		return "Entry [Key=" + key + ", Value=" + value + "]";
	}  

}
