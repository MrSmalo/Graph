package weightStrategies;

import vertex.Vertex;

public class WeightlessStrategy<T> extends AbstractWeightStrategy<T> {

	/**
	 * Default constructor.
	 */
	public WeightlessStrategy() {
		super();
	}

	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		weightTable.put(getKey(vertex1, vertex2), -1);
	}

	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, Integer weight) {
		weightTable.put(getKey(vertex1, vertex2), weight);
	}

}
