			
			/*    @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017    */

package hashTableProject;
import java.util.NoSuchElementException;


 /*********************************************************************************************************************
 *                                                  MainTest.java                                                     *
 * ********************************************************************************************************************
 * 
 * Description: In this class the Constructor and methods for a HashTable object are tested. 
 * My output matches the provided output sample, and the proper instantiation of the LinkedList
 * does not require the casting in the 'get' method as explained in an email sent to students. 
 * 
 *          For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     	     	 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	             *           
 *********************************************************************************************************************
 *
 */

public class MainTest {

	public static void main(String[] args) {

		HashTable<String, String> ht = new HashTable<>();

		ht.add("cat", "cat value");
		ht.add("dog", "dog value");
		ht.add("god", "god value");
		ht.add("moq", "moq value");
		ht.add("laptop", "laptop value 2");
		ht.add("laptop", "laptop value 1");
		ht.add("sofa", "sofa value");
		ht.add("tree", "tree value");
		ht.add("candy", "candy value");
		ht.add("portable", "portable value");
		ht.add("umbrella", "umbrella value");
		ht.add("horse", "horse value");
		ht.add("hunter", "hunter value");
		ht.add("marbelized", "marbelized value");
		ht.add("college", "college value");
		ht.add("television", "television value");
		ht.add("lollie", "lollie value");
		ht.add("hunters", "hunter value");
		ht.add("marbelizing", "marbelizing value");
		ht.add("colleges", "college value");
		ht.add("televisions", "television value");
		ht.add("lollipop", "lollie value");

		/*System.out.println(ht.get("cat"));
		System.out.println(ht.get("god"));
		System.out.println(ht.get("moq")); //used to expand list
		System.out.println(ht.get("dog"));
		System.out.println(ht.get("laptop"));
		System.out.println(ht.get("sofa"));
		System.out.println(ht.get("horse"));*/
		try{
			System.out.println(ht.get("tac"));
		}
		catch(NoSuchElementException e)
		{
			System.out.println(("tac is not in the list"));
		}

		System.out.println("\n\n ** Testing the toString Method ** \n" + ht);
		
		/*       Sample Output 
		 
		312 : cat value
		list in if [Entry [key=cat, value=cat value]]
		314 : dog value
		list in if [Entry [key=dog, value=dog value]]
		314 : god value
		list in else [Entry [key=dog, value=dog value], Entry [key=god, value=god value]]
		in get 312
		pos of key is 0
		cat value
		in get 314
		pos of key is 1
		god value
		in get 312
		pos of key is -1
		Exception in thread "main" java.util.NoSuchElementException: Looked through List, No Value with that Key
			at hashtablelab.HashTable.get(HashTable.java:82)
			at hashtablelab.MainTest.main(MainTest.java:16)
		 */

	}

}
