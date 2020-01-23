package stackArray;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxxxxxx <br>
 *<b>Filename:</b>	StackFullException.java <br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>
 *The StackFullException Class extends the Exception class and has a default and parameterized constructor
 *for the Class objects
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 */

public class StackFullException extends Exception 
{
	/**
	 * StackFullException default constructor - sends to super class a String 
	 */
	public StackFullException()
	{
		super ("Stack Full Exception");
	}

	/**
	 * StackFullException parameterized constructor - sends to the super class a String
	 * @param message - the message sent to the super class
	 */
	public StackFullException( String message)
	{
		super(message);
	}
}
