package unorderedListArray;

//the class declaration is a problem, I tried a few options but none seem to work
// the line we wrote in class looks like the one below, but it does not work:
//public class UnorderedList<T extends Comparable<T>> implements ListADT<T extends Comparable<T>

//If you have time, could you help me fix this issue?
//I understand the next lab is about lists, and i'd like to have my code working for that

//I imagine I will run into the same issues when i build the linked list implemented List
//public class UnorderedList<T extends Comparable<T>> implements ListADT<T> does not show an error but does not compile
//public class UnorderedList<T extends Comparable<T>> implements ListADT<T>,  Comparable<T> does not show an error but does not compile

public class UnorderedList<T extends Comparable<T>> implements ListADT<T>
{
	//instance data
	private T []data;
	private int size;
	private final int CAPACITY = 100;


	/**
	 * UnorderedList default Constructor - instantiates an object with 100 items of capacity
	 */
	@SuppressWarnings("unchecked")
	public UnorderedList()
	{
		data = (T[]) new Comparable[CAPACITY];
	}


	/**
	 * parameterized UnorderedList constructor - instantiates an object with capacity equal to parameter
	 * @param size - size of the data array
	 */
	@SuppressWarnings("unchecked")
	public UnorderedList(int size)
	{
		if (size < 0)
			data = (T[]) new Comparable[CAPACITY];
		else
			data = (T[]) new Comparable[size];
	}

	/**
	 * add method - Adds an item to the list
	 * @param item - the item to be added
	 */
	public void add(T item) 
	{
		if(size == data.length)
			expand();
		data[size] = item;
		size++;
	}

	/**
	 * expand method - doubles the capacity of data array
	 */
	private void expand() 
	{
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable [data.length * 2];
		for (int i = 0; i < data.length; i++)
			temp[i] = data[i];
		data = temp;
	}

	/**
	 * get method - Returns the item at specified location in the list
	 * @return  - the item at specified location
	 * @throws ListEmptyException - if the list is empty
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 */
	public T get(int location) throws IndexOutOfBoundsException, ListEmptyException
	{
		if (size == 0)
			throw new ListEmptyException("ListEmptyException: Cannot get item");
		if (location < 0 || location >= size)
			throw new IndexOutOfBoundsException ("IndexOutOfBoundsException: cannot get item");
		return data[location];
	}

	/**
	 * removeAt method - Removes and returns an item stored at a specified location in the list
	 * @param location - the location of the item to removed from the list        
	 * @return  - the item stored at that location
	 * @throws ListEmptyException - if the list is empty    
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 */
	public T removeAt(int location) throws ListEmptyException, IndexOutOfBoundsException
	{
		T value = null;
		if (size == 0)
			throw new ListEmptyException("ListEmptyException: Cannot remove item at location");
		if (location < 0 || location >= size)
			throw new IndexOutOfBoundsException ("IndexOutOfBoundsException: Cannot remove item at location");
		else
		{

			value = data[location];
			for(int i = location ; i < size - 1; i++ )
				data[i] = data[i+1];
			data[size - 1] = null;
			size--;
		}
		return value;
	}

	/**
	 * remove method - Removes first occurrence of an item from the list
	 * @param item - the item to removed from the list
	 * @throws ListEmptyException - if the list is empty
	 */
	public T remove(T item) throws ListEmptyException
	{
		T temp = null;
		if (size == 0)
			throw new ListEmptyException("ListEmptyException: Cannot remove item");

		if(find(item) == -1)
			return null;
		else
		{
			int place = find(item);
			temp = get(place);
			for(int i = place; i < size; i++)
				data[i] = data[i+1];
			data[size - 1] = null;
		}
		return temp;
	}

	/**
	 * valueAt method - Returns the item at a specified location in the list
	 * @param location - the location of the item in the list         
	 * @throws ListEmptyException - if the list is empty
	 * @throws IndexOutOfBoundsException - if location &lt; 0 or &gt;= getSize()
	 *             
	 */
	public T valueAt(int location) throws ListEmptyException, IndexOutOfBoundsException
	{
		if (size == 0)
			throw new ListEmptyException("ListEmptyException: Cannot remove item at location");
		if (location < 0 || location >= size)
			throw new IndexOutOfBoundsException ("IndexOutOfBoundsException: Cannot remove item at location");
		return data[location];
	}

	/**
	 * find method - Searches for an item in the list and returns its location or -1 if this item is not in the list
	 * @param item - the item to search for         
	 * @return the location of the item
	 * @throws ListEmptyException - if the list is empty
	 *             
	 */
	public int find(T item) throws ListEmptyException
	{
		if (size == 0)
			throw new ListEmptyException("ListEmptyException: Cannot find item");
		for (int i = 0; i < size; i++)
			if(data[i].compareTo(item) == 0)
				return i;
		return -1;
	}
	/**
	 * contains method - Searches for an item in the list and returns true if it can be found
	 * @param item - the item to search for
	 * @return <i>true</i> if an item is in the list or <i>false</i> otherwise
	 * @throws ListEmptyException - if the list is empty
	 */
	public boolean contains(T item) throws ListEmptyException
	{
		if (size == 0)
			throw new ListEmptyException ( "ListEmptyException: cannot iterate through the data array");
		boolean temp = false;
		if(find(item) != -1)
			temp = true;
		return temp;
	}

	/**
	 * clear method - Removes all of the items from the list.
	 */
	@SuppressWarnings("unchecked")
	public void clear() 
	{
		data = (T[]) new Comparable[data.length];
	}


	/**
	 * isEmpty method - Returns <i>true</i> if the list is empty, or <i>false</i> otherwise
	 * @return <i>true</i> if the list is empty, or <i>false</i> otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * getSize method - Returns the number of items in the list
	 * @return the number of items in the list
	 */
	public int getSize() 
	{
		return size;
	}

	/**
	 * replace method - replaces an object in the list
	 * @param position - the position on the list where item will be replaced
	 * @param item - new item to be place on position
	 * @throws IndexOutOfBoundsException - if the index is invalid
	 * @throws ListEmptyException - if the list is empty
	 */
	public void replace(int position, T item) throws IndexOutOfBoundsException, ListEmptyException
	{
		if (position < 0 || position >= size)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Cannot replace items");
		if (size == 0)
			throw new ListEmptyException ( "ListEmptyException: cannot replace items");
		data[position] = item;

	}

	/**
	 * replace method - replaces a specific item passed as first parameter by one passes as second parameter
	 * @param oldItem - item to be replaced
	 * @param newItem - replacement item
	  @throws SameItemException - if the items are equal
	 * @throws ListEmptyException - if the list is empty
	 */
	public void replace(T oldItem, T newItem) throws SameItemException, ListEmptyException
	{
		if(oldItem.compareTo(newItem) == 0)
			throw new SameItemException ("SameItemException: Equal items, replacing will not change the list");
		if (size == 0)
			throw new ListEmptyException ( "ListEmptyException: cannot replace items");
		for (int i = 0; i < size; i++)
			if (data[i].compareTo(oldItem) == 0)
				data[i] = newItem;
	}
	
	/**
	 * toString method - accessor for the current items in the list
	 * @return result - a reference to a String containing every item in the list.
	 */
	public String toString()
	{
		String result = "";
		for(T item: data)
			result += item + " ";
		return result.substring(0,result.length()-2) + ".";
	}

}
