package binarySearchTree;

import java.util.Random;

import javax.swing.plaf.synth.SynthSpinnerUI;

//import java.util.TreeSet;
/*********************************************************************************************************************
 *     							                TreeApp.java        
 * *******************************************************************************************************************
 *
 *<p><b>Description:</b></p>
 *<p> This class makes use of the code defined in the BinarySearchTree class, and contains an integer array whose members are 
 *inserted into a binary search tree object. The original array passed as parameter is printed. Additionally, the inOrder,
 * preOrder and postOrder forms of the tree are displayed. 
 *</p>
 *
 *********************************************************************************************************************
 *                       @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                            
 *********************************************************************************************************************
 * 
 *
 */
public class TreeApp 
{


	//have to do the rebalancing during he deletion and 
	//see if the nodes wont lose pointers if I add another function to rebalalnce and
	//pass the node as parameter.

	//insertion rebalancing seems right.
	
	public static void main(String[] args)
	{

		int val = 0;
		
		for(int i = 0; i < 26; i++)
		{
			val += Math.pow(2, i);
		}
		
	//	System.out.println("Value: " + val);
		/*
		for (int i  = 0; i < 20; i++)
		{
			String key = randKey();
			int vHash = vmHash(key);
			//System.out.println("key " + key);
			//System.out.println("Hash " + vHash);
			System.out.println("Mod " + vHash % 100);
			System.out.println();
		}
		 */


		System.out.println("**** Testing the tree ****\n");
		Random r = new Random();
		int[] x = {6,11,9,7,4,5,10,2,19,28,1,-20};

		AVLmap<Integer, Integer> searchTree = new AVLmap<Integer, Integer>();
		//System.out.println("This is the array passed as a parameter:");

		int size = 5000000;
		//int size = 80;
		boolean same [] = new boolean [size];
		int itemsAdded = 0;
		int [] xxx = new int [size];
		//System.out.print("[ ");
		
		long timeA = System.nanoTime();
		
		for(itemsAdded = 0; itemsAdded < size; /**/)
		{
			int adder = Math.abs(r.nextInt()) % size;
			if(same[adder] == false)
			{
				same[adder] = true;
				xxx[itemsAdded] = adder;
				itemsAdded++;
			}
		}
		
		
		
		System.out.println("Seconds to generate " + size + " items: " + (System.nanoTime() - timeA) / Math.pow(10, 9));

		timeA = System.nanoTime();

		for(int i = 0; i < size; i++)
		{
			searchTree.put(xxx[i], xxx[i]);
		}

		System.out.println("Seconds to put " + size + " items: " + (System.nanoTime() - timeA)/ Math.pow(10, 9));

				System.out.println("\nTree Height: " + searchTree.getTreeHeight());
				System.out.println("\nTree Size: " + searchTree.getTreeSize());
//				System.out.println("\nSize by level: ");  searchTree.getSizesbyLevel();
//				System.out.println("\nHeight by level: ");  searchTree.getHeightbyLevel();
//				System.out.println("\nBalance by level: ");  searchTree.getBalancebyLevel();

		timeA = System.nanoTime();

		for( int i = 0; i < size; i ++)
		{
			searchTree.get(xxx[i]);
		}	
		System.out.println("Seconds to get " + size + " items: " + (System.nanoTime() - timeA)/ Math.pow(10, 9));


		timeA = System.nanoTime();
		for( int i = 0; i < size; i ++)
		{
			searchTree.remove(xxx[i]);
		}
		System.out.println("Seconds to remove " + size + " items: " + (System.nanoTime() - timeA)/ Math.pow(10, 9));

		System.out.println("\nTree Height: " + searchTree.getTreeHeight());
		System.out.println("\nTree Size: " + searchTree.getTreeSize());
		System.out.println("\nSize by level: ");  searchTree.getSizesbyLevel();
		System.out.println("\nHeight by level: ");  searchTree.getHeightbyLevel();
		System.out.println("\nBalance by level: ");  searchTree.getBalancebyLevel();

		/*


		System.out.print("\n\n***BINARY SEARCH TREE ***\n");						
		System.out.println("\nPre Order:");
		searchTree.preOrder();
		System.out.println("\nIn Order:");
		searchTree.inOrder();
		System.out.println("\nPost Order:");
		searchTree.postOrder();
		System.out.println("\nLevel Order:");
		searchTree.levelOrder();

		System.out.println("\nMin: " + searchTree.getMin().getData());
		System.out.println("\nMax: " + searchTree.getMax().getData());

		searchTree.deleteMin();
		System.out.println("\nIn Order after min delete:");
		searchTree.inOrder();

		searchTree.deleteMax();
		System.out.println("\nIn Order after max delete:");
		searchTree.inOrder();

		searchTree.delete(10);
		System.out.println("\nLevel order delete leaf 10:");
		searchTree.levelOrder();

		searchTree.delete(6);
		System.out.println("\nLevel order delete root 6:");
		searchTree.levelOrder();

		System.out.println("\nSizes by level: ");searchTree.getSizesbyLevel();
		System.out.println("\n\nTree Height: " + searchTree.getHeight());
		System.out.println("\nTree Height by level: ");  searchTree.getHeightbyLevel();
		System.out.println("\nBalance by level: ");  searchTree.getBalancebyLevel();
		 */
	}

	/**
	 * buildHeap method - builds a Heap out of a integer array and prints its values
	 * @param a - the integer array
	 * @param size - the size of the array.
	 */
	public static void buildHeap(int[] a,int size){
		for(int i=size/2-1;i>=0;i--)
			heapify(a,i,size);

		// print the heap
		for(int i=0;i<size;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}	

	/**
	 * heapify - private method called by builHeap method which makes a heap out of a tree
	 * @param a - the array of integers representing the tree
	 * @param i - the size parameter divided by two
	 * @param size - the size parameter passed into buildHeap method
	 */
	private static void heapify(int[] a, int i, int size)
	{	
		int l = 2 * i + 1;		// left child		
		int r = 2 * i + 2;		// right child
		int largest=i;			// parent

		if(l <= size-1)
			//System.out.println("comparing " + a[l] + " and " + a[i]);

			// find the larger of the parent and left child
			if(l <= size-1 && a[l] > a[i])
				largest = l;
			else
				largest = i;

		if(r <= size-1)
			//System.out.println("comparing " + a[l] + " and " + a[r]);

			// find the larger of the parent and right child
			if(r <= size-1 && a[r] > a[largest])
				largest = r;

		// swap parent and larger child if necessary
		if(largest != i)
		{
			//System.out.println("swapping " + a[i] + " and " + a[largest]);

			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;

			// repeat heapify all children are in a heap
			heapify(a, largest, size);
		}
		//System.out.println("exiting heapify\n");		
	}

	public static int vmHash(String x)
	{

		String k = x;
		int hash = 0;
		for(int i = 0; i < 4; i++)
		{
			hash |= (int)k.charAt(i);
			//System.out.println("LEtter " + k.charAt(i) + " is " + Integer.toBinaryString(k.charAt(i)));
			if(i != 3)
				hash <<= 7;
		}

		int shift = 0;
		for (int i = 4; i < k.length(); i++)
		{
			hash ^= ((int)k.charAt(i) << shift);
			if (shift > 28)
				shift = 0;
			else
				shift += 6; 
			if(i == k.length() - 1)
				break;
			i++;
			int temp = (int)k.charAt(i);
			temp <<= shift;
			hash ^= temp;
			if (shift > 28)
				shift = 0;
			else
				shift += 7;
			hash >>= 1;
		}

		//System.out.println(Integer.toBinaryString(hash)  + "\n" + Integer.toBinaryString((Integer.MAX_VALUE << 31)));
		hash = (hash ^= Integer.MAX_VALUE << 31);
		//System.out.println(Integer.toBinaryString(hash));
		//System.out.println((int)(0xFFFFFFFF));
		//System.out.println("hash is " + hash);
		//System.out.println(Integer.toBinaryString((int)(0xFFFFFFFF)));
		//System.out.println(Integer.toBinaryString(hash));
		//System.out.println(Integer.toBinaryString(hash)  + " is \n" + Integer.toBinaryString((hash ^= Integer.MAX_VALUE << 31)));
		//System.out.println(" Final " + hash);
		return hash < 0 ? hash * -1 : hash;

	}

	public static String randKey()
	{
		String xx = "a$b&cd=ef]hij[klm,nopq.rstuvxyzABCDEFGHIJKLNOPQR789S6T5U4V32X1YZ ";
		Random r = new Random();
		int x = r.nextInt(12) + 8;
		String result = "";
		for(int i = 0; i < x; i++)
			result += xx.charAt(r.nextInt(60));
		return result;
	}
}
