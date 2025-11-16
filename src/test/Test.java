package test;

import vertices.Vertex;
import weightStrategies.RandomStrategy;

import java.util.LinkedList;
import java.util.List;

import algorithms.GraphSearch;
import graphs.DirectedGraph;
import graphs.Graph;
import graphs.NonDirectedGraph;

public class Test {

	public static void main(String[] args) {
		Graph<String> graph = new NonDirectedGraph<>(new RandomStrategy<>());
		graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Alice", "bob");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    
	}

}