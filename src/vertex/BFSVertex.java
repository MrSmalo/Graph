package vertex;

public class BFSVertex<T> extends SearchVertex<T> {

	/**
	 * The distance from the source vertex in a BFS traversal.
	 */
	private Integer distance;
	
	
	/**
	 * Constructs a BFSVertex with the given label.
	 * 
	 * @param label the label of the vertex
	 */
	public BFSVertex(T label) {
		super(label);
		this.setDistance(-1);
	}

	/**
	 * Gets the distance from the source.
	 * 
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * Sets the distance from the source.
	 * 
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	
	@Override
	public void printVertex() {
		super.printVertex();
		System.out.println("Distance: " + this.getDistance());
	}
}
