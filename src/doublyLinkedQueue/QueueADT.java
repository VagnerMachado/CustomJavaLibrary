package doublyLinkedQueue;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxx <br>
 *<b>Filename:</b>	QueueADT.java<br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This is the interface that contains the abstract methods to be implemented in the Queue Class
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************

/**
 * @param <T> - a generic data type 
 */

public interface QueueADT<T>
{
	//abstract methods
	public void enqueue (T d);
	public T dequeue() throws QueueEmptyException;
	public T front () throws QueueEmptyException;
	public T rear() throws QueueEmptyException;
	public boolean isEmpty();
	public int getSize();
}
