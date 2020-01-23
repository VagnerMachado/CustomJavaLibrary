package orderedLinkedList;
/**********************************************************************************************************************
 *             Please refer to the Lab7App.java file for a description of the project in a larger scope               *
 * ********************************************************************************************************************
 * 
 * <p>Title: ArrayListClass</p>
 *
 * <p>Description: Defines those properties and behaviors that are common to all lists.
 * The classes are designed using a generic type (T). Users of this
 * class (and its subclasses) should note that although the lists can store an "item"
 * of any type, they are required to override the equals method, defined
 * in the Object class, in their "item" class.</p>
 *
 * 
 *
 *  
 *
 *
 * 
 ********************************************************************************************************************
 * Class edited by VagnerMachado - ID N00820127 - Partner: Robert_Kasprzyk - Nassau Community College - Spring 2016 *           
 ********************************************************************************************************************
 */

public abstract class LinkedListClass<T extends Comparable<T>> 
{
	/**
	 * Inner class Node has 2 references, forward and back
	 * Accessors and mutators are necessary to provide access 
	 * to classes other than LinkedListClass
	 * @author F. Graham
	 * @param <E> - a generic
	 */
	class Node<E extends Comparable<E>> {
		private Node<E> prev;
		private E data;
		private Node<E> next;
		private OrderedList thisList;
		protected int thisListSize;

		public Node(){
			data = null;
			prev = next = null;
		}
		public Node(E d){
			data = d;
			prev = next = null;
		}
		public Node(Node<E> p, E d, Node<E> n){
			prev = p;
			data = d;
			next = n;
		}
		public Node(Node<E> p, OrderedList d, Node<E> n)
		{
			prev = p;
			thisList =  d;
			next = n;
			thisListSize = d.numItems; //used to compare insertion
			listOfList = true; // is true for a list of lists
		}
		public Node<E> getPrev() {
			return prev;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		public E getData() {
			return data;
		}
		public void setData(E data) {
			this.data = data;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	protected Node<T> head; // the head of the linked list of items
	protected int numItems; // the number of items in the list
	boolean listOfList = false; // gets initialized if a list is inserted in a list

	/**
	 * default constructor - creates an empty list; 
	 * the number of items in the list is initialized to 0
	 */
	public LinkedListClass(){
		head = new Node<T>();  // dummy node
	}	

	/**
	 * empty method - determines whether or not the list is empty
	 * @return true if the list is empty; false otherwise
	 */
	public boolean isEmpty(){
		return numItems == 0;
	}

	/**
	 * listSize method - returns the number of items in the list
	 * @return the number of items in the list
	 */
	public int listSize(){
		return numItems;
	}

	/**
	 * makeEmpty method - makes the list empty and sets numItems to 0
	 */
	public void makeEmpty(){
		head = new Node<T>();  // dummy node
		numItems = 0;
		System.gc();
	}
	/**
	 * toString method - returns the state of the object as a String
	 * @return a String containing the items in the list
	 */
	public String toString()
	{ 
		String str= "";
		if (this.listOfList == true)
			return ShowLists();

		{
			str = (isEmpty() ? "The list is empty... " : "The list contains\n");

			Node<T> trav = head.next;
			while(trav != null){
				str += trav.getData() + (trav.next==null ? "" : " -> ");
				trav = trav.next;
			}
		}

		return str;
	}

	public String ShowLists()
	{
		String str = "";// (isEmpty() ? "The list is empty... " : "The list contains\n");
		Node<T> trav = head.next;
		while(trav != null){
			str += trav.thisList.toString() + (trav.next==null ? "" : " -> ");
			trav = trav.next;
		}
		return str;
	}
	/**
	 * insert method - inserts an item in the list
	 * @param <i>item</i> is a reference to the item to be inserted
	 */
	public abstract void insert(T item);

	/**
	 * search method - determines whether or not <i>item</i> is in the list
	 * @param <i>item</i> is a reference to an item whose key-field has been initialized
	 * @return an integer which represents the location in the list where <i>item</i>
	 * was found; if <i>item</i> is not in the list, the method returns -1
	 */
	public abstract int search(T item);

	/**
	 * remove method - removes an item from the list
	 * @param <i>item</i> is a reference to an item whose key-field has been initialized.
	 * If the item is found it is removed and returned; otherwise the list remains unchanged
	 */
	public abstract T remove(T item);
}