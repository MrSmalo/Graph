package components;

import java.util.List;

import factory.VertexFactory;
import vertex.Vertex;
import weightStrategies.WeightStrategy;

public class DirectedGraph<T> extends AbstractGraph<T>{

	/**
	 * Constructs a DirectedGraph with the given weight strategy and vertex factory.
	 * 
	 * @param strategy the weight strategy to be used
	 * @param factory the vertex factory to be used
	 */
	public DirectedGraph(WeightStrategy<T> strategy, VertexFactory<T> factory) {
		super(strategy, factory);
	}

	@Override
	/**
	 * Adds a directed edge between two vertices. 
	 * Vertices are created if they do not exist.
	 */
	public void addEdge(T label1, T label2) {
//		// Ensure vertices exist
		addVertex(label1);
		addVertex(label2);
		// Only add if edge does not already exist
		if (!hasEdge(label1, label2)) {
			Vertex<T> v1 = factory.create(label1);
			Vertex<T> v2 = factory.create(label2);
			adjVertices.get(v1).add(v2);
			this.weightStrategy.addEdge(label1, label2);
		}
	}

	@Override
	/**
	 * Removes the directed edge between two vertices.
	 */
	public void removeEdge(T label1, T label2) {
		Vertex<T> v1 = factory.create(label1);
		Vertex<T> v2 = factory.create(label2);
		List<Vertex<T>> eV1 = adjVertices.get(v1);
		if(eV1 != null) 
			eV1.remove(v2);
	}
}