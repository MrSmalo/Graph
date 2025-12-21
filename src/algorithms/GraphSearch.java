package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * Utility class providing graph search algorithms.
 */
public class GraphSearch {
	
	/**
	 * Performs a Breadth-First Search (BFS) on the given graph starting from the specified value.
	 *
	 * @param <T> the type of labels for the vertices
	 * @param graph the graph to search
	 * @param startValue the label of the starting vertex
	 * @return a list of BFSVertex instances in the order they were discovered
	 */
	public static <T> List<BfsVertex<T>> bfs(Graph<T> graph,T startValue) {
		
		Map<Vertex<T>,BfsVertex<T>> vertices = new HashMap<>(); //change to map from Vertex to SearchVertex
		List<BfsVertex<T>> searchedGraph = new ArrayList<BfsVertex<T>>();
		
		for (Vertex<T> vertice : graph.getAdjList().keySet()) {
			vertices.put(vertice, new BfsVertex<T>(vertice.getLabel()));
		}
		
		
		BfsVertex<T> start = vertices.get(new Vertex<T>(startValue));
		start.setDistance(0);
		start.setColor(Colors.Grey);
		
		Queue<BfsVertex<T>> Q = new LinkedList<>();
		Q.add(start);
		
		while (!Q.isEmpty()) {
			
			BfsVertex<T> v = Q.poll();
			
			for (Vertex<T> neighborVertice : graph.getNeighbor(v.getLabel())) {
				BfsVertex<T> u = vertices.get(neighborVertice);
				if (u.getColor() != Colors.White) {
					continue;
				}
				u.setColor(Colors.Grey);
				u.setDistance(v.getDistance() + 1);
				u.setFrom(v);
				Q.add(u);
			}
			v.setColor(Colors.Black);
			searchedGraph.add(v);
		}
		return searchedGraph;
	}
	 
	
}
