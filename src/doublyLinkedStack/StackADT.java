package doublyLinkedStack;

/**********************************************************************************************************************
 *          Please refer to the xxxxxxxxxxxxxxx.java file for a description of the project in a larger scope          *
 * ********************************************************************************************************************
 * 
 *<b>Title:</b>	Project x: xxxxxxx<br>
 *<b>Filename:</b>	StackADT.java<br>
 *<b>Date Written:</b>	mm dd yyyy<br>
 *<b>Due Date:</b> mm dd yyyy<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This is the interface that contains the abstract methods to be implemented in the Stack Class
 *</p>
 *
 *********************************************************************************************************************
 *                  @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                    *           
 *********************************************************************************************************************
 *
 * @param <T> - a generic data type 
 */
	public interface StackADT <T>
	{	
		public void push (T d);
		public T pop()throws StackEmptyException;
		public T peek() throws StackEmptyException;
		public boolean isEmpty();
		public int size();

	}

	




