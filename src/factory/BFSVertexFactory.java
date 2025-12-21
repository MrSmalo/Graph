package factory;

import vertex.BFSVertex;
import vertex.Vertex;

public class BFSVertexFactory<T> implements VertexFactory<T> {

	/**
	 * Creates a new BFSVertex instance with the specified label.
	 * 
	 * @param label the label for the new vertex
	 * @return a new BFSVertex instance
	 */
	@Override
	public Vertex<T> create(T label) {
		return new BFSVertex<T>(label);
	}

}
