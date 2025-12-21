package factory;

import vertex.Vertex;

/**
 * Factory interface for creating Vertex instances.
 * 
 * @param <T> the type of labels for the vertices
 */
public interface VertexFactory<T> {
	/**
	 * Creates a new Vertex instance with the specified label.
	 * 
	 * @param label the label for the new vertex
	 * @return a new Vertex instance
	 */
	Vertex<T> create(T label);
}