package arrayListClass;

/**********************************************************************************************************************
 *             Please refer to the Lab6App.java file for a description of the project in a larger scope               *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Lab6: ArrayList<br>
 *<b>Filename:</b>	UnorderedArrayList.java<br>
 *<b>Date Written:</b>	April, 2016<br>
 *<b>Due Date:</b> April 16th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>The UnorderedLIstClass defines the methods specific to the class. Those methods are: search(), insert(), and remove().
 *Both class constructors call the parent class and instantiate an array of size 50 as default, or accepts an int parameter that
 *is sent to the parent class; an array of that size gets instantiated. The description for each method can be found in each
 *method's javadoc.
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 */

/**
 * UnordedArrayList - extends the ArrayListClass Class
 */

public class UnorderedArrayList extends ArrayListClass
{

	/**
	 * UnorderedArrayList constructor - calls the parent class and instantiates an array of size 50
	 */
	public UnorderedArrayList()
	{
		super();
	}

	/**
	 * UnorderedArrayList parameterized constructor - calls the parent class constructor and instantiates 
	 * an array of size x
	 * @param x - the size of the instantiated array
	 */
	public UnorderedArrayList(int x)
	{
		super(x);

	}
	/**
	 * search method - searches for an specific object in the UnorderedArrayList object.
	 * param searchItem - item being searched for in the list
	 *return -   if not found: -1
	 *			 if it is found - the array index of the item
	 */
	public int search(Object searchItem) 
	{
		if (numItems == 0)
			return -1;
		for (int i = 0; i < numItems; i++)
			if((items[i]).equals(searchItem))
				return i;
		return -1;
	}

	/**
	 * insert method - inserts an item at the end of the array
	 * 	   	   	  	   the list is expanded if it is full
	 * @param insertItem - item being inserted
	 */
	public void insert(Object insertItem) 
	{
		if(numItems == items.length)
			this.expand();
		else
		{
			items[numItems] = insertItem;
			numItems++;
		}
	}

	/**
	 * remove method - removes an item from the list
	 * @param removeItem - the item being removed
	 * @return - null if the item is not in the list; the item removed otherwise
	 */
	public Object remove(Object removeItem)
	{
		Object temp = null;
		int place = search(removeItem);

		if(place == -1)
			return null;
		else
		{
			temp = items[place];
			for(int i = place; i < numItems - 1; i++)
				items[i] = items[i+1];
			items[numItems - 1] = null;
			numItems--;
		}
		return temp;

	}

}
