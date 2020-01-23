package queueCircularArray;

/**********************************************************************************************************************
 *          Please refer to the ////////insert name///////  file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project 3: Airport Simulation<br>
 *<b>Filename:</b>	StackADT.java<br>
 *<b>Date Written:</b>	April, 2016<br>
 *<b>Due Date:</b> April 25th, 2016<br>
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
	
	void enqueue (T d);
	T dequeue() throws QueueEmptyException;
	T front () throws QueueEmptyException;
	T rear() throws QueueEmptyException;
	boolean isFull();
	boolean isEmpty();
	int getSize();
}
