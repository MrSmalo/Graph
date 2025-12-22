package vertex;

import java.util.Objects;

/**
 * Base implementation of the Vertex interface.
 * 
 * @param <T> the type of the label associated with the vertex
 */
public abstract class AbstractVertex<T> implements Vertex<T> {
	
	/**
	 * The label associated with this vertex.
	 */
	protected T label;
	
	/**
	 * Constructs an AbstractVertex with the given label.
	 * 
	 * @param label the label of the vertex
	 */
	public AbstractVertex(T label) {
		super();
		this.label = label;
	}

	@Override
	public T getLabel() {
		return this.label;
	}

	@Override
	public void setLabel(T label) {
		this.label = label;
	}

	@Override
	public void printVertex() {
		System.out.print(this.label);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<?> other = (Vertex<?>) obj;
		return Objects.equals(label, other.getLabel());
	}
	
	
}
