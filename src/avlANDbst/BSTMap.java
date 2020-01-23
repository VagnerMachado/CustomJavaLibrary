package avlANDbst;
import java.util.LinkedList;
import java.util.Queue;

/**
/**********************************************************************************************************************
 *                                                  BSTMap.java                                 
 * ********************************************************************************************************************
 *<strong>Description:</strong> This class allows for the instantiation of a BSTMap that hold Nodes
 * with generic types key and values. The user is able to put, get, remove, check if a BSTMap contains an
 * element, the size of the Map and if it is empty. A default constructor is defined which makes the root Node null.
 * The key for the entry must extend the Comparable type. This class counts on a private class that defines a Node
 * object used in the BSTMap.
 *  
 *       For information about other classes and methods used for this project, please refer to their javadocs.
 *
 *********************************************************************************************************************
 *                        @author VagnerMachado - ID 23651127 - Spring 2018 - Queens College                                               
 *********************************************************************************************************************
 *
 * @param <K, V> - are generic types but K must extend Comparable
 * @param <V> - the value for the node
 * @param <K> - the key for the node
 */

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> 
{
	/**
	 * Description: This private class enables the BSTMap class to create a new node each time a new 
	 * child is instantiated. Each node contains key and value data, the reference to a left and right 
	 * nodes that are initially null.
	 *
	 *
	 * @param <K,V> - a generic type
	 */
	@SuppressWarnings("hiding")
	private class Node<K, V>
	{
		//node instance variable
		private K key;
		private V value;
		private Node<K,V> left;
		private Node<K,V> right;
		private int size;

		/**
		 * node constructor - instantiates a node with values passed as parameters
		 * @param k - the key
		 * @param v - the value
		 */
		Node(K k, V v)
		{
			key = k;
			value = v;
			size = 1;
			left = null;
			right = null;
		}

	}

	//instance data for BSTMap
	private Node<K,V> root;

	public BSTMap()
	{
		root = null;
	}


	/**
	 * insert method - calls the auxiliary insert method
	 * @param item
	 */
	public void put(K k, V v)
	{
		root = put(root, k, v);
	}

	/**
	 * insert method - inserts the node into the binary search tree object based on its value
	 * @param newRoot - the root of the tree
	 * @param item - the data to be inserted
	 * @return - the root that will cause the recursion
	 */
	private Node<K,V> put(Node<K,V> newRoot, K k, V v)
	{
		if(newRoot == null)
		{
			newRoot = new Node<K,V>(k,v);
			newRoot.size = 1;
			return newRoot;
		}
		else if(k.compareTo(newRoot.key) == 0) // no repeat, ignored
		{
			return newRoot;
		}
		else if(k.compareTo(newRoot.key) < 0)
			newRoot.left = put(newRoot.left, k, v);
		else if (k.compareTo(newRoot.key) > 0)
			newRoot.right = put(newRoot.right, k, v);

		newRoot.size = 1 + size(newRoot.left) + size(newRoot.right);

		return newRoot;
	}

	/**
	 * preOrder method - calls the auxiliary method preOrder
	 */
	public void preOrder()
	{
		System.out.print("[");
		preOrder(root);
		System.out.print("]\n");
	}	

	/**
	 * inOrder method - calls the auxiliary method inOrder
	 */
	public void inOrder()
	{
		System.out.print("[");
		inOrder(root);
		System.out.print("]\n");
	}

	/**
	 * postOrder method - calls the auxiliary method postOrder
	 */
	public void postOrder()
	{
		System.out.print("[");
		postOrder(root);
		System.out.print("]\n");
	}

	/**
	 * levelOrder method - calls the auxiliary method levelOrder
	 */
	public void levelOrder()
	{
		System.out.print("[");
		levelOrder(root);
		System.out.print("]\n");
	}

	/**
	 * preOrder method - prints the binary search tree in a pre order format
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
	 * inOrder method - prints the binary search tree in a in order format
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
	 * postOrder method - prints the binary search tree in a post order format
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
	 * levelOrder method - prints the binary search tree in a level order format
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
		//root.size = 1 + size(root.left) + size(root.right);

	}
	/**
	 * deleteMin -  deletes the node with min key in BSTMap
	 * @param root - the node with possibly min key
	 * @return - a node as result of the operation
	 */
	private Node<K,V> deleteMin(Node <K,V> root)
	{
		if(root.left == null)
			return root.right;
		else
		{
			root.left = deleteMin(root.left);
		}
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}

	/**
	 * deleteMax -  deletes the node with max key in BSTMap
	 */
	public void deleteMax()
	{
		if(root == null)
			return;

		root =  deleteMax(root);
		//root.size = 1 + size(root.left) + size(root.right);
	}

	/**
	 * deleteMax -  deletes the node with max key in BSTMap
	 * @param root - the node with possibly max key
	 * @return - a node as result of the operation
	 */
	private Node<K,V> deleteMax(Node <K,V> root)
	{
		if(root.right == null)
			return root.left;
		else
		{
			root.right = deleteMax(root.right);
		}

		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}

	/**
	 * /**
	 * remove - removes a node from BSTMap based on the key passed
	 * @param key - the key of node to be deleted
	 */
	public void remove(K k)
	{
		if (root == null)
			return;
		root = remove(root, k);
	}

	/**
	 * remove - removes a node from BSTMap based on the key passed
	 * @param node - the possible node to be removed
	 * @param key - the key of node to be deleted
	 * @return - a node as result of the operation
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
			}
		}
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}


	/**
	 * getTreeSize - suggestive method
	 * @return the size of the tree
	 */
	public int getTreeSize()
	{
		return size();
	}

	/**
	 * getSizesbyLevel - used during testing. Calls private method below to get sizes by level
	 */
	public void getSizesbyLevel()
	{
		if(root == null)
			return;
		getSizesbyLevel(root);
	}
	/**
	 * getSizesbyLevel - used during testing. Prints the node sizes by level
	 * @param newRoot - the first node to be analyzed
	 */
	private void getSizesbyLevel(Node<K,V> newRoot)
	{
		Queue<Node<K,V>> q1 = new LinkedList<Node<K,V>>();
		q1.add(newRoot);
		while(!q1.isEmpty())
		{
			Node<K,V> node = q1.remove();
			System.out.print(size(node)+ " ");
			if(node.left != null) q1.add(node.left);
			if(node.right != null) q1.add(node.right);	
		}
	}

	/**
	 * size - private method to find the size of a specific node
	 * @param node - the node for which size is needed
	 * @return - the size of the param node
	 */
	private int size(Node<K,V> node)                                            
	{
		if (node == null)
			return 0;
		return node.size;
	}

	@Override
	/**
	 * get - accessor for value associated with key passed as parameter
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

	@Override
	/**
	 * size - accessor for the size of the BSTMap
	 */
	public int size() 
	{
		return root.size;

	}

	@Override
	/**
	 * isEmpty - let's the program know if the BSTMap is empty
	 * @return true if size is 0, false otherwise
	 */
	public boolean isEmpty() 
	{
		return root.size == 0;
	}

}
