package priorityQueueThreeWays;


/**<pre style="font:20px;">
 * ********************************************************************************************************************
 *      											   Node.java 								                      *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> In this class I defined accessor and mutator methods, and Constructors 
 * for Node objects.
 * 
 * For information about the other classes created for this program, please see their javadocs. 
 *
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                  *           
 *********************************************************************************************************************
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */

public class Node<E extends Comparable <E>>
{
	//instance data
	private E data;
	private Node<E> next;
	private Node<E> prev;
	
	/**
	 * Node parameterized constructor - instantiates Node object with data d and neighbors to null
	 * @param d - data to be assigned to this node
	 */
	public Node (E d)
	{
		data = d;
		next = null;
		prev = null;
	}

	/**
	 * Node parameterized constructor - instantiates Node object with data d with next n
	 * @param d - data to be assigned to this node
	 * @param n - this node's next
	 * @param p - previous node
	 */
	public Node (E d, Node<E> n, Node<E> p)
	{
		data = d;
		next = n;
		prev = p;
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
	 * getPrevious method - accessor to the previous field
	 * @return previous - the Node object previous to this Node object
	 */
	public Node<E> getPrevious() {
		return prev;
	}

	/**
	 * setNext method - modifier to the next field
	 * @param n - the Node object next to this Node object
	 */
	public void setNext(Node<E> n) {
		next = n;
	}

	/**
	 * setPrevious method - modifier to the previous field
	 * @param n - the Node object previous to this Node object
	 */
	public void setPrevious(Node<E> n) {
		prev = n;
	}
}
