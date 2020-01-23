package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**<pre>
/**********************************************************************************************************************
 *                                                  AVLmap.java                                 
 * ********************************************************************************************************************
 *<strong>Description:</strong> This class allows for the instantiation of a AVLmap that hold Nodes
 * with generic types key and values. The user is able to put, get, remove, check the size of the Map and 
 * if it is empty. A default constructor is defined which makes the root Node null.
 * The key for the entry must extend the Comparable type. This class counts on a private class that defines a Node
 * object used in the AVLmap.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs.
 *
 *********************************************************************************************************************
 *                        @author VagnerMachado - ID 23651127 - Spring 2018 - Queens College                                               
 *********************************************************************************************************************
 *
 * @param <K, V> - are generic types but K must extend Comparable
 * @param <V> - the value for the node
 * @param <K> - the key for the node    </pre>
 */
public class AVLmap<K extends Comparable<K>, V> 
{
	/**
	 * Node class - defines the private fields and constructor for nodes used in AVLmap
	 * @author Vagner Machado
	 * @param <K> - a key that extends Comparable
	 * @param <V> -the node's value
	 */

	@SuppressWarnings("hiding")
	protected class Node<K extends Comparable<K>, V>
	{
		//node instance variable
		private K key;
		private V value;
		private Node<K,V> left;
		private Node<K,V> right;
		private int size;
		private int height;

		/**
		 * Node constructor - instantiates a node with values passed as parameters
		 * @param k - the key
		 * @param v - the value
		 */
		private Node(K k, V v)
		{
			key = k;
			value = v;
			height = 1;
			size = 1;
			left = null;
			right = null;
		}
	}

	//instance data for tree
	private Node<K,V> root;

	public AVLmap()
	{
		root = null;
	}

	/**
	 * AVLrebalance - this method called when rebalancing is required 
	 * @param newRoot - The root that needs rebalancing 
	 * @param balance - The current balance, either -2 or 2 
	 * @return - The root of the rebalanced tree 
	 */
	private Node<K,V> AVLrebalance(Node<K, V> newRoot, int balance) 
	{
		//right right case
		if (balance > 1 && getBalance(newRoot.right) > 0)
			return rotateLeft(newRoot);

		// left left Case
		if (balance < -1 && getBalance(newRoot.left) < 0)
			return rotateRight(newRoot);

		// right left  Case
		if (balance > 1 && getBalance(newRoot.right) < 0) 
		{
			newRoot.right = rotateRight(newRoot.right);
			return rotateLeft(newRoot);
		}

		// left right case
		if (balance < -1 && getBalance(newRoot.left) > 0) 
		{
			newRoot.left = rotateLeft(newRoot.left);
			return rotateRight(newRoot);
		}

		return newRoot;
	}

	/**
	 * rotateRight - rotates a tree to the right
	 * @param y - the root of tree to be rotated
	 * @return - the root of the rotated subtree
	 */
	private Node<K,V> rotateRight(Node<K,V> y)
	{
		Node<K,V> left = y.left;
		Node<K,V> right = left.right;

		// rotate
		left.right = y;
		y.left = right;

		// Update 
		y.height = maxHeight(getHeight(y.left), getHeight(y.right)) + 1;
		y.size = size(y.left) + size(y.right) + 1;

		left.height = maxHeight(getHeight(left.left), getHeight(left.right)) + 1;
		left.size = size(left.left) + size(left.right) + 1;

		//new root
		return left;
	}

	/**
	 * rotateLeft - rotates a tree to the left
	 * @param x - the root of tree to be rotated
	 * @return - the root of the rotated subtree
	 */
	private Node<K,V> rotateLeft(Node<K,V> x)
	{
		Node<K,V> right = x.right;
		Node<K,V> left = right.left;

		// rotate
		right.left = x;
		x.right = left;

		//update
		x.height = maxHeight(getHeight(x.left), getHeight(x.right)) + 1;
		x.size = size(x.left) + size(x.right) + 1;

		right.height = maxHeight(getHeight(right.left), getHeight(right.right)) + 1;
		right.size = size(right.left) + size(right.right) + 1;

		//new root
		return right;
	}


	/**
	 * put - Calls the auxiliary put method 
	 * @param k - the key
	 * @param v - the value
	 */
	public void put(K k, V v)
	{
		root = put(root, k, v);
	}

	/**
	 * put method - inserts a node into the AVL tree object based on its value
	 * @param newRoot - the root of the tree
	 * @param item - the data to be inserted
	 * @return - the new root reassignment
	 */
	private Node<K,V> put(Node<K,V> newRoot, K k, V v)
	{
		if(newRoot == null)
			return new Node<K,V>(k,v);	
		else if(k.compareTo(newRoot.key) == 0) // no repeat
			return newRoot;
		else if(k.compareTo(newRoot.key) < 0)
			newRoot.left = put(newRoot.left, k, v);
		else if (k.compareTo(newRoot.key) > 0)
			newRoot.right = put(newRoot.right, k, v);


		int balance = getBalance(newRoot);
		if (balance < -1 || balance > 1)
			return AVLrebalance(newRoot, balance);
		else
		{
			newRoot.size = size(newRoot.left) + size(newRoot.right) + 1;
			newRoot.height = 1 + maxHeight(getHeight(newRoot.left), getHeight(newRoot.right));
		}

		return newRoot;
	}

	/**
	 * getHeight - accessor for the height of a node
	 * @param node - the node having the height calculated 
	 * @return - the height of the node, 0 for a null node otherwise
	 */
	private int getHeight (Node<K, V> node) 
	{
		if (node == null)
			return 0;	
		return node.height;
	}


	/**
	 * getBalance - calculates the balance of a node
	 * @param node - the node which balance is needed
	 */
	private int getBalance(Node<K,V> node)
	{
		if(node == null)
			return 0;
		else
			return  getHeight(node.right) - getHeight(node.left);
	}

	/**
	 * getMin - accessor for the node with lowest key value
	 * @return - a node with the lowest key value
	 */
	public Node<K,V> getMin()
	{
		return getMin(root);
	}

	/**
	 * getMin - auxiliary function to getMin()
	 * @param  node - the root node in path to min key, root initially
	 * @return node - the node with lowest key value
	 */
	private Node<K,V> getMin(Node<K,V> node)
	{
		if(node.left != null)
			return getMin(node.left);
		else
			return node;
	}

	/**
	 * accessor for the node with the max key value
	 * @return - the node with max key value
	 */
	public Node<K,V> getMax()
	{
		return getMax(root);
	}

	/**
	 * getMax - auxiliary function for getMax()
	 * @param node - the node on the path to max, root initially
	 * @return - the node with max key value
	 */
	private Node<K,V> getMax(Node<K,V> node)
	{
		if(node.right != null)
			return getMax(node.right);
		else
			return node;
	}

	/**
	 * delete min - deletes the node with min value
	 */
	public void deleteMin()
	{
		if(root == null)
			return;
		root =  deleteMin(root);
	}

	/**
	 * deleteMin - deletes the node with minimum value
	 * @param root - the root of tree which node is to be deleted
	 * @return - the new root of the tree result of the deletion
	 */
	private Node<K,V> deleteMin(Node <K,V> root)
	{
		if(root.left == null)
			return root.right;
		else
		{
			root.left = deleteMin(root.left);

			int balance = getBalance(root);
			if (balance < -1 || balance > 1)
				return AVLrebalance(root, balance);
			else
			{
				root.size = size(root.left) + size(root.right) + 1;
				root.height = 1 + maxHeight(getHeight(root.left), getHeight(root.right));
			}
		}
		return root;
	}

	/**
	 * remove - calls the auxiliary method remove(root,k)
	 * @param k - the key of node to be removed
	 */
	public void remove(K k)
	{
		if (root == null)
			return;
		root = remove(root, k);
	}

	/**
	 * remove - private method used to remove a node from the tree
	 * @param node - the node inthe remove recursion
	 * @param key - the key of node to be removed
	 * @return - the root of subtree resulted from the removal 
	 */
	private Node<K,V> remove(Node<K,V> node, K key)
	{
		if (node == null)
			return null;
		if (key.compareTo(node.key) < 0)
			node.left = remove(node.left, key);
		if (key.compareTo(node.key) > 0)
			node.right = remove(node.right, key);
		if (key.compareTo(node.key) == 0)
		{
			if(node.left == null && node.right != null)
				return node.right;
			else if(node.right == null && node.left != null)
				return node.left;
			else if (node.right == null && node.left == null )
				return null;
			else
			{
				Node<K,V> temp = node;
				node = getMin(node.right);
				node.right = deleteMin(temp.right);
				node.left = temp.left;

				int balance = getBalance(node);

				if(balance < -1 || balance > 1)
					return AVLrebalance(node, balance);
				else
				{
					node.size = size(node.left) + size(node.right) + 1;
					node.height = 1 + maxHeight(getHeight(node.left), getHeight(node.right));
				}
			}
		}
		return node;
	}

	/**
	 * get - accessor for the value associated with key passed as parameter
	 * @param - the key
	 * @return V - the value associated with the key
	 */
	public V get(K key) 
	{
		if (root == null)
			return null;
		Node <K,V> trav = root;
		while(trav != null)
		{
			if(trav.key.compareTo(key) == 0)
				return trav.value;
			else if (trav.key.compareTo(key) < 0)
				trav = trav.right;
			else if (trav.key.compareTo(key) > 0)
				trav = trav.left;
		}
		return null;		
	}

	/**
	 * getTreeSize - accessor for the size of the tree
	 * @return - the size of the root node which is the size of the tree
	 */
	public int getTreeSize()
	{
		if(root == null)
			return 0;
		return root.size;

	}

	/**
	 * size - accessor for the size of the tree
	 * @return - the size of the root node which is the size of the tree
	 */
	public int size()
	{
		return getTreeSize();
	}

	/**
	 * getTreeHeihgt - accessor for the height of the tree
	 * @return - the height of the root node which is the height of the tree
	 */
	public int getTreeHeight()
	{
		if(root == null)
			return 0;
		return root.height;
	}

	/**
	 * size - private accessor method for the height of a node
	 * @param node - the node which height is needed
	 * @return - the node's height, 0 if null
	 */
	private int size(Node<K,V> node)
	{
		if (node == null)
			return 0;
		return node.size;
	}

	/**
	 * maxHeight - used to compare tree heights
	 * @param a -  a height
	 * @param b -  another height   
	 * @return - the greater one
	 */
	private int maxHeight( int a, int b)
	{
		if(a <= b)
			return b;
		return a;
	}

	/**
	 * getSizesbyLevel - calls the auxiliary method getSizesbyLevel(root)
	 */
	public void getSizesbyLevel()
	{
		if(root == null)
			return;
		getSizesbyLevel(root);
	}

	/**
	 * getSizesbyLevel - prints the sizes of AVL tree by level
	 * @param newRoot - the root of the tree
	 */
	private void getSizesbyLevel(Node<K,V> newRoot)
	{
		Queue<Node<K,V>> q1 = new LinkedList<Node<K,V>>();
		q1.add(newRoot);
		while(!q1.isEmpty())
		{
			Node<K,V> node = q1.remove();
			System.out.print(node.size + " ");
			if(node.left != null) q1.add(node.left);
			if(node.right != null) q1.add(node.right);	
		}
	}

	/**
	 * getHeihgtByLevel - calls the auxiliary method getHeihgtByLevel(root)
	 */
	public void getHeightbyLevel() 
	{
		if (root == null)
			return;
		getHeihgtByLevel(root);
	}

	/**
	 * getHeihgtByLevel - prints the heights of the AVL tree by level
	 * @param newRoot - the root of the tree
	 */
	private void getHeihgtByLevel(Node<K, V> newRoot) 
	{
		Queue<Node<K,V>> q1 = new LinkedList<Node<K,V>>();
		q1.add(newRoot);
		while(!q1.isEmpty())
		{
			Node<K,V> node = q1.remove();
			System.out.print(node.height+ " ");

			if(node.left != null) q1.add(node.left);
			if(node.right != null) q1.add(node.right);	
		}

	}

	/**
	 * getBalancebyLevel - calls the auxiliary method getBalancebyLevel(root)
	 */
	public void getBalancebyLevel()
	{
		if(root == null)
			return;
		getBalancebyLevel(root);
	}

	/**
	 * getBalanceByLevel - prints the balance of AVL tree by level
	 * @param newRoot - the root of the three
	 */
	private void getBalancebyLevel(Node<K,V> newRoot)
	{
		Queue<Node<K,V>> q1 = new LinkedList<Node<K,V>>();
		q1.add(newRoot);
		while(!q1.isEmpty())
		{
			Node<K,V> node = q1.remove();
			System.out.print(getBalance(node) + " ");
			if(node.left != null) q1.add(node.left);
			if(node.right != null) q1.add(node.right);	
		}
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
	 * preOrder method - prints the AVL search tree in a pre order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void preOrder(Node<K,V> newRoot)
	{
		if(newRoot != null)
		{
			System.out.print(newRoot.value + " ");
			preOrder(newRoot.left);
			preOrder(newRoot.right);					
		}
	}

	/**
	 * inOrder method - prints the AVL search tree in a in order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void inOrder(Node<K,V> newRoot)
	{
		if(newRoot != null)
		{
			inOrder(newRoot.left);
			System.out.print(newRoot.value + " ");
			inOrder(newRoot.right);					
		}
	}

	/**
	 * postOrder method - prints the AVL search tree in a post order format
	 * @param newRoot - the node sent to the recursion
	 */
	private void postOrder(Node<K,V> newRoot)
	{
		if(newRoot != null)
		{
			postOrder(newRoot.left);
			postOrder(newRoot.right);
			System.out.print(newRoot.value+ " ");					
		}
	}

	/**
	 * levelOrder method - prints the AVL search tree in a level order format
	 * @param newRoot - the root of the binary search tree
	 */
	private void levelOrder(Node<K,V> newRoot)
	{
		if(newRoot == null)
			return;
		Queue<Node<K,V>> q1 = new LinkedList<Node<K,V>>();
		q1.add(newRoot);
		while(!q1.isEmpty())
		{
			Node<K,V> node = q1.remove();
			System.out.print(node.value + " ");
			if(node.left != null) 
				q1.add(node.left);
			if(node.right != null)
				q1.add(node.right);	
		}
	}

}
