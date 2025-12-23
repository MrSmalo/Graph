package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import algorithms.*;
import vertex.*;
import vertex.factory.BFSVertexFactory;
import vertex.factory.BasicVertexFactory;
import vertex.factory.DFSVertexFactory;
import vertex.factory.VertexFactory;
import weightStrategies.*;
import graphs.*;

public class Test {

	public static void main(String[] args) {
//		Graph<String> graph = new NonDirectedGraph<>(new RandomStrategy<>());
//		Vertex<String> bob = new BasicVertex<>("Bob");
//		Vertex<String> alice = new BasicVertex<>("Alice");
//		Vertex<String> mark = new BasicVertex<>("Mark");
//		Vertex<String> rob = new BasicVertex<>("Rob");
//		Vertex<String> maria = new BasicVertex<>("Maria");
//
//		graph.addVertex(bob);
//		graph.addVertex(alice);
//		graph.addVertex(mark);
//		graph.addVertex(rob);
//		graph.addVertex(maria);
//		graph.addEdge(bob, alice);
//		graph.addEdge(bob, rob);
//		graph.addEdge(alice, mark);
//		graph.addEdge(alice, bob);
//		graph.addEdge(rob, mark);
//		graph.addEdge(alice, maria);
//		graph.addEdge(rob, maria);
//
//		graph.printGraph();


		//checking nondirected graph logic

		Random random = new Random();
		Graph<String> graph;
		VertexFactory<String> vertexFactory;

		//for basic vertex factory
		vertexFactory = new BasicVertexFactory<>();
		//for BFS vertex factory
		//vertexFactory = new BFSVertexFactory<>();
		//for DFS vertex factory
		//vertexFactory = new DFSVertexFactory<>();

		List<Vertex<String>> vertices = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			vertices.add(vertexFactory.create(ListOfNames.NAMES[i]));
		}

		//for non directed graph
		//graph = new NonDirectedGraph<>(new WeightlessStrategy<>(), vertices);
		//for directed graph
		graph = new DirectedGraph<>(new WeightlessStrategy<>(), vertices);

		graph.getAdjList().forEach((k, v) -> {
			int r = random.nextInt(graph.getAdjListSize());
			for(int i = 0; i < r; i++){
				graph.addEdge(k, vertices.get(random.nextInt(vertices.size())));
			}
		});
		graph.printGraph();
	}

}