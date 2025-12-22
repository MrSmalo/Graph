package graphs;

import vertex.Vertex;
import weightStrategies.WeightStrategy;

import java.util.List;

/**
 * Implementation of a non-directed (undirected) graph.
 * In a non-directed graph, edges do not have a direction; an edge between vertices A and B 
 * is bidirectional.
 *
 * @param <T> the type of the label associated with the vertices in the graph
 */
public class NonDirectedGraph<T> extends AbstractGraph<T> {
	
	/**
	 * Constructs a NonDirectedGraph with a specific weight strategy.
	 *
	 * @param weightStrategy the weight strategy to be used
	 */
	public NonDirectedGraph(WeightStrategy<T> weightStrategy) {
		super(weightStrategy);
	}
	public NonDirectedGraph(WeightStrategy<T> weightStrategy, List<Vertex<T>> vertices) {super(weightStrategy, vertices);}
	
	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		// Ensure vertices exist
		addVertex(vertex1);
		addVertex(vertex2);
		// Only add if edge does not already exists
		//double-check it
		if (!hasEdge(vertex1, vertex2) && !hasEdge(vertex2, vertex1) && !vertex1.equals(vertex2)) {
			adjVertices.get(vertex1).add(vertex2);
			adjVertices.get(vertex2).add(vertex1);
			this.weightStrategy.addEdge(vertex1, vertex2);
			//this.weightStrategy.addEdge(vertex2, vertex1, this.getWeight(vertex1, vertex2));
		}
	}

	@Override
	public void removeEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		List<Vertex<T>> eV1 = adjVertices.get(vertex1);
		List<Vertex<T>> eV2 = adjVertices.get(vertex2);
		if(eV1 != null)
			eV1.remove(vertex2);
		if(eV2 != null)
			eV2.remove(vertex1);
	}
	
}