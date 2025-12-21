package graphs;

import java.util.List;
import java.util.Map;

import vertices.Vertex;

/**
 * Represents a generic graph data structure.
 *
 * @param <T> the type of the label associated with the vertices in the graph
 */
public interface Graph<T> {
	
	/**
	 * Creates a vertex with the specified label and adds it to the graph.
	 * If the vertex already exists, no changes are made.
	 *
	 * @param label the label of the vertex to add
	 */
	void addVertex(T label);

	/**
	 * Removes the vertex with the specified label and all its associated incoming and outgoing edges.
	 *
	 * @param label the label of the vertex to remove
	 */
	void removeVertex(T label);

	/**
	 * Adds an edge between two vertices identified by their labels.
	 * If the vertices do not exist, they are created and added to the graph.
	 *
	 * @param label1 the label of the source vertex (or one end in non-directed graphs)
	 * @param label2 the label of the destination vertex (or the other end in non-directed graphs)
	 */
	void addEdge(T label1,T label2);

	/**
	 * Removes the edge between two vertices identified by their labels.
	 *
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 */
	void removeEdge(T label1,T label2);

	/**
	 * Returns the adjacency list representation of the graph.
	 *
	 * @return a map where each key is a vertex and each value is a list of its neighbors
	 */
	public Map <Vertex<T>,List<Vertex<T>>> getAdjList();

	/**
	 * Returns a list of neighbors for the vertex with the specified label.
	 *
	 * @param label the label of the vertex
	 * @return a list of neighbor vertices
	 */
	public List<Vertex<T>> getNeighbor(T label);

	/**
	 * Prints the graph structure to the standard output.
	 * Each vertex is printed followed by its neighbors.
	 */
	public void printGraph();

	/**
	 * Gets the weight of the edge between two vertices.
	 *
	 * @param label1 the label of the source vertex
	 * @param label2 the label of the destination vertex
	 * @return the weight of the edge, or null if the edge doesn't exist
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
	 * Checks if a vertex with the specified label exists in the graph.
	 *
	 * @param label the label of the vertex
	 * @return true if the vertex exists, false otherwise
	 */
	public boolean hasVertex(T label);
		
}