package graphs;

import vertex.Vertex;
import weightStrategies.WeightStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



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
		super();
		adjVertices = new HashMap <>();
		this.weightStrategy = strategy;
	}

	/**
	 * Constructs an AbstractGraph with a specific weight strategy and a list of vertices.
	 * @param strategy
	 * @param vertices
	 */
	public AbstractGraph(WeightStrategy<T> strategy, List<Vertex<T>> vertices) {
		super();
		this.weightStrategy = strategy;
		adjVertices = new HashMap <>();
		adjVertices.putAll(vertices.stream().collect(HashMap::new, (m, v) -> m.put(v, new LinkedList<>()), HashMap::putAll));
	}
	
	@Override
	public void addVertex(Vertex<T> vertex) {
		adjVertices.putIfAbsent(vertex, new LinkedList<>());
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		adjVertices.values().stream().forEach(e -> e.remove(vertex));
		adjVertices.remove(vertex);
	}

	public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
		return adjVertices;
	}

	@Override
	public int getAdjListSize() {
		return adjVertices.size();
	}

	@Override
	public List<Vertex<T>> getNeighbor(Vertex<T> vertex) {
		return getAdjList().get(vertex);
	}

	@Override
	public void printGraph() {
		adjVertices.forEach((e, n) -> {
			e.printVertex();
			System.out.print(" -> ");
			n.forEach(m -> {
				m.printVertex();
				System.out.print(" ");
			});
			System.out.println();
		});
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Printing weights:");
		weightStrategy.printWeights();
	}

	@Override
	public abstract void addEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	@Override
	public abstract void removeEdge(Vertex<T> vertex1, Vertex<T> vertex2);

	@Override
	public Integer getWeight(Vertex<T> vertex1, Vertex<T> vertex2) {
		return weightStrategy.getWeight(vertex1, vertex2);
	}

	@Override
	public boolean hasEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
		List<Vertex<T>> neighbors = this.getNeighbor(vertex1);
		return neighbors != null && neighbors.contains(vertex2);
	}

	@Override
	public boolean hasVertex(Vertex<T> vertex) {
		return adjVertices.containsKey(vertex);
	}
	
}