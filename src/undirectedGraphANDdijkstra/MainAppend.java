
package undirectedGraphANDdijkstra;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**<pre>************************************************************************************
 * 										Main.java
 * *****************************************************************************************
 * 
 *The Main class uses the other coded classes to read a file passed in args[0], build an
 *undirected weighted graph and use the Dijkstra algorithm to find the longest of shortest
 *paths from all vertices in the graph.
 *
 * Each vertex and the longest of shortest path weight is written to a file passes on args[1]
 * 
 * @author Vagner Machado
 * 
 *******************************************************************************************
 *         @author VagnerMachado  - QCID 23651127  - Queens College - Spring 2018                                            
 *******************************************************************************************
 *
 * *<a href="http://www.facebook.com/vagnermachado84"> Do you like this code? Let me know! </a>
 *</pre>
 */
public class MainAppend
{
	/**
	 * main - runs the program
	 * @param args - an array of strings as arguments
	 */
	public static void main(String[] args) 
	{
		if(args.length != 2)
		{
			System.out.println("*****************************************************************"
					+ "To run the program to find the longest of shortest paths\n"
					+ "you need to pass two files as arguments. The first file\n"
					+ "must contain a graph representation in this format:\n"
					+ "[Number of Vertices as int]\n"
					+ "[Number of Edges as int]\n"
					+ "[from vertex as int] [to vertex as int] [weight of edge as double]\n"
					+ "[from vertex as int] [to vertex as int] [weight of edge as double]\n"
					+ "[from vertex as int] [to vertex as int] [weight of edge as double]  ... "
					+ "*****************************************************************\n\n");
			return;
		}
	
		//build a graph and  instantiate Dijkstra
		WeightedUndirectedGraph G = new WeightedUndirectedGraph(new File(args[0]));
		DijkstraPath d = new DijkstraPath(G);

		StringBuilder sb = new StringBuilder();
		//finds the longest shortest path
		for(int i = 0; i < G.V(); i++)
		{
			//append to file instead of concatenate to string
			
				sb.append(i + ": " + d.findFar(i) + "\n");
		}
		
		//write and close file
		try 
		{
			FileWriter f = new FileWriter(new File (args[1]));
			f.append(sb.toString());
			f.close();
		} catch (IOException e)
		{
			System.out.println("\n ***Error writing to File with results ***\n");
			e.printStackTrace();
		}
	}
	
}
