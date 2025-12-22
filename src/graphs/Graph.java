package graphs;

import vertex.Vertex;

import java.util.List;
import java.util.Map;

/**
 * Represents a generic graph data structure.
 *
 * @param <T> the type of the label associated with the vertices in the graph
 */
public interface Graph<T> {
	
	/**
	 * Creates a vertex and adds it to the graph.
	 * If the vertex already exists, no changes are made.
	 *
	 * @param vertex the vertex to add
	 */
	void addVertex(Vertex<T> vertex);

	/**
	 * Removes the specified vertex and all its associated incoming and outgoing edges.
	 *
	 * @param vertex the vertex to remove
	 */
	void removeVertex(Vertex<T> vertex);

	/**
	 * Adds an edge between two vertices.
	 * If the vertices do not exist, they are added to the graph.
	 *
	 * @param vertex1 the source vertex (or one end in non-directed graphs)
	 * @param vertex2 the destination vertex (or the other end in non-directed graphs)
	 */
	void addEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Removes the edge between two vertices.
	 *
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 */
	void removeEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Returns the adjacency list representation of the graph.
	 *
	 * @return a map where each key is a vertex and each value is a list of its neighbors
	 */
	public Map<Vertex<T>, List<Vertex<T>>> getAdjList();

	/**
	 * Returns the adjacency list size.
	 *
	 * @return int the size of the adjacency list
	 */
	public int getAdjListSize();

	/**
	 * Returns a list of neighbors for the specified vertex.
	 *
	 * @param vertex the vertex
	 * @return a list of neighbor vertices
	 */
	public List<Vertex<T>> getNeighbor(Vertex<T> vertex);

	/**
	 * Prints the graph structure to the standard output.
	 * Each vertex is printed followed by its neighbors.
	 */
	public void printGraph();

	/**
	 * Gets the weight of the edge between two vertices.
	 *
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 * @return the weight of the edge, or null if the edge doesn't exist
	 */
	public Integer getWeight(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Checks if an edge exists between two vertices.
	 *
	 * @param vertex1 the source vertex
	 * @param vertex2 the destination vertex
	 * @return true if the edge exists, false otherwise
	 */
	public boolean hasEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	/**
	 * Checks if the specified vertex exists in the graph.
	 *
	 * @param vertex the vertex
	 * @return true if the vertex exists, false otherwise
	 */
	public boolean hasVertex(Vertex<T> vertex);
		
}