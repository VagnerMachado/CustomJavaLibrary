package priorityQueueThreeWays;
import java.util.NoSuchElementException;

/**<pre>
 * ********************************************************************************************************************
 *      									  PriorityQueue.java Interface					                          *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> In this class I defined the methods used for a priority queue: enqueue, dequeue,
 * getSize, isEmpty, incementSize, decrementSize and peek. These methods will be implemented by the three 
 * different priority queues implementing this class.
 *  
 * For information about the other classes created for this program, please see their javadocs. 
 * 
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                  *           
 *********************************************************************************************************************
 *
 * @param T - a generic type that extends the Comparable interface
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public interface PriorityQueue<T>
{
	public void enqueue(T item)throws NoSuchElementException;
	public T dequeue() throws NoSuchElementException;
	public boolean isEmpty();
	public int getSize();
	public T peek() throws NoSuchElementException;
	
}
