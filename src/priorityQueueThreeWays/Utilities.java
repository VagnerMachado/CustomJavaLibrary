package priorityQueueThreeWays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Utilities 
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
	 *  analyzeAndWriteToCSV - sorts each row in the 2D array and analyzed the time it took 
	 * @param data - the 2D array to get analyzed
	 * @param filename - the name of CSV file to receive the result of analysis
	 */
	public static void analyzeAndWriteToCSV(int [][] data, String filename)
	{
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			for(int i = 0; i < data.length; i++)
			{
				long start = System.currentTimeMillis();
				Arrays.sort(data[i]); //replace for sorting method to be tested
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

			while ((fileReaderLine.readLine()) != null)
				totalLines++;
			result = new int [totalLines][];

			int position = 0;
			fileReader = new BufferedReader(new FileReader(filename));
			while ((line = fileReader.readLine()) != null) 
			{
				String[] items = line.split(",");
				if (items.length > 1) 
				{
					result[position] = new int [items.length];
					for(int i = 0; i < items.length; i++)
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
	public static long startTimer()
	{
		time = System.currentTimeMillis();
		return time; //in order to test i decided to return;
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

}
