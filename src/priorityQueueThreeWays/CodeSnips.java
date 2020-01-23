package priorityQueueThreeWays;

public class CodeSnips 
{
/*
  /**
	 * testRuntime - tests a kind of priority queue with characteristics passed as parameter that follow:
	 * @param t - the priority queue being tested
	 * @param dataInterval - data interval, or increment. i.e if passed 10, intervals will be 10, 20, 30 ...
	 * @param runs - how many times the same data size is re run to find an average
	 * @param dataPoints - the amount of data sizes being tested
	 * @param fileName - the file where results are written to
	 */
	/*public static void dequeueTest(PriorityQueue<Task> pq, int dataInterval, int runs, int dataPoints, String fileName)
	{



		//long [] timesENQ = new long[dataPoints];
		long [] timesDEQ = new long[dataPoints];
		//long [] timesMIX = new long[dataPoints];
		//int [] dataSizes = new int[dataPoints];

		try {
			//run for 10 different data sizes
			for(int i = 0; i < dataPoints; i++) 
			{
				//run each data size 10 times
				for(int j = 0; j < runs; j ++)
				{	
					System.out.println("Running Array Data set " + (i+1) + "  - Inner loop " + j);

					//timesENQ[i] += benchmarkEnqueue(enq , dataInterval * (i + 1));
					//enq = null;
					//System.gc();
					pq.clear();
					timesDEQ[i] += benchmarkDequeue(pq, dataInterval * (i + 1));
					pq = null;
					System.gc();
					ArrayPQ<Task> mix = new ArrayPQ<Task>(1000);
					timesMIX[i] += benchmarkEnqueueDequeue(mix, dataInterval * (i + 1));
					mix = null;
					System.gc();
				}
				dataSizes[i] = dataInterval * (i + 1) ;
				System.out.println("Ended Linked List run " + (i + 1) + " with " + dataSizes[i] + " items");
			}

			//averages the times
			for(int i = 0; i < dataPoints; i++)
			{
				timesENQ[i] /= runs;
				timesDEQ[i] /= runs;
				timesMIX[i] /= runs;
			}

		}
		catch (OutOfMemoryError e)
		{
			System.out.println("Out of Memory for analyzing " + fileName
					+ "choose a smaller set of data. Writing salvaged data to files");
			Utilities.writeToCSV(dataSizes, timesENQ, fileName);
			Utilities.writeToCSV(dataSizes, timesDEQ, fileName);
			Utilities.writeToCSV(dataSizes, timesMIX, fileName);
		}

		Utilities.writeToCSV(dataSizes, timesENQ, fileName);
		Utilities.writeToCSV(dataSizes, timesDEQ, fileName);
		Utilities.writeToCSV(dataSizes, timesMIX, fileName);

	} */

 
}
