package priorityQueueLinkedList;

/**
 * <pre>
 * **********************************************************************************
 * 								Store.java
 * **********************************************************************************
 * 
 * This is a Class that I used to test the comparable and equal method override.
 * The Comparable interface is implemented so it allows for comparison between store
 * values (names) before they are placed into a sorted linked list priority queue.
 * 
 * I will leave this class here for future reference since I think i got it working.
 * If you have any extra feedback on my implementation, i'd appreciate!
 *  
 * ***********************************************************************************
 *     @author VagnerMachado  -  QCID 23651127  - Queens College   -   Spring 2018
 * ***********************************************************************************
 * 
 * <a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class Store implements Comparable<Store> {

	private String name;
	private String openTime;
	private String closeTime;
	public Store(String name, String openTime, String closeTime) 
	{
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	/**
	 * compareTo method - compares Stores based on the name
	 * @return - zero if stores have the same name
	 * 		   - positive number if this name comes before the parameter Store (alphabetically)
	 * 	       - negative number if this name comes before the parameter Store (alphabetically)
	 */
	public int compareTo(Store n) 
	{
		return getName().compareToIgnoreCase(n.getName());

	}

	/**
	 * compareTo method - compares Stores based on the name
	 * @return - zero if stores have the same name
	 * 		   - positive number if this name comes before the parameter Store (alphabetically)
	 * 	       - negative number if this name comes before the parameter Store (alphabetically), or if parameter 
	 * 			 is not a Store object
	 */
	public int compareToObject(Object n) 
	{

		if (n instanceof Store)
			return getName().compareToIgnoreCase(((Store)n).getName());

		return -1;
	}
	/**
	 * equals object - compares two Store names
	 * @return - true if the names are the same
	 *         - false if the parameter is not a Store object, or if the store names are not the same
	 */
	public boolean equals(Object otherItem)
	{
		if (otherItem instanceof Store)
		{
			return getName().equals(((Store) otherItem).getName());
		}
		return false;
	}

	/**
	 * toString method - prints the store information
	 */
	public String toString() {
		return "[StoreName = " + name + ", openTime = " + openTime + ", closeTime = " + closeTime + "]";
	}

	/**
	 * *******************************************************************************************************
	 *                  Below are the getters and setters for the Store instance data
	 *                  
	 **********************************************************************************************************/


	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getOpenTime() 
	{
		return openTime;
	}
	public void setOpenTime(String openTime) 
	{
		this.openTime = openTime;
	}
	public String getCloseTime() 
	{
		return closeTime;
	}
	public void setCloseTime(String closeTime) 
	{
		this.closeTime = closeTime;
	}

}
