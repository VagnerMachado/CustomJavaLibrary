package queueLinkedList;

/**********************************************************************************************************************
 *          Please refer to the xxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxxx <br>
 *<b>Filename:</b>	QueueEmptyException.java <br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>
 *The QueueEmptyException Class extends the Exception class and has a default and parameterized constructor
 *for the Class objects
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 */

public class QueueEmptyException extends Exception{
	/**
	 * QueueEmptyException default constructor - sends to super class a String 
	 */
	public QueueEmptyException()
	{
		super ("Queue Empty Exception");
	}
	
	/**
	 * QueueEmptyException parameterized constructor - sends to the super class a String
	 * @param message - the message sent to the super class
	 */
	public QueueEmptyException( String message)
	{
		super(message);
	}
}

