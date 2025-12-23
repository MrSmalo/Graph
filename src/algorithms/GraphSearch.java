package algorithms;

import graphs.Graph;
import vertex.Vertex;
import vertex.BFSVertex;
import vertex.Color;

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
	 * Performs a Breadth-First Search (BFS) on the given graph starting from the specified vertex.
	 *
	 * @param <T> the type of labels for the vertices
	 * @param graph the graph to search
	 * @param startVertex the starting vertex
	 * @return a list of BFSVertex instances in the order they were discovered
	 */
	public static <T> List<BFSVertex<T>> bfs(Graph<T> graph, Vertex<T> startVertex) {
		
		Map<Vertex<T>, BFSVertex<T>> vertices = new HashMap<>(); 
		List<BFSVertex<T>> searchedGraph = new ArrayList<>();
		
		for (Vertex<T> vertex : graph.getAdjList().keySet()) {
			vertices.put(vertex, new BFSVertex<>(vertex.getLabel()));
		}
		
		
		BFSVertex<T> start = vertices.get(startVertex);
		if (start == null) {
			return searchedGraph;
		}
		
		start.setDistance(0);
		start.setColor(Color.Grey);
		
		Queue<BFSVertex<T>> Q = new LinkedList<>();
		Q.add(start);
		
		while (!Q.isEmpty()) {
			
			BFSVertex<T> v = Q.poll();
			
			List<Vertex<T>> neighbors = graph.getNeighbor(v);
			if (neighbors != null) {
				for (Vertex<T> neighborVertex : neighbors) {
					BFSVertex<T> u = vertices.get(neighborVertex);
					if (u == null || u.getColor() != Color.White) {
						continue;
					}
					u.setColor(Color.Grey);
					u.setDistance(v.getDistance() + 1);
					u.setFrom(v);
					Q.add(u);
				}
			}
			v.setColor(Color.Black);
			searchedGraph.add(v);
		}
		return searchedGraph;
	}
	 
	
}
