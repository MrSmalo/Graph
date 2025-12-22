package weightStrategies;

import vertex.Vertex;

/**
 * Strategy interface for managing edge weights in a graph.
 * 
 * @param <T> the type of labels for the vertices
 */
public interface WeightStrategy<T> {
	
	/**
	 * Adds an edge between two vertices with a default weight.
	 * 
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 */
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Adds an edge between two vertices with a specific weight.
	 * 
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 * @param weight the weight to assign to the edge
	 */
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, Integer weight);

	/**
	 * Gets the weight of the edge between two vertices.
	 * 
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 * @return the weight of the edge, or null if it doesn't exist
	 */
	public Integer getWeight(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Generates a unique key representation for an edge.
	 * 
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 * @return the unique key for the edge
	 */
	public String getKey(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Prints the weights of all edges in the graph to the standard output.
	 */
	public void printWeights();
}
