package vertex.factory;

import vertex.DFSVertex;
import vertex.Vertex;

public class DFSVertexFactory<T> implements VertexFactory<T> {

	/**
	 * Creates a new DFSVertex instance with the specified label.
	 * 
	 * @param label the label for the new vertex
	 * @return a new DFSVertex instance
	 */
	@Override
	public Vertex<T> create(T label) {
		return new DFSVertex<T>(label);
	}

}
