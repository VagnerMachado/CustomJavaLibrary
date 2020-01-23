package unorderedListArray;

/**
 * Interface for the List class
 * @author F. Graham
 * Edited by VagnerMachado
 * @version Spring 2016
 * 
 *********************************************************************************************************************
 *          Please refer to the xxxxxxxxx.java file for a description of the project in a larger scope               *
 *********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxx<br>
 *<b>Filename:</b>	ListADT.java<br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This is the interface that contains the abstract methods to be implemented in the List Class
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 * @param <T> - a generic data type 
 */
 
public interface ListADT<T extends Comparable<T>> 
{
	/**
	 * add method - Adds an item to the list
	 * @param item - the item to be added
	 */
	void add(T item);
	
	/**
	 * get method - Returns the item at specified location in the list
	 * @return  - the item at specified location
	 * @throws ListEmptyException - if the list is empty
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 */
	T get(int location) throws IndexOutOfBoundsException, ListEmptyException;
	
	/**
	 * removeAt method - Removes and returns an item stored at a specified location in the list
	 * @param location - the location of the item to removed from the list        
	 * @return  - the item stored at that location
	 * @throws ListEmptyException - if the list is empty    
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 */
	T removeAt(int location) throws ListEmptyException, IndexOutOfBoundsException;
	
	/**
	 * remove method - Removes first occurrence of an item from the list
	 * @param item - the item to removed from the list
	 * @throws ListEmptyException - if the list is empty
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 *            
	 */
	T remove(T item) throws ListEmptyException;
	
	/**
	 * valueAt method - Returns the item at a specified location in the list
	 * @param location - the location of the item in the list         
	 * @throws ListEmptyException - if the list is empty
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 *             
	 */
	T valueAt(int location) throws ListEmptyException, IndexOutOfBoundsException;
	
	/**
	 * find method - Searches for an item in the list and returns its location or -1 if this item is not in the list
	 * @param item - the item to search for         
	 * @return the location of the item
	 * @throws ListEmptyException - if the list is empty
	 *             
	 */
	int find(T item) throws ListEmptyException;
	
	/**
	 * contains method - Searches for an item in the list and returns true if it can be found
	 * @param item - the item to search for
	 * @return <i>true</i> if an item is in the list or <i>false</i> otherwise
	 * @throws ListEmptyException - if the list is empty
	 */
	boolean contains(T item) throws ListEmptyException;
	
	/**
	 * isEmpty method - Returns <i>true</i> if the list is empty, or <i>false</i> otherwise
	 * @return <i>true</i> if the list is empty, or <i>false</i> otherwise
	 */
	boolean isEmpty();
	
	/**
	 * getSize method - Returns the number of items in the list
	 * @return the number of items in the list
	 */
	int getSize();
	
	/**
	 * Removes all of the items from the list.
	 */
	void clear();
	
	/**
	 * replace method - replaces an object in the list
	 * @param position - the position on the list where item will be replaced
	 * @param item - new item to be place on position
	 * @throws ListEmptyException 
	 * @throws IndexOutOfBoundsException 
	 */
	public void replace(int position, T item) throws IndexOutOfBoundsException, ListEmptyException;

	/**
	 * replace method - replaces a specific item passed as first parameter by one passes as second parameter
	 * @param oldItem - item to be replaced
	 * @param newItem - replacement item
	 * @throws ListEmptyException 
	 * @throws SameItemException 
	 */
public void replace(T oldItem, T newItem) throws SameItemException, ListEmptyException;
}
