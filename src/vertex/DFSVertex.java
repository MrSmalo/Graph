package vertex;

public class DFSVertex<T> extends SearchVertex<T> {
	
	/**
	 * The discovery time of the vertex in a DFS traversal.
	 */
	private Integer start;
	/**
	 * The finishing time of the vertex in a DFS traversal.
	 */
	private Integer end;
	
	/**
	 * Constructs a DFSVertex with the given label.
	 * 
	 * @param label the label of the vertex
	 */
	public DFSVertex(T label) {
		super(label);
		this.setStart(-1);
		this.setEnd(-1);
	}

	/**
	 * Gets the discovery time.
	 * 
	 * @return the discovery time
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * Sets the discovery time.
	 * 
	 * @param start the discovery time to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * Gets the finishing time.
	 * 
	 * @return the finishing time
	 */
	public Integer getEnd() {
		return end;
	}

	/**
	 * Sets the finishing time.
	 * 
	 * @param end the finishing time to set
	 */
	public void setEnd(Integer end) {
		this.end = end;
	}
	
	@Override
	public void printVertex() {
		super.printVertex();
		System.out.println("Starts: " + getStart());
		System.out.println("ends: " + getEnd());
	}
	
}
