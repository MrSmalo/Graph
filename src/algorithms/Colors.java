package algorithms;

/**
 * Represents the search status (color) of a vertex during graph traversal algorithms.
 */
public enum Colors {
	/** Vertex has not been visited yet. */
	White,
	/** Vertex is currently being visited. */
	Grey,
	/** Vertex and all its neighbors have been visited. */
	Black
}
