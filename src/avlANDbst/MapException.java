package avlANDbst;

@SuppressWarnings("serial")
/**<pre>
 * ********************************************************************************************************************
 *      									     MapException.java       					                          
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
public class MapException extends Exception
{
	/**
	 * default MapException constructor
	 */
	public MapException()
	{
		super("**\nMap Exception Thrown\n**");
	}
	
	/**
	 * parameterized MapException constructor
	 */
	public MapException(String s)
	{ 
		super(s);
	}
}
