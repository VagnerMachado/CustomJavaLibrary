package orderedLinkedList;

/**********************************************************************************************************************
 *             Please refer to the Lab7App.java file for a description of the project in a larger scope               *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Lab7: Ordered Linked List<br>
 *<b>Filename:</b>	OrderedList.java<br>
 *<b>Date Written:</b>	April, 2016<br>
 *<b>Due Date:</b> April 23th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description: The OrderdList Class extends the LinkedListClass and contains a default and parameterized constructor. It 
 *defines the abstract methods contained in the parent class: insert, search and remove. There are actually two insert methods:
 *one that accepts T objects and the other that accepts OrderedLists. The later insert method allows the user to insert a list
 *into another. These method were tailored to fit the purpose of this lab and enabled the app to compare id's and amount of 
 *items to order the lists. 
 *</b></p>
 *<p> 
 *</p>
 *
 *********************************************************************************************************************
 *      @author VagnerMachado - ID N00820127 - Partner: Robert_Kasprzyk - Nassau Community College - Spring 2016     *           
 *********************************************************************************************************************
 *
 * @param <T> - a generic type
 */

public class OrderedList<T extends Comparable<T>> extends LinkedListClass<T>
{
	/**
	 * OrderedList default constructor - calls the parent constructor
	 */
	public OrderedList()
	{

		super();
	}

	/**
	 * OrderedList parameterized constructor - accepts and array of T objects and loads them into this list
	 * @param str = an array of items to be loaded into this list
	 */
	public OrderedList(T[] str)
	{
		for(int i = 0; i<str.length;i++)
		{
			insert(str[i]);
		}
	}

	/**
	 * insert method - inserts a T object into the list based on the item's id
	 */
	public void insert(T item) {
		if(item != null)
		{
			if(numItems == 0){
				head.setNext(new Node<T>(head,item,null));
			}
			else
			{
				Node<T> trav =head;
				while(trav.getNext()!=null && item.compareTo(trav.getNext().getData())>0){
					trav=trav.getNext();
				}
				Node<T> newNode = (new Node<T>(trav, item, trav.getNext()));
				trav.setNext(newNode);
				if(newNode.getNext()!=null)
					newNode.getNext().setPrev(newNode);

			}
			numItems ++;
		}
	}
	/**
	 * search method - searches for a T object in the list based on its data
	 * @param item - the item being sarched for in the list
	 * @return if the item is not found: -1
	 *         if the item is found, the position in the list is returned
	 */
	public int search(T item) 
	{

		int index = 0;

		Node<T> trav = head;

		boolean found =false;

		if(!isEmpty()){

			while(!found && index<listSize()){

				if(trav.getNext().getData().equals(item))
				{
					found = true;
				}
				else
					index++;
				trav = trav.getNext();
			}
		}
		if(found == false){
			index =-1;
		}
		return index;
	}

	/**
	 * remove method - removes a T object from the list
	 * @param item - the item being removed
	 * @return T - the item removed or null if item is not in the list
	 */
	public T remove(T item) 
	{
		Node <T> trav = head;
		T data = null;
		int x = search(item);
		if (x == -1)
		{
			return data;
		}
		int i = 0;
		while(i++ < x)
		{
			trav = trav.getNext();
		}
		if(x == 0 && numItems >= 2)
		{
			//System.out.println("***beginning >=1");
			data = trav.getNext().getData();
			trav.setNext(trav.getNext().getNext());
		}
		else
			if(x == 0 && numItems == 1)
			{
				//System.out.println("***only one");
				data = trav.getNext().getData();
				trav.setNext(null);
			}
			else

				if(x == numItems - 1)

				{
					//System.out.println("***end***");
					data= trav.getNext().getData();
					trav.getNext().setNext(null);
					trav.setNext(null);

				}
				else
				{
					//System.out.println("***middle***");
					data= trav.getNext().getData();
					trav.setNext(trav.getNext().getNext());
					trav.getNext().setPrev(trav);
				}
		numItems--;
		return data;
	}

	/**
	 * insert method - inserts a list into another list
	 * @param list - the list being added to this list
	 */
	public void insert(OrderedList list)
	{
		if(list != null)
		{
			if(this.numItems == 0)
			{
				head.setNext(new Node<T>(head, list,null));
			}
			else
			{
				Node<T> trav = head;
				while(trav.getNext()!= null && list.numItems > trav.getNext().thisListSize) 
				{
					trav=trav.getNext();
				}
				Node<T> newNode = (new Node<T>(trav, list, trav.getNext()));
				trav.setNext(newNode);
				if(newNode.getNext()!=null)
					newNode.getNext().setPrev(newNode);

			}
			numItems ++;
		}
	}
}

