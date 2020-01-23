package radixSortPositive;

import java.util.Arrays;

public class Radix
{
	private int [] ArrayToBeSorted;// = {123,50,2,5,45};

	public Radix(int [] x)
	{
		ArrayToBeSorted = x;
	}

	public int [] sort()
	{
		int [] result = Arrays.copyOf(ArrayToBeSorted, ArrayToBeSorted.length); // copies the insance array
		int maxLen = String.valueOf(getMax()).length();
		int resultLen = result.length;
		int radix = 1;
		// iterates for the length of max number
		for ( int i = 0; i < maxLen; i++)
		{
			int [] freq = new int [10];

			//makes a frequency array based on the radix in case
			for (int j = 0; j < resultLen; j++)
			{
				int index = (result[j]/radix)%10;
				//System.out.println(index);
				(freq[index])++;
			}
			//System.out.println("Frequency: " + Arrays.toString(freq));

			//adds up the frequency to make a positional array
			for(int k = 1; k < 10; k++)
			{
				freq[k] += freq[k-1];
			}
			//System.out.println("Positional: " + Arrays.toString(freq));
			int [] temp = new int [result.length];

			//iterates through array to reposition based on the postional array
			for (int m = resultLen - 1; m >= 0; m--)
			{
				int z = result[m];
				int index = (z/radix)%10;
				int place = --(freq[index]);
				temp[place] = z;
			}
			//point result to temp
			result = temp;
			//increment radix
			radix *= 10;
		}

		return result;
	}

	/**getMax method - private method used to identify the largest
	 * number in the instance array.
	 * @return the largest number in the instance array
	 */
	private int getMax()
	{
		int max = ArrayToBeSorted[0]; //assume max to be first value
		int len = ArrayToBeSorted.length; //length
		for(int i  = 1; i < len; i++) //iterates to find max value in array
			if(ArrayToBeSorted[i] > max)
				max = ArrayToBeSorted[i];
		return max;
	}
}
