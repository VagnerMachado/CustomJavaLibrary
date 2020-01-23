package Utilities;

import java.util.Arrays;

public class Test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		int [] master = Utilities.generateRandom(100000, -500000, 500000);
		Integer[] bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		long time;

		
		Utilities.startTimer();
		Utilities.mergeSort(bal);
		time = Utilities.timeElapsed();
		System.out.println("Time to merge sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(bal[i] > bal[i+1])
				System.out.println("Missorted merges sort: " + bal[i] + " < " + bal[i+1]);
		
		master = Utilities.generateRandom(100000, 0, 1000000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		int [] xx = Utilities.radixSort(master);
		time = Utilities.timeElapsed();
		System.out.println("Time to radix: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(xx[i] > xx[i+1])
				System.out.println("Missorted radix: " + xx[i] + " < " + xx[i+1]);
		
		master = Utilities.generateRandom(100000, -500000, 500000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		Utilities.shellSort(bal);
		time = Utilities.timeElapsed();
		System.out.println("Time to shell sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(bal[i] > bal[i+1])
				System.out.println("Missorted Shell: " + bal[i] + " < " + bal[i+1]);

		master = Utilities.generateRandom(100000, -5000000, 500000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		Utilities.bubbleSort(bal);
		time = Utilities.timeElapsed();
		System.out.println("Time to bubble sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(bal[i] > bal[i+1])
				System.out.println("Missorted Bubble: " + bal[i] + " < " + bal[i+1]);


		master = Utilities.generateRandom(100000, -5000000, 500000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		Utilities.insertionSort(bal);
		time = Utilities.timeElapsed();
		System.out.println("Time to insertion sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(bal[i] > bal[i+1])
				System.out.println("Missorted insertion: " + bal[i] + " < " + bal[i+1]);
		 
		master = Utilities.generateRandom(100000, -5000000, 500000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		Utilities.selectionSort(bal);
		time = Utilities.timeElapsed();
		System.out.println("Time to selection sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(bal[i] > bal[i+1])
				System.out.println("Missorted selection: " + bal[i] + " < " + bal[i+1]);
		
		
		master = Utilities.generateRandom(100000, 0, 1000000);
		bal = Arrays.stream(master).boxed().toArray( Integer[]::new );
		Utilities.startTimer();
		int [] arr = Utilities.radixSort(master);
		time = Utilities.timeElapsed();
		System.out.println("Time to radix sort: " + time);
		for(int i = 0 ; i < bal.length - 1; i++)
			if(arr[i] > arr[i+1])
				System.out.println("Missorted radix: " + arr[i] + " < " + arr[i+1]);
		
		
		
		

	}

}
