package weightStrategies;

/**
 * Strategy interface for managing edge weights in a graph.
 * 
 * @param <T> the type of labels for the vertices
 */
public interface WeightStrategy<T> {
	
	/**
	 * Adds an edge between two vertices with a default weight.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 */
	public void addEdge(T label1, T label2);

	/**
	 * Adds an edge between two vertices with a specific weight.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @param weight the weight to assign to the edge
	 */
	public void addEdge(T label1, T label2, Integer weight);

	/**
	 * Gets the weight of the edge between two vertices.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @return the weight of the edge, or null if it doesn't exist
	 */
	public Integer getWeight(T label1, T label2);

	/**
	 * Generates a unique key representation for an edge.
	 * 
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @return the unique key for the edge
	 */
	public String getKey(T label1, T label2);
}
