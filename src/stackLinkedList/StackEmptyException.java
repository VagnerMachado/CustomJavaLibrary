package stackLinkedList;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxxx <br>
 *<b>Filename:</b>	StackEmptyException.java <br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>
 *The StackEmptyException Class extends the Exception class and has a default and parameterized constructor
 *for the Class objects
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 */

public class StackEmptyException extends Exception 
{
	/**
	 * StackEmptyException default constructor - sends to super class a String 
	 */
	public StackEmptyException()
	{
		super ("Stack Empty Exception");
	}
	
	/**
	 * StackEmptyException parameterized constructor - sends to the super class a String
	 * @param message - the message sent to the super class
	 */
	public StackEmptyException( String message)
	{
		super(message);
	}
}
