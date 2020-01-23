package trees;

import java.util.Random;

//import java.util.TreeSet;
/************************************************************************************************************************
 *       This is the only class for Lab9, in which I tested my hand written answers for the question 1 of lab           *
 * **********************************************************************************************************************
 * 
 *<b>Title:</b>	Lab 9: Search Tree <br>
 *<b>Filename:</b>	TreeApp.java<br>
 *<b>Date Written:</b>	May, 2016<br>
 *<b>Due Date:</b> May 7th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p> This class makes use of the code defined in the BinarySearchTree class, and contains an integer array whose members are 
 *inserted into a binary search tree object. The original array passed as parameter is printed. Additionally, the inOrder,
 * preOrder and postOrder forms of the tree are displayed. 
 *</p>
 *
 ***********************************************************************************************************************************
 *                       @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                             *           
 ***********************************************************************************************************************************
 * 
 *
 */
public class App 
{

	public static void main(String[] args)
	{
Random r = new Random();
		System.out.println("**** Testing the answers for the lab 9, quetion 1 ****\n");

		int[] x = {6,11,9,7,4,5,10,2,19,28,1};
		
		Tree<Integer> searchTree = new Tree<Integer>();
		System.out.println("This is the array passed as a parameter:");


		System.out.print("[ ");
		for(int i=0; i < 1000; i++){
			int xx = r.nextInt(100);
			//System.out.print(xx + " ");
			
			searchTree.insert(xx);
		}
		System.out.print("]\n");
		System.out.print("\n***BINARY SEARCH TREE ***\n");						
		System.out.println("\nPre Order:");
		searchTree.preOrder();
		System.out.println("\nIn Order:");
		searchTree.inOrder();
		System.out.println("\nPost Order:");
		searchTree.postOrder();
		System.out.println("\nLevel Order:");
		searchTree.levelOrder();

		System.out.println("\nHeapfy:");
		buildHeap(x, x.length);


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
}
