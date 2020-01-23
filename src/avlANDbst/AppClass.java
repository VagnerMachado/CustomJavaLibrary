
package avlANDbst;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



/**********************************************************************************************************************
 *                                                  AppClass.java                                                     
 * ********************************************************************************************************************
 * 
 * Description: In this class the Constructor and methods for  Map objects are tested.  The Maps 
 * are instantiated, and  randomly generated String keys ranging from 10 to 20 digits are used as test data.
 * The benchmarking methods for project 2 were optimized relative to Project 1's methods. Now there is one outer method
 * that is used by the three types of Maps being tested. This method then calls the proper benchmarking method based
 * on parameters passed. The test data is made possible by a static String generator method. To avoid crashes, the  
 * key data array size = 2 * greatest interval * data points. Interval is the interval of data tested i.e. if 1 million
 *  is passed as parameter, that will be the interval of data tested. dataPoints is how many of those intervals are 
 * being tested. The two comes from the benchmarking methods. They usually handle double the necessary data and perform 
 * the test on the data added in the 'middle' of the data batch to simulate a Map with extra information.
 *
 * The Map methods tested are put, remove and get. Additionally, print methods are provided for the user in the 
 * Map Classes.
 * 
 * Regarding code research: I coded all classes myself. The only thing that I had to look up was the rotate left and 
 * rotate right methods. My thinking and code was mostly correct, however I was returning the wrong node in those
 * methods. I looked a few place and settled for the explanation given in 
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/. Based on that code, I made the AVLrebalance method to 
 * figure out which rotations are necessary, and added the AVLrebalance to deleteMin() and remove() methods.
 * 
 * 
 *          For information about the other classes created for this project, please see their javadocs.
 *
 *********************************************************************************************************************
 *     	     	        Author VagnerMachado  - ID 23651127 - Queens College  -  Spring 2018      	                        
 *********************************************************************************************************************
 *
 */

public class AppClass 
{
	static Random random = new Random();
	static String [] data;

	@SuppressWarnings("resource")
	public static void main(String[] args)  
	{

		System.out.println("\n\n          *************************************************************\n"
				+ "          **** Welcome to Vagner's Map Benchmarking App ****\n"
				+ "          *************************************************************\n\n");

		////////////////////////////////////////  Start Command Line ///////////////////////////////////////////////

		//program variables default values
		int hp = 500000;
		int lp = 10000;
		int bp = 500000;
		int hg = 500000;
		int lg = 10000;
		int bg = 500000;
		int hr = 500000;
		int lr = 10000;
		int br = 500000;
		int runs = 10;
		int dataPoints = 10;
		int loadFactor = 4;
		int dataSize = 10500000;
		int hashArray = hp/4;


		Scanner scan = new Scanner(System.in);

		//case no arguments are passed
		if(args.length == 0)
		{
			String answer = "";
			while(!answer.equalsIgnoreCase("yes") && !answer.equals("no"))
			{
				System.out.println("\n* Would you like to enter the data intevals for Map testing? *\n"
						+ "\n              * Please enter YES or NO *");
				answer = scan.nextLine();
			}
			//user wants to use default values
			if(answer.equalsIgnoreCase("no"))
			{
				System.out.println("\n* Using default Task intervals for Map testing *\n"
						+ "* " + hp + " increments for HashMap put\n"
						+ "* " + lp + " increments for LinkedMap put\n"
						+ "* " + bp + " increment for BSTMap and AVLmap put\n"
						+ "* " + hg + " increments for HashMap get\n"
						+ "* " + lg + " increments for LinkedMap get\n"
						+ "* " + bg + " increment for BSTMap and AVLmap get\n"
						+ "* " + hr + " increments for HashMap remove\n"
						+ "* " + lr + " increments for LinkedMap remove\n"
						+ "* " + br + " increment for BSTMap and AVLmap remove\n"
						+ "* " + dataSize + " random Key-Value Pairs\n"
						+ "* " + loadFactor + " load facor for the HashMap\n"
						+ "* " + hp/4 + " for HashMap array size\n\n");
			}

			//user wants to chose own values
			else
			{
				boolean done = false;
				while(!done)
				{
					try
					{   
						int max = 1;
						System.out.println("\nPlease enter a positive integer for HashMap Put data interval:");
						hp = scan.nextInt();
						if(max < hp)
							max = hp;
						System.out.println("\nPlease enter a positive integer for LinkedMap Put interval:");
						lp = scan.nextInt();
						if(max < lp)
							max = lp;
						System.out.println("\nPlease enter a positive integer for BSTMap and AVLmap Put interval:");
						bp = scan.nextInt();
						if(max < bp)
							max = bp;
						System.out.println("\nPlease enter a positive integer for HashMap Get data interval:");
						hg = scan.nextInt();
						if(max < hg)
							max = hg;
						System.out.println("\nPlease enter a positive integer for LinkedMap Get interval:");
						lg = scan.nextInt();
						if(max < lg)
							max = lg;
						System.out.println("\nPlease enter a positive integer for BSTMap and AVLmap Get interval:");
						bg = scan.nextInt();
						if(max < bg)
							max = bg;
						System.out.println("\nPlease enter a positive integer for HashMap Remove data interval:");
						hr = scan.nextInt();
						if(max < hr)
							max = hr;
						System.out.println("\nPlease enter a positive integer for LinkedMap Remove interval:");
						lr = scan.nextInt();
						if(max < lr)
							max = lr;
						System.out.println("\nPlease enter a positive integer for BSTMap and AVLmap Remove interval:");
						br = scan.nextInt();
						if(max < br)
							max = br;
						System.out.println("\nPlease enter an integer greater than 1 for Hash Map load factor:");
						loadFactor = scan.nextInt();
						System.out.println("\nPlease enter an integer greater than 1 for HashMap array size:");
						hashArray = scan.nextInt();
						//data size is 21 times the size of freatest interval
						dataSize = 21 * max;

						if (hp <=0 || hg <= 0 || hr <= 0 || 
								lp <= 0 || lg <= 0 || lr <= 0 ||
								bp <= 0 || bg <= 0 || br <= 0 || loadFactor <= 1 || hashArray <= 0 )
						{
							System.out.println("\n * Error: Do not enter invalid integers. Enter proper "
									+ "values as prompted * \n\n");
						}
						else
							done = true;
					}
					catch(InputMismatchException e)
					{
						System.out.println("\n* Exception: Please enter only positive Integers as prompted * \n");
						scan = new Scanner(System.in);
					}
				}
			}
		}

		else
		{
			//case arguments are not enough
			if(args.length > 0 && args.length < 11)
			{
				System.out.println("\n* Warning: Enter 11 positive integers as arguments in this order *\n\n"
						+ "[Data interval for HashMap Put ] [Data interval for LinkedMap Put]" 
						+ " [Data interval for BSTMap and AVLmap Put]\n[Data interval for HashMap Get] "
						+ "[Data interval for LinkedMap Get] [Data interval for BST Get and AVLmap]"
						+ "\n[Data interval for HashMap Remove] "
						+ "[Data interval for LinkedMap Remove] [Data interval for BSTMap and AVLmap remove]"
						+ "\n[Load factor grater than 1 for HashMap] [HashMap Array size greater than 0]\n\n");
				System.out.println("\n\n* Otherwise, pass 0 arguments and you will be prompted when program starts *\n\n");
				System.exit(1);
			}
			//use args values
			try 
			{
				System.out.println("\n* Using data interval passed as arguments *\n");
				hp = Integer.parseInt(args[0]);
				lp = Integer.parseInt(args[1]);
				bp = Integer.parseInt(args[2]);	
				hg = Integer.parseInt(args[3]);
				lg = Integer.parseInt(args[4]);
				bg = Integer.parseInt(args[5]);	
				hr = Integer.parseInt(args[6]);
				lr = Integer.parseInt(args[7]);
				br = Integer.parseInt(args[8]);
				loadFactor = Integer.parseInt(args[9]);
				hashArray = Integer.parseInt(args[10]);

				//figure out the random data size needed
				int max = 1;
				for(int i = 0; i < 9; i++)
					if(Integer.parseInt(args[i]) > max)
						max = Integer.parseInt(args[i]);

				dataSize = 21 * max;

				//validate
				if (hp < 0 || hg < 0 || hr < 0 || 
						lp < 0 || lg < 0 || lr < 0 ||
						bp < 0 || bg < 0 || br < 0 || loadFactor <= 1 || hashArray <= 0)
				{
					System.out.println("\n * Error: Invalid integer passed as parameter * \n\n");
					throw new NumberFormatException();
				}
			}
			//use defaults
			catch(NumberFormatException e)
			{
				hp = 500000;
				lp = 10000;
				bp = 500000;
				hg = 500000;
				lg = 10000;
				bg = 500000;
				hr = 500000;
				lr = 10000;
				br = 500000;
				runs = 10;
				dataPoints = 10;
				loadFactor = 4;
				dataSize = 10500000;
				hashArray = hp/4;

				System.out.println("\n* Using default Task intervals for Map testing *\n"
						+ "* " + hp + " increments for HashMap put\n"
						+ "* " + lp + " increments for LinkedMap put\n"
						+ "* " + bp + " increment for BSTMap and AVLmap put\n\n"
						+ "* " + hg + " increments for HashMap get\n"
						+ "* " + lg + " increments for LinkedMap get\n"
						+ "* " + bg + " increment for BSTMap and AVLmap get\n\n"
						+ "* " + hr + " increments for HashMap remove\n"
						+ "* " + lr + " increments for LinkedMap remove\n"
						+ "* " + br + " increment for BSTMap and AVLmap remove\n"
						+ "* " + dataSize + " random Key-Value Pairs\n"
						+ "* " + loadFactor + " load facor for the HashMap\n"
						+ "* " + hashArray + " for HashMap array size\n\n");
			}
		}

		scan.close();

		/////////////////////////////////////////  End Command Line ////////////////////////////////////////////////////

		data = new String[dataSize];
		Object [] result = new Object[2];
		//loading test data 
		System.out.print("\n\n** Generating Key and Value data **\n\n");
		for(int i = 0; i < data.length; i++)
			data [i] = getRandomString();


		HashMap<String, String> hash = new HashMap<>(hashArray, loadFactor);
		LinkedMap<String, String> linked = new LinkedMap<>();
		BSTMap<String, String> bst = new BSTMap<>();
		AVLmap<String, String> avl = new AVLmap<>();


		try
		{
			//benchmarking put
						result = benchmarker(dataPoints, runs, hp, hash, "put");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "hashPut.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, lp, linked, "put");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "linkedPut.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, bp, bst, "put");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "BSTPut.csv");
						result = new Object[2];

			result = benchmarker(dataPoints, runs, bp, avl, "put");
			Utilities.writeToCSV((int[])result[0], (long[])result[1],  "AVLput.csv");
			result = new Object[2];

			hash = new HashMap<>(hashArray, loadFactor);
			linked = new LinkedMap<>();
			bst = new BSTMap<>();
			avl = new AVLmap<>();

			//benchmarking get
						result = benchmarker(dataPoints, runs, hg, hash, "get");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "hashGet.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, lg, linked, "get");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "linkedGet.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, bg, bst, "get");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "BSTGet.csv");
						result = new Object[2];

			result = benchmarker(dataPoints, runs, bg, avl, "get");
			Utilities.writeToCSV((int[])result[0], (long[])result[1],  "AVLget.csv");
			result = new Object[2];

			hash = new HashMap<>(hashArray, loadFactor);
			linked = new LinkedMap<>();
			bst = new BSTMap<>();
			avl = new AVLmap<>();

			//benchmarking remove
						result = benchmarker(dataPoints, runs, hr, hash, "remove");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "hashRemove.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, lr, linked, "remove");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "linkedRemove.csv");
						result = new Object[2];
						
						result = benchmarker(dataPoints, runs, br, bst, "remove");
						Utilities.writeToCSV((int[])result[0], (long[])result[1],  "BSTremove.csv");
						result = new Object[2];

			result = benchmarker(dataPoints, runs, br, avl, "remove");
			Utilities.writeToCSV((int[])result[0], (long[])result[1],  "AVLremove.csv");
			result = new Object[2];

			System.out.println("\n\n** The testing has concluded, please see CVS files created for benchmarking results **");

		} 
		catch (MapException e) 
		{
			System.out.println("\n\n*** Program Execution Failed ***\n\n");
			System.out.println("Possible Reason: " + e.getMessage() + " traced to: \n");
			e.printStackTrace();
		}
	}

	/**
	 * benchmarkGet - benchmarks the time it takes to get a certain a number of items,
	 * This method adds twice the amount of data and then gets the data added in the 
	 * middle of the Map
	 * @param map - the map being tested
	 * @param items - the number of items to get
	 * @return - the time it took to get those items
	 */
	public static long benchmarkGet(Map <String,String> map, int items) throws MapException
	{
		for(int i = 0; i < items * 2; i++) //adds twice the data
		{
			map.put(data [i], data[i]);
		}

		long start = System.nanoTime();

		int half =  items/2; 
		for( int j = half; j < (items + half); j++) //then time get for data size in 'middle' of Map
		{
			map.get(data [j]);
		}
		return  System.nanoTime() - start;
	}

	/**
	 * benchmarkPut - benchmarks the time it takes to put a certain a number of items,
	 * extra data is added, then put time is tested with number of items passed
	 * @param map - the Map being tested
	 * @param items -  the number of items being tested
	 * @return - the time it took to put the items passed as parameter
	 */
	public static long benchmarkPut(Map <String,String> map, int items) throws MapException
	{

		int i = 0;
		for(i = 0; i < items; i++) //adds proportional data
		{
			map.put(data [i], data[i]);
		}

		long start = System.nanoTime();

		for( int j = (i + 1); j < (items * 2 + 1); j++) //then time put for data size passed as parameter
		{
			map.put(data [j], data[j]);
		}
		return  System.nanoTime() - start;

	}

	/**
	 * benchmarkRemove - benchmarks the time it takes to remove a certain a number of items,
	 * the data added is doubled, then removal of items added in the 'middle' is timed.
	 * @param map - the Map being tested
	 * @param items - the number of items being removed
	 * @return - then time it took to remove those items
	 */
	public static long benchmarkRemove(Map <String,String> map, int items) throws MapException
	{

		for(int i = 0; i < items * 2; i++) //adds twice the data size 
		{
			map.put(data [i], data[i]);
		}

		long start = System.nanoTime();

		int half = items/2;
		for( int j = half; j < (items + half); j++) //then time remove for data int the 'middle' of Map
		{
			map.remove(data [j]);
		}
		return  System.nanoTime() - start;

	}

	/**
	 * getRandomString - generates a string with 10 to 20 characters. They were made with all sorts of characters
	 * in order to avoid a repeated key and an eventual exception
	 * @return - a string with 10 to 20 characters
	 */
	public static String getRandomString()
	{
		String s = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./?><mnbvcxz\":lkjhgfdsa}{poiuytrewq+_)(*&^%$#@!~`)";
		String result = "";
		int len = random.nextInt(11) + 10;
		for(int i = 0; i < len; i++)
			result += s.charAt(random.nextInt(94));
		return result;
	}

	/**
	 * benchmarker - the outer benchmarking method that calls the other appropriate benchmarking methods 
	 * based on the parameters passed into this method
	 * @param dataPoints - the number of data points to be collected
	 * @param runs - how many repeated runs for each data points, used then to average time
	 * @param interval - data interval increments to be analyzed
	 * @param map - the map to be benchmarked (HashMap<K,V>\nLinkedMap<K,V>\nBSTMap<K,V>\nAVLmap<K,V>)
	 * @param method - the method to be benchmarked (put, get, remove)
	 * @return an Object array of size 2. Those are mapSizes array  at index 0 and mapTimes array at index 1
	 * @throws MapException - case option of method or Map is invalid
	 */
	public static Object [] benchmarker(int dataPoints, int runs, int interval,
			Map<String, String> map, String method) throws MapException
	{	
		Object [] results = new Object[2];
		String type;
		if (map instanceof HashMap)
			type = "HashMap";
		else if (map instanceof LinkedMap)
			type = "LinkedMap";
		else if (map instanceof BSTMap)
			type = "BSTMap";
		else
			type = "AVLmap";

		System.out.println("\n*** Testing " + method + " in a " + type + "***\n");
		// data sizes
		int [] mapSizes = new int[dataPoints];

		//array for the times
		long [] mapTimes = new long[dataPoints];

		try {
			//runs with different data sizes
			for(int i = 0; i < dataPoints; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runs; j++)
				{	
					System.out.println("Running " + type + " with data set " + interval *(i+1) + "  - Inner loop " + j);

					if (method.equalsIgnoreCase("put"))
						mapTimes[i] += benchmarkPut(map, interval * (i + 1));
					else if (method.equalsIgnoreCase("remove"))
						mapTimes[i] += benchmarkRemove(map, interval * (i + 1));
					else if (method.equalsIgnoreCase("get"))
						mapTimes[i] += benchmarkGet(map, interval * (i + 1));
					else
						throw new MapException("\n***Invalid Method passed as parameter ***\n Choices are:\n"
								+ "get\nput\nremove\n");
					if (type.equals("HashMap"))
					{
						map = new HashMap<String, String>
						(((HashMap<String, String>) map).getFirstArraySize(), 
								((HashMap<String, String>) map).getMaxLoad());

					} else if (type.equals("LinkedMap"))
						map = new LinkedMap<String, String>();
					else if (type.equals("BSTMap"))
						map = new BSTMap<String, String>();
					else if (type.equals("AVLmap"))
						map = new AVLmap<String, String>();
					else 
						throw new MapException("\n***Invalid Data Structure passed as parameter ***\n Choices are:\n"
								+ "HashMap<K,V>\nLinkedMap<K,V>\nBSTMap<K,V>\n\\nAVLmap<K,V>\\n\n");

					System.gc();
				}
				mapSizes[i] = interval * (i + 1) ;
				System.out.println("Ended " + runs + " runs with " + type + " with " + mapSizes[i] + " items\n");
			}

			//averages the times
			for(int i = 0; i < dataPoints; i++)
			{
				mapTimes[i] /= runs;
			}

		}
		catch (OutOfMemoryError e)
		{
			//averages the times
			for(int i = 0; i < dataPoints; i++)
			{
				mapTimes[i] /= runs;
			}
			System.out.println("\n** Out of Memory, choose a smaller set of data, writing salvaged data to files **\n");
			// load objects and return
			results[0] = mapSizes;
			results[1] = mapTimes;
			return results;
		}

		// load objects and return
		results[0] = mapSizes;
		results[1] = mapTimes;
		return results;
	}

}
