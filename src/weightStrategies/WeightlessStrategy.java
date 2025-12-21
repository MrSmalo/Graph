package weightStrategies;

public class WeightlessStrategy<T> extends AbstractWeightStrategy<T> {

	/**
	 * Default constructor.
	 */
	public WeightlessStrategy() {
		super();
	}

	@Override
	public void addEdge(T label1, T label2) {
		weightTable.put(getKey(label1,label2),-1);
	}

	@Override
	public void addEdge(T label1, T label2, Integer weight) {
		weightTable.put(getKey(label1,label2),weight);
	}

}
