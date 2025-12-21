package vertex;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of the label associated with the vertex
 */
public interface Vertex<T> {

	/**
	 * Gets the label of the vertex.
	 * 
	 * @return the label of the vertex
	 */
	public T getLabel();

	/**
	 * Sets the label for the vertex.
	 * 
	 * @param label the new label for the vertex
	 */
	public void setLabel(T label);

	/**
	 * Prints the vertex details to the standard output.
	 */
	public void printVertex();
	
}
