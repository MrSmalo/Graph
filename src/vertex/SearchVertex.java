package vertex;

public abstract class SearchVertex<T> extends BasicVertex<T> {
	
	/**
	 * The predecessor vertex from which this vertex was discovered during a search.
	 */
	protected Vertex<T> from;

	/**
	 * The current color (state) of the vertex during a search (e.g., White, Gray, Black).
	 */
	protected Color color;
	
	
	/**
	 * Constructs a SearchVertex with the given label and default state.
	 * 
	 * @param label the label of the vertex
	 */
	public SearchVertex(T label) {
		super(label);
		this.setColor(Color.White);
	}

	/**
	 * Gets the predecessor vertex.
	 * 
	 * @return the predecessor vertex
	 */
	public Vertex<T> getFrom() {
		return this.from;
	}

	/**
	 * Sets the predecessor vertex.
	 * 
	 * @param from the predecessor vertex
	 */
	public void setFrom(Vertex<T> from) {
		this.from = from;
	}

	/**
	 * Gets the current color (state) of the vertex.
	 * 
	 * @return the current color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the color (state) of the vertex.
	 * 
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	/**
	 * Prints the vertex details, including its label, predecessor, and color.
	 */
	public void printVertex() {
		super.printVertex();
		System.out.println("Get From:"+ this.getFrom() + ";");
		System.out.println("Color:"+ this.getColor() + ";");
	}
}
