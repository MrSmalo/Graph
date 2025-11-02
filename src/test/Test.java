package test;

import components.DirectedGraph;
import components.Graph;
import components.NonDirectedGraph;
import weightStrategies.RandomStrategy;

public class Test {

	public static void main(String[] args) {
		Graph<String> graph = new DirectedGraph<>(new RandomStrategy<>());
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
	    System.out.println(graph.getWeight("Bob", "Alice"));
	    System.out.println(graph.getWeight("Rob", "Mark"));
	    System.out.println(graph.getWeight("Alice", "Rob"));
	    System.out.println(graph.getWeight("Alice", "Bob"));
	    System.out.println(graph.getWeight("Jack", "Rob"));
	    graph.printGraph();
	}

}