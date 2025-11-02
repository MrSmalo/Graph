package weightStrategies;

//An abstract class that define the weight function strategy
public interface WeightStrategy<T> {
	
	//Adding an Edge to an hashMap which save the weight size
	public void addEdge(T label1, T label2);
	
	//Adding an Edge with a specific value
	public void addEdge(T label1, T label2, Integer weight);
	
	//Get the weight of the Edge. Weight is an Integer 
	public Integer getWeight(T label1, T label2);
}
