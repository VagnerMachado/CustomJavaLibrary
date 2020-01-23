package priorityQueueThreeWays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**<pre>
 * ********************************************************************************************************************
 *      									     Main.java       					                              *
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class instantiates each each different implementation of the PriorityQueues and 
 * uses the benchmarkEnqueue, benchmarkDequeue and benchmarkEnqueueDequeue to respectively test the efficiency of
 * the priority	queues for ONLY enqueuing, ONLY dequeuing, and lastly random enqueue-dequeue. The latter, however,
 * only allows dequeues after at least half of the Tasks were already enqueued. This simulates a possible real 
 * world use for a priority queue where lots of data are manipulated.
 *  
 * For information about other classes and methods used for this project, please refer to their javadocs. 
 * 
 *********************************************************************************************************************
 *     		 @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                  *           
 *********************************************************************************************************************
 *
 * @param T - a generic type that extends the Comparable interface
 * 
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class Main 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		System.out.println("\n\n          *************************************************************\n"
				+ "          **** Welcome to Vagner's Priority Queue Benchmarking App ****\n"
				+ "          *************************************************************\n\n");
		int intervalArrE = 0;  
		int intervalHeapE = 0; 
		int intervalLLE = 0;	  

		int intervalArrD = 0;  
		int intervalHeapD = 0; 
		int intervalLLD = 0;

		int intervalArrM = 0;  
		int intervalHeapM = 0; 
		int intervalLLM = 0;

		Scanner scan = new Scanner(System.in);
		if(args.length == 0)
		{
			String answer = "";
			while(!answer.equalsIgnoreCase("yes") && !answer.equals("no"))
			{
				System.out.println("\n* Would you like to enter the data intevals for testing? *\n"
						+ "\n              * Please enter yes or no *");
				answer = scan.nextLine();
			}
			if(answer.equalsIgnoreCase("no"))
			{
				System.out.println("\n* Using default Task intervals for testing *\n"
						+ "* 5 million increments for ArrayPQ enqueue\n"
						+ "* 5 milion increments for HeapPQ enqueue\n"
						+ "* 25 thousand increment for LinkedListPQ enqueue\n\n"
						+ "* 5 million increments for ArrayPQ dequeue\n"
						+ "* 5 million increments for HeapPQ dequeue\n"
						+ "* 25 thousand increment for LinkedListPQ dequeue\n\n"
						+ "* 25 thousand increments for ArrayPQ enqueue-dequeue\n"
						+ "* 5 million increments for HeapPQ enqueue-dequeue\n"
						+ "* 25 thousand increment for LinkedListPQ enqueue-dequeue\n\n");

				intervalArrE = 5000000;  
				intervalHeapE = 5000000; 
				intervalLLE = 25000;	  

				intervalArrD = 5000000;  
				intervalHeapD = 5000000; 
				intervalLLD = 25000;

				intervalArrM = 25000;  
				intervalHeapM = 5000000; 
				intervalLLM = 25000;
			}
			else
			{
				boolean done = false;
				while(!done)
				{
					try
					{
						System.out.println("\nPlease enter a positive integer for ArrayPQ enqueue interval:");
						intervalArrE = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for HeapPQ enqueue interval:");
						intervalHeapE = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for LinkedListPQ enqueue interval:");
						intervalLLE = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for ArrayPQ dequeue interval:");
						intervalArrD = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for HeapPQ dequeue interval:");
						intervalHeapD = scan.nextInt();
						System.out.println("\nPlease enter a posivite integer for LinkedListPQ deqeue interval:");
						intervalLLD = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for ArrayPQ enqueue-dequeue interval:");
						intervalArrM = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for HeapPQ enqueue-dequeue interval:");
						intervalHeapM = scan.nextInt();
						System.out.println("\nPlease enter a positive integer for LinkedListPQ enqueue-dequeue interval:");
						intervalLLM = scan.nextInt();
						if (intervalArrE < 0 || intervalArrD < 0 || intervalArrM < 0 || 
								intervalHeapE < 0 || intervalHeapD < 0 || intervalHeapM < 0 ||
								intervalLLE < 0 || intervalLLD < 0 || intervalLLM < 0)
						{
							System.out.println("\n * Error: Do not enter negative integers. Enter positive integers when prompted * \n\n");
						}
						else
							done = true;
					}
					catch(InputMismatchException e)
					{
						System.out.println("\n* Exception: Please enter only positive Integers when prompted * \n");
						scan = new Scanner(System.in);
					}
				}
			}
		}
		else
		{
			if(args.length > 0 && args.length < 9)
			{
				System.out.println("\n* Warning: Enter nine positive integers as arguments in this order *\n\n"
						+ "[Task interval for ArrayPQ enqueue ] [Task interval forHeapPQ enqueue]" 
						+ " [Task interval for LinkedListPQ enqueue]\n[Task interval forArrayPQ dequeue] "
						+ "[Task interval for HeapPQ dequeue] [Task interval for LinkedListPQ dequeue]"
						+ "\n[Task interval for Array enqueue-dequeue] "
						+ "[Task interval forHeapPQ enqueue-dequeue] [Task interval for LinkedListPQ enqueue-dequeue]");
				System.out.println("\n\n* Otherwise, pass 0 arguments and you will be prompted when program starts *\n\n");
				System.exit(1);
			}
			try 
			{
				System.out.println("\n* Using data interval passed as arguments *\n");
				
				intervalArrE = Integer.parseInt(args[0]);
				intervalHeapE = Integer.parseInt(args[1]);
				intervalLLE = Integer.parseInt(args[2]);	
				intervalArrD = Integer.parseInt(args[3]);
				intervalHeapD = Integer.parseInt(args[4]);
				intervalLLD = Integer.parseInt(args[5]);	
				intervalArrM = Integer.parseInt(args[6]);
				intervalHeapM = Integer.parseInt(args[7]);
				intervalLLM = Integer.parseInt(args[8]);
				if (intervalArrE < 0 || intervalArrD < 0 || intervalArrM < 0 || 
						intervalHeapE < 0 || intervalHeapD < 0 || intervalHeapM < 0 ||
						intervalLLE < 0 || intervalLLD < 0 || intervalLLM < 0)
				{
					System.out.println("\n * Error: Negative integer passed as parameter * \n\n");
					throw new NumberFormatException();
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("\n* Exception: An argument passed is not a positive integer *" +
						"\n* Using default Task intervals for testing *\n"
						+ "* 5 million increments for ArrayPQ enqueue\n"
						+ "* 5 milion increments for HeapPQ enqueue\n"
						+ "* 25 thousand increment for LinkedListPQ enqueue\n\n"
						+ "* 5 million increments for ArrayPQ dequeue\n"
						+ "* 5 million increments for HeapPQ dequeue\n"
						+ "* 25 thousand increment for LinkedListPQ dequeue\n\n"
						+ "* 25 thousand increments for ArrayPQ enqueue-dequeue\n"
						+ "* 5 million increments for HeapPQ enqueue-dequeue\n"
						+ "* 25 thousand increment for LinkedListPQ enqueue-dequeue\n\n");
				intervalArrE = 5000000;  
				intervalHeapE = 5000000; 
				intervalLLE = 25000;	  

				intervalArrD = 5000000;  
				intervalHeapD = 5000000; 
				intervalLLD = 25000;

				intervalArrM = 25000;  
				intervalHeapM = 5000000; 
				intervalLLM = 25000;
			}
		}

		scan.close();

		/* *********************************************************************************************
		 *     The upcoming section is dedicated to benchmarking the Array Based Priority Queue
		 ***********************************************************************************************/


		//amount of data points with the increment above
		int dataPointsArr = 10;

		// number of runs with same data set size, used to find an average
		int runsArr = 10;

		long [] arrayTimesENQ = new long[dataPointsArr];
		long [] arrayTimesDEQ = new long[dataPointsArr];
		long [] arrayTimesMIX = new long[dataPointsArr];
		int [] arraySizesE = new int[dataPointsArr];
		int [] arraySizesD = new int[dataPointsArr];
		int [] arraySizesM = new int[dataPointsArr];

		try {
			//runs with different data sizes
			for(int i = 0; i < dataPointsArr; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runsArr; j ++)
				{	
					System.out.println("Running Array Data set " + (i+1) + "  - Inner loop " + j);
					ArrayPQ<Task> enqArr = new ArrayPQ<Task>(1000);
					arrayTimesENQ[i] += benchmarkEnqueue(enqArr, intervalArrE * (i + 1));
					enqArr = null;
					System.gc();
					ArrayPQ<Task> deqArr = new ArrayPQ<Task>(1000);
					arrayTimesDEQ[i] += benchmarkDequeue(deqArr, intervalArrD * (i + 1));
					deqArr = null;
					System.gc();
					ArrayPQ<Task> mixArr = new ArrayPQ<Task>(1000);
					arrayTimesMIX[i] += benchmarkEnqueueDequeue(mixArr, intervalArrM * (i + 1));
					mixArr = null;
					System.gc();
				}
				arraySizesE[i] = intervalArrE * (i + 1) ;
				arraySizesD[i] = intervalArrD * (i + 1) ;
				arraySizesM[i] = intervalArrM * (i + 1) ;
				System.out.println("Ended Array run " + (i + 1));
			}

			//averages the times
			for(int i = 0; i < dataPointsArr; i++)
			{
				arrayTimesENQ[i] /= runsArr;
				arrayTimesDEQ[i] /= runsArr;
				arrayTimesMIX[i] /= runsArr;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory, choose a smaller set of data, writing salvaged data to files");
			Utilities.writeToCSV(arraySizesE, arrayTimesENQ, "ArrayENQ.csv");
			Utilities.writeToCSV(arraySizesD, arrayTimesDEQ, "ArrayDEQ.csv");
			Utilities.writeToCSV(arraySizesM, arrayTimesMIX, "ArrayMIX.csv");
		}

		Utilities.writeToCSV(arraySizesE, arrayTimesENQ, "ArrayENQ.csv");
		Utilities.writeToCSV(arraySizesD, arrayTimesDEQ, "ArrayDEQ.csv");
		Utilities.writeToCSV(arraySizesM, arrayTimesMIX, "ArrayMIX.csv");


		/* *********************************************************************************************
		 *     The upcoming section is dedicated to benchmarking the Heap Based Priority Queue
		 ***********************************************************************************************/

		//data interval for each set


		//amount of data points with the increment above
		int dataPointsHeap = 10;

		// number of runs with same data set size, used to find an average
		int runsHeap = 10;

		long [] heapTimesENQ = new long[dataPointsHeap];
		long [] heapTimesDEQ = new long[dataPointsHeap];
		long [] heapTimesMIX = new long[dataPointsHeap];
		int [] heapSizesE = new int[dataPointsHeap];
		int [] heapSizesD = new int[dataPointsHeap];
		int [] heapSizesM = new int[dataPointsHeap];

		try {
			//runs with different data sizes
			for(int i = 0; i < dataPointsHeap; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runsHeap; j++)
				{	
					System.out.println("Running Heap Data set " + (i+1) + "  - Inner loop " + j);
					HeapPQ<Task> enqHeap = new HeapPQ<Task>(1000);
					heapTimesENQ[i] += benchmarkEnqueue(enqHeap, intervalHeapE * (i + 1));
					enqHeap = null;
					System.gc();
					HeapPQ<Task> deqHeap = new HeapPQ<Task>(1000);
					heapTimesDEQ[i] += benchmarkDequeue(deqHeap, intervalHeapD * (i + 1));
					deqHeap = null;
					System.gc();
					HeapPQ<Task> mixHeap = new HeapPQ<Task>(1000);
					heapTimesMIX[i] += benchmarkEnqueueDequeue(mixHeap, intervalHeapM * (i + 1));
					mixHeap = null;
					System.gc();
				}
				heapSizesE[i] = intervalHeapE * (i + 1) ;
				heapSizesD[i] = intervalHeapD * (i + 1) ;
				heapSizesM[i] = intervalHeapM * (i + 1) ;
				System.out.println("Ended Heap run " + (i + 1));
			}

			//averages the times
			for(int i = 0; i < dataPointsHeap; i++)
			{
				heapTimesENQ[i] /= runsHeap;
				heapTimesDEQ[i] /= runsHeap;
				heapTimesMIX[i] /= runsHeap;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory, choose a smaller set of data, writing salvaged data to files");
			Utilities.writeToCSV(heapSizesE, heapTimesENQ, "HeapENQ.csv");
			Utilities.writeToCSV(heapSizesD, heapTimesDEQ, "HeapDEQ.csv");
			Utilities.writeToCSV(heapSizesM, heapTimesMIX, "HeapMIX.csv");
		}

		Utilities.writeToCSV(heapSizesE, heapTimesENQ, "HeapENQ.csv");
		Utilities.writeToCSV(heapSizesD, heapTimesDEQ, "HeapDEQ.csv");
		Utilities.writeToCSV(heapSizesM, heapTimesMIX, "HeapMIX.csv");


		/* *********************************************************************************************
		 *     The upcoming section is dedicated to benchmarking the Linked List Based Priority Queue
		 ***********************************************************************************************/

		/* ***********************************         Enqueue      ************************************/  

		//amount of data points with the increment above
		int dataPointsLL = 10;

		// number of runs with same data set size, used to find an average
		int runsLL = 10;

		//array for the times
		int [] linkedListSizesE = new int[dataPointsLL];

		//array fir the times
		long [] linkedListTimesENQ = new long[dataPointsLL];

		try {
			//runs with different data sizes
			for(int i = 0; i < dataPointsLL; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runsLL; j++)
				{	
					System.out.println("Running LL ENQ Data set " + (i+1) + "  - Inner loop " + j);
					LinkedListPQ<Task> enqLL = new LinkedListPQ<Task>();
					linkedListTimesENQ[i] += benchmarkEnqueue(enqLL, intervalLLE * (i + 1));
					enqLL = null;
					System.gc();
				}
				linkedListSizesE[i] = intervalLLE * (i + 1) ;
				System.out.println("Ended Linked List run " + (i + 1) + " with " + linkedListSizesE[i] + " items");
			}

			//averages the times
			for(int i = 0; i < dataPointsLL; i++)
			{
				linkedListTimesENQ[i] /= runsLL;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory, choose a smaller set of data, writing salvaged data to files");
			Utilities.writeToCSV(linkedListSizesE, linkedListTimesENQ, "LinkedListENQ.csv");
		}
		//writing to file
		Utilities.writeToCSV(linkedListSizesE, linkedListTimesENQ, "LinkedListENQ.csv");


		/* *********************************************************************************************
		 *     The upcoming section is dedicated to benchmarking the Linked List Based Priority Queue
		 ***********************************************************************************************/

		/* ******************************           Dequeue           *******************************/

		//testing a mix of enqueue and dequeue in a linked list 

		//amount of data points with the increment above
		dataPointsLL = 10;

		// number of runs with same data set size, used to find an average
		runsLL = 10;

		//array for the times
		long [] linkedListTimesDEQ = new long[dataPointsLL];

		//array for the data sizes
		int [] linkedListSizesD = new int[dataPointsLL];

		try 
		{
			//runs with different data sizes
			for(int i = 0; i < dataPointsLL; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runsLL; j ++)
				{	
					System.out.println("Running LL DEQ Data set " + (i+1) + "  - Inner loop " + j);
					LinkedListPQ<Task> deqLL = new LinkedListPQ<Task>();
					linkedListTimesDEQ[i] += benchmarkDequeue(deqLL, intervalLLD * (i + 1));
					deqLL = null;
					System.gc();
				}
				linkedListSizesD[i] = intervalLLD * (i + 1) ;
				System.out.println("DEQ - Ended Linked List run " + (i + 1) + " with " + linkedListSizesD[i] + " items");
			}

			//averages the times
			for(int i = 0; i < dataPointsLL; i++)
			{
				linkedListTimesDEQ[i] /= runsLL;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory, choose a smaller set of data, writing salvaged data to files");
			Utilities.writeToCSV(linkedListSizesD, linkedListTimesDEQ, "LinkedListDEQ.csv");
		}

		//write to the file
		Utilities.writeToCSV(linkedListSizesD, linkedListTimesDEQ, "LinkedListDEQ.csv");


		/* *********************************************************************************************
		 *     The upcoming section is dedicated to benchmarking the Linked List Based Priority Queue
		 ***********************************************************************************************/

		/* ******************************         Enqueue-Dequeue      *******************************/ 

		//amount of data points with the increment above
		dataPointsLL = 10;

		// number of runs with same data set size, used to find an average
		runsLL = 10;

		//array for the data sizes
		int [] linkedListSizesM = new int[dataPointsLL];

		//array for the times
		long [] linkedListTimesMIX = new long[dataPointsLL];

		try {
			//runs with different data sizes
			for(int i = 0; i < dataPointsLL; i++) 
			{
				//run each data size this many times
				for(int j = 0; j < runsLL; j++)
				{	
					System.out.println("Running LL MIX Data set " + (i+1) + "  - Inner loop " + j);
					LinkedListPQ<Task> mixLL = new LinkedListPQ<Task>();
					linkedListTimesMIX[i] += benchmarkEnqueueDequeue(mixLL, intervalLLM * (i + 1));
					mixLL = null;
					System.gc();
				}
				linkedListSizesM[i] = intervalLLM * (i + 1) ;
				System.out.println("MIX Ended Linked List run " + (i + 1) + " with " + linkedListSizesM[i] + " items");
			}

			//averages the times
			for(int i = 0; i < dataPointsLL; i++)
			{
				linkedListTimesMIX[i] /= runsLL;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory, choose a smaller set of data, writing salvaged data to files");
			Utilities.writeToCSV(linkedListSizesM, linkedListTimesMIX, "LinkedListMIX.csv");
		}

		// write to file
		Utilities.writeToCSV(linkedListSizesM, linkedListTimesMIX, "LinkedListMIX.csv");


	}



	/**
	 * benchmarkEnqueue - instantiates certain amount of tasks and times how long it takes to 
	 * enqueue all of them
	 * @param pq - the priority queue being tested
	 * @param size - the data size being tested
	 * @return - how long it took to enqueue all the data
	 */
	public static long benchmarkEnqueue(PriorityQueue<Task> pq, int size)
	{
		Random random = new Random();

		Task [] tasks = new Task[size];

		for(int i = 0; i < size; i++)
			tasks[i] = new Task(random.nextInt(), random.nextInt());

		Utilities.startTimer();
		for(int i = 0; i < size; i++)
		{
			pq.enqueue(tasks[i]);
			//System.out.println("ENQ - Size: " + pq.getSize() + " Item #: " + i);	
		}
		return  Utilities.timeElapsed();

	}

	/**
	 * benchmarkDequeue - instantiates certain amount of tasks, enqueues all of them and times
	 * how long it takes to dequeue it all
	 * @param pq - the priority queue to be tested
	 * @param size - the data size to be tested
	 * @return how long it took to dequeue all the data
	 */
	public static long benchmarkDequeue(PriorityQueue<Task> pq, int size)
	{
		Random random = new Random();
		Task [] tasks = new Task[size];

		for(int i = 0; i < size; i++)
			tasks[i] = new Task(random.nextInt(), random.nextInt());

		for(int i = 0; i < size; i++)
			pq.enqueue(tasks[i]);

		Utilities.startTimer();

		//int j = 0;
		while(!pq.isEmpty())
		{								
			//System.out.println("DEQ -  Size: " + pq.getSize() + " Item #: " + j++);
			pq.dequeue();
		}

		return  Utilities.timeElapsed();

	}

	/**
	 * benchmarkEnqueueDequeue - tests randomly enqueuing a data size passed as parameter, while 
	 * items get randomly dequeued after half of the data being enqueued
	 * @param pq - the priority queue to be tested
	 * @param size - the data size being enqueued with random dequeues in between
	 * @return - the time it took to randomly enqueue all data size, in milliseconds
	 */
	public static long benchmarkEnqueueDequeue(PriorityQueue<Task> pq, int size)
	{
		Task [] tasks = new Task[size];

		Random rand = new Random();

		for(int i = 0; i < size; i++)
			tasks[i] = new Task(rand.nextInt(), rand.nextInt());

		Utilities.startTimer();
		for(int i = 0; i < size;  /*conditional incrementing */ )
		{
			int coin = rand.nextInt(1000);
			if(coin % 2 == 0)
			{
				pq.enqueue(tasks[i++]);
			}

			//dequeues only if it is empty AND if half of the items are added
			else if (!pq.isEmpty() && i >= (size / 2))
			{
				pq.dequeue();
				//System.out.println("MIX DEQ - Size: " + pq.getSize() + " Item #: " + i);
			}
		}
		return  Utilities.timeElapsed();
	}
}