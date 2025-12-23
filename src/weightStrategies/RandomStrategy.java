package weightStrategies;

import vertex.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//A function that give each Edge a Random weight
public class RandomStrategy<T> extends AbstractWeightStrategy<T> {
	
	/**
	 * Default constructor initializing the weight table.
	 */
	public RandomStrategy(){
		super();
	}

	/**
	 * Generates a random weight between 1 and 100.
	 * 
	 * @return a random integer weight
	 */
	public int randomWeight() {
		Random rand = new Random();
		return rand.nextInt(100) + 1;
	}
	
	@Override
	public String getKey(Vertex<T> vertex1, Vertex<T> vertex2) {
		String v1 = vertex1.getLabel().toString();
		String v2 = vertex2.getLabel().toString();
		return v1 + "," + v2;
	}

	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
			int rand = randomWeight();
			weightTable.put(getKey(vertex1, vertex2), rand);
	}
	
	@Override
	public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, Integer weight) {
		weightTable.put(getKey(vertex1, vertex2), weight);
	}
	
	@Override
	public Integer getWeight(Vertex<T> vertex1, Vertex<T> vertex2) {
		String key = getKey(vertex1, vertex2);
		if (!weightTable.containsKey(key)) {
			return null;
		}
		return weightTable.get(key);
	}

}
