package components;

import java.util.List;

import weightStrategies.WeightStrategy;

public class DirectedGraph<T> extends AbstractGraph<T>{

	public DirectedGraph(WeightStrategy<T> strategy) {
		super(strategy);
	}

	@Override
	public void addEdge(T label1, T label2) {
		// Ensure vertices exist
		addVertex(label1);
		addVertex(label2);
		// Only add if edge does not already exist
		if (!hasEdge(label1, label2)) {
			Vertex<T> v1 = new Vertex<>(label1);
			Vertex<T> v2 = new Vertex<>(label2);
			adjVertices.get(v1).add(v2);
			this.weightStrategy.addEdge(label1, label2);
		}
	}

	@Override
	public void removeEdge(T label1, T label2) {
		Vertex<T> v1 = new Vertex<T>(label1);
		Vertex<T> v2 = new Vertex<T>(label2);
		List<Vertex<T>> eV1 = adjVertices.get(v1);
		if(eV1 != null) 
			eV1.remove(v2);
	}
}