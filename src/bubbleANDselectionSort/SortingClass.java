
/*    @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017    */

package bubbleANDselectionSort;

/*********************************************************************************************************************
 *                                                 SortingClass.java                                                     *
 * ********************************************************************************************************************
 * 
 * Description: This class contains a constructor that instantiates an instance integer array to be the integer
 * array passed as parameter. This class contains two sorting methods: bubbleSort and selectionSort. Additionally a 
 * swap method used as an auxiliary method to the ones above. A toString method is defined and prints the current array
 * value for the SortingClass Object. A reverse method was include to change the order of values in the array.
 * 
 *          For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     	     	 @author VagnerMachado  - ID N00820127  - Nassau Community College - Spring 2017     	             *           
 *********************************************************************************************************************
 *
 */

public class SortingClass 
{
	//instance data
	static int x [];

	/**
	 * SortingCalss constructor - instantiates the instance variable array
	 * with the values for the parameter array
	 * @param m - an array of integers
	 */
	public SortingClass(int [] m)
	{
		x = m;
	}

	/**
	 * bubbleSort method  - compares value two at a time and swaps 
	 * the values if left > right. The nested loop has a boolean variable
	 * to track if changes were made, if so, the code iterates once more,
	 * otherwise, it stops. 
	 */
	public void bubbleSort()
	{
		int passOut = 0;
		int passIn = 0;
		boolean swapped = true;
		int n = x.length;
		int last = -1;//tracks how far to check the inner loop

		//stops is length is reached or if changes were not made in inner loop
		for (int i = 0; i < n && swapped; i++) 
		{
			swapped = false; //will stay false if changes are not made causing a break in the loops
			last++;
			//check pairs and swap if necessary
			for (int j = 1; j < x.length - last; j++) 
			{
				//checks if swap is needed
				if (x[j-1] > x[j]) 
				{
					swap(j-1, j);
					swapped = true; //changes were made
				}
				passIn++;
			}	
			passOut++;
		}
		
		System.out.println("Iterations:           It took " + passOut +" outter loop iterations and " + passIn + " inner loop iterations to sort this array." ); //this will always be the array size
	}

	/**
	 * selectionSort method - picks the lowest value of each full iteration
	 * and places it at the starting point of each iteration. Starting
	 * point gets incremented with each loop to avoid changing the previous
	 * value. The method contains a boolean variable that is used to swap 
	 * value only if necessary
	 */
	public void selectionSort()
	{
		int passOut = 0;
		int passIn = 0;
		int n = x.length;
		int smallestNum = 0; 
		int indexOfLowest = 0;
		boolean doSwap = false; //tracks if swaps are necessary

		// each iteration increments the starting point of check up to array length
		for (int startInd = 0; startInd < n; startInd++) 
		{
			smallestNum = x[startInd]; //assume first number is lowest
			doSwap = false; // assume changes are not needed

			//compares lowest to numbers left to check
			for (int j = startInd + 1; j < n; j++) 
			{
				//if there is a number lower than smallestNum save array index and value
				if (smallestNum > x[j]) 
				{
					doSwap = true;
					indexOfLowest = j;
					smallestNum = x[j];	
				}
				passIn++;
			}
			//swap only if found a lower number than smallestNum
			if(doSwap)
				swap(startInd, indexOfLowest );
			passOut++;
		}
		System.out.println("Iterations:           It took " + passOut +" outter loop iterations and " + passIn + " inner loop iterations to sort this array." ); //this will always be the array size
	}

	/**
	 * swap method - swaps the values for the array indexes passed as parameters
	 * @param a - an array index to swap values with b index
	 * @param b - an array index to swap values with a index
	 */
	private static void swap(int a, int b) 
	{
		int temp = x[a]; //copies the value at a
		x[a] = x[b]; //assigns value at b to a 
		x[b] = temp; //assigns value a to b
	}

	/**
	 * reverse method - reverses the array from increasing order to decreasing order
	 * and vice versa depending on how array is currently sorted.
	 */
	public void reverse()
	{
		int len = x.length;
		int [] temp = new int [len];
		int i = 0;
		for(int v : x)
			temp[i++] = v;
		i = len - 1;
		for(int m: temp)
			x[i--] = m;
	}

	/**
	 * toString method - accessor for the current values for the SortingClass Object
	 * @return b - a String containing the values in the instance data array
	 */
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		for(int m : x)
			b.append(m + " ");
		return b.toString();
	}

}
