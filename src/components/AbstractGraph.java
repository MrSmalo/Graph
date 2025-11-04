package components;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import weightStrategies.WeightStrategy;

public abstract class AbstractGraph<T> implements Graph<T> {
	
	protected Map <Vertex<T>,List<Vertex<T>>> adjVertices;
	protected WeightStrategy<T> weightStrategy;
	
	//Define the kind of strategy we are going to use
	public AbstractGraph(WeightStrategy<T> strategy) {
		adjVertices = new HashMap <>();
		this.weightStrategy = strategy;
	}
	
	@Override
	public void addVertex(T label) {
		adjVertices.putIfAbsent(new Vertex<T>(label), new LinkedList<Vertex<T>>());
	}

	@Override
	public void removeVertex(T label) {
		Vertex<T> v = new Vertex<T>(label);
		adjVertices.values().stream().forEach(e-> e.remove(v));
		adjVertices.remove(new Vertex<T>(label));		
	}
	@Override
	public void printGraph() {
		adjVertices.forEach((e,n)->{
			e.printVertex();
			System.out.print(" -> ");
			n.forEach(m-> {
				m.printVertex();
				System.out.print(" ");
				});
			System.out.println();
		});
	}

	@Override
	public abstract void addEdge(T label1, T label2);

	@Override
	public abstract void removeEdge(T label1, T label2);
	
	@Override
	public Integer getWeight(T label1,T label2) {
		return weightStrategy.getWeight(label1, label2);
	}
	
	@Override
	public boolean hasEdge(T label1, T label2) {
		Vertex<T> v1 = new Vertex<T>(label1);
		Vertex<T> v2 = new Vertex<T>(label2);
		List<Vertex<T>> neighbors = adjVertices.get(v1);
		return neighbors != null && neighbors.contains(v2);
	}
	
	@Override
	public boolean hasVertex(T label) {
		Vertex<T> v = new Vertex<T>(label);
		return adjVertices.containsKey(v);
	}
	
}