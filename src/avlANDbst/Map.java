package avlANDbst;

/**<pre>
 * ********************************************************************************************************************
 *      									     Map.java       					                          
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This interface contains the methods that all Maps must implement or stay 
 * abstract, case they are not implemented. I took the liberty to add the throws statements to the methods
 * in order to comply with the need to throws exceptions.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     	             	  VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *********************************************************************************************************************
 *
 * @param K,V - generic types
 * @author Adolpas_Lapsys
 *</pre>
 */
public interface Map <K,V>
{
	// Insert a value into the map associated with the key.
	void put(K key, V value) throws MapException;

	// Retrieve the value associated with the key.
	V get(K key) throws MapException;

	// Remove and return the value associated with the key. 
	void remove(K key) throws MapException;

	// Return the number of elements in the map.
	int size();

	// Return true if there are no elements in the map.
	boolean isEmpty();

}
