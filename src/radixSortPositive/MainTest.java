package radixSortPositive;

import java.util.Arrays;

public class MainTest 
{

	public static void main(String[] args) 
	{	//cannot be negative
		int [] x = {78,3,56,65,42,12,74,98,55,63,21,447,12,874,452,12,4,5,63,6,5,6,76,6,6,6,5,4,3,5,7,8,6,4,3,93,6,8,9};
		Radix rad = new Radix (x);
		System.out.println("Original: " + Arrays.toString(x));
		System.out.println("Sorted: " + Arrays.toString(rad.sort()));
	}

}
