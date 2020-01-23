package Utilities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * Utilities - this class contains methods to generate 1D and 2D arrays with random numbers, allows the user to 
 * write and read a 2D array to CSV file, and lastly the user can write the sorting time analysis of a 2D
 * array to a CSV file
 * 
 * @author Vagner Machado QCID 23651127
 *
 */
public class Utilities<T extends Comparable<T>> 
{
	private static long time = 0;

	private Utilities()
	{

	}

	/**
	 * generateRandom - generates a random array of integers
	 * @param arraySize - the size of the array
	 * @param minVal - minimum random value
	 * @param maxVal - maximum value in the array
	 * @return - an array with the specified size and range
	 */
	public static int [] generateRandom(int arraySize, int minVal, int maxVal) 
	{
		int [] result = new int [arraySize];
		Random r = new Random();
		for(int i = 0; i < arraySize; i++) 
		{
			int x = r.nextInt(maxVal - minVal) + minVal;
			result [i] = x;
		}
		return result;
	}

	/**
	 * generateRandom - generates a random array of integers
	 * @param arraySize - the size of the array
	 * @param minVal - minimum random value
	 * @param maxVal - maximum value in the array
	 * @return - an array with the specified size and range
	 */
	public static Integer [] generateRandomInteger(int arraySize, int minVal, int maxVal) 
	{
		Integer [] result = new Integer [arraySize];
		Random r = new Random();
		for(int i = 0; i < arraySize; i++) 
		{
			int x = r.nextInt(maxVal - minVal) + minVal;
			result [i] = x;
		}
		return result;
	}

	/**
	 * generateRandom2D - generates a 2D array with random integer values
	 * @param arraySize - the number of rows 
	 * @param minRandVal - minimum random value
	 * @param maxRandVal - maximum random value
	 * @param interval - the array length difference in each column (if interval is 10: 0, 10, 20, 30.. items per row)
	 *				   - new addition: if interval is zero, interval will be powers of 2 from 10 to arraySize parameter
	 * @return - a 2D array with the specified sized and range of values
	 */
	public static int [][] generateRandom2D(int arraySize, int minRandVal, int maxRandVal, int interval)
	{
		int [][] result = new int [arraySize][];
		int power = 10;
		for(int i = 0; i < arraySize; i++)
		{
			int x;
			if(interval == 0)
				x = (int) Math.pow(2, power++);
			else
				x = i * interval;

			result[i] = generateRandom(x, minRandVal, maxRandVal);
		}
		return result;
	}

	/**
	 * write2DtoCSV - writes a 2D array to a CSV file
	 * @param data - the 2D array to be written to a CSv file
	 * @param filename - the name for the CSV file
	 */
	public static void write2DtoCSV(int [][] data, String filename)
	{
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			for(int i = 0; i < data.length; i++)
			{
				for(int j = 0; j < data[i].length; j++)
				{
					writer.append(String.valueOf(data[i][j]));
					writer.append(',');
				}
				writer.append('\n');
			}

		} catch (IOException e) 
		{
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
		try {
			writer.flush();
			writer.close();
		}
		catch (IOException e) 
		{
			System.out.println("Error flushing and closing the writer");
			e.printStackTrace();
		}

	}

	/**
	 *  writeAnalysisToCSV - sorts each row in the 2D array and analyzed the time it took 
	 * @param data - the 2D array to get analyzed
	 * @param filename - the name of CSV file to receive the result of analysis
	 */
	public static void sortAnalyzeAndWriteToCSV(int [][] data, String filename)
	{
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			for(int i = 0; i < data.length; i++)
			{
				long start = System.currentTimeMillis();
				Arrays.sort(data[i]); //replace for preferred sorting method
				long end = System.currentTimeMillis();
				writer.append(String.valueOf(data[i].length));
				writer.append(',');
				writer.append(String.valueOf(end - start));
				writer.append('\n');
			}
		} catch (IOException e) 
		{
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
		try 
		{
			writer.flush();
			writer.close();
		}
		catch (IOException e) 
		{
			System.out.println("Error flushing and closing the writer");
			e.printStackTrace();
		}

	}

	/**
	 *  writeAnalysisToCSV - sorts each row in the 2D array and analyzed the time it took 
	 * @param data - the 2D array to get analyzed
	 * @param filename - the name of CSV file to receive the result of analysis
	 */
	public static void writeToCSV(int [] size, long [] times, String filename)
	{
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			writer.append("0,0\n");
			for(int i = 0; i < size.length; i++)
			{
				writer.append(String.valueOf(size[i]));
				writer.append(',');
				writer.append(String.valueOf(times[i]));
				writer.append('\n');
				System.out.flush();
				System.out.println();
			}
		} catch (IOException e) 
		{
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
		try 
		{
			writer.flush();
			writer.close();
		}
		catch (IOException e) 
		{
			System.out.println("Error flushing and closing the writer");
			e.printStackTrace();
		}

	}

	/**
	 * readCSV - reads in a CSV file and turns it into a 2D array
	 * @param filename - the CSV file to be read in
	 * @return - a 2D array with the data int he CSV file
	 */
	public static int [][] readCSV(String filename)
	{

		BufferedReader fileReader = null;
		BufferedReader fileReaderLine = null;
		int [][] result = null;
		try 
		{
			String line = "";
			fileReaderLine = new BufferedReader(new FileReader(filename));
			int totalLines = 0;

			//line counter
			while ((fileReaderLine.readLine()) != null)
				totalLines++;
			result = new int [totalLines][];
			//System.out.println("There are " + totalLines + " lines");

			int position = 0;
			fileReader = new BufferedReader(new FileReader(filename));
			//line = fileReader.readLine(); //skips the empty one
			while ((line = fileReader.readLine()) != null) 
			{
				String[] items = line.split(",");
				//System.out.println(Arrays.toString(items));
				if (items.length > 1) 
				{
					result[position] = new int [items.length];
					for(int i = 0; i < items.length; i++)
						//if(items[i] != "")
						result[position] [i] = Integer.parseInt(items[i]);
				}
				else
					result[position] = new int [0];
				position++;
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error in CSV FileReader");
			e.printStackTrace();
		}

		try 
		{
			fileReader.close();
		} 
		catch (IOException e) 
		{
			System.out.println("Error closing FileReader");
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * startTimer -  enables the user to keep track of the time
	 * a certain task is initiated.
	 */
	public static void startTimer()
	{
		time = System.currentTimeMillis();
	}

	/**
	 * timeElapsed - accessor to the time a certain task took
	 * from the call to startTimer() to timeElapsed()
	 * @return the time elapsed between those two method calls
	 */
	public static long timeElapsed()
	{
		return System.currentTimeMillis() - time;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * shellSort - uses the shell sort method to sort a comparable array
	 * @param arr - an array of comparable items
	 */
	public static void shellSort(Comparable [] arr)
	{
		int len = arr.length;
		int gap = 1;
		while(gap < (len / 3))
			gap = gap * 3 + 1;

		while (gap >= 1)
		{
			for(int i  = gap; i < len; i++)
			{
				//note second param of for loop
				for(int j = i; j >= gap && arr[j].compareTo(arr[j - gap]) < 0; j -= gap)
				{
					Comparable T = arr[j];
					arr[j] = arr[j - gap];
					arr[j - gap] = T;
				}

			}
			gap = gap/3;
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * bubbleSort - uses the bubble sort method to sort a comparable array
	 * @param arr - an array of comparable items
	 */
	public static void bubbleSort(Comparable [] arr)
	{
		boolean done;
		for(int i = 0; i < arr.length; i++) 
		{
			done = true;
			for(int j = i + 1; j < arr.length; j++) 
			{
				if(arr[j].compareTo(arr[i]) < 0)
				{
					Comparable temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					done = false;
				}
			}
			if (done)
			{
				//System.out.println("Broke Bubble with i = " + i + " instead of " + arr.length); //works
				break;
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * insertionSort - uses the insertion sort method to sort a comparable array
	 * @param arr - an array of comparable items
	 */
	public static void insertionSort(Comparable [] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j > 0 /*&& arr[j].compareTo(arr[j-1]) < 0*/; j--)
			{
				if(arr[j].compareTo(arr[j-1]) < 0)
				{
					Comparable temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	/**
	 * selectionSort - uses the selection sort method to sort a comparable array
	 * @param arr - an array of comparable items
	 */
	public static void selectionSort(Comparable [] arr)
	{
		int min;
		boolean newLow;

		for(int i = 0; i < arr.length - 1 ; i++)
		{
			min = i;
			newLow = false;
			for(int j = i + 1; j < arr.length; j++)
			{	
				if (arr[j].compareTo(arr[min]) < 0)
				{
					newLow = true;
					min = j;
				}
			}
			if(newLow)
			{
				Comparable temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;	
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] first, Comparable[] second, Comparable[] result)
	{
		//index of first
		int f = 0; 
		//index of second
		int s = 0;
		//index of merge
		int m = 0;

		//compare and merge
		while (f < first.length && s < second.length)
		{
			if (first[f].compareTo(second[s]) < 0)
				result[m++] = first[f++];
			else
				result[m++] = second[s++];
		}
		//copy remaining elements from both halves 
		if (f == first.length)
			while(s < second.length)
				result[m++] = second[s++];
		
		if (s == second.length)
			while(f < first.length)
				result[m++] = first[f++];
	
	}
	@SuppressWarnings("rawtypes")
	public static Comparable[] mergeSort(Comparable[] list)
	{
		//Size 1 is done
		if (list.length <= 1) {
			return list;
		}

		//Split
		Comparable[] first = new Comparable[list.length / 2];
		Comparable[] second = new Comparable[list.length - first.length];
		
		for(int i = 0; i < first.length; i++)
			first[i] = list[i];
		
		for(int place = 0, i = first.length; i < list.length; /*blank*/)
			second[place++] = list[i++];
		
		//keep splitting in half
		mergeSort(first);
		mergeSort(second);

		//merge sorted arrays
		merge(first, second, list);
		return list;
	}

	public static int [] radixSort(int [] arr)
	{
		int [] result = Arrays.copyOf(arr, arr.length); // copies the instance array
		int maxLen = String.valueOf(getMax(arr)).length();
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
	private static int getMax(int [] arr)
	{
		int max = arr[0]; //assume max to be first value
		int len = arr.length; //length
		for(int i  = 1; i < len; i++) //iterates to find max value in array
			if(arr[i] > max)
				max = arr[i];
		return max;
	}
	
	
	

}
