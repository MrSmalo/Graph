package weightStrategies;

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
		weightTable = new HashMap<>();
	}
	
	@Override
	/**
	 * Generates a unique key for the edge based on vertex labels.
	 */
	public String getKey(T label1,T label2) {
		String v1 = label1.toString();
		String v2 = label2.toString();
		return v1 + "," + v2;
	}

	@Override
	/**
	 * Gets the weight of the edge between two vertices.
	 */
	public Integer getWeight(T label1, T label2) {
		if (!weightTable.containsKey(getKey(label1,label2))) {
			return null;
		}
		return weightTable.get(getKey(label1,label2));
	}

}
