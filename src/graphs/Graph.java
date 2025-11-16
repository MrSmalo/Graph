package graphs;

import java.util.List;
import java.util.Map;

import vertices.Vertex;

public interface Graph<T> {
	
		//Create a Vertex and add it to a Graph.
		void addVertex(T label);
		//Removes Vertex and all of its in and out Edges.
		void removeVertex(T label);
		//Connect between 2 Vertices by an Edge.
		void addEdge(T label1,T label2);
		//Removes an Edge between 2 Vertices.
		void removeEdge(T label1,T label2);
		//receive adjList
		public Map <Vertex<T>,List<Vertex<T>>> getAdjList();
		//Receive vertex neighbors
		public List<Vertex<T>> getNeighbor(T label);
		//Prints a graph as vertex -> edge1 edge2 ...
		public void printGraph();
		//Get an edge weight
		public Integer getWeight(T label1, T label2);
		//Check whether an edge exists between two vertices
		public boolean hasEdge(T label1, T label2);
		//Check whether an vertex exists
		public boolean hasVertex(T label);
		
}