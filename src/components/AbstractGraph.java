package components;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import factory.VertexFactory;
import vertex.*;

import weightStrategies.WeightStrategy;

/**
 * Base implementation of the Graph interface.
 * 
 * @param <T> the type of labels for the vertices
 */
public abstract class AbstractGraph<T> implements Graph<T> {
	
	/**
	 * Map holding the adjacency list representation of the graph.
	 * Maps each vertex to a list of its adjacent vertices.
	 */
	protected Map <Vertex<T>,List<Vertex<T>>> adjVertices;

	/**
	 * The strategy used for calculating and managing edge weights.
	 */
	protected WeightStrategy<T> weightStrategy;

	/**
	 * The factory used for creating new vertex instances.
	 */
	protected final VertexFactory<T> factory;
	
	/**
	 * Constructs an AbstractGraph with the given weight strategy and vertex factory.
	 * 
	 * @param strategy the weight strategy to be used
	 * @param factory the vertex factory to be used
	 */
	public AbstractGraph(WeightStrategy<T> strategy, VertexFactory<T> factory) {
		adjVertices = new HashMap <>();
		this.weightStrategy = strategy;
		this.factory = factory;
	}
	
	@Override
	/**
	 * Adds a vertex with the given label to the graph if it doesn't already exist.
	 */
	public void addVertex(T label) {
		adjVertices.putIfAbsent(factory.create(label), new LinkedList<Vertex<T>>());
	}

	@Override
	/**
	 * Removes the vertex with the given label and all edges connected to it.
	 */
	public void removeVertex(T label) {
		Vertex<T> v = factory.create(label);
		adjVertices.values().stream().forEach(e-> e.remove(v));
		adjVertices.remove(v);		
	}
	@Override
	/**
	 * Prints the adjacency list representation of the graph.
	 */
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
	/**
	 * Adds an edge between two vertices. Abstract method to be implemented by subclasses.
	 */
	public abstract void addEdge(T label1, T label2);

	@Override
	/**
	 * Removes an edge between two vertices. Abstract method to be implemented by subclasses.
	 */
	public abstract void removeEdge(T label1, T label2);
	
	@Override
	/**
	 * Gets the weight of the edge between two vertices.
	 */
	public Integer getWeight(T label1,T label2) {
		return weightStrategy.getWeight(label1, label2);
	}
	
	@Override
	/**
	 * Checks if an edge exists between two vertices.
	 */
	public boolean hasEdge(T label1, T label2) {
		Vertex<T> v1 = factory.create(label1);
		Vertex<T> v2 = factory.create(label2);
		List<Vertex<T>> neighbors = adjVertices.get(v1);
		return neighbors != null && neighbors.contains(v2);
	}
	
	@Override
	/**
	 * Checks if a vertex with the given label exists in the graph.
	 */
	public boolean hasVertex(T label) {
		Vertex<T> v = factory.create(label);
		return adjVertices.containsKey(v);
	}
	
}