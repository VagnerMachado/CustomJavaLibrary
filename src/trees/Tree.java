package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
/**********************************************************************************************************************************
 *                      Please refer to the TreeApp.java for a brief description of the lab 9                                     *
 * ********************************************************************************************************************************
 * 
 *<b>Title:</b>	Lab 9: Search Trees <br>
 *<b>Filename:</b>	BinarySearchTree.java<br>
 *<b>Date Written:</b>	May, 2016<br>
 *<b>Due Date:</b> May 7th, 2016<br>
 *<p>
 **</p>
 *<p><b>Description:</b></p>
 *<p>This class defines the methods and behaviors for a BinarySearchTree object. The methods made available for this class are insert,
 *preOrder, inOrder and postOrder. The description of each method can be found in its javadoc.
 *</p>
 *
 ***********************************************************************************************************************************
 *                         @author VagnerMachado - ID N00820127 - Nassau Community College - Spring 2016                           *           
 ***********************************************************************************************************************************
 *
 * @param <T> - a generic type
 */
public class Tree<T extends Comparable<T>> 
{
	/**
	 * *<b>Title:</b>	Lab 9: Search Trees <br>
	 *<b>Filename:</b>	BinarySearchTree.java<br>
	 *<b>Date Written:</b>	May, 2016<br>
	 *<b>Due Date:</b> May 7th, 2016<br>
	 *<p>
	 **</p>
	 *<p><b>Description:</b></p>
	 *<p>This private class enables the BinarySearchTree class to create a new node each time a new child is instantiated.
	 *Each node contains data, and the reference to a left and right nodes that are initially null.
	 *</p>
	 *
	 * @param <E> - a generic type
	 */
	private class Node<E extends Comparable<E>>
	{
		E data;
		Node<E> left;
		Node<E> right;
		Node(E item)
		{
			data = item;
		}
	}

	//instance data
	private Node<T> root;
	private int size;

	/**
	 * insert method - calls the auxiliary insert method
	 * @param item
	 */
	public void insert(T item){
		root = insert(root, item);
	}
	
	/**
	 * insert method - inserts the node into the binary search tree object based on its value
	 * @param newRoot - the root of the tree
	 * @param item - the data to be inserted
	 * @return - the root that will cause the recursion
	 */
	private Node<T> insert(Node<T> newRoot, T item){
		if(newRoot == null)
			newRoot = new Node<T>(item);
		else if(item.compareTo(newRoot.data) < 0)
			newRoot.left = insert(newRoot.left, item);
		else
			newRoot.right = insert(newRoot.right, item);
		size++;
		return newRoot;
	}
	
	/**
	 * preOrder method - calls the auxiliary method preOrder
	 */
	public void preOrder(){
		System.out.print("[");
		preOrder(root);
		System.out.print("]\n");
	}	
	
	/**
	 * inOrder method - calls the auxiliary method inOrder
	 */
	public void inOrder(){
		System.out.print("[");
		inOrder(root);
		System.out.print("]\n");
	}
	
	/**
	 * postOrder method - calls the auxiliary method postOrder
	 */
	public void postOrder(){
		System.out.print("[");
		postOrder(root);
		System.out.print("]\n");
	}
	
	/**
	 * levelOrder method - calls the auxiliary method levelOrder
	 */
	public void levelOrder(){
		System.out.print("[");
		levelOrder(root);
		System.out.print("]\n");
	}
	
	/**
	 * preOrder method - prints the binary search tree in a pre order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void preOrder(Node<T> newRoot){
		if(newRoot != null){
			System.out.print(newRoot.data + " ");
			preOrder(newRoot.left);
			preOrder(newRoot.right);					
		}
	}
	
	/**
	 * inOrder method - prints the binary search tree in a in order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void inOrder(Node<T> newRoot){
		if(newRoot != null){
			inOrder(newRoot.left);
			System.out.print(newRoot.data+ " ");
			inOrder(newRoot.right);					
		}
	}
	
	/**
	 * postOrder method - prints the binary search tree in a post order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void postOrder(Node<T> newRoot){
		if(newRoot != null){
			postOrder(newRoot.left);
			postOrder(newRoot.right);
			System.out.print(newRoot.data+ " ");					
		}
	}
	
	/**
	 * levelOrder method - prints the binary search tree in a level order format
	 * @param newRoot - the root of the binary search tree
	 */
	private void levelOrder(Node<T> newRoot){
		Queue<Node<T>> q1 = new LinkedList<Node<T>>();
		q1.add(newRoot);
		while(!q1.isEmpty()){
			Node<T> node = q1.remove();
			System.out.print(node.data + " ");
			if(node.left != null) q1.add(node.left);
			if(node.right != null) q1.add(node.right);
		}
	}
}
