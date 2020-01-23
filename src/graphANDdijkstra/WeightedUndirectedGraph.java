package graphANDdijkstra;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***************************************************************************************************
 *                                 WeightedUndirectedGraph.java
 ***************************************************************************************************
 * 
 * My own implementation of a Weighted Undirected Graph needed to solve the task given 
 * for project 3. I decided to use a matrix for the weights to give quick access.
 * This class only instantiates a Graph from a file. Number of edges, vertices and pairs of
 * vertices must be non negative to avoid IndexOutOfBoundsException. This class was coded
 * without checks and assumes the file follows the pattern and that edges and vertices
 * are non negative. Only method needed to accomplish project 3 and debug are present in this file.
 * Worth noting that many other useful methods could be coded for a more broad use of this class.
 * 
 * Other aspects of this class follow an outline lectured about in class.
 * 
 * *************************************************************************************************
 *                      Queens College - QCID 23651127 - VagnerMachado - Spring 2018
 * *************************************************************************************************
 * 
 * @author Vagner Machado
 *
 */
public class WeightedUndirectedGraph 
{
	private int V;                          // vertices
	private int E;                          // edges
	private LinkedList <Integer>[] adj;     // adjacency list
	private  double [][] weight; 			//for fast access (might be better)


	/**  
	 * Initializes a Weighted Undirected Graph from the specified file in format:
	 * [vertices number]
	 * [edge number]
	 * [from] [to] [weight]
	 * [from] [to] [weight]
	 * [from] [to] [weight] ...
	 * @param  f - a file
	 * Prints a warning if edge parameter and actual added edges do not match
	 */
	
	@SuppressWarnings("unchecked")
	public WeightedUndirectedGraph(File f) 
	{
		Scanner scan = null;
		try 
		{
			scan = new Scanner(f);
		} catch (FileNotFoundException e) 
		{
			System.out.println("Graph input file not found");
			e.printStackTrace();
		}
		
		V = scan.nextInt();
		weight = new double [V][V];
		
		//initializes adj list 
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Integer>();

		int edges = scan.nextInt();

		//reads all the vertices and weights between them
		while(scan.hasNextLine())
		{
			int v = scan.nextInt();
			int w = scan.nextInt();
			double lb = scan.nextDouble();
			weight[v][w] = lb;
			weight[w][v] = lb;
			adj[v].put(w);
			adj[w].put(v);
			E++;
		}

		//warning!
		if (E != edges)
			System.out.println("*** WARNING: Parameter edge and number of added edges do not match ***");
	}

	/**
	 * getWeight - accessor for the weight of two vertices
	 */
	public double getWeight(int v, int w)
	{
		return weight[v][w];
	}

	/**
	 * Returns vertices in this Weighted Undirected Graph
	 * @return the number of vertices in this  Graph
	 */
	public int V() 
	{
		return V;
	}

	/**
	 * Returns edges in this Weighted Undirected Graph
	 * @return the number of edges in this  Graph
	 */
	public int E() 
	{
		return E;
	}


	/**
	 * Returns the  edges adjacent to vertex v
	 * @param v - the vertex being analyzed
	 * @return the edges adjacent to vertex v as an Iterable
	 */
	public Iterable <Integer> adj(int v) 
	{
		return adj[v];
	}

	/**
	 * Uses string builder to append a string format of the graph
	 * @return the number of vertices, the number of edges,
	 * and adjacency list.
	 */
	public String toString() {
		String result = "Vertices: " + V + "  Edges: " + E + "\n";
		for (int v = 0; v < V; v++) {
			result += v + ": ";
			for (int e : adj[v]) {
				result += e + " - " +  weight[v][e] + "  ";
			}
			result += "\n";
		}
		return result;
	}
}