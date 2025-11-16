package vertices;

import algorithms.Colors;

public class BfsVertex<T> extends Vertex<T> {
	
	private Colors color;
	private BfsVertex<T> from;
	private Integer distance;
	

	public BfsVertex(T label) {
		super(label);
		this.distance = -1;
		this.color = Colors.White;
	}



	public Colors getColor() {return color;}
	public void setColor(Colors color) {this.color = color;}

	public BfsVertex<T> getFrom() {return from;}
	public void setFrom(BfsVertex<T> from) {this.from = from;}

	public Integer getDistance() {return distance;}
	public void setDistance(Integer distance) {this.distance = distance;}
	
}
