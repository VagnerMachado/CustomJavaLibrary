package deque;
import java.util.NoSuchElementException;

/**********************************************************************************************************************
 *           								    	Test.java			     				                          *
 * ********************************************************************************************************************
 * 
 * Description: In this class methods that allow the user to add and remove item from the from and the rear of the list.
 * Additionally another method enables the user to add an item at a specific valid position. A toString method prints
 * all the items in the list and emptyList empties the list that it is called upon.
 * 
 * Methods additional to the ones requested were also tested. For a list of all methods used, please refer to the 
 * header javadoc in the List Class.
 * 
 *      For information about the other classes  and methods created for this project, please see their javadocs.
 *
 *  Credits: Professor Ochani helped me to debug some incrementing and assignment issues I had in my code.
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	                 *           
 *********************************************************************************************************************
 *
 */
public class Test {
	/*Professor,
	 * 
	 * I included the try/catch block around the calls that would need them. Valid calls are intentionally not
	 * wrapped in a try/catch block. Additionally, i added a bunch of methods that can be helpful to sort lists.
	 * The snow day gave me some extra time to tinker with the Lab!
	 * 
	 * Vagner
	 */

	public static void main(String [] VagnerArgs)
	{
		System.out.println( "\n  *********************************************************************************************"
				+ "\n  *******   This is the Test class in which all methods for the List Class "
				+ "are tested.   ******\n  ***   A List of Integet type is instantiated and manipulated through "
				+ "its Class' methods.  ***\n  **************************   Written by Vagner Machado N00820127" 
				+ "   **************************\n");


		List <Integer>list = new List <Integer>();
		System.out.println("Calling toString on a empty List:\n" + list + "\n");

		try
		{
			list.removeFromFront(); //throws an exception
		}catch (NoSuchElementException e)
		{
			System.out.println("Invalid remove from front:\n" + e.getMessage() + "\n");
		}

		try
		{
			list.removeFromRear(); //throws and exception
		}catch (NoSuchElementException e)
		{
			System.out.println("Invalid remove from rear:\n" + e.getMessage() + "\n");
		}

		try
		{
			list.addAtPosition(40,1); // throws an exception because the list is size zero so far and position > listSize
		}catch (NoSuchElementException e)
		{
			System.out.println("Invalid add at position call:\n" + e.getMessage() + "\n");
		}

		System.out.println("List after the invalid position should be unchanged:\n" + list + "\n");

		try
		{
			list.addAtPosition(20,0); //this works because position is at least the listSize
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("List with one item inserted at position 0:\n" + list + "\n");

		list.addToFront(10);
		System.out.println("10 is added to the front:\n" + list + "\n");

		list.addToRear(72);
		System.out.println("72 is intserted in the rear of the list:\n" + list +"\n");

		//System.out.println("10 is added to the front of the list:\n" + list + "\n");
		list.addToFront(15);
		System.out.println("15 is added to the front of the list:\n" + list + "\n");
		list.addAtPosition(13, 1);
		System.out.println("13 is added at position 1:\n" + list + "\n");

		try{
			list.addAtPosition(100,6); //throws an exception for invalid position
		}catch (NoSuchElementException e)
		{
			System.out.println("Invalid add at positon call:\n " + e.getMessage() + "\n");
		}

		try
		{
			System.out.println("Remove from front: " + list.removeFromFront());
		} catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			System.out.println("Remove from rear: " + list.removeFromRear() + "\n");
		} 
		catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("List after front and rear removal:\n" + list +"\n");

		try
		{
			list.addAtPosition(47, 2);
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("47 is added at position 2:\n" + list + "\n");

		try
		{
			list.addAtPosition(17, 1);
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("17 is added at position 1:\n" + list + "\n");


		list.addToFront(15);
		System.out.println("15 is added to the front:\n" + list + "\n");

		System.out.println("Regular list: " + list);
		System.out.println("Reverse List: " + list.reverseString() + "\n");

		list.addAtPosition(99, 3);
		System.out.println("99 added at position 3:\n" +  list + "\n");
		System.out.println("Reverse list:\n"  + list.reverseString() + "\n");
		System.out.println("Regular list:\n" + list + "\n");

		System.out.println("Get item value at position -2:");
		try{
			list.get(-2); //throws an exception for negative position
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("\nGet item value at position 7 (invalid):");
		try{
			list.get(7); //throws an axception for position
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("\n" + list);
		System.out.println("Get item value at position 3: " + list.get(3));
		System.out.println("Get item value at position 5: " + list.get(5));
		System.out.println("Search method - Is 47 in list? " + list.search(47));
		System.out.println("Search method - Is 20 in list? " + list.search(999));
		System.out.println("Search method - Is 99 in list? " + list.search(99));

		list.addToRear(101);
		System.out.println("\nAdding 101 to the rear of list:\n" + list + "\n");

		System.out.println("Reverse list:\n" + list.reverseString());
		System.out.println("Regular list:\n" + list + "\n");

		list.removeAtPosition(0);
		System.out.println("Removed position 0:\n" + list);

		list.removeAtPosition(5);
		System.out.println("\nRemoved at position 5:\n" + list + "\n");

		System.out.println("Removed at position 17 (invalid):");
		try{
			list.removeAtPosition(17);
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage()); //the position is in invalid range
		}

		list.removeAtPosition(2);
		System.out.println("\nRemoved at positon 2:\n" + list + "\n");

		System.out.println("Searches for item 47 (existing) and used returned value to remove it:");
		list.removeAtPosition(list.search(47));
		System.out.println(list + "\n");

		System.out.println("Searches for item 55 (inexisting) and uses returned value to remove it:");
		try
		{
			list.removeAtPosition(list.search(55)); // throws an exception, item does not exist
		} catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		//System.out.println(list + "\n");

		list.addToRear(1984);
		System.out.println("\nAdding 1984 to rear of list:\n" + list + "\n");


		System.out.println("Call to 'get' method in invalid positon:");
		try
		{
			System.out.println(list.get(9)); //invalid position, will throw an exception
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("\nCalling add to rear, front and position passing a null object:");
		try
		{
			list.addToFront(null); //null item, will throw an exception
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			list.addToRear(null); //null item, will throw an exception
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}

		try
		{
			list.addAtPosition(null,2); //null item, will throw an exception
		}catch (NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}


		System.out.println("\nTesting the empty list method, then printing list and reverse list:");
		list.emptyList();  //cleans up the list
		System.out.println(list);
		System.out.println(list.reverseString());

		System.out.println("\n***  Testing a sortedInsert method that I implemented  ***\n"
				+ "     ***  After each insert the list is printed  ***\n");
		list.sortedInsert(20);
		System.out.println(list);
		list.sortedInsert(270);
		System.out.println(list);
		list.sortedInsert(-25);
		System.out.println(list);
		list.sortedInsert(40);
		System.out.println(list);
		list.sortedInsert(47);
		System.out.println(list);
		list.sortedInsert(-20);
		System.out.println(list);
		list.sortedInsert(49);
		System.out.println(list);
		list.sortedInsert(-21);
		list.sortedInsert(47);
		System.out.println(list);
		System.out.println(list);
		list.sortedInsert(-24);
		System.out.println(list);
		list.sortedInsert(270);
		System.out.println(list);
		System.out.println(list.reverseString());
		System.out.println("\n***  Testing using the List for Store objects ***\n");

		/*The block below tested inserting a Store into an Integer List 
		 *After specifying the list to be Integer type, i commented this block out to avoid errors.
		 */
		List storeList = new List();
		Store store = new Store("DEF", "8:00am", "5:00pm");
		Store same = new Store("ABC", "8:00am", "5:00pm");
		Store different = new Store("BCD", "8:30am", "9:00pm");
		Store other = new Store("ABC", "8:30am", "9:00pm");
		storeList.sortedInsert(store);
		storeList.sortedInsert(same);
		storeList.sortedInsert(different);
		storeList.sortedInsert(other);
		Store notInserted = new Store("FGF", "8:30am", "9:00pm");
		System.out.println(storeList);
		System.out.println("Searching for 'DEF' Store: " + storeList.search(store));
		System.out.println("Searching for 'FGF' Store: " + storeList.search(notInserted));

		System.out.println("Comparing the same stores: " + other.compareTo(same));
		System.out.println("Comparing different stores (this > param): " + store.compareTo(different));
		System.out.println("Comparing different stores (this < param): " + different.compareTo(store));
		System.out.println("(true) Is 'store' in list? " + storeList.search(other));
		System.out.println("(false) Is 'notInserted' store in list? " + storeList.search(notInserted));

		System.out.println("\n   ***  Testing the sort method I implemented  ***   \n");

		list.emptyList();
		System.out.println("List is emptied: " + list);
		list = list.sortList();
		System.out.println("Calling sortList on an empty List: " + list);
		list.addToFront(20);
		System.out.println(list);
		list.addToFront(-101);
		System.out.println(list);
		list.addToFront(250);
		System.out.println(list);
		list.addToRear(29);
		System.out.println(list);
		list.sortedInsert(47);
		System.out.println(list);
		list.addToRear(-10);
		System.out.println(list);
		list.addToRear(52);
		System.out.println(list);
		list.addAtPosition(-273, 3);
		System.out.println(list);
		list.sortedInsert(-93);
		System.out.println(list);
		list.sortedInsert(1984);
		System.out.println(list);

		list = list.sortList();
		System.out.println("\nSorted List:\n" + list); //I'm proud of this one!
		
		System.out.println("\n				*****   This is the end of the Test  *****");
		
		list.emptyList();
		System.out.println("This it the list" + list);
		list.addToRear(88);
		System.out.println("This it the list" + list);
System.out.println(list.removeFromRear());		
	}
}
