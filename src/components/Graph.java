package components;

/**
 * Interface for a Graph data structure.
 * 
 * @param <T> the type of labels for the vertices
 */
public interface Graph<T> {
	
	/**
	 * Creates a vertex with the given label and adds it to the graph.
	 * 
	 * @param label the label of the vertex to add
	 */
	void addVertex(T label);

	/**
	 * Removes the vertex with the given label and all its associated edges.
	 * 
	 * @param label the label of the vertex to remove
	 */
	void removeVertex(T label);

	/**
	 * Connects two vertices with an edge.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 */
	void addEdge(T label1, T label2);

	/**
	 * Removes the edge between two vertices.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 */
	void removeEdge(T label1, T label2);

	/**
	 * Prints the graph structure (adjacency list) to the standard output.
	 */
	public void printGraph();

	/**
	 * Gets the weight of the edge between two vertices.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @return the weight of the edge, or null if no weight is defined or edge doesn't exist
	 */
	public Integer getWeight(T label1, T label2);

	/**
	 * Checks if an edge exists between two vertices.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @return true if the edge exists, false otherwise
	 */
	public boolean hasEdge(T label1, T label2);

	/**
	 * Checks if a vertex with the given label exists in the graph.
	 * 
	 * @param label the label of the vertex to check
	 * @return true if the vertex exists, false otherwise
	 */
	public boolean hasVertex(T label);
		
}