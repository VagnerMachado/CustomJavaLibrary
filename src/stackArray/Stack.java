package stackArray;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxxxx<br>
 *<b>Filename:</b>	Stack.java<br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy <br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This class implements the abstract methods contained in the StackADT interface. The methods available enable the 
 *user to determine if a stack is full or empty, add or remove an item, see the top item and the size of the stack.
 *The description for each method can be found above each method's signature, in its javadoc.
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 */

/**
 * Stack Class - implements the methods defined in the Stack ADT Class
 * @param <T> - a generic data type
 */
public class Stack<T> implements StackADT<T>
{
	//Stack instance data
	public final int CAPACITY =100;
	private T [] data;
	private int size = 0;

	/**
	 * Default Stack Constructor - instantiates a stack of size 100
	 */
	@SuppressWarnings("unchecked")
	public Stack()
	{
		data = (T[]) new Object[CAPACITY];
	}

	/**
	 * Parameterized Stack Constructor - instantiates a Stack of a certain size
	 * @param x - the size of the instantiated Stack
	 */
	@SuppressWarnings("unchecked")
	public Stack( int x)
	{
		data = (T[]) new Object[x];
	}

	/**
	 * push method - adds an object to top of Stack. 
	 * @throws StackFullException if the Stack is full
	 * @param T d - the object to be added to Stack
	 */
	public void push(T d)throws StackFullException
	{
		if (isFull()) 
			throw new StackFullException ("Full Stack Exception, the entry was not pushed");
		data[size++] = d;
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

		return data[--size];
	}

	/**
	 * peek method - displays the items on the of the Stack
	 * @throws StackEmptyException if the Stack is empty
	 * @return T - the object on top of the Stack
	 */
	public T peek() throws StackEmptyException {
		if (isEmpty()) 
			throw new StackEmptyException ("Empty Stack Exception, not able to peek");
		return data[size - 1];
	}

/**
 * isFull method - checks to see if the Stack is full
 * @return - true if the stack is full, false otherwise
 */
	public boolean isFull() 
	{
		return (data.length == size);
	}

/**
 * isEmpty method - checks to see if the Stack is full
 * @return - true if the Stack is empty, false otherwise.
 */
	public boolean isEmpty() 
	{
		return (size == 0);
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
	 * toString method - returns a reference to a String containing all objects on the stack
	 * @return - a string with all objects in the stack
	 */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < size; i++)
			str += data[i] + " ";
		return str;
			
	}


	
}
