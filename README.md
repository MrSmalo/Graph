# Graph Library

A flexible and extensible Java library for graph data structures, supporting both directed and non-directed graphs with various vertex types and edge weight strategies.

## Features

- **Graph Types**: 
  - `DirectedGraph`: Edges have a direction from source to destination.
  - `NonDirectedGraph`: Edges are bidirectional.
- **Vertex Types**:
  - `BasicVertex`: A standard vertex with a label.
  - `BFSVertex`: Vertex with distance and search-related properties (color, predecessor).
  - `DFSVertex`: Vertex with discovery/finish times and search-related properties.
- **Edge Weight Strategies**:
  - `RandomStrategy`: Assigns random weights to edges.
  - `WeightlessStrategy`: Edges have no weight (or a default weight).
- **Design Patterns**:
  - **Factory Pattern**: Used for creating different types of vertices (`VertexFactory`).
  - **Strategy Pattern**: Used for defining edge weight calculations (`WeightStrategy`).
  - **Template Method**: `AbstractGraph` and `AbstractVertex` provide common functionality for their respective hierarchies.

## Project Structure

- `components`: Core graph interfaces and implementations.
- `vertex`: Vertex interfaces and various specialized vertex classes.
- `factory`: Factories for creating vertex instances.
- `weightStrategies`: Strategies for managing edge weights.
- `test`: Contains a sample `Test` class demonstrating library usage.

## Usage Example

```java
import components.DirectedGraph;
import components.Graph;
import factory.BasicVertexFactory;
import weightStrategies.RandomStrategy;

public class Main {
    public static void main(String[] args) {
        // Create a directed graph with random weights and basic vertices
        Graph<String> graph = new DirectedGraph<>(new RandomStrategy<>(), new BasicVertexFactory<>());

        // Add vertices
        graph.addVertex("Alice");
        graph.addVertex("Bob");

        // Add an edge
        graph.addEdge("Alice", "Bob");

        // Print the graph
        graph.printGraph();

        // Get edge weight
        System.out.println("Weight from Alice to Bob: " + graph.getWeight("Alice", "Bob"));
    }
}
```

## Getting Started

1. Import the necessary classes from the `components`, `factory`, and `weightStrategies` packages.
2. Choose your desired `WeightStrategy` and `VertexFactory`.
3. Instantiate a `DirectedGraph` or `NonDirectedGraph`.
4. Start building your graph!
