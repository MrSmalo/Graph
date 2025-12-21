package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import vertices.Vertex;
import weightStrategies.WeightStrategy;

/**
 * Provides a skeletal implementation of the {@link Graph} interface to minimize the effort required 
 * to implement this interface.
 *
 * @param <T> the type of the label associated with the vertices in the graph
 */
public abstract class AbstractGraph<T> implements Graph<T> {
	
	/**
	 * Map storing the adjacency list where each key is a vertex and each value is a list of its neighbors.
	 */
	protected Map <Vertex<T>,List<Vertex<T>>> adjVertices;
	/**
	 * Strategy used to manage edge weights within the graph.
	 */
	protected WeightStrategy<T> weightStrategy;
	
	/**
	 * Constructs an AbstractGraph with a specific weight strategy.
	 *
	 * @param strategy the weight strategy to be used
	 */
	public AbstractGraph(WeightStrategy<T> strategy) {
		adjVertices = new HashMap <>();
		this.weightStrategy = strategy;
	}
	
	@Override
	public void addVertex(T label) {
		adjVertices.putIfAbsent(new Vertex<>(label), new LinkedList<>());
	}

	@Override
	public void removeVertex(T label) {
		Vertex<T> v = new Vertex<T>(label);
		adjVertices.values().stream().forEach(e-> e.remove(v));
		adjVertices.remove(new Vertex<T>(label));		
	}
	
	public Map<Vertex<T>,List<Vertex<T>>> getAdjList(){
		return adjVertices; 
	}
	
	@Override
	public List<Vertex<T>> getNeighbor(T label) {
		Vertex<T> v = new Vertex<>(label);
 		return adjVertices.get(v);
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