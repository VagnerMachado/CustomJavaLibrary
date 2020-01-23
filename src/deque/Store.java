package deque;

/************************************************************************************
 * 								Store.java
 * **********************************************************************************
 * Professor Ochani, 
 * 
 * This is a Class that I used to test the comparable and equal method override.
 * I used these methods to search for a store object in a list class that - originally -
 * had other types of objects in it (Integer in the test case). Now I know that we should 
 * stick to one data type in each list, so I created a store list to check some methods.
 * 
 * I will leave this class here for future reference since I think i got it working.
 * If you have any extra feedback on my implementation, i'd appreciate!
 * 
 * ***********************************************************************************
 * @author VagnerMachado  - N00820127  - Nassau Community College - Spring 2017
 * ***********************************************************************************
 *
 */
public class Store implements Comparable<Object> {

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
	 * 	       - negative number if this name comes before the parameter Store (alphabetically), or if parameter is not a Store object
	 */
	public int compareTo(Object n) 
	{
		
		if (n instanceof Store)
			return getName().compareToIgnoreCase(((Store) n).getName());
		
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
	
	/*
	 * *******************************************************************************************************
	 *                  Below are the getters and setters for the Store instance data
	 **********************************************************************************************************/
	
	
	private String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
}
