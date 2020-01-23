
/*    @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017    */

package bubbleANDselectionSort;
import java.util.Random;

/*********************************************************************************************************************
 *                                                  MainTest.java                                                     *
 * ********************************************************************************************************************
 * 
 * Description: In this class the Constructor and methods for SortingClass Object are tested. 
 * My output indicates that the methods are sorting the arrays properly. Both sorting methods in the SortingClass
 * contain a boolean variable that tracks if value swaps are needed or not, improving the methods' efficiency. I included
 * a printout in each method to display the amount of outter and inner loop iteration for each sort.
 * 
 *          For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     	     	 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	             *           
 *********************************************************************************************************************
 *
 */
public class Application {

	public static void main(String[] args) 
	{   
		System.out.println("\n        *****************************************************************************");
		System.out.println("        *** 	          This is Vagner Machado's Sorting Lab 	            	  ***");
		System.out.println("        ***       The bubble sort and selection sort methods are tested thrice    ***");
		System.out.println("        *****************************************************************************\n\n");
		System.out.println("        ******************************     Test #1      *****************************\n\n");

		// arrays to be sorted
		int [] v = new int [20];
		int [] m = new int [20];
		//random number generator
		Random random = new Random();

		//I instantiated  different arrays 
		for (int i = 0; i < 20; i++)
		{
			//Range is given by ( upper - lower) + lower
			v[i] = random.nextInt(1000) - 500;
		}

		//Instantiate a SortingClass object
		SortingClass bubbleSort= new SortingClass(v);
		//print unsorted and sorted arrays
		System.out.println("Unsorted Bubble:     " + bubbleSort);
		bubbleSort.bubbleSort();
		System.out.println("Bubble Sort:         " + bubbleSort);
		bubbleSort.reverse();
		System.out.println("Reverse method:      " + bubbleSort);

		//other array is loaded for selection sort
		for (int i = 0; i < 20; i++)
		{
			m[i] = random.nextInt(1000) - 500;
		}

		//A SortingClass Object is instantiated
		SortingClass selectionSort= new SortingClass(m);
		//prints unsorted and sorted arrays
		System.out.println("\nUnsorted Selection:  " + selectionSort);
		selectionSort.selectionSort();
		System.out.println("Selection Sort:      " + selectionSort);
		selectionSort.reverse();
		System.out.println("Reverse method:      " + selectionSort);


		System.out.println("\n\n        ******************************     Test #2      *****************************\n\n");

		//I instantiated  different arrays 
		for (int i = 0; i < 20; i++)
		{
			//Range is given by ( upper - lower) + lower
			v[i] = random.nextInt(1000) - 500;
		}

		//Instantiate a SortingClass object
		bubbleSort= new SortingClass(v);
		//print unsorted and sorted arrays
		System.out.println("Unsorted Bubble:     " + bubbleSort);
		bubbleSort.bubbleSort();
		System.out.println("Bubble Sort:         " + bubbleSort);
		bubbleSort.reverse();
		System.out.println("Reverse method:      " + bubbleSort);

		//other array is loaded for selection sort
		for (int i = 0; i < 20; i++)
		{
			m[i] = random.nextInt(1000) - 500;
		}

		//A SortingClass Object is instantiated
		selectionSort= new SortingClass(m);
		//prints unsorted and sorted arrays
		System.out.println("\nUnsorted Selection:  " + selectionSort);
		selectionSort.selectionSort();
		System.out.println("Selection Sort:      " + selectionSort);
		selectionSort.reverse();
		System.out.println("Reverse method:      " + selectionSort);

		System.out.println("\n\n        ******************************     Test #3      *****************************\n\n");

		//I instantiated  different arrays 
		for (int i = 0; i < 20; i++)
		{
			//Range is given by ( upper - lower) + lower
			v[i] = random.nextInt(1000) - 500;
		}

		//Instantiate a SortingClass object
		bubbleSort= new SortingClass(v);
		//print unsorted and sorted arrays
		System.out.println("Unsorted Bubble:     " + bubbleSort);
		bubbleSort.bubbleSort();
		System.out.println("Bubble Sort:         " + bubbleSort);
		bubbleSort.reverse();
		System.out.println("Reverse method:      " + bubbleSort);

		//other array is loaded for selection sort
		for (int i = 0; i < 20; i++)
		{
			m[i] = random.nextInt(1000) - 500;
		}

		//A SortingClass Object is instantiated
		selectionSort= new SortingClass(m);
		//prints unsorted and sorted arrays
		System.out.println("\nUnsorted Selection:  " + selectionSort);
		selectionSort.selectionSort();
		System.out.println("Selection Sort:      " + selectionSort);
		selectionSort.reverse();
		System.out.println("Reverse method:      " + selectionSort);

		System.out.println("\n\n        ******************************     Test #4      *****************************\n\n");

		//I instantiated  different arrays 
		for (int i = 0; i < 20; i++)
		{
			//Range is given by ( upper - lower) + lower
			v[i] = random.nextInt(1000) - 500;
		}

		//Instantiate a SortingClass object
		bubbleSort= new SortingClass(v);
		//print unsorted and sorted arrays
		System.out.println("Unsorted Bubble:     " + bubbleSort);
		bubbleSort.bubbleSort();
		System.out.println("Bubble Sort:         " + bubbleSort);
		bubbleSort.reverse();
		System.out.println("Reverse method:      " + bubbleSort);

		//other array is loaded for selection sort
		for (int i = 0; i < 20; i++)
		{
			m[i] = random.nextInt(1000) - 500;
		}

		//A SortingClass Object is instantiated
		selectionSort= new SortingClass(m);
		//prints unsorted and sorted arrays
		System.out.println("\nUnsorted Selection:  " + selectionSort);
		selectionSort.selectionSort();
		System.out.println("Selection Sort:      " + selectionSort);
		selectionSort.reverse();
		System.out.println("Reverse method:      " + selectionSort);

		System.out.println("\n\n        ******************************     Test #5      *****************************\n\n");

		//I instantiated  different arrays 
		for (int i = 0; i < 20; i++)
		{
			//Range is given by ( upper - lower) + lower
			v[i] = random.nextInt(1000) - 500;
		}

		//Instantiate a SortingClass object
		bubbleSort= new SortingClass(v);
		//print unsorted and sorted arrays
		System.out.println("Unsorted Bubble:     " + bubbleSort);
		bubbleSort.bubbleSort();
		System.out.println("Bubble Sort:         " + bubbleSort);
		bubbleSort.reverse();
		System.out.println("Reverse method:      " + bubbleSort);

		//other array is loaded for selection sort
		for (int i = 0; i < 20; i++)
		{
			m[i] = random.nextInt(1000) - 500;
		}

		//A SortingClass Object is instantiated
		selectionSort= new SortingClass(m);
		//prints unsorted and sorted arrays
		System.out.println("\nUnsorted Selection:  " + selectionSort);
		selectionSort.selectionSort();
		System.out.println("Selection Sort:      " + selectionSort);
		selectionSort.reverse();
		System.out.println("Reverse method:      " + selectionSort);

		System.out.println("\n\n        ******************************     Test #6      *****************************\n\n");
		
		//comparing the time used to bubble sort and selections sort pre sorted arrays
		System.out.println("	**	Passing an already sorted array to bubble sort	**\n");
		int [] ordered = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49}; //prints that sorter went through only one time
		bubbleSort = new SortingClass(ordered);
		System.out.println("Pre Ordered:          " + bubbleSort);
		long thyme = System.nanoTime();
		bubbleSort.bubbleSort();
		thyme = System.nanoTime() - thyme; 
		System.out.println("Time:                 It took " + thyme + " nanoseconds to bubble sort a pre sorted integer array of size 50.");

		System.out.println("Note:                 The values show this sorting will iterate through at least one time and continue only if necessary.");

		System.out.println("After Sorting:        " + bubbleSort + "\n");
		
		System.out.println("	**	Passing an already sorted array to selection sort	**\n");
		int [] orderedToo = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};
		selectionSort = new SortingClass(orderedToo);
		System.out.println("Pre Ordered:          " + selectionSort);
		long time = System.nanoTime();
		selectionSort.selectionSort();
		time = System.nanoTime() - time;
		System.out.println("Time:                 It took " + time + " nanoseconds to selection sort a pre sorted integer array of size 50.");
		System.out.println("Note:                 The values show this sorting will iterate through all possible indexes even if not necessay.");
		System.out.println("After Sorting:        " + selectionSort);
		

		System.out.println("\n\n        ******************************     The End      *****************************\n");
for(int o = 20; o < 101; o++)
	System.out.print(o + ",");



	}

}
