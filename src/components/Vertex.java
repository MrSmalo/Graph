//package components;
//
//import java.util.Objects;
//
//public class Vertex<T> {
//	private T label;
//	
//	//Create a Vertex with a given label.
//	public Vertex(T label) {
//		this.label = label;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(label);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Vertex<?> other = (Vertex<?>) obj;
//		return Objects.equals(label, other.label);
//	}
//	
//	public void printVertex() {
//		System.out.print(label);
//	}
//	
//}
