package graph6;
public class Neighbour {
	private int neighbourVertex;
	private int edgeWeight;
	Neighbour(int vertex, int edgeWeight) {
		this.neighbourVertex = vertex;
		this.edgeWeight = edgeWeight;
	}
	public int getNeighbourVertex() {
		return this.neighbourVertex;
	}
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}