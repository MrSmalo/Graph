package factory;

import vertex.BasicVertex;
import vertex.Vertex;

public class BasicVertexFactory<T> implements VertexFactory<T> {

	/**
	 * Creates a new BasicVertex instance with the specified label.
	 * 
	 * @param label the label for the new vertex
	 * @return a new BasicVertex instance
	 */
	@Override
	public Vertex<T> create(T label) {
		return new BasicVertex<T>(label);
	}

}
