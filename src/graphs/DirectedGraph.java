package graphs;

import vertex.Vertex;
import weightStrategies.WeightStrategy;

import java.util.List;

/**
 * Implementation of a directed graph.
 * In a directed graph, edges have a direction from a source vertex to a destination vertex.
 *
 * @param <T> the type of the label associated with the vertices in the graph
 */
public class DirectedGraph<T> extends AbstractGraph<T>{

	/**
	 * Constructs a DirectedGraph with a specific weight strategy.
	 *
	 * @param strategy the weight strategy to be used
	 */
	public DirectedGraph(WeightStrategy<T> strategy) {
		super(strategy);
	}

	/**
	 * Constructs a DirectedGraph with a specific weight strategy and a list of vertices.
	 * @param strategy
	 * @param vertices
	 */
	public DirectedGraph(WeightStrategy<T> strategy, List<Vertex<T>> vertices) {super(strategy, vertices);}

	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		// Ensure vertices exist
		addVertex(vertex1);
		addVertex(vertex2);
		// Only add if edge does not already exist
		// Check for self-loops
		if (!hasEdge(vertex1, vertex2) && !vertex1.equals(vertex2)) {
			adjVertices.get(vertex1).add(vertex2);
			this.weightStrategy.addEdge(vertex1, vertex2);
		}
	}

	@Override
	public void removeEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		List<Vertex<T>> eV1 = adjVertices.get(vertex1);
		if(eV1 != null) 
			eV1.remove(vertex2);
	}
}