package weightStrategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//A function that give each Edge a Random weight
public class RandomStrategy<T> implements WeightStrategy<T> {

	Map<String,Integer> weightTable;
	
	//Create a new HashMap that built as <Key = (String) label1 + label2, Value = Integer>
	public RandomStrategy(){
		weightTable = new HashMap<>();
	}
	
	private String getKey(T label1,T label2) {
		String v1 = label1.toString();
		String v2 = label2.toString();
		return v1 + "," + v2; 
	}
	
	public int randomWeight() {
		Random rand = new Random();
		return rand.nextInt(100) + 1;
	}
	
	@Override
	public void addEdge(T label1, T label2) {
			int rand = randomWeight();
			weightTable.put(getKey(label1,label2),rand);
	}
	
	@Override
	public void addEdge(T label1, T label2, Integer weight) {
		weightTable.put(getKey(label1, label2), weight);
	}
	
	@Override
	public Integer getWeight(T label1,T label2) {
		if (!weightTable.containsKey(getKey(label1,label2))) {
			return null;
		}
		return weightTable.get(getKey(label1,label2));
				
	}

	

}
