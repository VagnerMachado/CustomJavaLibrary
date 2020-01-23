package avlANDbst;


/**<pre>**************************************************************************************************************
 *                                                    Entry.java  						 							 
 *********************************************************************************************************************
 *                                                    
 * Description: Allows user to create Entry Objects that take two generic parameters K and V. 
 * The class provides getters and setters for the field data in addition to a to String method, these objects
 * are meant to be used on the LinkedMap and HashMap. Each Entry object contains a key, a value and a pointer to 
 * the next Entry
 * 
 *           For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *                       @author VagnerMachado - ID 23651127 -  Queens College - Spring 2018              
 *********************************************************************************************************************
 *
 * @param <K> - generic for the key for the object
 * @param <V> - generic for the value of the object
 /<pre>*/
public class Entry<K extends Comparable<K>, V> 
{
	//instance data
	private K key;
	private V value;
	private Entry<K,V> next;
	
	/**
	 * Entry constructor
	 * @param key - the Entry's key
	 * @param value - the Entry's value
	 */
	public Entry(K key, V value) 
	{
		this.key = key;
		this.value = value;
		next = null;

	}
	/**
	 * getNext - accessor for the next Entry
	 * @return next - the next Entry
	 */
	public Entry<K, V> getNext() 
	{
		return next;
	}

	/**
	 * setNext r- mutator for the next Entry
	 * @param n - the new next Entry
	 */
	public void setNext(Entry<K, V> n) 
	{
		next = n;
	}

	/**
	 * getKey method - accessor to Entry's key
	 * @return key - the Entry's key
	 */
	public K getKey()
	{
		return key;
	}

	/**
	 * setKey method - setter for Entry's Key
	 * @return key - the Entry's key
	 */
	public void setKey(K key) 
	{
		this.key = key;
	}

	/**
	 * getValue method - accessor to Entry's value
	 * @return key - the Entry's key
	 */
	public V getValue() 
	{
		return value;
	}

	/**
	 * setValue method - setter for Entry's Value
	 * @return value - the Entry's value
	 */
	public void setValue(V value)
	{
		this.value = value;
	}

	@Override
	/**
	 * toString method - prints the key and value for the entry
	 */
	public String toString() 
	{
		return "[Key = " + key + ", Value = " + value + "] -> ";
	}  

}
