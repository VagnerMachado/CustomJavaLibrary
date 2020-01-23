package undirectedGraphANDdijkstra;


/**<pre>
 * ********************************************************************************************************************
 *      									     DijkstraPath.java       					                          
 * ********************************************************************************************************************
 * 
 * <strong>Description:</strong> This class allows for the instantiation of an object whose sole purpose is to 
 * use the Dijkstra algorithm to find the vertex farthest away from the source vertex. The class is modified to 
 * reduce the amount of instantiations when finding the farthest vertex from all vertices in a graph. It operated
 * a few seconds faster on my computer this way instead of using multiple instantiations in the main method.
 * This class contains only the methods necessary to accomplish the tak for project 3. Many other methods could
 * be coded for a broader use of the class. 
 * 
 *********************************************************************************************************************
 *     		             @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *********************************************************************************************************************
 *
 *
 *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */

public class DijkstraPath
{
	private boolean [] distFound;
	private double  [] distTo;
	private HeapPQ<Double, Integer> pq;
	private int vertices;
	private WeightedUndirectedGraph g;
	private double max;

	/**
	 *  DijkstraPath constructor - Initiates an object based on undirected weighted graph
	 *  passed as parameter
	 * @param g - an undirected weighted graph
	 */
	public DijkstraPath(WeightedUndirectedGraph g)
	{
		vertices = g.V();
		this.g= g;
		max = 0;
	}

	/**
	 * findFar - finds the farthest vertex using longest of shortest path from source
	 * @param source - the source vertex
	 */
	public double findFar(int source)
	{
		distFound = new boolean [vertices];
		distTo = new double [vertices];
		pq = new HeapPQ<Double, Integer>();

		distTo[source] = 0;
		pq.enqueue(0,source);
		int vertex = 0;
		while(!pq.isEmpty())
		{
			vertex = pq.dequeue().getVertex();
			if (!distFound[vertex])
				relax(g, vertex);
		}	
		return max;
	}

	/**
	 * distanceTo - gets a distance to a vertex, must be called after findFar(int source)
	 * @param x - the vertex being looked for 
	 * @return - the distance from source to vertex.
	 */
	public double distanceTo(int x)
	{
		return distTo[x];
	}
	
	/**
	 * relax - private method called by findFar. Sets a distance to found and
	 * enqueues all the adjacent vertices to vertex with distance not found.
	 * @param g - a graph
	 * @param vertex - the vertex being relaxed
	 */
	private void relax(WeightedUndirectedGraph g, int vertex)
	{
		distFound[vertex] = true;
		max = distTo[vertex];
		for(int x : g.adj(vertex))
		{
			if(distFound[x] == false)
			{
				double newDist = distTo[vertex] + g.getWeight(x, vertex);
				if(distTo[x] == 0 || distTo[x] > newDist)
				{
					pq.enqueue(newDist, x);
					distTo[x] = newDist;
				}
			}
		}
	}
}


