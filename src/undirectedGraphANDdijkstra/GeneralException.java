package undirectedGraphANDdijkstra;

@SuppressWarnings("serial")
/**<pre>
 * ********************************************************************************************************************
 *      									     GeneralException.java       					                          
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class is used throughout the program to throw exceptions in certain cases. The 
 * exception objects are instantiated with a String passed as parameter or a default one can be instantiated
 * with a default String value. Both constructor send the String to the Exception super class.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     	             	  VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *********************************************************************************************************************
 *
 *</pre>
 */
public class GeneralException extends RuntimeException 
{
	/**
	 * default Exception constructor
	 */
	public GeneralException()
	{
		super("**\nGeneral Exception Thrown: Good Luck Debugging!\n**");
	}
	
	/**
	 * parameterized MapException constructor
	 */
	public GeneralException(String s)
	{ 
		super(s);
	}
}
