package weightStrategies;

import vertex.Vertex;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWeightStrategy<T> implements WeightStrategy<T> {

	/**
	 * Map storing edge weights, where the key is a string representation 
	 * of the edge (source,destination) and the value is the weight.
	 */
	Map<String,Integer> weightTable;
	
	/**
	 * Default constructor initializing the weight table.
	 */
	public AbstractWeightStrategy() {
		super();
		this.weightTable = new HashMap<>();
	}
	
	@Override
	/**
	 * Generates a unique key for the edge based on vertex labels.
	 */
	public String getKey(Vertex<T> vertex1, Vertex<T> vertex2) {
		String v1 = vertex1.getLabel().toString();
		String v2 = vertex2.getLabel().toString();
		return v1 + "," + v2;
	}

	@Override
	/**
	 * Gets the weight of the edge between two vertices.
	 */
	public Integer getWeight(Vertex<T> vertex1, Vertex<T> vertex2) {
		String key = getKey(vertex1, vertex2);
		if (!weightTable.containsKey(key)) {
			return null;
		}
		return weightTable.get(key);
	}

	@Override
	public void printWeights(){
		weightTable.forEach((k,v) -> System.out.println(k + " : " + v));
	}

}
