package queueCircularArray;

/**********************************************************************************************************************
 *          Please refer to the Driver java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project 3: Airport Simulator <br>
 *<b>Filename:</b>	QueueFullException.java <br>
 *<b>Date Written:</b>	April, 2016<br>
 *<b>Due Date:</b> April 25th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>
 *The QueueFullException Class extends the Exception class and has a default and parameterized constructor
 *for the Class objects
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 */

public class QueueFullException extends Exception 
{
	/**
	 * QueueFullException default constructor - sends to super class a String 
	 */
	public QueueFullException()
	{
		super ("Queue Full Exception");
	}

	/**
	 * QueueFullException parameterized constructor - sends to the super class a String
	 * @param message - the message sent to the super class
	 */
	public QueueFullException( String message)
	{
		super(message);
	}
}
