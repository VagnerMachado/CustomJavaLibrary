package stackLinkedList;

/**********************************************************************************************************************
 *     
 * ********************************************************************************************************************
 * 
 *<b>Title:</b> Project x: xxxxxxxxxx  <br>
 *<b>Filename:</b>	Stack.java<br>
 *<b>Date Written:</b>	March, 2016<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This class implements the abstract methods contained in the StackADT interface. The methods available enable the 
 *user to determine if a stack is empty, add or remove an item, see the top item and the size of the stack.
 *The description for each method can be found above each method's signature, in its javadoc.
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 */

/**
 * Stack Class - implement the methods defined in the Stack ADT Class
 * @param <T> - a generic data type
 */
public class Stack<T> implements StackADT<T>
{
	/**
	 * private Class Node - contains three constructors to assist the Stack Class
	 * @param <E> - a generic data type
	 */
	public class Node <E> 
	{
		//Node instance data
		private E data;
		private Node <E> next;

		/**
		 * Node default constructor -  instantiates a Node object with data and next null
		 */
		public Node()
		{
			data = null;
			next = null;
		}

		/**
		 * Node parameterized constructor - instantiates a Node object with data d and next null
		 * @param d - the data assigned to data field of instantiated Node object
		 */
		public Node(E d)
		{
			data = d;
			next = null;
		}

		/**
		 * Node parameterized constructor - instantiates Node object with data d with next n
		 * @param d - data to be assigned to this node
		 * @param n - this node's next
		 */
		public Node (E d, Node<E> n)
		{
			data = d;
			next = n;
		}
		/**
		 * getData method - accessor to the data field
		 * @return - object stored in this node's data field
		 */
		public E getData() {
			return data;
		}

		/**
		 * setData method - modifier for the data field
		 * @param d - object to be stored in data field
		 */
		public void setData(E d) {
			data = d;
		}

		/**
		 * getNext method - accessor to the next field
		 * @return next - the Node object next to this Node object
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * setNext method - modifier to the nexxt field
		 * @param n - the Node object next to this Node object
		 */
		public void setNext(Node<E> n) {
			next = n;
		}

	}

	//instance data
	private Node<T> head;
	private int size = 0;

	/**
	 * Default Stack Constructor - instantiates a stack with head value null for Node <T>.
	 */
	@SuppressWarnings("unchecked")
	public Stack()
	{
		head = null;
	}

	/**
	 * push method - instantiates a new Node with parameter as its data 
	 * @param T d - the object to be added to Stack's new Node
	 */
	public void push(T d) 
	{
		head = new Node(d, head);
		size++;
	}

	/**
	 * pop method - removes and displays the item on the top of the Stack
	 * @throws StackEmptyExceprtion if the Stack is Empty
	 * @return T - the object popped off the stack
	 */
	public T pop() throws StackEmptyException 
	{
		if(isEmpty()) 
			throw new StackEmptyException ("Empty Stack Exception, there is not an item to pop");
		T value = head.data;
		head = head.next;
		size--;
		return value;
	}

	/**
	 * peek method - displays the items on the of the Stack
	 * @throws StackEmptyException if the Stack is empty
	 * @return T - the object on top of the Stack
	 */
	public T peek() throws StackEmptyException {
		if (isEmpty()) 
			throw new StackEmptyException ("Empty Stack Exception, not able to peek");
		return head.data;
	}

	/**
	 * isEmpty method - checks to see if the Stack is empty
	 * @return - true if the Stack is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return (head == null || size == 0);
	}

	/**
	 * size method - gives access to the size of the Stack
	 * @return - the size of the Stack
	 */
	public int size() 
	{
		return size;
	}

	/**
	 * toString method - prints a String with all Nodes' data
	 * return - a reference to a String with all Nodes' data
	 */
	public String toString()
	{
		String str = "";
		Node <T> trav = head;
		while (trav != null)
		{
			str += trav.data + " ";
			trav = trav.next;
		}
		return str;
	}
	
	public String reverseString() throws StackEmptyException
	{
		String str = "";
		Stack <T> stack = new Stack<T>();
		Node<T> trav = head;
		while (trav != null)
		{
			stack.push(trav.data);
			trav= trav.next;
		}
		while (!stack.isEmpty())
			str += stack.pop() + " ";
		return str;
	}


}
